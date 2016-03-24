package com.kinder.login;

import com.kinder.app.tools.KinderEventMessage;
import com.kinder.forgetpsw.ForgetPswActivity_VC;
import com.kinder.login.customviews.LoginMainViewXmlView;
import com.kinder.menu.MenuActivity_VC;
import com.kinder.perfect.PerfectActivity_VC;

import android.os.Bundle;
import android.view.View;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;

public class LoginActivity_VC extends LoginActivity_BC {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new LoginMainViewXmlView(this,app.pro,app.screenW,app.screenH);
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
			case KinderEventMessage.MSG_LOGIN_START:
				start_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_LOGIN_SUCCESS:
				succ_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_LOGIN_FAIL:
				fail_getData(msg.getObj());
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		if(id==mainView.login_Button.getId())
		{
			logic_clickBtn();
			//test_hxLogin();
			//register();
			//skipActivity(MenuActivity_VC.class);
		}else if(id==mainView.forgetPsw_TextView.getId())
		{
			skipActivity(ForgetPswActivity_VC.class);
		}
		
		 if(v==mainView.wrapView.usernameView.del_ImageView)
		{
			//删除用户名
			mainView.wrapView.usernameView.clearText();
		}else if(v==mainView.wrapView.pswView.del_ImageView)
		{
			//删除密码
			mainView.wrapView.pswView.clearText();
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
