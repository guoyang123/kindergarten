package com.kinder.login.viewsxml;

import android.content.Context;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.login.customviews.KinderTitelBarXmlView;
import com.kinder.login.customviews.LoginWrapXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class LoginMainViewXml extends MyRelativeLayout {

	public KinderTitelBarXmlView titlebarView;
	public LoginWrapXmlView wrapView;
	public Button login_Button;
	public TextView forgetPsw_TextView;
	public LoginMainViewXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		
		
		titlebarView=new KinderTitelBarXmlView(context,pro,screenW,screenH);
		titlebarView.setId(101);
		LayoutParams titlebarView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,44) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		titlebarView.setLayoutParams(titlebarView_param);
		this.addView(titlebarView);
		
		
		wrapView=new LoginWrapXmlView(context,pro,screenW,screenH);
		wrapView.setId(102);
		LayoutParams wrapView_param=new LayoutParams
				((int)(DensityUtil.dip2px(context,260) * pro),(int)(DensityUtil.dip2px(context,91) * pro));
		wrapView_param.addRule(RelativeLayout.BELOW,titlebarView.getId());
		wrapView_param.addRule(RelativeLayout.CENTER_HORIZONTAL);
		wrapView_param.setMargins(0, (int)(DensityUtil.dip2px(context,48) * pro), 0, 0);
		wrapView.setLayoutParams(wrapView_param);
		this.addView(wrapView);
		wrapView.setBackgroundResource(R.getRCode("drawable", "login_coner"));
		
		login_Button=productButton(context, pro, 103,
				260, 36, 
				0, 0, 0, 0,
				0, 0, CENTER_IN_PARENT,
				0, 0, 0, 0,
				"登录", 14, "#ffffff", this);
		login_Button.setBackgroundResource(R.getRCode("drawable", "userlogin_selector"));
		
		forgetPsw_TextView=productTextView(context, pro, 104,
				LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,
				0, 0, 0, login_Button.getId(), 
				0, 0, 0,
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 14, 45, 0, 
				"忘记密码", 12, "#6ccfa9", this);
	}

}
