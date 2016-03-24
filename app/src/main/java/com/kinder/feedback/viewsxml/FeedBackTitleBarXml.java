package com.kinder.feedback.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.myt360.app.customviews.MyRelativeLayout;

public class FeedBackTitleBarXml extends MyRelativeLayout {


	//左侧按钮
		public Button leftBtn;
		//中间文本
		public TextView centerTextView;
		//右侧按钮
		public TextView rightBtn;
		
	public FeedBackTitleBarXml(Context context, float pro, float screenW,
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
		    leftBtn.setId(10015);
		    LayoutParams leftBtn_params=new LayoutParams((int)(DensityUtil.dip2px(context,44) * pro),(int)(DensityUtil.dip2px(context,44) * pro));
			leftBtn.setLayoutParams(leftBtn_params);
			leftBtn.setBackgroundResource(R.getRCode("drawable", "back_selector"));
			wrap.addView(leftBtn);
			
		    centerTextView=new TextView(context);
		    centerTextView.setId(10016);
		    LayoutParams centerTextView_params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		    centerTextView_params.addRule(RelativeLayout.CENTER_IN_PARENT);
		    centerTextView.setLayoutParams(centerTextView_params);
		    centerTextView.setText("意见反馈");
		    centerTextView.setTextSize((int)19*pro);
		    centerTextView.setTextColor(Color.parseColor("#ffffff"));
		    wrap.addView(centerTextView);
			
		    rightBtn=new TextView(context);
		    rightBtn.setId(10017);
		    LayoutParams rightBtn_params=new LayoutParams
		    		((int)(DensityUtil.dip2px(context,44) * pro),(int)(DensityUtil.dip2px(context,44) * pro));
		    rightBtn_params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		    rightBtn.setLayoutParams(rightBtn_params);
		    rightBtn.setGravity(Gravity.CENTER_VERTICAL);
		    //rightBtn.setBackgroundResource(R.getRCode("drawable", "home_search_selector"));
		    wrap.addView(rightBtn);
		    rightBtn.setVisibility(View.GONE);
		    rightBtn.setTextSize((int)12*pro);
		    rightBtn.setTextColor(Color.parseColor("#ffffff"));
		    rightBtn.setText("请假");
	}

}
