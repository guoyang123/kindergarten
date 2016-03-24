package com.kinder.chat.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.perfect.customviews.PerfectNameInfoXmlView;
import com.kinder.perfect.customviews.PerfectSexInfoXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class ChatUser_ChildInfoXml extends MyRelativeLayout {

	public ImageView head_ImageView;
	public PerfectSexInfoXmlView sexInfoView;
	public PerfectSexInfoXmlView whoInfoView;
	public TextView childname_TextView;
	public ImageView childsex_ImageView;
	public ChatUser_ChildInfoXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.parseColor("#ffffff"));
		
		head_ImageView=productCircularImage(context, pro, 424,
				60, 60, 
				0, 0, 0, 0, 
				0, 0, 0,
				0, 0, 0, 0,
				16, 10, 0, 0, this);
		head_ImageView.setImageResource(R.getRCode("drawable", "user_default"));
		
	
		sexInfoView=new PerfectSexInfoXmlView(context,pro,screenW,screenH);
		sexInfoView.setId(427);
		LayoutParams sexInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,60) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		//sexInfoView_param.addRule(RelativeLayout.BELOW,view1.getId());
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
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,60) * pro));
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
		
		
		RelativeLayout child_wrap=productRelativeLayout(context, pro, 431,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, head_ImageView.getId(),
				0, 0, 0, 
				0,0, 0, 0,
				16, 2, 0, 0, this);
		
		childname_TextView=productTextView(context, pro, 432,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0, 
				0, 0, 0,
				10, 0, 0, 0,
				"小明", 13, "#3c3c3c", child_wrap);
		
		childsex_ImageView=productImageView(context, pro, 433,
				10, 10,
				0, childname_TextView.getId(), 0, 0, 
				0, 0, 0, 
				0, 0, 0, 0, 
				3, 3, 0, 0, child_wrap);
		childsex_ImageView.setImageResource(R.getRCode("drawable", "man"));
		
		
		productTextView(context, pro, 434,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, childname_TextView.getId(), 
				0, 0, 0,
				0, 0, 0, 0,
				"我是宝宝", 13, "#3c3c3c", child_wrap);
	}

}
