package com.kinder.setpsw.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;

import com.myt360.app.customviews.MyRelativeLayout;

public class SetPswWrapXml extends MyRelativeLayout {

	public EditText phone_EditText;
	public EditText confirmpsw_EditText;
	public SetPswWrapXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		phone_EditText=productEditText(context, pro, 311, 
				LayoutParams.MATCH_PARENT, 35,
				0, 0, 0, 0, 
				0, 0, 0,
				0, 0, 0, 0, 
				"", 12, "#313131", this, false);
		phone_EditText.setHint("设置6位数字");
		phone_EditText.setGravity(Gravity.CENTER_VERTICAL);
		phone_EditText.setBackgroundColor(Color.parseColor("#ffffff"));
		phone_EditText.setInputType(InputType.TYPE_CLASS_NUMBER);
		confirmpsw_EditText=productEditText(context, pro, 312, 
				LayoutParams.MATCH_PARENT, 35,
				0, 0, 0, phone_EditText.getId(), 
				0, 0, 0,
				0, 14, 0, 0, 
				"", 12, "#313131", this, false);
		confirmpsw_EditText.setHint("确认密码");
		confirmpsw_EditText.setGravity(Gravity.CENTER_VERTICAL);
		confirmpsw_EditText.setBackgroundColor(Color.parseColor("#ffffff"));
		confirmpsw_EditText.setInputType(InputType.TYPE_CLASS_NUMBER);
		
	}

}
