package com.kinder.login.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.view.View;
import android.widget.RelativeLayout;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.login.customviews.LoginWrapinfoXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class LoginWrapXml extends MyRelativeLayout {
	public LoginWrapinfoXmlView usernameView;
	public LoginWrapinfoXmlView pswView;
	public LoginWrapXml(Context context, float pro, float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		usernameView=new LoginWrapinfoXmlView(context,pro,screenW,screenH);
		usernameView.setId(121);
		LayoutParams titlebarView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,45) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		usernameView.setLayoutParams(titlebarView_param);
		
		this.addView(usernameView);
		
		View view=productView(context, pro, 122,
				LayoutParams.MATCH_PARENT, 1,
				0, 0, 0, usernameView.getId(), 
				0, 0, 0, 
				0, 0, 0, 0, 
				0, 0, 0, 0, this);
		view.setBackgroundColor(Color.parseColor("#dfdfdf"));
		pswView=new LoginWrapinfoXmlView(context,pro,screenW,screenH);
		pswView.setId(123);
		LayoutParams pswView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,45) * pro));
		pswView_param.addRule(RelativeLayout.BELOW,view.getId());
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		pswView.setLayoutParams(pswView_param);
		this.addView(pswView);
		pswView.phone_EditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		
		
	}

}
