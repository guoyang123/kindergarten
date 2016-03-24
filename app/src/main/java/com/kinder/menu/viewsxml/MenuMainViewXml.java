package com.kinder.menu.viewsxml;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.menu.customviews.MenuActivity_TitleBarXmlView;
import com.kinder.menu.customviews.MenuMainBottomWrapXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class MenuMainViewXml extends MyRelativeLayout {

	public MenuActivity_TitleBarXmlView titleBarView;
	public MenuMainBottomWrapXmlView bottomWrap;
	public FrameLayout frameLayout;
	public MenuMainViewXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		titleBarView=new MenuActivity_TitleBarXmlView(context,pro,screenW,screenH);
		titleBarView.setId(11);
		LayoutParams titleBarView_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		titleBarView.setLayoutParams(titleBarView_params);
		this.addView(titleBarView);
		
		
		bottomWrap=new MenuMainBottomWrapXmlView(context,pro,screenW,screenH);
		bottomWrap.setId(12);
		LayoutParams bottomWrap_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,43) * pro));
		bottomWrap_params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		bottomWrap.setLayoutParams(bottomWrap_params);
		this.addView(bottomWrap);
		
		
		frameLayout = new FrameLayout(context);
		frameLayout.setId(13);
		LayoutParams frameLayout_params = new LayoutParams(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,500) * pro));
		frameLayout_params.addRule(RelativeLayout.BELOW, titleBarView.getId());
		frameLayout_params.addRule(RelativeLayout.ABOVE, bottomWrap.getId());
		frameLayout.setLayoutParams(frameLayout_params);
		this.addView(frameLayout);
	}

}
