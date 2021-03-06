package com.kinder.chat;

import android.os.Bundle;
import android.view.View;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;

import com.kinder.app.tools.KinderEventMessage;
import com.kinder.chat.customviews.ChatUserMainViewXmlView;

public class ChatUserActivity_VC extends ChatUserActivity_BC {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new ChatUserMainViewXmlView(this,app.pro,app.screenW,app.screenH);
		mainView.setListener(this);
		setContentView(mainView);
		userid=getIntent().getStringExtra("userId");
		interface_getUserInfo_ByNetWork();
		
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
			KinderEventMessage msg=(KinderEventMessage)object;
			switch(msg.getCode())
			{
			case KinderEventMessage.MSG_GET_USERIFNO_START:
				start_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GET_USERIFNO_SUCCESS:
				succ_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GET_USERIFNO_FAIL:
				fail_getData(msg.getObj());
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		int id=v.getId();
		if(id==mainView.titlebarView.back_Button.getId())
		{
			this.finish();
		}else if(id==mainView.talk_RelativeLayout.getId())
		{
			 logic_clickTalkBtn();
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

}
