package com.kinder.check.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.RelativeLayout.LayoutParams;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.check.customviews.Check_LeaveTitleBarXmlView;
import com.myt360.app.customviews.MyRelativeLayout;
import com.squareup.customviews.CalTitleXmlView;
import com.squareup.timessquare.CalendarPickerView;
import com.weiwangcn.betterspinner.library.BetterSpinner;

public class Check_LeaveMainViewXml extends MyRelativeLayout {

	
	public Check_LeaveTitleBarXmlView titleBarView;
	//public RelativeLayout calendar_RelativeLayout;
	public CalTitleXmlView calTitleView;
	public CalendarPickerView canledarView;
	public BetterSpinner babyname_BetterSpinner;
	public BetterSpinner leave_type;
	public BetterSpinner diseasename;
	public EditText holidayname_EditText;
	public EditText remark_EditText;
	public Button save_Button;
	public Check_LeaveMainViewXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		titleBarView=new Check_LeaveTitleBarXmlView(context,pro,screenW,screenH);
		titleBarView.setId(3200);
		LayoutParams titleBarView_param=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		titleBarView.setLayoutParams(titleBarView_param);
		this.addView(titleBarView);
		
		
		
		ScrollView scroll=productScrollView(context, pro, 3201,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0,titleBarView.getId() ,
				0, 0, 0,
				0, 0, 0, 10, this);
		scroll.setBackgroundColor(Color.parseColor("#f0f0f0"));
		RelativeLayout wrap=productRelativeLayout(context, pro, 3202,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, scroll);
		
//		calendar_RelativeLayout=productRelativeLayout(context, pro, 3203,
//				LayoutParams.MATCH_PARENT, 265,
//				0, 0, 0, 0,
//				0, CENTER_HORIZONTAL, 0,
//				0, 0, 0, 0,
//				12, 12, 12, 0, wrap);

		
		calTitleView=new CalTitleXmlView(context,pro,screenW,screenH);
		calTitleView.setId(3110);
		LayoutParams calTitleView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		//calTitleView_param.setMargins(0, 0, 0, (int)(DensityUtil.dip2px(context,4) * pro));
		calTitleView_param.setMargins((int)(DensityUtil.dip2px(context,13) * pro), 0, (int)(DensityUtil.dip2px(context,13) * pro), 0);
		//calTitleView_param.addRule(RelativeLayout.BELOW,babyname_TextView.getId());
		calTitleView.setLayoutParams(calTitleView_param);
		wrap.addView(calTitleView);
		calTitleView.setBackgroundColor(Color.parseColor("#f5f5f5"));
			
		
		canledarView=new CalendarPickerView(context,pro,screenW,screenH);
		canledarView.setId(3203);
		LayoutParams canledarView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		canledarView_param.addRule(RelativeLayout.CENTER_HORIZONTAL);
		canledarView_param.addRule(RelativeLayout.BELOW,calTitleView.getId());
		canledarView_param.setMargins((int)(DensityUtil.dip2px(context,13) * pro), (int)(DensityUtil.dip2px(context,12) * pro), (int)(DensityUtil.dip2px(context,13) * pro), 0);
		canledarView.setLayoutParams(canledarView_param);
		wrap.addView(canledarView);
		
		
		
		View view=productView(context, pro, 3204,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 
				0, 0, 0, canledarView.getId(),
				0, 0, 0, 
				0, 0, 0, 0, 
				0, 10, 0, 0, wrap);
		view.setBackgroundColor(Color.parseColor("#ffffff"));
		
		babyname_BetterSpinner=productBetterSpinner(context, pro, 3208,
				125, 30,
				0, 0, 0, canledarView.getId(), 
				0, 0, 0, 
				0, 0, 0, 0, 
				26, 24, 0, 0,
				"", 12, "#383838", wrap);
		babyname_BetterSpinner.setBackgroundResource(R.getRCode("drawable", "leave_coner"));
	
		
		
		leave_type=productBetterSpinner(context, pro, 3205,
				125, 30,
				0, babyname_BetterSpinner.getId(), 0, canledarView.getId(), 
				0, 0, 0, 
				0, 0, 0, 0, 
				10, 24, 0, 0,
				"", 12, "#383838", wrap);
		leave_type.setBackgroundResource(R.getRCode("drawable", "leave_coner"));
		diseasename=productBetterSpinner(context, pro, 3206,
				125, 30,
				0, 0, 0, leave_type.getId(), 
				0, 0, 0, 
				0, 0, 0, 0, 
				26, 12, 0, 0,
				"", 12, "#383838", wrap);
		diseasename.setBackgroundResource(R.getRCode("drawable", "leave_coner"));
		holidayname_EditText=productEditText(context, pro, 3207,
				125, 30, 
				0, diseasename.getId(), 0, leave_type.getId(),//
				0, 0, 0, 
				10, 12, 0, 0,
				"", 12, "#383838", wrap, false);
		holidayname_EditText.setHint("请输入就医医院");
		//
		holidayname_EditText.setHintTextColor(Color.parseColor("#bababa"));
		holidayname_EditText.setBackgroundResource(R.getRCode("drawable", "leave_coner"));
		
		
		remark_EditText=productEditText(context, pro, 3209,
				LayoutParams.MATCH_PARENT, 120, 
				0, 0, 0, diseasename.getId(),//
				0, 0, 0, 
				26, 12, 0, 0,
				"", 12, "#383838", wrap, false);
		remark_EditText.setHint("备注");
		holidayname_EditText.setHintTextColor(Color.parseColor("#bababa"));
		holidayname_EditText.setGravity(Gravity.TOP);
		remark_EditText.setBackgroundResource(R.getRCode("drawable", "leave_coner"));
		
		
		save_Button=productButton(context, pro, 3210,
				260, 36, 
				0, 0, 0,remark_EditText.getId(),
				0, CENTER_HORIZONTAL, 0,
				0, 20, 0, 0,
				"确定", 14, "#ffffff", wrap);
		save_Button.setBackgroundResource(R.getRCode("drawable", "userlogin_selector"));
		
		productView(context, pro, 3211,
				LayoutParams.MATCH_PARENT, 1,
				0, 0, 0, save_Button.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 20, 0, 0, wrap);
	}

}
