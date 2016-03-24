package com.kinder.setting.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

public class SettingWrapXml extends MyRelativeLayout 
{
   public ImageView icon_ImageView;
   public TextView text_TextView;
   public ImageView to_ImageView;
   public TextView cache_TextView;
	public SettingWrapXml(Context context, float pro, float screenW,
			float screenH,int icon_width,int icon_height) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		RelativeLayout wrap=productRelativeLayout(context, pro, 4891,
				LayoutParams.MATCH_PARENT, 48,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		wrap.setBackgroundColor(Color.parseColor("#ffffff"));
		
		icon_ImageView=productImageView(context, pro, 4892,
				icon_width, icon_height,
				0, 0, 0, 0, 
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0,
				10, 0, 0, 0, wrap);
		text_TextView=productTextView(context, pro, 4893,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, icon_ImageView.getId(), 0, 0,
				CENTER_VERTICAL, 0, 0,
				10, 0, 0, 0,
				"", 12, "#797979", wrap);
		
		//2547
		
		to_ImageView=productImageView(context, pro, 4894,
				7, 12,
				0, 0, 0, 0, 
				CENTER_VERTICAL, 0, 0,
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0, 10, 0, wrap);
		to_ImageView.setImageResource(R.getRCode("drawable", "setting_to"));
		
		
		cache_TextView=productTextView(context, pro, 4895,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0, 10, 0,
				"", 12, "#797979", wrap);
		cache_TextView.setVisibility(View.GONE);
	}

}
