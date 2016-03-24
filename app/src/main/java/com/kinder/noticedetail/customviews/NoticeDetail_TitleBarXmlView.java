package com.kinder.noticedetail.customviews;

import android.content.Context;
import android.view.View.OnClickListener;

import com.kinder.noticedetail.viewsxml.NoticeDetail_TitleBarXml;

public class NoticeDetail_TitleBarXmlView extends NoticeDetail_TitleBarXml {

	public NoticeDetail_TitleBarXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setListener(OnClickListener onClickListener)
	{
		this.back_Button.setOnClickListener(onClickListener);
	}
}
