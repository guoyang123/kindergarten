package com.kinder.about.customviews;

import android.content.Context;
import android.view.View.OnClickListener;

import com.kinder.about.viewsxml.AboutMainViewXml;

public class AboutMainViewXmlView extends AboutMainViewXml {

	public AboutMainViewXmlView(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setListener(OnClickListener onClickListener)
	{
		this.titleBarView.setListener(onClickListener);
		this.score_RelativeLayout.setOnClickListener(onClickListener);
	}
}
