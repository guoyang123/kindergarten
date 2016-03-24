package com.myt360.app.customviews;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.iucd.iucdframe.utils.DensityUtil;
import cn.com.iucd.iucdframe.utils.RUtil;

/**
 * 
 * 页面的标题栏
 * 
 * */
public class TitleBarXml extends MyRelativeLayout {
//id 10000
	//左侧按钮
	public Button leftBtn;
	//中间文本
	public TextView centerTextView;
	
	
	public TitleBarXml(Context context,float pro,float screenW,float screenH) {
		super(context); 
		RUtil R=new RUtil(context);
		this.setId(10000);
		RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,44) * pro));
	    this.setLayoutParams(params);
	    this.setBackgroundColor(Color.parseColor("#40c7f4"));
	
	    leftBtn=new Button(context);
	    leftBtn.setId(10001);
	    RelativeLayout.LayoutParams leftBtn_params=new RelativeLayout.LayoutParams((int)(DensityUtil.dip2px(context,44) * pro),(int)(DensityUtil.dip2px(context,44) * pro));
		leftBtn.setLayoutParams(leftBtn_params);
		leftBtn.setBackgroundResource(R.getRCode("drawable", "activityplug_titlebar_left_selector"));
	    this.addView(leftBtn);
		
	    centerTextView=new TextView(context);
	    centerTextView.setId(10002);
	    RelativeLayout.LayoutParams centerTextView_params=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
	    centerTextView_params.addRule(RelativeLayout.CENTER_IN_PARENT);
	    centerTextView.setLayoutParams(centerTextView_params);
	    centerTextView.setText("关于我们");
	    centerTextView.setTextSize((int)19*pro);
	    centerTextView.setTextColor(Color.parseColor("#ffffff"));
	    this.addView(centerTextView);
		
	   
	    
	    
	    
	}

}
