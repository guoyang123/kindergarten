package com.kinder.login.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.ImageView;

import com.myt360.app.customviews.MyRelativeLayout;

public class LoginWrapInfoXml extends MyRelativeLayout 
{

	public ImageView icon_ImageView;
	public EditText phone_EditText;
	public ImageView del_ImageView;
	public LoginWrapInfoXml(Context context, float pro, float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		icon_ImageView=productImageView(context, pro, 111,
				11, 12, 
				0, 0, 0, 0, 
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0,
				20, 0, 0, 0, this);
		
		del_ImageView=productImageView(context, pro, 112,
				44, 44, 
				0, 0, 0, 0, 
				CENTER_VERTICAL, 0, 0,
				0, ALIGN_PARENT_RIGHT, 0, 0,
				20, 0, 0, 0, this);
		del_ImageView.setImageResource(R.getRCode("drawable", "del_selector"));
		phone_EditText=productEditText(context, pro, 113, 
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				del_ImageView.getId(), icon_ImageView.getId(), 0, 0, 
				0, 0, 0,
				15, 0, 0, 0, 
				"", 12, "#313131", this, false);//12312312312家长  13672138493 98765432111 12312312312
		phone_EditText.setHint("手机号");
		phone_EditText.setGravity(Gravity.CENTER_VERTICAL);
		phone_EditText.setBackgroundColor(Color.parseColor("#ffffff"));
	}

}
