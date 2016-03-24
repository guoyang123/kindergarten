package com.kinder.noticedetail.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ScrollView;

import com.kinder.noticedetail.viewsxml.Webviewplug_webviewxml;

 public class Webviewplug_webviewxmlView extends Webviewplug_webviewxml {

	private Context context;
	public Webviewplug_webviewxmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		this.context=context;
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
//		webSettings.setBlockNetworkImage(false);
		webSettings.setDefaultTextEncodingName("utf-8");
		//webView.loadUrl("http://mp.weixin.qq.com/s?__biz=MzA4NjE1NjQwNw==&mid=403868614&idx=1&sn=aa13315ef053f8ae060f22e21ed94216&3rd=MzA3MDU4NTYzMw==&scene=6#rd");
	}

	/**
	 * @param type code or url
	 * */
	public void setwebviewData(String code,String type)
	{
		
		if (type.equals("url")) 
		{
			webView.loadUrl(code);
		 } else if (type.equals("code"))
		 {
			 webView.loadDataWithBaseURL(null, getHtmlData(code), "text/html", "UTF-8", null);				
		 }

	}
	

	private String getHtmlData(String bodyHTML) {
	    String head = "<head>" +
	                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
	                "<style>img{max-width: 100%; width:auto; height:auto;}</style>" +
	                "</head>";
	    return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
	}
	
}
