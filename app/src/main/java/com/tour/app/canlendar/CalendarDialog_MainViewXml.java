package com.tour.app.canlendar;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.myt360.app.customviews.MyRelativeLayout;
import com.squareup.customviews.CalTitleXmlView;
import com.squareup.timessquare.CalendarPickerView;

public class CalendarDialog_MainViewXml extends MyRelativeLayout {

	public CalTitleXmlView calTitleView;
	public CalendarPickerView canledarView;
	public CalendarDialog_MainViewXml(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
	
	 this.setLayoutParams(getParam(context, pro, LayoutParams.MATCH_PARENT, 160));
	 	
	
	 ScrollView scroll=productScrollView(context, pro, 3201,
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0,0 ,
				0, 0, 0,
				0, 0, 0, 10, this);
		scroll.setBackgroundColor(Color.parseColor("#f0f0f0"));
		RelativeLayout wrap=productRelativeLayout(context, pro, 3202,
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, scroll);
		

		
		calTitleView=new CalTitleXmlView(context,pro,screenW,screenH);
		calTitleView.setId(3110);
		LayoutParams calTitleView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		//calTitleView_param.setMargins(0, 0, 0, (int)(DensityUtil.dip2px(context,4) * pro));
		calTitleView_param.setMargins((int)(DensityUtil.dip2px(context,13) * pro), 0, (int)(DensityUtil.dip2px(context,13) * pro), 0);
		//calTitleView_param.addRule(RelativeLayout.BELOW,babyname_TextView.getId());
		calTitleView.setLayoutParams(calTitleView_param);
		wrap.addView(calTitleView);
		calTitleView.setBackgroundColor(Color.parseColor("#f5f5f5"));
			
		
		canledarView=new CalendarPickerView(context,pro,screenW,screenH);
		canledarView.setId(3203);
		LayoutParams canledarView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		canledarView_param.addRule(RelativeLayout.CENTER_HORIZONTAL);
		canledarView_param.addRule(RelativeLayout.BELOW,calTitleView.getId());
		canledarView_param.setMargins((int)(DensityUtil.dip2px(context,13) * pro), (int)(DensityUtil.dip2px(context,12) * pro), (int)(DensityUtil.dip2px(context,13) * pro), 0);
		canledarView.setLayoutParams(canledarView_param);
		wrap.addView(canledarView);
	}

}
