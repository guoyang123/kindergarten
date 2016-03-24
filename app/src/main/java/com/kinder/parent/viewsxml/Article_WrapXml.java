package com.kinder.parent.viewsxml;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

public class Article_WrapXml extends MyRelativeLayout {

	public ImageView icon_ImageView;
	public TextView count_TextView;
	public Article_WrapXml(Context context, float pro, float screenW,
			float screenH,int icon_width,int icon_height,String icon) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		RelativeLayout wrap=productRelativeLayout(context, pro, 431,
				80, 40, 
				0, 0, 0, 0, 
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		RelativeLayout child_wrap=productRelativeLayout(context, pro, 432,
				LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT, 
				0, 0, 0, 0, 
				0, 0, CENTER_IN_PARENT,
				0, 0, 0, 0,
				0, 0, 0, 0, wrap);
		
		icon_ImageView=productImageView(context, pro, 433,
				icon_width, icon_height, 
				0, 0, 0, 0, 
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, child_wrap);
		icon_ImageView.setImageResource(R.getRCode("drawable",icon));
		
		count_TextView=productTextView(context, pro, 434,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, icon_ImageView.getId(), 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0, 
				"", 12, "#3c3c3c", child_wrap);
		
	}

	
}
