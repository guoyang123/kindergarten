package com.kinder.setting.viewsxml;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.setting.customviews.SettingTitleBarXmlView;
import com.kinder.setting.customviews.SettingWrapXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class SettingMainViewXml extends MyRelativeLayout {

	public SettingTitleBarXmlView titleBarView;
	public SettingWrapXmlView cacheView;
	public SettingWrapXmlView modifyPswView;
	public SettingWrapXmlView aboutView;
	public Button exit_Button;
	public SettingMainViewXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		titleBarView=new SettingTitleBarXmlView(context,pro,screenW,screenH);
		titleBarView.setId(3200);
		LayoutParams titleBarView_param=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		titleBarView.setLayoutParams(titleBarView_param);
		this.addView(titleBarView);
		
		
		cacheView=new SettingWrapXmlView(context,pro,screenW,screenH,12,13);
		cacheView.setId(3201);
		LayoutParams cacheView_param=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		cacheView_param.addRule(RelativeLayout.BELOW,titleBarView.getId());
		cacheView.setLayoutParams(cacheView_param);
		this.addView(cacheView);
		cacheView.icon_ImageView.setImageResource(R.getRCode("drawable", "setting_del"));
		cacheView.text_TextView.setText("清除缓存");
		cacheView.to_ImageView.setVisibility(View.GONE);
		
		modifyPswView=new SettingWrapXmlView(context,pro,screenW,screenH,11,13);
		modifyPswView.setId(3202);
		LayoutParams modifyPswView_param=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		modifyPswView_param.addRule(RelativeLayout.BELOW,cacheView.getId());
		modifyPswView_param.setMargins(0, (int)(DensityUtil.dip2px(context,15) * pro), 0, 0);
		modifyPswView.setLayoutParams(modifyPswView_param);
		this.addView(modifyPswView);
		modifyPswView.icon_ImageView.setImageResource(R.getRCode("drawable", "setting_modify"));
		modifyPswView.text_TextView.setText("修改密码");
		
		aboutView=new SettingWrapXmlView(context,pro,screenW,screenH,13,13);
		aboutView.setId(3203);
		LayoutParams aboutView_param=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		aboutView_param.addRule(RelativeLayout.BELOW,modifyPswView.getId());
		aboutView_param.setMargins(0, (int)(DensityUtil.dip2px(context,15) * pro), 0, 0);
		aboutView.setLayoutParams(aboutView_param);
		this.addView(aboutView);
		aboutView.icon_ImageView.setImageResource(R.getRCode("drawable", "setting_about"));
		aboutView.text_TextView.setText("关于我们");
		
		
		exit_Button=productButton(context, pro, 3204,
				260, 36, 
				0, 0, 0, aboutView.getId(),
				0, CENTER_HORIZONTAL, 0,
				0, 20, 0, 0,
				"退出登录", 14, "#ffffff", this);
		exit_Button.setBackgroundResource(R.getRCode("drawable", "userlogin_selector"));
		
	}
	
	

}
