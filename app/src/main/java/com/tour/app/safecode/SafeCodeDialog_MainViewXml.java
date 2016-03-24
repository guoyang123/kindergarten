package com.tour.app.safecode;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;
import com.myt360.kindergarten.R;

public class SafeCodeDialog_MainViewXml extends MyRelativeLayout {

	public TextView code_TextView;
	public EditText phone_EditText;
	public Button cancel_Button;
	public Button sure_Button;
	public SafeCodeDialog_MainViewXml(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
	
	 	
	 RelativeLayout wrap=productRelativeLayout(context, pro, 2301,
			 200, 160,
			 0, 0, 0, 0, 
			 0, 0, 0, 
			 0, 0, 0, 0, 
			 0, 0, 0, 0, this);
	 wrap.setBackgroundResource(R.getRCode("drawable", "coner"));
		
	 
	 
	 code_TextView=productTextView(context, pro, 2302,
			 LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
			 0, 0, 0, 0,
			 0, CENTER_HORIZONTAL, 0,
			 0, 20, 0, 0, 
			 "安全接送密码:", 12, "#3c3c3c", wrap);
	 
	 
	 
	 phone_EditText=productEditText(context, pro, 2303,
			 175, 32,
			 0, 0, 0, code_TextView.getId(), 
			 0, CENTER_HORIZONTAL, 0,
			 0, 20, 0, 0,
			 "", 12, "#3c3c3c", wrap, false);
	 phone_EditText.setHint("请输入手机号码");
	 phone_EditText.setHintTextColor(Color.parseColor("#c9c9c9"));
	 
	 
	 
	 cancel_Button=productButton(context, pro, 2304,
			 100, 40,
			 0, 0, 0, 0,
			 0, 0, 0,
			 0,0,0,ALIGN_PARENT_BOTTOM,
			 0, 0, 0, 0, 
			 "取消", 13, "#acacac", wrap);
	 //camera_Button.setBackgroundResource(R.getRCode("drawable", "userdetail_cameraback_selector"));
	 cancel_Button.setBackgroundColor(Color.parseColor("#efeded"));
	 //
	 
	 
	 
	 View view1=productView(context, pro, 2305, 
			 1, 40,
			 0, cancel_Button.getId(), 0, 0,
			 0, 0, 0,
			 0, 0, 0, ALIGN_PARENT_BOTTOM, 
			 0, 0, 0, 0, wrap);
	 view1.setBackgroundColor(Color.parseColor("#ffffff"));
	 sure_Button=productButton(context, pro, 2306,
			 99, 40,
			 0, view1.getId(), 0, 0,
			 0, 0, 0,
			 0,0,0,ALIGN_PARENT_BOTTOM,
			 0, 0, 0, 0, 
			 "确定", 13, "#6ccfa9", wrap);
	 sure_Button.setBackgroundColor(Color.parseColor("#efeded"));
	// photo_Button.setBackgroundResource(R.getRCode("drawable", "userdetail_cameraback_selector"));
	 
	
	 
	}

}
