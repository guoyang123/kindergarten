package com.kinder.parent.customviews;

import android.content.Context;

import com.kinder.menu.viewsxml.Notice_TitleBarXml;

public class ParentSearch_TitleBarXmlView extends Notice_TitleBarXml {

	public ParentSearch_TitleBarXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.root_wrap.getBackground().setAlpha(70);
		this.search_EditText.getBackground().setAlpha(10);
	}

	
	public void setListener(OnClickListener onClickListener)
	{
		this.rightBtn.setOnClickListener(onClickListener);
		this.search_ImageView.setOnClickListener(onClickListener);
	}
}
