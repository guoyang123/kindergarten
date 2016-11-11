package com.kinder.forgetpsw.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;

import com.myt360.app.customviews.MyRelativeLayout;

public class ForgetPswWrapXml extends MyRelativeLayout {

	public EditText phone_EditText;
	public EditText vertify_EditText;
	public Button getVertify_Button;
	public ForgetPswWrapXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		phone_EditText=productEditText(context, pro, 211, 
				LayoutParams.MATCH_PARENT, 35,
				0, 0, 0, 0, 
				0, 0, 0,
				0, 0, 0, 0, 
				"", 12, "#313131", this, false);
		phone_EditText.setHint("请输入手机号");
		phone_EditText.setGravity(Gravity.CENTER_VERTICAL);
		//phone_EditText.setBackgroundColor(Color.parseColor("#ffffff"));
		phone_EditText.setBackgroundResource(R.getRCode("drawable", "search_coner"));
		
		vertify_EditText=productEditText(context, pro, 212, 
				170, 35,
				0, 0, 0, phone_EditText.getId(), 
				0, 0, 0,
				0, 14, 0, 0, 
				"", 12, "#313131", this, false);
		vertify_EditText.setHint("请输入验证码");
		vertify_EditText.setGravity(Gravity.CENTER_VERTICAL);
		vertify_EditText.setBackgroundResource(R.getRCode("drawable", "forgetpsw_coner"));
		getVertify_Button=productButton(context, pro, 213,
				90, 35, 
				0, vertify_EditText.getId(), 0, phone_EditText.getId(),
				0, 0, 0,
				0, 14, 0, 0,
				"获取验证码", 12, "#ffffff", this);
		//getVertify_Button.setBackgroundResource(R.getRCode("drawable", "userlogin_selector"));
		getVertify_Button.setBackgroundResource(R.getRCode("drawable", "getvcard_coner"));
		
	}

}
