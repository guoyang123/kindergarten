package com.kinder.setpsw.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;
import com.myt360.kindergarten.R;

public class SetPswTitelBarXml extends MyRelativeLayout 
{

	public Button back_Button;
	public TextView desc_TextView;
	public Button right_Button;
	public SetPswTitelBarXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		//bridgedetail_btn_selector.xml
		this.setBackgroundColor(Color.parseColor("#6ccfa9"));
		back_Button=productButton(context, pro, 361,
				44, 44, 
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0, 
				0, 0, 0, 0,
				"", 0, null, this);
		back_Button.setBackgroundResource(R.getRCode("drawable", "back_selector"));
		//back_Button.setVisibility(View.GONE);
	
		desc_TextView=productTextView(context, pro, 362, 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				0, 0, CENTER_IN_PARENT, 
				0, 0, 0, 0,
				"设置密码", 15, "#ffffff", this);
	
		right_Button=productButton(context, pro, 363,
				44, 44, 
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0, 
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0, 22, 0,
				"", 25, "#ffffff", this);
		right_Button.setVisibility(View.GONE);
	
	
	}

}
