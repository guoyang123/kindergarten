package com.tour.app.wheelviewdialog;

import kankan.wheel.widget.WheelView;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

public class WheelViewDialog_MainViewXml extends MyRelativeLayout {

	
	//public TextView desc_TextView;
	public WheelView wheel_WheelView;
	public Button sure_Button;
	public Button cancel_Button;
	public WheelViewDialog_MainViewXml(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
	
	 	
	 RelativeLayout wrap=productRelativeLayout(context, pro, 2401,
			 LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT,
			 0, 0, 0, 0, 
			 0, 0, 0, 
			 0, 0, 0, 0, 
			 0, 0, 0, 0, this);
	 wrap.setBackgroundColor(Color.parseColor("#ffffff"));

	 
	 sure_Button=productButton(context, pro, 2405,
			 LayoutParams.WRAP_CONTENT, 40, 
			 0, 0, 0, 0, 
			 0, 0, 0,
			 0,ALIGN_PARENT_RIGHT,0,0,
			 0, 0, 0, 0,
			 "确认", 15, "#797979", wrap);
	 sure_Button.setBackgroundColor(Color.parseColor("#ffffff"));
	 
	 cancel_Button=productButton(context, pro, 2407,
			 LayoutParams.WRAP_CONTENT, 40, 
			 0,  0, 0, 0, 
			 0, 0, 0,
			 0, 0, 0, 0,
			 "取消", 15, "#797979", wrap);
	 cancel_Button.setBackgroundColor(Color.parseColor("#ffffff"));
		

	 wheel_WheelView=new WheelView(context);
	 wheel_WheelView.setId(2403);
	 LayoutParams wheel_param=getParam(context, pro, LayoutParams.MATCH_PARENT, 100);
	 wheel_param.addRule(RelativeLayout.BELOW,cancel_Button.getId());
	 wheel_WheelView.setLayoutParams(wheel_param);
	 wrap.addView(wheel_WheelView);
///	 wheel_WheelView.setCyclic(true);
	 wheel_WheelView.setBackgroundColor(Color.parseColor("#ffffff"));
	 View view2=productView(context, pro, 2404,
			 LayoutParams.MATCH_PARENT, 1, 
			 0, 0, 0, wheel_WheelView.getId(), 
			 0, 0, 0,
			 0, 0, 0, 0, 
			 0, 0, 0, 0, wrap);
	 view2.setBackgroundColor(Color.parseColor("#999999"));
	
			
	 View view3=productView(context, pro, 2406,
			1, 20, 
			 0, 0, 0, wheel_WheelView.getId(), 
			 0, 0, 0,
			 0, 0, 0, 0, 
			 0, 0, 0, 0, wrap);
	 view3.setBackgroundColor(Color.parseColor("#ffffff"));
	 
	
	}

}
