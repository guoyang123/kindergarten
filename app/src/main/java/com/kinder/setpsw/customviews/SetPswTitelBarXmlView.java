package com.kinder.setpsw.customviews;

import android.content.Context;
import android.view.View.OnClickListener;

import com.kinder.forgetpsw.viewsxml.ForgetPswTitelBarXml;
import com.kinder.setpsw.viewsxml.SetPswTitelBarXml;

public class SetPswTitelBarXmlView extends SetPswTitelBarXml {

	public SetPswTitelBarXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setListener(OnClickListener onClickListener)
	{
		this.back_Button.setOnClickListener(onClickListener);
	}
}
