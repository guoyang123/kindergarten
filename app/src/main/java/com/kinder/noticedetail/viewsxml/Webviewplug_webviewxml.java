package com.kinder.noticedetail.viewsxml;

import android.content.Context;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.myt360.app.customviews.MyRelativeLayout;

/**
 * 
 * webviewPlug视图
 * 
 * */
public class Webviewplug_webviewxml extends MyRelativeLayout {

	//public iYueHu_JSWebView webView;
	public WebView webView;
	public Webviewplug_webviewxml(Context context,float pro,float screenW,float screenH) 
	{
		super(context);
		this.setId(23000);
		this.setBackgroundColor(context.getResources().getColor(
				android.R.color.white));
		
		
		webView = new WebView(context);
		webView.setId(23001);
		LayoutParams found_webview_wv_params = new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		found_webview_wv_params.setMargins((int)(DensityUtil.dip2px(context,10) * pro), 
				(int)(DensityUtil.dip2px(context,10) * pro), 
				(int)(DensityUtil.dip2px(context,10) * pro), 0);
		webView.setLayoutParams(found_webview_wv_params);
		this.addView(webView);
//		webView.setBackgroundColor(context.getResources().getColor(
//				android.R.color.transparent));
		
		
		
		
	}

	
}
