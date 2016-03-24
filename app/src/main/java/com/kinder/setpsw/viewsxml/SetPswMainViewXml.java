package com.kinder.setpsw.viewsxml;

import android.content.Context;
import android.widget.Button;
import android.widget.RelativeLayout;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.setpsw.customviews.SetPswTitelBarXmlView;
import com.kinder.setpsw.customviews.SetPswWrapXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class SetPswMainViewXml extends MyRelativeLayout {

	public SetPswTitelBarXmlView titlebarView;
	public SetPswWrapXmlView wrapView;
	public Button finish_Button;
	public SetPswMainViewXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		

		titlebarView=new SetPswTitelBarXmlView(context,pro,screenW,screenH);
		titlebarView.setId(301);
		LayoutParams titlebarView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,44) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		titlebarView.setLayoutParams(titlebarView_param);
		this.addView(titlebarView);
		
		wrapView=new SetPswWrapXmlView(context,pro,screenW,screenH);
		wrapView.setId(302);
		LayoutParams wrapView_param=new LayoutParams
				((int)(DensityUtil.dip2px(context,260) * pro),LayoutParams.WRAP_CONTENT);
		wrapView_param.setMargins(0, (int)(DensityUtil.dip2px(context,48) * pro), 0, 0);
		wrapView_param.addRule(RelativeLayout.BELOW,titlebarView.getId());
		wrapView_param.addRule(RelativeLayout.CENTER_HORIZONTAL);
		wrapView.setLayoutParams(wrapView_param);
		this.addView(wrapView);
		
		finish_Button=productButton(context, pro, 303,
				260, 40,
				0, 0, 0, 0,
				0, 0, CENTER_IN_PARENT,
				0, 0,0, 0,
				"完成", 14, "#ffffff", this);
		finish_Button.setBackgroundResource(R.getRCode("drawable", "userlogin_selector"));
		
		
	}

}
