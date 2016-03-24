package com.kinder.check.viewsxml;

import android.content.Context;
import android.support.v4.view.ViewPager;

import com.myt360.app.customviews.MyRelativeLayout;

public class CheckUserXml extends MyRelativeLayout {

	public ViewPager viewpager;
	public CheckUserXml(Context context, float pro, float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		
		viewpager=productViewPager(context, pro, 3301,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, 0, 
				0, 0, 0, 0, this);
	}
}
