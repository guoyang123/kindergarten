package com.kinder.perfect.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.myt360.app.customviews.MyRelativeLayout;

public class PerfectSexInfoXml extends MyRelativeLayout {

	public TextView key_TextView;
	public TextView value_TextView;
	public PerfectSexInfoXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.parseColor("#ffffff"));
		
		key_TextView=productTextView(context, pro, 481,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0, 
				"请选择性别", 15, "#3c3c3c", this);
		key_TextView.setPadding((int)(DensityUtil.dip2px(context,20) * pro), 0, 0, 0);
		key_TextView.setGravity(Gravity.CENTER_VERTICAL);
		key_TextView.setBackgroundColor(Color.parseColor("#ffffff"));
		
		value_TextView=productTextView(context, pro, 482,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0, 18, 0, 
				"男", 15, "#3c3c3c", this);
		//value_TextView.setPadding((int)(DensityUtil.dip2px(context,20) * pro), 0, 0, 0);
		value_TextView.setGravity(Gravity.CENTER_VERTICAL);
		value_TextView.setBackgroundColor(Color.parseColor("#ffffff"));
		
		
	}

}
