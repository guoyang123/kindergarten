package com.tour.app.camera;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.myt360.app.customviews.MyRelativeLayout;

public class CameraDialog_MainViewXml extends MyRelativeLayout {

	public Button camera_Button;
	public Button photo_Button;
	public Button cancel_Button;
	public CameraDialog_MainViewXml(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
	
	 this.setLayoutParams(getParam(context, pro, LayoutParams.MATCH_PARENT, 160));
	 	
	 RelativeLayout wrap=productRelativeLayout(context, pro, 2301,
			 LayoutParams.MATCH_PARENT, 175,
			 0, 0, 0, 0, 
			 0, 0, 0, 
			 0, 0, 0, 0, 
			 0, 0, 0, 0, this);
	 wrap.setBackgroundColor(Color.parseColor("#ffffff"));
		
	 camera_Button=productButton(context, pro, 176,
			 290, 40,
			 0, 0, 0, 0,
			 0, CENTER_HORIZONTAL, 0,
			 0, 15, 0, 0, 
			 "拍照", 15, "#797979", wrap);
	 //camera_Button.setBackgroundResource(R.getRCode("drawable", "userdetail_cameraback_selector"));
	 camera_Button.setBackgroundColor(Color.parseColor("#ffffff"));
	 //
	 
	 View view1=productView(context, pro, 178, 
			 LayoutParams.MATCH_PARENT, 1,
			 0, 0, 0, camera_Button.getId(),
			 0, 0, 0,
			 0, 0, 0, 0, 
			 0, 0, 0, 0, wrap);
	 view1.setBackgroundColor(Color.parseColor("#b4b4b4"));
	 photo_Button=productButton(context, pro, 177,
			 290, 40,
			 0, 0, 0, view1.getId(),
			 0, CENTER_HORIZONTAL, 0,
			 0, 10, 0, 0, 
			 "手机相册", 15, "#797979", wrap);
	 photo_Button.setBackgroundColor(Color.parseColor("#ffffff"));
	// photo_Button.setBackgroundResource(R.getRCode("drawable", "userdetail_cameraback_selector"));
	 
	 View view2=productView(context, pro, 179, 
			 LayoutParams.MATCH_PARENT, 1,
			 0, 0, 0, photo_Button.getId(),
			 0, 0, 0,
			 0, 0, 0, 0, 
			 0, 0, 0, 0, wrap);
	 view2.setBackgroundColor(Color.parseColor("#b4b4b4"));
	 
	 cancel_Button=productButton(context, pro, 180,
			 290, 40,
			 0, 0, 0, view2.getId(),
			 0, CENTER_HORIZONTAL, 0,
			 0, 15, 0, 0, 
			 "取消", 15, "#797979", wrap);
	// cancel_Button.setBackgroundResource(R.getRCode("drawable", "user_login_selector"));
	 cancel_Button.setBackgroundColor(Color.parseColor("#ffffff"));
	}

}
