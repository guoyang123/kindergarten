package com.kinder.login.customviews;

import android.content.Context;

import com.kinder.login.viewsxml.LoginWrapInfoXml;

public class LoginWrapinfoXmlView extends LoginWrapInfoXml {

	public LoginWrapinfoXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}
	
	public void setListener(OnClickListener onClickListener)
	{
		this.del_ImageView.setOnClickListener(onClickListener);
	}
	
	/**清空数据*/
	public void clearText()
	{
		this.phone_EditText.setText("");
	}
}
