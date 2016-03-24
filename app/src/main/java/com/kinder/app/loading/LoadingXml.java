package com.kinder.app.loading;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.myt360.app.customviews.MyRelativeLayout;

/**
 * 
 * buzz loading布局
 * 
 * */
public class LoadingXml extends MyRelativeLayout {

	public ImageView loading;
	public LoadingXml(Context context,float pro,float screenW,float screenH) {
		super(context);
		this.setId(100000);
		 this.setBackgroundResource(R.getRCode("drawable", "coner"));//loadingconer
		
		
//		RelativeLayout wrap=new RelativeLayout(context);
//		wrap.setId(10001);
//		RelativeLayout.LayoutParams params=getParam(context, pro, 150, 150);
//	    this.setLayoutParams(params);
		 RelativeLayout wrap= productRelativeLayout(context, pro, 10001, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, this);
		
	   loading= productImageView(context, pro, 10002, 53, 53, 0, 0, 0, 0, 0, 0, CENTER_IN_PARENT, 0, 0, 0, 0, 0, 0, 0, 0, wrap);
	   loading.setImageResource(R.getRCode("drawable", "loading"));
	}

}
