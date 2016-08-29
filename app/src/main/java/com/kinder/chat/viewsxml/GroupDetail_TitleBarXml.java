package com.kinder.chat.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.com.iucd.iucdframe.utils.DensityUtil;
import cn.com.iucd.iucdframe.utils.RUtil;
import com.myt360.app.customviews.MyRelativeLayout;

public class GroupDetail_TitleBarXml extends MyRelativeLayout
{

	public Button back_Button;
	public Button rightBtn;
	public TextView desc_TextView;
	public GroupDetail_TitleBarXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.parseColor("#6ccfa9"));
		RUtil R=new RUtil(context);
		back_Button=productButton(context, pro, 261,
				44, 44, 
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0, 
				0, 0, 0, 0,
				"", 0, null, this);

		back_Button.setBackgroundResource(R.getRCode("drawable", "back_selector"));
	
		desc_TextView=productTextView(context, pro, 262, 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				0, 0, CENTER_IN_PARENT, 
				0, 0, 0, 0,
				"", 15, "#ffffff", this);
	
		  rightBtn=new Button(context);
		    rightBtn.setId(263);
		    LayoutParams rightBtn_params=new LayoutParams((int)(DensityUtil.dip2px(context, 44) * pro),(int)(DensityUtil.dip2px(context,44) * pro));
		    rightBtn_params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		    rightBtn.setLayoutParams(rightBtn_params);
		    rightBtn.setBackgroundResource(R.getRCode("drawable", "home_slide_selector"));
		    this.addView(rightBtn);
	}

}
