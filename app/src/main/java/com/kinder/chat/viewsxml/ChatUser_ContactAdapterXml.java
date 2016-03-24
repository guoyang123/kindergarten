package com.kinder.chat.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

public class ChatUser_ContactAdapterXml extends MyRelativeLayout {

	public ImageView thumb_ImageView;
	public TextView classname_TextView;
	public TextView classtime_TextView;
	public TextView current_TextView;
	public TextView babyname_TextView;
	public ChatUser_ContactAdapterXml(Context context, float pro,
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
		thumb_ImageView=productImageView(context, pro, 5202,
				40, 40, 
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0, 
				10, 0, 0, 0, wrap);
		thumb_ImageView.setScaleType(ScaleType.CENTER_CROP);
		thumb_ImageView.setImageBitmap(getBitmapFromCache(context, "user_default"));
		
	
		classname_TextView=productTextView(context, pro, 5203,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, thumb_ImageView.getId(), 0, 0, 
				0, 0, 0, 
				13, 11, 0, 0,
				"刘莉莉", 13, "#3f3f3f", wrap);
		
		classtime_TextView=productTextView(context, pro, 5204,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, thumb_ImageView.getId(), 0, classname_TextView.getId(), 
				0, 0, 0, 
				13, 12, 0, 0,
				"", 12, "#5a5a5a", wrap);
		
		
		current_TextView=productTextView(context, pro, 5205,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0,0, 0, 0, 
				CENTER_VERTICAL, 0, 0, 
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0, 11, 0,
				"", 12, "#6ccfa9", wrap);
		current_TextView.setVisibility(View.GONE);
		
		babyname_TextView=productTextView(context, pro, 5206,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0,0, 0, classname_TextView.getId(), 
				0, 0, 0, 
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0, 11, 0,
				"", 12, "#5a5a5a", wrap);
		babyname_TextView.setVisibility(View.GONE);
	}

}
