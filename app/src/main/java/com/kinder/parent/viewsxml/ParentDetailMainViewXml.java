package com.kinder.parent.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.kinder.chat.customviews.Chat_ContactListTitleBarXmlView;
import com.kinder.noticedetail.customviews.Webviewplug_webviewxmlView;
import com.kinder.parent.customviews.ParentDetail_BottomXmlView;
import com.kinder.parent.customviews.ParentDetail_InfoXmlView;
import com.kinder.parent.customviews.ParentDetail_TitleBarXmlView;
import com.myt360.app.customviews.MyRelativeLayout;


public class ParentDetailMainViewXml extends MyRelativeLayout {

	public ParentDetail_TitleBarXmlView titleBarView;
	public ParentDetail_InfoXmlView infoView;
	public  Webviewplug_webviewxmlView  webView;//
	public ParentDetail_BottomXmlView bottomView;
	
	public ParentDetailMainViewXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		titleBarView=new ParentDetail_TitleBarXmlView(context,pro,screenW,screenH);
		titleBarView.setId(400);
		LayoutParams titleBarView_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		titleBarView.setLayoutParams(titleBarView_params);
		this.addView(titleBarView);
		

		bottomView=new ParentDetail_BottomXmlView(context,pro,screenW,screenH);
		bottomView.setId(401);
		LayoutParams bottomView_params = getParam(context, pro, LayoutParams.MATCH_PARENT, 40);
		bottomView_params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);//
		bottomView.setLayoutParams(bottomView_params);
		this.addView(bottomView);
//		
//		ScrollView scroll=productScrollView(context, pro, 402,
//				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
//				0, 0, bottomView.getId(),titleBarView.getId() ,
//				0, 0, 0,
//				0, 0, 0, 10, this);
//		scroll.setBackgroundColor(Color.parseColor("#f0f0f0"));
//		RelativeLayout wrap=productRelativeLayout(context, pro, 403,
//				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
//				0, 0, 0, 0,
//				0, 0, 0,
//				0, 0, 0, 0, 
//				0, 0, 0, 0, scroll);
		
		infoView=new ParentDetail_InfoXmlView(context, pro, screenW, screenH);
		infoView.setId(404);
		LayoutParams infoView_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		infoView_params.addRule(RelativeLayout.BELOW,titleBarView.getId());
		infoView.setLayoutParams(infoView_params);
		this.addView(infoView);
		
		webView=new Webviewplug_webviewxmlView(context,pro,screenW,screenH);
		webView.setId(405);
		LayoutParams webView_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		webView_params.addRule(RelativeLayout.BELOW,infoView.getId());
		webView_params.addRule(RelativeLayout.ABOVE,bottomView.getId());
		
		webView.setLayoutParams(webView_params);
		this.addView(webView);
		
		
	}

}
