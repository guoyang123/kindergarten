package com.kinder.about;

import android.content.Intent;
import android.net.Uri;

import com.kinder.about.customviews.AboutMainViewXmlView;
import com.myt360.kindergarten.Kind_BaseActivity;

public abstract class AboutActivity_BC extends Kind_BaseActivity {

	
	protected AboutMainViewXmlView mainView;
	
	/**
	 * 
	 * 应用打分
	 * 
	 * */
	protected void scroing(){
		Uri uri = Uri.parse("market://details?id="+this.getPackageName());  
		Intent intent = new Intent(Intent.ACTION_VIEW,uri);  
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
		startActivity(intent);  
	};
}
