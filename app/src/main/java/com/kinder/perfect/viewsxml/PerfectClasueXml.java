package com.kinder.perfect.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

public class PerfectClasueXml extends MyRelativeLayout {

	public ImageView icon_ImageView;
	public TextView agrement_TextView;
	public PerfectClasueXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		icon_ImageView=productImageView(context, pro, 531,
				20, 20, 
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, this);
		icon_ImageView.setImageResource(R.getRCode("drawable", "agrement_agre"));
		icon_ImageView.setScaleType(ScaleType.CENTER_CROP);
	
		agrement_TextView=productTextView(context, pro, 532,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, icon_ImageView.getId(), 0, 0,
				CENTER_VERTICAL, 0, 0,
				10, 0, 0, 0, 
				"我已阅读并同意服务条款", 14, "#797979", this);
		
	}

}
