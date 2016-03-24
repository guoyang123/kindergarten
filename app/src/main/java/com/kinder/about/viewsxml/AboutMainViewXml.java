package com.kinder.about.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.kinder.about.customviews.AboutTitleBarXmlView;
import com.kinder.setting.customviews.SettingTitleBarXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class AboutMainViewXml extends MyRelativeLayout {

	public AboutTitleBarXmlView titleBarView;
	public RelativeLayout score_RelativeLayout;
	public AboutMainViewXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		titleBarView=new AboutTitleBarXmlView(context,pro,screenW,screenH);
		titleBarView.setId(3400);
		LayoutParams titleBarView_param=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		titleBarView.setLayoutParams(titleBarView_param);
		this.addView(titleBarView);
		
		RelativeLayout wrap=productRelativeLayout(context, pro, 3401,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 
				0, 0, 0, titleBarView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		
		
		//给我评分
		score_RelativeLayout=productRelativeLayout(context, pro, 3402,
				LayoutParams.MATCH_PARENT, 50, 
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, wrap);
		score_RelativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
		
		productTextView(context, pro, 3403,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0, 
				CENTER_VERTICAL, 0, 0,
				40, 0, 0, 0,
				"给我评分", 14, "#3c3c3c", score_RelativeLayout);
		productImageView(context, pro, 3404,
				44, 44,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0,
				0, 0, 12, 0, score_RelativeLayout)
				.setImageResource(R.getRCode("drawable", "about_to"));
		
		productTextView(context, pro, 3405,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0, 
				0, CENTER_HORIZONTAL, 0,
				0,0,0,ALIGN_PARENT_BOTTOM,
				0, 0, 0, 10,
				"Copyright2015-2016\n家园互动版权所有", 11, "#959393", wrap);
		
		
		ImageView logo_ImageView=productImageView(context, pro, 3406,
				72, 72,
				0, 0, 0, 0,
				0, CENTER_HORIZONTAL, 0,
				0, 0, 0, 0,
				0, 10, 0, 0, wrap);
		logo_ImageView.setImageResource(R.getRCode("drawable", "user_default"));
		
		ImageView qr_ImageView=productImageView(context, pro, 3407,
				70, 70,
				0, 0, 0, logo_ImageView.getId(),
				0, CENTER_HORIZONTAL, 0,
				0, 0, 0, 0,
				0, 10, 0, 0, wrap);
		qr_ImageView.setImageResource(R.getRCode("drawable", "qr"));
		
		productTextView(context, pro, 3408,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0,qr_ImageView.getId(), 
				0, CENTER_HORIZONTAL, 0,
				0,0,0,0,
				0, 5, 0, 0,
				"扫描二维码，您的朋友也可下载家园互动客户端！", 11, "#959393", wrap);
		
		
	}

}
