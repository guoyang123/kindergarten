package com.kinder.chat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;

import com.easemob.chat.EMGroupManager;
import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.activity.ChatActivity;
import com.kinder.app.tools.KinderEventMessage;
import com.kinder.chat.customviews.GroupDetail_MainViewXmlView;

public class GruopDetailActivity_VC extends GroupDetailActivity_BC implements OnItemClickListener{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new GroupDetail_MainViewXmlView(this,app.pro,app.screenW,app.screenH);
	    mainView.setListener(this,this);
	    grouplist = EMGroupManager.getInstance().getAllGroups();
	    mainView.initMainViewDataBeforeNetWork(getEMGroup());
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
		
		startActivity(new Intent(this, ChatActivity.class).
				putExtra("userId", this.dataSource.getUberModelList().get(position).getUserModel().getEasemobid()));
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		super.onClick(v);
		int id=v.getId();
		if(id==mainView.titleBarView.back_Button.getId())
		{
			this.finish();
		}else if(id==mainView.titleBarView.rightBtn.getId())
		{
			Intent intent = new Intent(this, ContactUsersActivity_VC.class);//ContactUsersActivity_VC.class
			intent.putExtra("groupId", getIntent().getStringExtra("groupId"));
			startActivityForResult(intent, 0);
		}else if(id==mainView.exit_Button.getId())
		{
			exitGroup();
		}
		
	}

	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) 
		{
			String st2 = getResources().getString(R.string.is_quit_the_group_chat);
			if (progressDialog == null) {
				progressDialog = new ProgressDialog(this);
				progressDialog.setMessage(st2);
				progressDialog.setCanceledOnTouchOutside(false);
			}
			switch (requestCode) {
			
			case REQUEST_CODE_EXIT: // 退出群
				progressDialog.setMessage(st2);
				progressDialog.show();
				exitGrop();
				break;
			default:
				break;
			}
		}
	}
}
