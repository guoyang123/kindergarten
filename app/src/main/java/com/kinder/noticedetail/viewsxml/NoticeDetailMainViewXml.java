package com.kinder.noticedetail.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.noticedetail.customviews.NoticeDetail_BottomXmlView;
import com.kinder.noticedetail.customviews.NoticeDetail_InfoXmlView;
import com.kinder.noticedetail.customviews.NoticeDetail_PartXmlView;
import com.kinder.noticedetail.customviews.NoticeDetail_TitleBarXmlView;
import com.kinder.noticedetail.customviews.Webviewplug_webviewxmlView;
import com.kinder.parent.customviews.ParentDetail_BottomXmlView;
import com.myt360.app.customviews.MyRelativeLayout;


public class NoticeDetailMainViewXml extends MyRelativeLayout {

	public NoticeDetail_TitleBarXmlView titleBarView;
	public NoticeDetail_InfoXmlView infoView;
	public Webviewplug_webviewxmlView webviewwrap;
	public NoticeDetail_PartXmlView partView;
	public NoticeDetail_BottomXmlView bottomView;
	public NoticeDetailMainViewXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		titleBarView=new NoticeDetail_TitleBarXmlView(context,pro,screenW,screenH);
		titleBarView.setId(400);
		LayoutParams titleBarView_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		titleBarView.setLayoutParams(titleBarView_params);
		this.addView(titleBarView);
		
		bottomView=new NoticeDetail_BottomXmlView(context,pro,screenW,screenH);
		bottomView.setId(406);
		LayoutParams bottomView_params = getParam(context, pro, LayoutParams.MATCH_PARENT, 42);
		bottomView_params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);//
		bottomView.setLayoutParams(bottomView_params);
		this.addView(bottomView);
		bottomView.setVisibility(View.GONE);
		
		ScrollView scroll=productScrollView(context, pro, 402,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, bottomView.getId(),titleBarView.getId() ,
				0, 0, 0,
				0, 0, 0, 10, this);
		scroll.setBackgroundColor(Color.parseColor("#f0f0f0"));
		RelativeLayout wrap=productRelativeLayout(context, pro, 403,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, scroll);
		
		infoView=new NoticeDetail_InfoXmlView(context, pro, screenW, screenH);
		infoView.setId(404);
		LayoutParams infoView_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		
		infoView.setLayoutParams(infoView_params);
		wrap.addView(infoView);
		

		
		webviewwrap=new Webviewplug_webviewxmlView(context, pro, screenW, screenH);
		webviewwrap.setId(405);
		LayoutParams webView_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		webView_params.addRule(RelativeLayout.BELOW,infoView.getId());
		webviewwrap.setLayoutParams(webView_params);
		wrap.addView(webviewwrap);
		
		
		partView=new NoticeDetail_PartXmlView(context, pro, screenW, screenH);
		partView.setId(407);
		LayoutParams partView_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		partView_params.addRule(RelativeLayout.BELOW,webviewwrap.getId());
		partView_params.setMargins(0, (int)(DensityUtil.dip2px(context,10) * pro), 0, 0);
		partView.setLayoutParams(partView_params);
		wrap.addView(partView);
		partView.setVisibility(View.GONE);
		partView.setBackgroundResource(R.getRCode("drawable", "signchild_coner"));
		
		
		
	}

}
