package com.kinder.chat.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myt360.app.customviews.CircularImage;
import com.myt360.app.customviews.MyRelativeLayout;

public class ChatUser_UserInfoXml extends MyRelativeLayout {

	public CircularImage userhead_CircularImage;
	public TextView name_TextView;
	public ImageView sex_ImageView;
	public TextView rule_TextView;
	public ChatUser_UserInfoXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		RelativeLayout wrap=productRelativeLayout(context, pro, 3001,
				LayoutParams.MATCH_PARENT, 130,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		wrap.setBackgroundColor(Color.parseColor("#ffffff"));
		
		userhead_CircularImage=productCircularImage(context, pro, 3002,
				60, 60,
				0, 0, 0, 0,
				0, CENTER_HORIZONTAL, 0, 
				0, 0, 0, 0,
				0, 12, 0, 0, wrap);
		userhead_CircularImage.setImageResource(R.getRCode("drawable", "user_default"));
		
		
		name_TextView=productTextView(context, pro, 3003,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, userhead_CircularImage.getId(), 
				0, CENTER_HORIZONTAL, 0,
				0, 0, 0, 0,
				"一万", 13, "#3c3c3c", wrap);
		
		sex_ImageView=productImageView(context, pro, 3004,
				8, 8, 
				0, name_TextView.getId(), 0, userhead_CircularImage.getId(), 
				0, 0, 0,
				0, 0, 0, 0, 
				5, 4, 0, 0, wrap);
		sex_ImageView.setImageResource(R.getRCode("drawable", "man"));
	
		rule_TextView=productTextView(context, pro, 3005,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, sex_ImageView.getId(), 
				0, CENTER_HORIZONTAL, 0,
				0, 8, 0, 0,
				"我是妈妈", 13, "#3c3c3c", wrap);
		rule_TextView.setVisibility(View.GONE);
	}

}
