package com.kinder.chat.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.perfect.customviews.PerfectNameInfoXmlView;
import com.kinder.perfect.customviews.PerfectSexInfoXmlView;
import com.kinder.perfect.customviews.PerfectUserInfoXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class TeacherInfoXml extends MyRelativeLayout {

	public PerfectSexInfoXmlView schoolnameView;
	public PerfectSexInfoXmlView classnameView;
	
	public TeacherInfoXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		
	
	
		schoolnameView=new PerfectSexInfoXmlView(context,pro,screenW,screenH);
		schoolnameView.setId(427);
		LayoutParams schoolnameView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		schoolnameView.setLayoutParams(schoolnameView_param);
		this.addView(schoolnameView);
		schoolnameView.key_TextView.setText("幼儿园名称");
		View view2=productView(context, pro, 428,
				LayoutParams.MATCH_PARENT, 1, 
				0, 0, 0, schoolnameView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view2.setBackgroundColor(Color.parseColor("#e3e3e3"));
		
		classnameView=new PerfectSexInfoXmlView(context,pro,screenW,screenH);
		classnameView.setId(429);
		LayoutParams whoInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		whoInfoView_param.addRule(RelativeLayout.BELOW,view2.getId());
		classnameView.setLayoutParams(whoInfoView_param);
		this.addView(classnameView);
		classnameView.key_TextView.setText("所属班级");
		View view3=productView(context, pro, 430,
				LayoutParams.MATCH_PARENT, 1, 
				0, 0, 0, classnameView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view3.setBackgroundColor(Color.parseColor("#e3e3e3"));
		
		
		
	}

}
