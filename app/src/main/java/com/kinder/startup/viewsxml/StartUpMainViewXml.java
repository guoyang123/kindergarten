package com.kinder.startup.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.myt360.app.customviews.MyRelativeLayout;

public class StartUpMainViewXml extends MyRelativeLayout {

	public StartUpMainViewXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		RelativeLayout wrap=productRelativeLayout(context, pro, 101,
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0, 
				0, 0, CENTER_IN_PARENT, 
				0, 0, 0, 0,
				0, 0, 0, 0, this);
				//.setBackgroundColor(Color.RED);
		
		ImageView icon=productImageView(context, pro, 102,
				80, 80,
				0, 0, 0, 0,
				0, CENTER_HORIZONTAL, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, wrap);
		icon.setImageResource(R.getRCode("drawable", "startup"));
		productTextView(context, pro, 103,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, icon.getId(),
				0, CENTER_HORIZONTAL, 0,
				0, 10, 0, 0, 
				"好朋友", 16, "#000000", wrap);
		
	}

}
