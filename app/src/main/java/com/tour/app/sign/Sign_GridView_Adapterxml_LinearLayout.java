package com.tour.app.sign;

import android.content.Context;
import android.widget.LinearLayout;

import com.kinder.noticedetail.customviews.NoticeDetail_GridView_AdapterXmlView;

public class Sign_GridView_Adapterxml_LinearLayout extends LinearLayout {

	public Sign_GridView_AdapterXmlView adapterXmlView;
	public Sign_GridView_Adapterxml_LinearLayout(Context context,float pro,float screenW,float screenH) 
	{
		super(context);
		this.setId(2210);
		adapterXmlView=new Sign_GridView_AdapterXmlView(context,pro,screenW,screenH);
		adapterXmlView.setId(2211);
		LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		adapterXmlView.setLayoutParams(params);
		this.addView(adapterXmlView);
	}

}
