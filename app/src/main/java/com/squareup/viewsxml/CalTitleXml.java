package com.squareup.viewsxml;

import com.myt360.app.customviews.MyRelativeLayout;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.iucd.iucdframe.utils.DensityUtil;

public class CalTitleXml extends MyRelativeLayout {

	public TextView title;
	public Button beforemonth_Buttton;
	public Button beforeyear_Buttton;
	public Button nextmonth_Buttton;
	public Button nextyear_Buttton;
	
	public CalTitleXml(Context context,float pro,float screenW,float screenH)
	{
		super(context);
		// TODO Auto-generated constructor stub
		
		title=new TextView(context);
		title.setId(3871);
		LayoutParams title_param=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		title_param.setMargins(0, (int)(DensityUtil.dip2px(context,10) * pro), 0, 0);
		title_param.addRule(RelativeLayout.CENTER_HORIZONTAL);
		title.setLayoutParams(title_param);
		title.setTextColor(Color.parseColor("#6ccfa9"));
		title.setTextSize((int)(14*pro));
		title.getPaint().setFakeBoldText(true);
		title.setGravity(Gravity.CENTER_HORIZONTAL);
		this.addView(title);
		
		beforemonth_Buttton=productButton(context, pro, 3872, 
				40, 40,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0,
				"", 0, null, this);
		beforemonth_Buttton.setBackgroundResource(R.getRCode("drawable", "beforemonth"));
		//beforemonth_Buttton.setBackgroundColor(Color.parseColor("#f5f5f5"));

		beforeyear_Buttton=productButton(context, pro, 3873, 
				40, 40,
				0, beforemonth_Buttton.getId(), 0, 0,
				0, 0, 0,
				5, 0, 0, 0,
				"", 0, null, this);
		beforeyear_Buttton.setBackgroundResource(R.getRCode("drawable", "beforeyear"));
		
		
		nextmonth_Buttton=productButton(context, pro, 3874, 
				40, 40,
				0,0, 0, 0,
				0, 0, 0,
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0, 0, 0,
				"", 0, null, this);
		nextmonth_Buttton.setBackgroundResource(R.getRCode("drawable", "nextmonth"));
		
		nextyear_Buttton=productButton(context, pro, 3875, 
					40, 40,
					nextmonth_Buttton.getId(),0, 0, 0,
					0, 0, 0,
					0,0,0,0,
					0, 0, 5, 0,
					"", 0, null, this);
		nextyear_Buttton.setBackgroundResource(R.getRCode("drawable", "nextyear"));
			
		
		TextView tv1=productTextView(context, pro, 3876,
				42, LayoutParams.WRAP_CONTENT,
				0, 0, 0, nextyear_Buttton.getId(), 
				0, 0, 0,
				0, 0, 0, 0, 
				"日", 12, "#797979", this);
		tv1.setGravity(Gravity.CENTER_HORIZONTAL);
		
		TextView tv2=productTextView(context, pro, 3877,
				42, LayoutParams.WRAP_CONTENT,
				0,tv1.getId(), 0, nextyear_Buttton.getId(), 
				0, 0, 0,
				0, 0, 0, 0, 
				"一", 12, "#797979", this);
		tv2.setGravity(Gravity.CENTER_HORIZONTAL);
		
		TextView tv3=productTextView(context, pro, 3879,
				42, LayoutParams.WRAP_CONTENT,
				0, tv2.getId(), 0, nextyear_Buttton.getId(), 
				0, 0, 0,
				0, 0, 0, 0, 
				"二", 12, "#797979", this);
		tv3.setGravity(Gravity.CENTER_HORIZONTAL);
		
		
		TextView tv4=productTextView(context, pro, 3880,
				42, LayoutParams.WRAP_CONTENT,
				0, tv3.getId(), 0, nextyear_Buttton.getId(), 
				0, 0, 0,
				0, 0, 0, 0, 
				"三", 12, "#797979", this);
		tv4.setGravity(Gravity.CENTER_HORIZONTAL);
		
		TextView tv5=productTextView(context, pro, 3881,
				42, LayoutParams.WRAP_CONTENT,
				0, tv4.getId(), 0, nextyear_Buttton.getId(), 
				0, 0, 0,
				0, 0, 0, 0, 
				"四", 12, "#797979", this);
		tv5.setGravity(Gravity.CENTER_HORIZONTAL);
		
		TextView tv6=productTextView(context, pro, 3882,
				42, LayoutParams.WRAP_CONTENT,
				0, tv5.getId(), 0, nextyear_Buttton.getId(), 
				0, 0, 0,
				0, 0, 0, 0, 
				"五", 12, "#797979", this);
		tv6.setGravity(Gravity.CENTER_HORIZONTAL);
		
		TextView tv7=productTextView(context, pro, 3883,
				42, LayoutParams.WRAP_CONTENT,
				0, tv6.getId(), 0, nextyear_Buttton.getId(), 
				0, 0, 0,
				0, 0, 0, 0, 
				"六", 12, "#797979", this);
		tv7.setGravity(Gravity.CENTER_HORIZONTAL);
	}

}
