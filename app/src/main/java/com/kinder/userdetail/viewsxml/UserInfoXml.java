package com.kinder.userdetail.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.perfect.customviews.PerfectNameInfoXmlView;
import com.kinder.perfect.customviews.PerfectSexInfoXmlView;
import com.kinder.perfect.customviews.PerfectUserInfoXmlView;
import com.kinder.userdetail.customviews.UserDetailNameInfoXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class UserInfoXml extends MyRelativeLayout {

	public Button back_Button;
	public TextView save_Button;
	public ImageView userhead_ImageView;
	//public PerfectSexInfoXmlView nameinfoView;
	public UserDetailNameInfoXmlView nameinfoView;
	public PerfectSexInfoXmlView phoneInfoView;//电话
	public PerfectSexInfoXmlView sexInfoView;
	public PerfectSexInfoXmlView whoInfoView;//我是
	
	
	public UserInfoXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		

		RelativeLayout user_wrap=productRelativeLayout(context, pro, 421,
				LayoutParams.MATCH_PARENT, 170, 
				0, 0, 0, 0, 
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		user_wrap.setBackgroundResource(R.getRCode("drawable", "perfect_background"));
		
		back_Button=productButton(context, pro, 423,
				44, 44, 
				0, 0, 0, 0,
				0, 0, 0, 
				0, 0, 0, 0,
				"", 0, null, this);
		back_Button.setBackgroundResource(R.getRCode("drawable", "back_selector"));
	
		
		productTextView(context, pro, 422,
				LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0, 
				0, CENTER_HORIZONTAL, 0,
				0,0,0,0,
				0, 10, 0, 0, 
				"完善信息", 15, "#ffffff", user_wrap);
		
		save_Button=productTextView(context, pro, 430,
				44, 40, 
				0, 0, 0, 0,
				0, 0, 0, 
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0, 10, 0,
				"保存", 12, "#ffffff", this);
		save_Button.setGravity(Gravity.CENTER);
		//save_Button.setBackgroundResource(R.getRCode("drawable", "perfect_background"));
		
		userhead_ImageView=productCircularImage(context, pro, 424,
				85, 85, 
				0, 0, 0, 0, 
				0, 0, CENTER_IN_PARENT,
				0, 0, 0, 0,
				0, 0, 0, 0, user_wrap);
		userhead_ImageView.setImageResource(R.getRCode("drawable", "username_icon"));
		
		
		
				
		nameinfoView=new UserDetailNameInfoXmlView(context,pro,screenW,screenH);
		nameinfoView.setId(425);
		LayoutParams userInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		userInfoView_param.addRule(RelativeLayout.BELOW,user_wrap.getId());
		nameinfoView.setLayoutParams(userInfoView_param);
		this.addView(nameinfoView);
		nameinfoView.key_TextView.setText("姓名");
		//
		View view1=productView(context, pro, 426,
				LayoutParams.MATCH_PARENT, 1, 
				0, 0, 0, nameinfoView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view1.setBackgroundColor(Color.parseColor("#e3e3e3"));
		phoneInfoView=new PerfectSexInfoXmlView(context,pro,screenW,screenH);
		phoneInfoView.setId(427);
		LayoutParams phoneInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		phoneInfoView_param.addRule(RelativeLayout.BELOW,view1.getId());
		phoneInfoView.setLayoutParams(phoneInfoView_param);
		this.addView(phoneInfoView);
		phoneInfoView.key_TextView.setText("电话");
		
		View view2=productView(context, pro, 428,
				LayoutParams.MATCH_PARENT, 1, 
				0, 0, 0, phoneInfoView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view2.setBackgroundColor(Color.parseColor("#e3e3e3"));
		
		sexInfoView=new PerfectSexInfoXmlView(context,pro,screenW,screenH);
		sexInfoView.setId(429);
		LayoutParams sexInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		sexInfoView_param.addRule(RelativeLayout.BELOW,view2.getId());
		sexInfoView.setLayoutParams(sexInfoView_param);
		this.addView(sexInfoView);
		//sexInfoView.setVisibility(View.GONE);
		sexInfoView.key_TextView.setText("性别");
		View view3=productView(context, pro, 431,
				LayoutParams.MATCH_PARENT, 1, 
				0, 0, 0, sexInfoView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view3.setBackgroundColor(Color.parseColor("#e3e3e3"));
		
		whoInfoView=new PerfectSexInfoXmlView(context,pro,screenW,screenH);
		whoInfoView.setId(432);
		LayoutParams whoInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,50) * pro));
		whoInfoView_param.addRule(RelativeLayout.BELOW,view3.getId());
		whoInfoView.setLayoutParams(whoInfoView_param);
		this.addView(whoInfoView);
		whoInfoView.key_TextView.setText("我是");
		//whoInfoView.setVisibility(View.GONE);
		
		View view4=productView(context, pro, 433,
				LayoutParams.MATCH_PARENT, 1, 
				0, 0, 0, whoInfoView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		view4.setBackgroundColor(Color.parseColor("#e3e3e3"));
		
	}

}
