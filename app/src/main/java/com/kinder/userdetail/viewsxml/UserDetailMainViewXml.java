package com.kinder.userdetail.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.kinder.userdetail.customviews.UserInfoXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class UserDetailMainViewXml extends MyRelativeLayout {

	public RelativeLayout wrap;
	public UserInfoXmlView userInfoView;
	
//	//儿童
//	public UserDetailChildInfoXmlView childInfoView;
//	//老师
//	public UserDetail_TeacherInfoXmlView teacherInfoView;
	public UserDetailMainViewXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		ScrollView scroll=productScrollView(context, pro, 401,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0,0 ,
				0, 0, 0,
				0, 0, 0, 10, this);
		scroll.setBackgroundColor(Color.parseColor("#f0f0f0"));
		 wrap=productRelativeLayout(context, pro, 402,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, scroll);
		 
		userInfoView=new UserInfoXmlView(context,pro,screenW,screenH);
		userInfoView.setId(403);
		LayoutParams userInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		userInfoView.setLayoutParams(userInfoView_param);
		wrap.addView(userInfoView);
		
		
//		childInfoView=new UserDetailChildInfoXmlView(context,pro,screenW,screenH);
//		childInfoView.setId(429);
//		RelativeLayout.LayoutParams childInfoView_param=new RelativeLayout.LayoutParams
//				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
//		childInfoView_param.addRule(RelativeLayout.BELOW,userInfoView.getId());
//		//childInfoView_param.addRule(RelativeLayout.RIGHT_OF,head_ImageView.getId());
//		childInfoView_param.setMargins(0, (int)(DensityUtil.dip2px(context,10) * pro), 0, 0);
//		childInfoView.setLayoutParams(childInfoView_param);
//		wrap.addView(childInfoView);
//		childInfoView.setVisibility(View.GONE);
//		
//		teacherInfoView=new UserDetail_TeacherInfoXmlView(context,pro,screenW,screenH);
//		teacherInfoView.setId(429);
//		RelativeLayout.LayoutParams teacherInfoView_param=new RelativeLayout.LayoutParams
//				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
//		teacherInfoView_param.addRule(RelativeLayout.BELOW,userInfoView.getId());
//		//childInfoView_param.addRule(RelativeLayout.RIGHT_OF,head_ImageView.getId());
//		teacherInfoView_param.setMargins(0, (int)(DensityUtil.dip2px(context,10) * pro), 0, 0);
//		teacherInfoView.setLayoutParams(teacherInfoView_param);
//		wrap.addView(teacherInfoView);
//		teacherInfoView.setVisibility(View.GONE);
	}

}
