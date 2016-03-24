package com.kinder.notice.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;

import com.myt360.app.customviews.MyRelativeLayout;
import com.tour.app.tabpageindicator.TabPageIndicator;


public class NoticeMainViewXml extends MyRelativeLayout {

	public TabPageIndicator tabpageIndicator;
	public ViewPager viewpager;
	public NoticeMainViewXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);//
		// TODO Auto-generated constructor stub
		

		
		tabpageIndicator=new TabPageIndicator(context);
		tabpageIndicator.setId(4231);
		LayoutParams tabpageIndicator_param=new LayoutParams( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		tabpageIndicator.setLayoutParams(tabpageIndicator_param);
		this.addView(tabpageIndicator);
		tabpageIndicator.setBackgroundResource(R.getRCode("drawable", "base_action_bar_bg"));
		//
		viewpager=productViewPager(context, pro, 4232,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, tabpageIndicator.getId(), //
				0, 0, 0, 0, this);
		
		
	}

}
