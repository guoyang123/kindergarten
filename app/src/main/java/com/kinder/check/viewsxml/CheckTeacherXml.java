package com.kinder.check.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.check.customviews.Check_BabyLeaveXmlView;
import com.kinder.check.customviews.Check_SafeXmlView;
import com.myt360.app.customviews.MyRelativeLayout;
import com.squareup.timessquare.utils.TimeUtils;

public class CheckTeacherXml extends MyRelativeLayout {

	public RelativeLayout date_RelativeLayout;
	public TextView date_TextView;
	public GridView  grideView;
	public Check_BabyLeaveXmlView babyLeaveView;
	public Check_SafeXmlView safeView;
	public CheckTeacherXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		

		ScrollView scroll=productScrollView(context, pro, 3401,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0,0 ,
				0, 0, 0,
				0, 0, 0, 0, this);
		
		RelativeLayout wrap=productRelativeLayout(context, pro, 3402,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, scroll);
		wrap.setBackgroundColor(Color.parseColor("#f0f0f0"));
		
		
		View view=productView(context, pro, 3406,
				LayoutParams.MATCH_PARENT, 46,
				0, 0, 0, 0, 
				0, 0, 0, 
				0, 0, 0, 0,
				0, 0, 0, 0, wrap);
		view.setBackgroundColor(Color.parseColor("#ffffff"));
		date_RelativeLayout=productRelativeLayout(context, pro, 3403,
				192, 24,
				0, 0, 0, 0,
				0, CENTER_HORIZONTAL, 0,
				0, 0, 0, 0,
				0, 10, 0, 0, wrap);
		date_RelativeLayout.setBackgroundResource(R.getRCode("drawable", "teacher_calconer"));
		
		date_TextView=productTextView(context, pro, 3404,
				150, 20,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				2, 0, 0, 0,
				TimeUtils.getActivityDetailTime(String.valueOf(System.currentTimeMillis()/1000)), 13, "#b4b4b4", date_RelativeLayout);
		date_TextView.setBackgroundColor(Color.parseColor("#ffffff"));
		date_TextView.setGravity(Gravity.CENTER);
		ImageView icon=productImageView(context, pro, 3405,
				11, 12,
				0, 0, 0, 0, 
				CENTER_VERTICAL, 0, 0, 
				0, ALIGN_PARENT_RIGHT, 0, 0,
				0, 0, 14, 0, date_RelativeLayout);
		icon.setImageResource(R.getRCode("drawable", "teacher_cal"));
		
		
		
		
		grideView=new GridView(context);
		grideView.setId(3407);
		LayoutParams grideView_param=getParam(context, pro, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		grideView_param.addRule(RelativeLayout.BELOW,view.getId());
		grideView.setLayoutParams(grideView_param);
		grideView.setNumColumns(3);
		grideView_param.setMargins((int)(DensityUtil.dip2px(context,10) * pro), (int)(DensityUtil.dip2px(context,10) * pro), (int)(DensityUtil.dip2px(context,10) * pro), (int)(DensityUtil.dip2px(context,10) * pro));
		grideView.setColumnWidth((int)(DensityUtil.dip2px(context,90) * pro));
		grideView.setHorizontalSpacing((int)(DensityUtil.dip2px(context,15) * pro));
		grideView.setVerticalSpacing((int)(DensityUtil.dip2px(context,15) * pro));
		wrap.addView(grideView);
		
		
		babyLeaveView=new Check_BabyLeaveXmlView(context,pro,screenW,screenH);
		babyLeaveView.setId(3408);
		LayoutParams checkUserView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,86) * pro));
		checkUserView_param.setMargins(0, (int)(DensityUtil.dip2px(context,10) * pro), 0, 0);
		checkUserView_param.addRule(RelativeLayout.BELOW,grideView.getId());
		babyLeaveView.setLayoutParams(checkUserView_param);
		wrap.addView(babyLeaveView);
		babyLeaveView.setBackgroundColor(Color.parseColor("#ffffff"));
		babyLeaveView.setVisibility(View.GONE);
		//
		View view2=productView(context, pro, 3409,
				LayoutParams.MATCH_PARENT, 1,
				0, 0, 0, babyLeaveView.getId(), 
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, wrap);
		
		safeView=new Check_SafeXmlView(context,pro,screenW,screenH);
		safeView.setId(3410);
		LayoutParams safeView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,86) * pro));
		safeView_param.addRule(RelativeLayout.BELOW,view2.getId());
		safeView.setLayoutParams(safeView_param);
		wrap.addView(safeView);
		safeView.setBackgroundColor(Color.parseColor("#ffffff"));
		safeView.setVisibility(View.GONE);
		
	} 

}
