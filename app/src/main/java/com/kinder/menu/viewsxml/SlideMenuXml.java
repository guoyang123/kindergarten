package com.kinder.menu.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.myt360.app.customviews.CircularImage;
import com.myt360.app.customviews.MyRelativeLayout;

public class SlideMenuXml extends MyRelativeLayout {

	public CircularImage head_ImageView;
	public TextView name_TextView;
	public ListView listView;
	public SlideMenuXml(Context context, float pro, float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		ScrollView scroll=productScrollView(context, pro, 100,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, this);
		scroll.setBackgroundColor(Color.parseColor("#aae3b8"));	
		
		RelativeLayout wrap=productRelativeLayout(context, pro, 101,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, 0, 
				0, 0, 0, 
				0, 0, 0, 0,
				0, 0, 0, 0, scroll);
			
			head_ImageView=productCircularImage(context, pro, 102,
					80, 80,
					0, 0, 0, 0,
					0, CENTER_HORIZONTAL, 0,
					0, 0, 0, 0, 
					0, 40, 0, 0, wrap);
			head_ImageView.setImageResource(R.getRCode("drawable", "user_default"));
	
			name_TextView=productTextView(context, pro, 103,
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
					0, 0, 0, head_ImageView.getId(),
					0, CENTER_HORIZONTAL, 0,
					0, 10, 0, 0, 
					"昵称", 13, "#ffffff", wrap);
	
	
			listView=productListView(context, pro, 104,
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
					0, 0, 0, name_TextView.getId(), 
					0, 0, 0,
					0, 20, 0, 0, wrap);
			
	
	}

}
