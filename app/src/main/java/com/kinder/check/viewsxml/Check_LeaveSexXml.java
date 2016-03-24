package com.kinder.check.viewsxml;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

public class Check_LeaveSexXml extends MyRelativeLayout {

	public ImageView sex_ImageView;
	public TextView  baby_TextView;
	public Check_LeaveSexXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		sex_ImageView=productImageView(context, pro, 5301,
				8, 9,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0, 
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		//
		sex_ImageView.setImageResource(R.getRCode("drawable", "check_teacher_icon"));
	
		
		baby_TextView=productTextView(context, pro, 5302,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, sex_ImageView.getId(), 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				"小米", 12, "#3c3c3c", this);
	
	}

}
