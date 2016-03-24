package com.kinder.login.customviews;

import android.content.Context;

import com.kinder.login.viewsxml.LoginMainViewXml;

public class LoginMainViewXmlView extends LoginMainViewXml {

	public LoginMainViewXmlView(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}
	
	public void setListener(OnClickListener onClickListener)
	{
		this.titlebarView.setListener(onClickListener);
		this.login_Button.setOnClickListener(onClickListener);
		this.forgetPsw_TextView.setOnClickListener(onClickListener);
	    this.wrapView.setListener(onClickListener);
	}

	
	/**获取用户名密码*/
	public String[] getInfos()
	{
		return this.wrapView.getInfos();
	}
	
}
