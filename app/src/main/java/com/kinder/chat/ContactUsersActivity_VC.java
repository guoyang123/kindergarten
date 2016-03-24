package com.kinder.chat;

import com.easemob.chatuidemo.activity.ChatActivity;
import com.kinder.app.tools.KinderEventMessage;
import com.kinder.chat.customviews.ContactUser_MainViewXmlView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.UserModel;

public class ContactUsersActivity_VC extends ContactUsersActivity_BC implements OnItemClickListener{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new ContactUser_MainViewXmlView(this,app.pro,app.screenW,app.screenH);
	    mainView.setListener(this,this);
		setContentView(mainView);
		interface_getUsers_byNetWork();
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
		// 
		
		if(object!=null&&object instanceof KinderEventMessage)
		{
			//
			KinderEventMessage msg=(KinderEventMessage)object;
			switch(msg.getCode())
			{
			case KinderEventMessage.MSG_GETUSERS_START:
				startLoading();
				break;
			case KinderEventMessage.MSG_GETUSERS_SUCCESS:
				succ_getContanctList(msg.getObj());
				break;
			case KinderEventMessage.MSG_GETUSERS_FAIL:
				stopLoading();
				break;
			}
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
		UserModel userModel=this.dataSource.getUberModelList().get(position).getUserModel();
		startActivity(new Intent(this, ChatActivity.class).
				putExtra("userId", userModel.getEasemobid())
				.putExtra("nickname", userModel.getUsername()));
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		super.onClick(v);
		int id=v.getId();
		if(id==mainView.titleBarView.back_Button.getId())
		{
			this.finish();
		}
	}

}
