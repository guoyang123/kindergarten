package com.kinder.noticedetail.customviews;

import android.content.Context;
import android.widget.LinearLayout;


public class NoticeDetail_GridView_Adapterxml_LinearLayout extends LinearLayout {

	public NoticeDetail_GridView_AdapterXmlView adapterXmlView;
	public NoticeDetail_GridView_Adapterxml_LinearLayout(Context context,float pro,float screenW,float screenH) 
	{
		super(context);
		this.setId(2210);
		adapterXmlView=new NoticeDetail_GridView_AdapterXmlView(context,pro,screenW,screenH);
		adapterXmlView.setId(2211);
		LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		adapterXmlView.setLayoutParams(params);
		this.addView(adapterXmlView);
	}

}
