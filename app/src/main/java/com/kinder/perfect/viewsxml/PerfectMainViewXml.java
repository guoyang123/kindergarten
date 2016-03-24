package com.kinder.perfect.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.perfect.customviews.PerfectChildInfoXmlView;
import com.kinder.perfect.customviews.PerfectClasueXmlView;
import com.kinder.perfect.customviews.PerfectUserInfoXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class PerfectMainViewXml extends MyRelativeLayout {

	public RelativeLayout wrap;
	public PerfectUserInfoXmlView userInfoView;
	public PerfectClasueXmlView clauseView;
//	public PerfectChildInfoXmlView childInfoView;
	public Button save_Button;
	public PerfectMainViewXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		
		RelativeLayout save_wrap=productRelativeLayout(context, pro, 401,
				LayoutParams.MATCH_PARENT, 60, 
				0, 0, 0, 0, 
				0, 0, 0,
				0, 0, 0, ALIGN_PARENT_BOTTOM,
				0, 0, 0, 0, this);
		save_wrap.setBackgroundColor(Color.parseColor("#ffffff"));
		
		save_Button=productButton(context, pro, 402,
				260, 36, 
				0, 0, 0, 0,
				0, 0, CENTER_IN_PARENT,
				0, 0, 0, 0,
				"保存", 14, "#ffffff", save_wrap);
		save_Button.setBackgroundResource(R.getRCode("drawable", "userlogin_selector"));
		
		

		ScrollView scroll=productScrollView(context, pro, 403,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, save_wrap.getId(),0 ,
				0, 0, 0,
				0, 0, 0, 10, this);
		scroll.setBackgroundColor(Color.parseColor("#f0f0f0"));
		 wrap=productRelativeLayout(context, pro, 404,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, scroll);
		
		
		userInfoView=new PerfectUserInfoXmlView(context,pro,screenW,screenH);
		userInfoView.setId(405);
		LayoutParams userInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		userInfoView.setLayoutParams(userInfoView_param);
		wrap.addView(userInfoView);
		
		clauseView=new PerfectClasueXmlView(context,pro,screenW,screenH);
		clauseView.setId(406);
		LayoutParams clauseView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,37) * pro));
		clauseView_param.addRule(RelativeLayout.BELOW,userInfoView.getId());
		clauseView_param.setMargins((int)(DensityUtil.dip2px(context,20) * pro), 0, 0, 0);
		clauseView.setLayoutParams(clauseView_param);
		wrap.addView(clauseView);
		
		
//		childInfoView=new PerfectChildInfoXmlView(context,pro,screenW,screenH);
//		childInfoView.setId(405);
//		RelativeLayout.LayoutParams childInfoView_param=new RelativeLayout.LayoutParams
//				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
//		childInfoView_param.addRule(RelativeLayout.BELOW,clauseView.getId());
//		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
//		childInfoView.setLayoutParams(childInfoView_param);
//		wrap.addView(childInfoView);
		
		
		
		
	}

}
