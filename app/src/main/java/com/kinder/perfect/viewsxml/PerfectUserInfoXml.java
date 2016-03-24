package com.kinder.perfect.viewsxml;

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

public class PerfectUserInfoXml extends MyRelativeLayout {

	public Button back_Button;
	public ImageView userhead_ImageView;
	public PerfectNameInfoXmlView nameinfoView;
	public PerfectSexInfoXmlView sexInfoView;
	public PerfectSexInfoXmlView whoInfoView;
	
	public PerfectUserInfoXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		

		RelativeLayout user_wrap=productRelativeLayout(context, pro, 451,
				LayoutParams.MATCH_PARENT, 170, 
				0, 0, 0, 0, 
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		user_wrap.setBackgroundResource(R.getRCode("drawable", "perfect_background"));
		
		back_Button=productButton(context, pro, 452,
				44, 44, 
				0, 0, 0, 0,
				0, 0, 0, 
				0, 0, 0, 0,
				"", 0, null, this);
		back_Button.setBackgroundResource(R.getRCode("drawable", "back_selector"));
	
		
		productTextView(context, pro, 453,
				LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0, 
				0, CENTER_HORIZONTAL, 0,
				0,0,0,0,
				0, 10, 0, 0, 
				"完善信息", 15, "#ffffff", user_wrap);
		
		userhead_ImageView=productCircularImage(context, pro, 454,
				85, 85, 
				0, 0, 0, 0, 
				0, 0, CENTER_IN_PARENT,
				0, 0, 0, 0,
				0, 0, 0, 0, user_wrap);
		userhead_ImageView.setImageResource(R.getRCode("drawable", "username_icon"));
		
		
		
				
		nameinfoView=new PerfectNameInfoXmlView(context,pro,screenW,screenH);
		nameinfoView.setId(455);
		LayoutParams userInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		userInfoView_param.addRule(RelativeLayout.BELOW,user_wrap.getId());
		nameinfoView.setLayoutParams(userInfoView_param);
		this.addView(nameinfoView);
		
		//
		View view1=productView(context, pro, 456,
				LayoutParams.MATCH_PARENT, 1, 
				0, 0, 0, nameinfoView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view1.setBackgroundColor(Color.parseColor("#e3e3e3"));
		sexInfoView=new PerfectSexInfoXmlView(context,pro,screenW,screenH);
		sexInfoView.setId(457);
		LayoutParams sexInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		sexInfoView_param.addRule(RelativeLayout.BELOW,view1.getId());
		sexInfoView.setLayoutParams(sexInfoView_param);
		this.addView(sexInfoView);
		
		View view2=productView(context, pro, 458,
				LayoutParams.MATCH_PARENT, 1, 
				0, 0, 0, sexInfoView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view2.setBackgroundColor(Color.parseColor("#e3e3e3"));
		
		whoInfoView=new PerfectSexInfoXmlView(context,pro,screenW,screenH);
		whoInfoView.setId(459);
		LayoutParams whoInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		whoInfoView_param.addRule(RelativeLayout.BELOW,view2.getId());
		whoInfoView.setLayoutParams(whoInfoView_param);
		this.addView(whoInfoView);
		whoInfoView.setVisibility(View.GONE);
		
		View view3=productView(context, pro, 460,
				LayoutParams.MATCH_PARENT, 1, 
				0, 0, 0, whoInfoView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view3.setBackgroundColor(Color.parseColor("#e3e3e3"));
		
	}

}
