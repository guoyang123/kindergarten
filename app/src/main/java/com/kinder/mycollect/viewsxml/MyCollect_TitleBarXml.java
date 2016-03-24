package com.kinder.mycollect.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

import com.myt360.app.customviews.MyRelativeLayout;

public class MyCollect_TitleBarXml extends MyRelativeLayout
{

	public Button back_Button;
	public TextView desc_TextView;
	public MyCollect_TitleBarXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.parseColor("#6ccfa9"));
		back_Button=productButton(context, pro, 261,
				44, 44, 
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0, 
				0, 0, 0, 0,
				"", 0, null, this);
		back_Button.setBackgroundResource(R.getRCode("drawable", "back_selector"));
	
		desc_TextView=productTextView(context, pro, 262, 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				0, 0, CENTER_IN_PARENT, 
				0, 0, 0, 0,
				"我的收藏", 15, "#ffffff", this);
	
	}

}
