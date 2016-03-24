package com.kinder.setpsw;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;

import com.kinder.app.tools.KinderEventMessage;
import com.kinder.setpsw.customviews.SetPswMainViewXmlView;

public class SetPswActivity_VC extends SetPswActivity_BC {

	@SuppressLint("DefaultLocale")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new SetPswMainViewXmlView(this,app.pro,app.screenW,app.screenH);
		mainView.setListener(this);
		setContentView(mainView);
		vertify=getIntent().getStringExtra("vertify");
		
		usertel=getIntent().getStringExtra("usertel");
		
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
		//
		if(object!=null&&object instanceof KinderEventMessage)
		{
			KinderEventMessage msg=(KinderEventMessage)object;
			switch(msg.getCode())
			{
			case KinderEventMessage.MSG_SETPSW_START:
				start_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_SETPSW_SUCCESS:
				succ_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_SETPSW_FAIL:
				fail_getData(msg.getObj());
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		if(id==mainView.finish_Button.getId())//完成
		{
			logic_clcikFinishBtn();
		}else if(id==mainView.titlebarView.back_Button.getId())
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

}
