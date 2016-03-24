package com.kinder.noticedetail.customviews;

import android.content.Context;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;

public class iYueHu_JSWebView extends WebView {
    public iYueHu_JSWebView(Context context,float pro) {
        super(context);
        this.setWebViewClient(new iYueHu_JSWebViewClient(context));
        fixFontSize(this, pro);
    }

    public iYueHu_JSWebView(Context context) {
        super(context);
        this.setWebViewClient(new iYueHu_JSWebViewClient(context));
    }
    public void sendMessage(Context context, String data) {
        String source = context.getPackageName();
        this.loadUrl(String.format("javascript:YueHuBridge.messageCallback(\"%s\", \"%s\")", source, data));
    }
    
    /**
     * �������Body��ǩ
     * @param webView
     * @param pro
     */
    public void fixFontSize(WebView webView,float pro){
    	if (pro <= 0) {
    		return;	
		}
    	if (pro <= 0.75) {
			webView.getSettings().setTextSize(TextSize.SMALLER);
		}else if (pro > 0.75 && pro <= 1.5) {
			webView.getSettings().setTextSize(TextSize.NORMAL);
		}else if (pro > 1.5) {
			webView.getSettings().setTextSize(TextSize.LARGEST);
		}
    }
    
  
}
