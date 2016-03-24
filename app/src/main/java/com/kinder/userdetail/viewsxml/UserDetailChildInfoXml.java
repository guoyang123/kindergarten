package com.kinder.userdetail.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.perfect.customviews.PerfectNameInfoXmlView;
import com.kinder.perfect.customviews.PerfectSexInfoXmlView;
import com.kinder.userdetail.customviews.UserDetailChildInfoXmlView;
import com.myt360.app.customviews.CircularImage;
import com.myt360.app.customviews.MyRelativeLayout;

public class UserDetailChildInfoXml extends MyRelativeLayout {

	public CircularImage head_ImageView;
	public PerfectNameInfoXmlView nameinfoView;
	public PerfectSexInfoXmlView sexInfoView;
	public PerfectSexInfoXmlView whoInfoView;
	
	
	public UserDetailChildInfoXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.parseColor("#ffffff"));
		
		head_ImageView=productCircularImage(context, pro, 424,
				62, 62, 
				0, 0, 0, 0, 
				0, 0, 0,
				0, 0, 0, 0,
				16, 20, 0, 0, this);
		head_ImageView.setImageResource(R.getRCode("drawable", "username_icon"));
		
		
		
		nameinfoView=new PerfectNameInfoXmlView(context,pro,screenW,screenH);
		nameinfoView.setId(425);
		LayoutParams userInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		userInfoView_param.addRule(RelativeLayout.RIGHT_OF,head_ImageView.getId());
		nameinfoView.setLayoutParams(userInfoView_param);
		this.addView(nameinfoView);
		
		//
		View view1=productView(context, pro, 426,
				LayoutParams.MATCH_PARENT, 1, 
				0, head_ImageView.getId(), 0, nameinfoView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view1.setBackgroundColor(Color.parseColor("#e3e3e3"));
		sexInfoView=new PerfectSexInfoXmlView(context,pro,screenW,screenH);
		sexInfoView.setId(427);
		LayoutParams sexInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		sexInfoView_param.addRule(RelativeLayout.BELOW,view1.getId());
		sexInfoView_param.addRule(RelativeLayout.RIGHT_OF,head_ImageView.getId());
		sexInfoView.setLayoutParams(sexInfoView_param);
		this.addView(sexInfoView);
		
		View view2=productView(context, pro, 428,
				LayoutParams.MATCH_PARENT, 1, 
				0, head_ImageView.getId(), 0, sexInfoView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view2.setBackgroundColor(Color.parseColor("#e3e3e3"));
		
		whoInfoView=new PerfectSexInfoXmlView(context,pro,screenW,screenH);
		whoInfoView.setId(429);
		LayoutParams whoInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		whoInfoView_param.addRule(RelativeLayout.BELOW,view2.getId());
		whoInfoView_param.addRule(RelativeLayout.RIGHT_OF,head_ImageView.getId());
		whoInfoView.setLayoutParams(whoInfoView_param);
		this.addView(whoInfoView);
		
		View view3=productView(context, pro, 430,
				LayoutParams.MATCH_PARENT, 1, 
				0, head_ImageView.getId(), 0, whoInfoView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view3.setBackgroundColor(Color.parseColor("#e3e3e3"));
		
		
		
		
		
		
		
		
	}

}
