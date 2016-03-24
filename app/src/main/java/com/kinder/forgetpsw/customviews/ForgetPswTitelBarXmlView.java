package com.kinder.forgetpsw.customviews;

import android.content.Context;
import android.view.View.OnClickListener;

import com.kinder.forgetpsw.viewsxml.ForgetPswTitelBarXml;

public class ForgetPswTitelBarXmlView extends ForgetPswTitelBarXml {

	public ForgetPswTitelBarXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}
	
	public void setListener(OnClickListener onClickListener)
	{
		this.back_Button.setOnClickListener(onClickListener);
		
	}

}
