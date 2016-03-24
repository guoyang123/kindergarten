package com.kinder.menu.viewsxml;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

/**左侧adapter布局*/
public class MenuLeftAdapterXml extends MyRelativeLayout 
{
    
	public ImageView icon_ImageView;
	public TextView text_TextView;
	public ImageView switch_ImageView;
	public MenuLeftAdapterXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		RelativeLayout wrap=productRelativeLayout(context, pro, 2901,
				LayoutParams.MATCH_PARENT, 44,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, this);
		
		icon_ImageView=productImageView(context, pro, 2902,
				20, 20,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0, 
				0, 0, 0, 0,
				26, 0, 0, 0, wrap);
		
		
		text_TextView=productTextView(context, pro, 2903,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, icon_ImageView.getId(), 0, 0, 
				CENTER_VERTICAL, 0, 0,
				17, 0, 0, 0,
				"", 15, "#ffffff", wrap);
		
		switch_ImageView=productImageView(context, pro, 2904,
				28, 14,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0, 
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0,12, 0, wrap);
		switch_ImageView.setVisibility(View.GONE);
	}

}
