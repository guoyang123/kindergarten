package com.kinder.login.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;
import com.myt360.kindergarten.R;

public class KinderTitelBarXml extends MyRelativeLayout 
{

	public Button back_Button;
	public TextView desc_TextView;
	public Button right_Button;
	public KinderTitelBarXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		//bridgedetail_btn_selector.xml
		this.setBackgroundColor(Color.parseColor("#6ccfa9"));
		back_Button=productButton(context, pro, 261,
				44, 44, 
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0, 
				35, 0, 0, 0,
				"", 0, null, this);
		//back_Button.setBackgroundResource(R.getRCode("drawable", "bridgedetail_btn_selector"));
		back_Button.setVisibility(View.GONE);
	
		desc_TextView=productTextView(context, pro, 262, 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				0, 0, CENTER_IN_PARENT, 
				0, 0, 0, 0,
				"登陆", 15, "#ffffff", this);
	
		right_Button=productButton(context, pro, 263,
				44, 44, 
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0, 
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0, 22, 0,
				"", 25, "#ffffff", this);
		right_Button.setVisibility(View.GONE);
	
	
	}

}
