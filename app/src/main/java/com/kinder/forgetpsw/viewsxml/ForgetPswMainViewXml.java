package com.kinder.forgetpsw.viewsxml;

import android.content.Context;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.forgetpsw.customviews.ForgetPswTitelBarXmlView;
import com.kinder.forgetpsw.customviews.ForgetPswWrapXmlView;
import com.kinder.login.customviews.KinderTitelBarXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class ForgetPswMainViewXml extends MyRelativeLayout {

	public ForgetPswTitelBarXmlView titlebarView;
	public ForgetPswWrapXmlView wrapView;
	public Button next_Button;
	public ForgetPswMainViewXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		

		titlebarView=new ForgetPswTitelBarXmlView(context,pro,screenW,screenH);
		titlebarView.setId(201);
		LayoutParams titlebarView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,44) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		titlebarView.setLayoutParams(titlebarView_param);
		this.addView(titlebarView);
		
		wrapView=new ForgetPswWrapXmlView(context,pro,screenW,screenH);
		wrapView.setId(202);
		LayoutParams wrapView_param=new LayoutParams
				((int)(DensityUtil.dip2px(context,260) * pro),LayoutParams.WRAP_CONTENT);
		wrapView_param.setMargins(0, (int)(DensityUtil.dip2px(context,48) * pro), 0, 0);
		wrapView_param.addRule(RelativeLayout.BELOW,titlebarView.getId());
		wrapView_param.addRule(RelativeLayout.CENTER_HORIZONTAL);
		wrapView.setLayoutParams(wrapView_param);
		this.addView(wrapView);
		
		next_Button=productButton(context, pro, 203,
				260, 40,
				0, 0, 0, 0,
				0, 0, CENTER_IN_PARENT,
				0, 0,0, 0,
				"下一步", 14, "#ffffff", this);
		next_Button.setBackgroundResource(R.getRCode("drawable", "userlogin_selector"));
		
		
	}

}
