package com.kinder.chat.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

import com.myt360.app.customviews.MyRelativeLayout;

public class GroupDetail_GroupInfoXml extends MyRelativeLayout {

	public TextView key_TextView;
	public TextView value_TextView;
	public GroupDetail_GroupInfoXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		
		
		key_TextView=productTextView(context, pro, 181, 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0, 
				14, 0, 0, 0,
				"群名称", 13, "#3c3c3c", this);
		
		
		value_TextView=productTextView(context, pro, 182, 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0, 
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0, 14, 0,
				"群名称", 13, "#3c3c3c", this);
		
		productView(context, pro, 183,
				LayoutParams.MATCH_PARENT, 1, 
				0, 0, 0, key_TextView.getId(),
				0, 0, 0, 
				0, 0, 0, 0,
				0, 12, 0, 0, this).setBackgroundColor(Color.parseColor("#e3e3e3"));
	}

}
