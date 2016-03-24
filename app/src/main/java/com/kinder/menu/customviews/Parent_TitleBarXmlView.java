package com.kinder.menu.customviews;

import android.content.Context;
import android.view.View.OnClickListener;

import com.kinder.menu.viewsxml.Parent_TitleBarXml;

/**育儿titlebar*/
public class Parent_TitleBarXmlView extends Parent_TitleBarXml {

	public Parent_TitleBarXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	/**设置监听*/
	public void setListener(OnClickListener onClickListener)
	{
		this.leftBtn.setOnClickListener(onClickListener);
		this.rightBtn.setOnClickListener(onClickListener);
	}
}
