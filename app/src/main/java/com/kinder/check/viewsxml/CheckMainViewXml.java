package com.kinder.check.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.check.customviews.CheckTeacherXmlView;
import com.kinder.check.customviews.CheckUserXmlView;
import com.kinder.login.customviews.KinderTitelBarXmlView;
import com.myt360.app.customviews.MyRelativeLayout;


public class CheckMainViewXml extends MyRelativeLayout {

	public CheckUserXmlView checkUserView;
	public CheckTeacherXmlView checkTeacherView;
	public CheckMainViewXml(Context context, float pro, float screenW,
			float screenH,FragmentManager fm) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		
		checkUserView=new CheckUserXmlView(context,pro,screenW,screenH,fm);
		checkUserView.setId(151);
		LayoutParams checkUserView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		checkUserView.setLayoutParams(checkUserView_param);
		this.addView(checkUserView);
		checkUserView.setBackgroundColor(Color.parseColor("#f0f0f0"));
		checkUserView.setVisibility(View.GONE);
		//
				
		checkTeacherView	=new CheckTeacherXmlView(context,pro,screenW,screenH);
		checkTeacherView.setId(152);
		LayoutParams checkTeacherView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		checkTeacherView.setLayoutParams(checkTeacherView_param);
		this.addView(checkTeacherView);
		checkTeacherView.setVisibility(View.GONE);
	}

}
