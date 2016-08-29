package com.kinder.chat.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.com.iucd.iucdframe.utils.DensityUtil;
import com.myt360.app.customviews.MyRelativeLayout;

public class Chat_ContactListTitleBarXml extends MyRelativeLayout {


	    //左侧按钮
		public Button leftBtn;
		//中间文本
		public TextView centerTextView;
		//右侧按钮
		public TextView rightBtn;
		
	public Chat_ContactListTitleBarXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		RelativeLayout wrap=productRelativeLayout(context, pro, 571,
				LayoutParams.MATCH_PARENT, 44,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, this);
		wrap.setBackgroundColor(Color.parseColor("#6ccfa9"));
		
		    leftBtn=new Button(context);
		    leftBtn.setId(10011);
		    LayoutParams leftBtn_params=new LayoutParams((int)(DensityUtil.dip2px(context,44) * pro),
		    		(int)(DensityUtil.dip2px(context, 44) * pro));
			leftBtn.setLayoutParams(leftBtn_params);
			leftBtn.setBackgroundResource(R.getRCode("drawable", "back_selector"));
			wrap.addView(leftBtn);
			
		    centerTextView=new TextView(context);
		    centerTextView.setId(10012);
		    LayoutParams centerTextView_params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		    centerTextView_params.addRule(RelativeLayout.CENTER_IN_PARENT);
		    centerTextView.setLayoutParams(centerTextView_params);
		    centerTextView.setText("通讯录");
		    centerTextView.setTextSize((int)19*pro);
		    centerTextView.setTextColor(Color.parseColor("#ffffff"));
		    wrap.addView(centerTextView);
			
		    rightBtn=new TextView(context);
		    rightBtn.setId(10013);
		    LayoutParams rightBtn_params=new LayoutParams(LayoutParams.WRAP_CONTENT,(int)(DensityUtil.dip2px(context,44) * pro));
		    rightBtn_params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		    rightBtn_params.setMargins(0, 0, (int)(DensityUtil.dip2px(context,10) * pro), 0);
		    rightBtn.setLayoutParams(rightBtn_params);
		    rightBtn.setText("通讯录");
		    rightBtn.setTextColor(Color.parseColor("#ffffff"));
		    rightBtn.setTextSize((int)14*pro);
		    rightBtn.setGravity(Gravity.CENTER_VERTICAL);
		    wrap.addView(rightBtn);
		    rightBtn.setVisibility(View.GONE);
	}

}
