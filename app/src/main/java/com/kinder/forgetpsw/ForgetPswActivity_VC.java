package com.kinder.forgetpsw;

import com.kinder.app.tools.KinderEventMessage;
import com.kinder.forgetpsw.customviews.ForgetPswMainViewXmlView;
import com.kinder.setpsw.SetPswActivity_VC;

import android.os.Bundle;
import android.view.View;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;

public class ForgetPswActivity_VC extends ForgetPswActivity_BC {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new ForgetPswMainViewXmlView(this,app.pro,app.screenW,app.screenH,type);
		mainView.setListener(this);
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
			KinderEventMessage msg=(KinderEventMessage)object;
			switch(msg.getCode())
			{
			case KinderEventMessage.MSG_GET_VERFITY_START:
				start_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GET_VERFITY_SUCCESS:
				succ_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GET_VERFITY_FAIL:
				fail_getData(msg.getObj());
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		if(id==mainView.next_Button.getId())
		{
			logic_clickNextBtn();
		//	this.finish();
			//skipActivity(SetPswActivity_VC.class);
		}else if(id==mainView.titlebarView.back_Button.getId())
		{
			this.finish();
		}else if(id==mainView.wrapView.getVertify_Button.getId())
		{
			//获取验证码
			logic_clickVertifyBtn();
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
