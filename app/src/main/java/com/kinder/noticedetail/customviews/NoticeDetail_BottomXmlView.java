package com.kinder.noticedetail.customviews;

import android.content.Context;
import android.view.View.OnClickListener;

import com.kinder.noticedetail.viewsxml.NoticeDetail_BottomXml;

public class NoticeDetail_BottomXmlView extends NoticeDetail_BottomXml {

	public NoticeDetail_BottomXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	
	/**设置监听*/
	public void setListener(OnClickListener onClickListener)
	{
		this.nopart_Button.setOnClickListener(onClickListener);
		this.part_Button.setOnClickListener(onClickListener);
	}
}
