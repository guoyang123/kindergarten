package com.kinder.check.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.myt360.app.customviews.CircularImage;
import com.myt360.app.customviews.MyRelativeLayout;

public class Check_TeacherAdapterXml extends MyRelativeLayout {

	
	public ImageView safecode_ImageView;
	public ImageView leave_ImageView;
	public CircularImage baby_CircularImage;
	public TextView babyname_TextView;
	
	public Check_TeacherAdapterXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		RelativeLayout wrap=productRelativeLayout(context, pro, 3801,
				90, 90, 
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		wrap.setBackgroundColor(Color.parseColor("#ffffff"));
		
		safecode_ImageView=productImageView(context, pro, 3802,
				14, 14,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0,
				5, 5, 0, 0, this);
		safecode_ImageView.setImageResource(R.getRCode("drawable", "baby_safe"));
		safecode_ImageView.setVisibility(View.GONE);
		leave_ImageView=productImageView(context, pro, 3803,
				14, 14,
				0, 0, 0, 0,
				0, 0, 0,
				0, ALIGN_PARENT_RIGHT, 0, ALIGN_PARENT_BOTTOM,
				0, 0, 5, 5, this);
		leave_ImageView.setImageResource(R.getRCode("drawable", "baby_rest"));
		leave_ImageView.setVisibility(View.GONE);
		
		baby_CircularImage=productCircularImage(context, pro, 3804,
				60, 60,
				0, 0, 0, 0,
				0, CENTER_HORIZONTAL, 0, 
				0, 0, 0, 0,
				0, 8, 0, 0, this);
		baby_CircularImage.setImageResource(R.getRCode("drawable", "user_default"));
		
		babyname_TextView=productTextView(context, pro, 3805,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, baby_CircularImage.getId(),
				0, CENTER_HORIZONTAL, 0,
				0, 5, 0, 0, 
				"", 12, "#797979", this);
	}

	
}
