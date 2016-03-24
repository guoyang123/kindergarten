package com.kinder.check.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.myt360.app.customviews.MyRelativeLayout;
import com.squareup.customviews.CalTitleXmlView;
import com.squareup.interfaces.OnClickOtherDateListener;
import com.squareup.timessquare.CalendarPickerView;

public class CheckUserFragmentXml extends MyRelativeLayout {

	public TextView babyname_TextView;
	public CalTitleXmlView calTitleView;
	//日历控件
//	public CalendarPickerViewPager canledarView;
	public CalendarPickerView canledarView;
	public TextView month_TextView;
	public TextView days_TextView;
	public Button send_Button;
	public CheckUserFragmentXml(Context context, float pro, float screenW, float screenH,OnClickOtherDateListener onClickOtherDateListener) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		
		ScrollView scroll=productScrollView(context, pro, 3101,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0,0 ,
				0, 0, 0,
				0, 0, 0, 10, this);
		scroll.setBackgroundColor(Color.parseColor("#f0f0f0"));
		RelativeLayout wrap=productRelativeLayout(context, pro, 3102,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, scroll);
		
		babyname_TextView=productTextView(context, pro, 3109,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				0, CENTER_HORIZONTAL, 0,
				0, 10, 0, 0, 
				"宝宝:王小明", 13, "#3c3c3c", wrap);//
		
		
		calTitleView=new CalTitleXmlView(context,pro,screenW,screenH);
		calTitleView.setId(3110);
		LayoutParams calTitleView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		//calTitleView_param.setMargins(0, 0, 0, (int)(DensityUtil.dip2px(context,4) * pro));
		calTitleView_param.setMargins((int)(DensityUtil.dip2px(context,13) * pro), 0, (int)(DensityUtil.dip2px(context,13) * pro), 0);
		calTitleView_param.addRule(RelativeLayout.BELOW,babyname_TextView.getId());
		calTitleView.setLayoutParams(calTitleView_param);
		wrap.addView(calTitleView);
		calTitleView.setBackgroundColor(Color.parseColor("#f5f5f5"));
			
		canledarView=new CalendarPickerView (context,pro,screenW,screenH);//CalendarPickerViewPager
		canledarView.setId(3108);
		LayoutParams canledarView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);//(int)(DensityUtil.dip2px(context,290) * pro)
		canledarView_param.addRule(RelativeLayout.CENTER_HORIZONTAL);
		canledarView_param.addRule(RelativeLayout.BELOW,calTitleView.getId());
		canledarView_param.setMargins((int)(DensityUtil.dip2px(context,13) * pro), 0, (int)(DensityUtil.dip2px(context,13) * pro), 0);
		canledarView.setLayoutParams(canledarView_param);
		wrap.addView(canledarView);
		//
		//canledarView.selectionMode=SelectionMode.MULTIPLE;
				
		
	
		RelativeLayout date_wrap=productRelativeLayout(context, pro, 3104,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, canledarView.getId(),
				0, CENTER_HORIZONTAL, 0,
				0, 0, 0, 0,
				0, 20, 0, 0,wrap);//wrap
		
		month_TextView=productTextView(context, pro, 3105,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0, 
				0, 0, 0,
				0, 0, 0, 0,
				"八月请假天数:", 13, "#3c3c3c", date_wrap);
		
		days_TextView=productTextView(context, pro, 3106,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, month_TextView.getId(), 0, 0, 
				0, 0, 0,
				5, 0, 0, 0,
				"", 12, "#6ccfa9", date_wrap);
		
		
		View view=productView(context, pro, 3107,
				LayoutParams.MATCH_PARENT,200, 
				0, 0, 0, date_wrap.getId(),
				0, 0, 0, 
				0, 0, 0, 0, 
				0, 22, 0, 0,wrap);//wrap
		view.setBackgroundColor(Color.parseColor("#ffffff"));//
		
		
		send_Button=productButton(context, pro, 3111,
				260, 36, 
				0, 0, 0, date_wrap.getId(),
				0, CENTER_HORIZONTAL, 0,
				0, 75, 0, 0, 
				"发送密码给接孩子的人", 14, "#ffffff", wrap);//wrap
		send_Button.setBackgroundResource(R.getRCode("drawable", "userlogin_selector"));
	
	}

}
