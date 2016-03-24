package com.kinder.chat;

import java.io.Serializable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.ContactListModel;
import cn.kinder.bean.UserModel;

import com.easemob.chatuidemo.activity.ChatActivity;
import com.easemob.chatuidemo.activity.GroupsActivity;
import com.kinder.app.tools.KinderEventMessage;
import com.kinder.chat.customviews.ChatUser_ContactMainViewXmlView;

public class ContactlistActivity_VC extends ContactlistActivity_BC 
implements OnItemClickListener
{

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new ChatUser_ContactMainViewXmlView(this,app.pro,app.screenW,app.screenH);
	    mainView.setListener(this,this);
		setContentView(mainView);
	}
	@Override
	public void onMessage(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessageBackgroundThread(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessageMainThread(Object object) {
		// TODO Auto-generated method stub

		if(object!=null&&object instanceof KinderEventMessage)
		{
			//
			KinderEventMessage msg=(KinderEventMessage)object;
			switch(msg.getCode())
			{
			case KinderEventMessage.MSG_CONTACTLIST_START:
				startLoading();
				break;
			case KinderEventMessage.MSG_CONTACTLIST_SUCCESS:
				succ_getContanctList(msg.getObj());
				break;
			case KinderEventMessage.MSG_CONTACTLIST_FAIL:
				stopLoading();
				break;
			}
		}
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
     int id=v.getId();
     if(id==mainView.titleBarView.leftBtn.getId())
     {
    	   this.finish();
     }
	}

	@Override
	public EventMessage initLocalEventMessage() {
		// TODO Auto-generated method stub
		return getEventMessage();
	}

	@Override
	public EventMessage initPlugEventMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	    ContactListModel model= this.dataSource.getContactModels().get(position);
		int type = model.getType();
		 if (type==ContactListModel.GROUP) {//群组
			// 进入群聊列表页面
			Intent intent = new Intent(ContactlistActivity_VC.this, ChatActivity.class);//ContactUsersActivity_VC.class
			intent.putExtra("chatType", ChatActivity.CHATTYPE_GROUP);
			intent.putExtra("groupId",model.getClassModel().getGroupid());
			intent.putExtra("nickname",model.getClassModel().getClassname());
			intent.putExtra("usermodels", (Serializable)(dataSource.getContactListUserModels()));
			startActivityForResult(intent, 0);
//			 interface_getUsers_byNetWork(dataSource.getContactModels().get(position).getClassModel().getGroupid());
			 
		}else {
			// demo中直接进入聊天页面，实际一般是进入用户详情页
			UserModel userModel=model.getContactUserModel().getUserModel();
			startActivity(new Intent(ContactlistActivity_VC.this, ChatActivity.class).
					putExtra("userId", userModel.getEasemobid())
					.putExtra("nickname", userModel.getUsername()));
		}
	}


}
