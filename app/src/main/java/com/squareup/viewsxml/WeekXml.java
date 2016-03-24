package com.squareup.viewsxml;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;

import com.squareup.timessquare.CalendarCellView;
import com.squareup.timessquare.CalendarRowView;

public class WeekXml extends CalendarRowView{

	public CalendarCellView one_calendarCellView;
	public CalendarCellView two_calendarCellView;
	public CalendarCellView three_calendarCellView;
	public CalendarCellView four_calendarCellView;
	public CalendarCellView five_calendarCellView;
	public CalendarCellView six_calendarCellView;
	public CalendarCellView seven_calendarCellView;
	public WeekXml(Context context,float pro,float screenW,float screenH) 
	{
		super(context);
		// TODO Auto-generated constructor stub
	
		
		one_calendarCellView=new CalendarCellView(context);
		one_calendarCellView.setId(3851);
		ViewGroup.LayoutParams one_calendarCellView_param=new ViewGroup.LayoutParams
				(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		one_calendarCellView.setLayoutParams(one_calendarCellView_param);
		one_calendarCellView.setTextSize((int)(pro*12));
		one_calendarCellView.setClickable(true);
		one_calendarCellView.getPaint().setFakeBoldText(true);//设置粗体
		one_calendarCellView.setGravity(Gravity.CENTER);
		this.addView(one_calendarCellView);
		
		
		//2
		two_calendarCellView=new CalendarCellView(context);
		two_calendarCellView.setId(3852);
		ViewGroup.LayoutParams two_calendarCellView_param=new ViewGroup.LayoutParams
				(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		two_calendarCellView.setLayoutParams(two_calendarCellView_param);
		two_calendarCellView.setTextSize((int)(pro*12));
		two_calendarCellView.setClickable(true);
		two_calendarCellView.getPaint().setFakeBoldText(true);//设置粗体
		two_calendarCellView.setGravity(Gravity.CENTER);
		this.addView(two_calendarCellView);
		
		//3
		three_calendarCellView=new CalendarCellView(context);
		three_calendarCellView.setId(3853);
		ViewGroup.LayoutParams three_calendarCellView_param=new ViewGroup.LayoutParams
				(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		three_calendarCellView.setLayoutParams(three_calendarCellView_param);
		three_calendarCellView.setTextSize((int)(pro*12));
		three_calendarCellView.setClickable(true);
		three_calendarCellView.getPaint().setFakeBoldText(true);//设置粗体
		three_calendarCellView.setGravity(Gravity.CENTER);
		this.addView(three_calendarCellView);
		//4
		four_calendarCellView=new CalendarCellView(context);
		four_calendarCellView.setId(3854);
		ViewGroup.LayoutParams four_calendarCellView_param=new ViewGroup.LayoutParams
				(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		four_calendarCellView.setLayoutParams(four_calendarCellView_param);
		four_calendarCellView.setTextSize((int)(pro*12));
		four_calendarCellView.setClickable(true);
		four_calendarCellView.getPaint().setFakeBoldText(true);//设置粗体
		four_calendarCellView.setGravity(Gravity.CENTER);
		this.addView(four_calendarCellView);
		//5
		five_calendarCellView=new CalendarCellView(context);
		five_calendarCellView.setId(3855);
		ViewGroup.LayoutParams five_calendarCellView_param=new ViewGroup.LayoutParams
				(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		five_calendarCellView.setLayoutParams(five_calendarCellView_param);
		five_calendarCellView.setTextSize((int)(pro*12));
		five_calendarCellView.setClickable(true);
		five_calendarCellView.getPaint().setFakeBoldText(true);//设置粗体
		five_calendarCellView.setGravity(Gravity.CENTER);
		this.addView(five_calendarCellView);
		//6
		six_calendarCellView=new CalendarCellView(context);
		six_calendarCellView.setId(3856);
		ViewGroup.LayoutParams six_calendarCellView_param=new ViewGroup.LayoutParams
				(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		six_calendarCellView.setLayoutParams(six_calendarCellView_param);
		six_calendarCellView.setTextSize((int)(pro*12));
		six_calendarCellView.setClickable(true);
		six_calendarCellView.getPaint().setFakeBoldText(true);//设置粗体
		six_calendarCellView.setGravity(Gravity.CENTER);
		this.addView(six_calendarCellView);
		//7
		seven_calendarCellView=new CalendarCellView(context);
		seven_calendarCellView.setId(3857);
		ViewGroup.LayoutParams seven_calendarCellView_param=new ViewGroup.LayoutParams
				(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		seven_calendarCellView.setLayoutParams(seven_calendarCellView_param);
		seven_calendarCellView.setTextSize((int)(pro*12));
		seven_calendarCellView.setClickable(true);
		seven_calendarCellView.getPaint().setFakeBoldText(true);//设置粗体
		seven_calendarCellView.setGravity(Gravity.CENTER);
		this.addView(seven_calendarCellView);
	}

}
