package com.kinder.chat.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myt360.app.customviews.CircularImage;
import com.myt360.app.customviews.MyRelativeLayout;

public class ContactUser_AdapterXml extends MyRelativeLayout {

	public CircularImage thumb_ImageView;
	public TextView username_TextView;
	public TextView classtime_TextView;
	public TextView babyname_TextView;
	public ContactUser_AdapterXml(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		RelativeLayout wrap=productRelativeLayout(context, pro, 5201, 
				LayoutParams.MATCH_PARENT, 60,
				0, 0, 0, 0,
				0, 0, 0, 
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		wrap.setBackgroundColor(Color.parseColor("#ffffff"));
		thumb_ImageView=productCircularImage(context, pro, 5202,
				40, 40, 
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0, 
				10, 0, 0, 0, wrap);
		thumb_ImageView.setScaleType(ScaleType.CENTER_CROP);
		username_TextView=productTextView(context, pro, 5203,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, thumb_ImageView.getId(), 0, 0, 
				0, 0, 0, 
				13, 11, 0, 0,
				"刘莉莉", 13, "#3f3f3f", wrap);
		
		classtime_TextView=productTextView(context, pro, 5204,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, thumb_ImageView.getId(), 0, username_TextView.getId(), 
				0, 0, 0, 
				13, 0, 0, 0,
				"", 12, "#5a5a5a", wrap);
		
		
		
		
		babyname_TextView=productTextView(context, pro, 5206,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0,0, 0, username_TextView.getId(), 
				0, 0, 0, 
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0, 11, 0,
				"", 12, "#5a5a5a", wrap);
		//babyname_TextView.setVisibility(View.GONE);
	}

}
