package com.kinder.notice.viewsxml;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

public class Notice_All_AdapterXml extends MyRelativeLayout {

	public ImageView thumb_ImageView;
	public TextView title_TextView;
	public TextView author_TextView;
	public TextView time_TextView;
	
	public Notice_All_AdapterXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		RelativeLayout wrap=productRelativeLayout(context, pro, 5201,
				LayoutParams.MATCH_PARENT, 80,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		
		thumb_ImageView=productImageView(context, pro, 5202,
				96, 64,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0,
				11, 0, 0, 0, wrap);
		thumb_ImageView.setScaleType(ScaleType.CENTER_CROP);
		thumb_ImageView.setImageBitmap(getBitmapFromCache(context, "user_default"));
		title_TextView=productTextView(context, pro, 5203,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, thumb_ImageView.getId(), 0, 0,
				0, 0, 0,
				20, 7, 0, 0,
				"", 13, "#3c3c3c", wrap);
		
		author_TextView=productTextView(context, pro, 5204,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, thumb_ImageView.getId(), 0, 0,
				0, 0, 0,
				0,0,0,ALIGN_PARENT_BOTTOM,
				20, 0, 0, 10,
				"", 10, "#797979", wrap);
		
		time_TextView=productTextView(context, pro, 5205,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, 0, 0, 0,
				0, 0, 0,
				0,ALIGN_PARENT_RIGHT,0,ALIGN_PARENT_BOTTOM,
				0, 0, 10, 10,
				"", 10, "#797979", wrap);
		
		
	}

}
