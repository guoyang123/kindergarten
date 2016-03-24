package com.kinder.setpsw.customviews;

import android.content.Context;

import com.kinder.forgetpsw.viewsxml.ForgetPswMainViewXml;
import com.kinder.setpsw.viewsxml.SetPswMainViewXml;

public class SetPswMainViewXmlView extends SetPswMainViewXml {

	public SetPswMainViewXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setListener(OnClickListener onClickListener)
	{
		this.finish_Button.setOnClickListener(onClickListener);
		this.titlebarView.setListener(onClickListener);
	}
	/**获取密码*/
	public String  getPsw()
	{
		return this.wrapView.getPsw();
	}
}
