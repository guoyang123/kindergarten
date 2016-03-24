package com.kinder.userdetail.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.perfect.customviews.PerfectSexInfoXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class UserDetail_TeacherInfoXml extends MyRelativeLayout {

	public PerfectSexInfoXmlView schoolnameView;//幼儿园名称
	public PerfectSexInfoXmlView classesView;//所属班级
	public UserDetail_TeacherInfoXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		schoolnameView=new PerfectSexInfoXmlView(context,pro,screenW,screenH);
		schoolnameView.setId(601);
		LayoutParams userInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		schoolnameView.setLayoutParams(userInfoView_param);
		this.addView(schoolnameView);
		schoolnameView.key_TextView.setText("幼儿园名称");
		//
		View view1=productView(context, pro, 602,
				LayoutParams.MATCH_PARENT, 1, 
				0, 0, 0, schoolnameView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view1.setBackgroundColor(Color.parseColor("#e3e3e3"));
		classesView=new PerfectSexInfoXmlView(context,pro,screenW,screenH);
		classesView.setId(603);
		LayoutParams phoneInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		phoneInfoView_param.addRule(RelativeLayout.BELOW,view1.getId());
		classesView.setLayoutParams(phoneInfoView_param);
		this.addView(classesView);
		classesView.key_TextView.setText("所属班级");
		
		View view2=productView(context, pro, 604,
				LayoutParams.MATCH_PARENT, 1, 
				0, 0, 0, classesView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view2.setBackgroundColor(Color.parseColor("#e3e3e3"));
		
		
	}

}
