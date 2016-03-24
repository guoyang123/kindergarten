package com.kinder.noticedetail.customviews;

import java.io.InputStream;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.TextSize;

public class iYueHu_JSWebViewClient extends WebViewClient {
	Context context;
	
	public iYueHu_JSWebViewClient(Context context) {
		this.context = context;
	}
    public void onPageFinished(WebView webView, String url) {
    	//����bridge
    	loadBridge(webView);
    	//����Jquery
    	loadJQuery(webView);
    }
    
    
    /**
     * ����bridge
     * @param webView
     */
    public void loadBridge(WebView webView){
    	try {
        	InputStream is = context.getAssets().open("WebViewJavascriptBridge.js.txt");
        	int size = is.available(); 
        	byte[] buffer = new byte[size];  
        	is.read(buffer);
        	is.close(); 
        	String text = new String(buffer, "utf-8");
  	
        	webView.loadUrl("javascript:" + text);
		} catch (Exception e) {
			// TODO: handle exception
		}

    	
    	webView.loadUrl("javascript:YueHuBridge.setPlatform('android')");
    }
    
    
    /**
     * ����bridge
     * @param webView
     */
    public void loadJQuery(WebView webView){
    	try {
        	InputStream is = context.getAssets().open("jquery.min.js.txt");
        	int size = is.available(); 
        	byte[] buffer = new byte[size];  
        	is.read(buffer);
        	is.close(); 
        	String text = new String(buffer, "utf-8");
  	
        	webView.loadUrl("javascript:" + text);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}
