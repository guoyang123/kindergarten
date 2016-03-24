package com.squareup.viewsxml;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.customviews.CalTitleXmlView;
import com.squareup.customviews.WeekXmlView;
import com.squareup.timessquare.CalendarGridView;
import com.squareup.timessquare.CalendarRowView;

public class MonthXml extends LinearLayout {

//	public TextView title;
	public CalTitleXmlView calTitleView;
	public CalendarGridView calendar_grid;
	public CalendarRowView rowView;
	public MonthXml(Context context,float pro,float screenW,float screenH) 
	{
		super(context);
		// TODO Auto-generated constructor stub
		
		this.setOrientation(VERTICAL);
//		LinearLayout.LayoutParams root_param=new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
//		this.setLayoutParams(root_param);
	
		AbsListView.LayoutParams root_param=new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(root_param);
		
		
		 calTitleView=new CalTitleXmlView(context,pro,screenW,screenH);
		LayoutParams calTitleView_param=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		//calTitleView_param.setMargins(0, 0, 0, (int)(DensityUtil.dip2px(context,4) * pro));
		calTitleView.setLayoutParams(calTitleView_param);
		this.addView(calTitleView);
		
		 calendar_grid=new CalendarGridView(context);
		LayoutParams calendar_grid_param=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		calendar_grid.setLayoutParams(calendar_grid_param);
		this.addView(calendar_grid);
		
		rowView=new CalendarRowView(context);
		ViewGroup.LayoutParams rowView_param=new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		rowView.setLayoutParams(rowView_param);
		calendar_grid.addView(rowView);
		
		TextView tv1=new TextView(context);
		ViewGroup.LayoutParams tv1_param=new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		tv1.setLayoutParams(tv1_param);
		tv1.setTextSize((int)(14*pro));
		rowView.addView(tv1);
		
		TextView tv2=new TextView(context);
		ViewGroup.LayoutParams tv2_param=new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		tv2.setLayoutParams(tv2_param);
		tv2.setTextSize((int)(14*pro));
		rowView.addView(tv2);
		
		TextView tv3=new TextView(context);
		ViewGroup.LayoutParams tv3_param=new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		tv3.setLayoutParams(tv3_param);
		tv3.setTextSize((int)(14*pro));
		rowView.addView(tv3);
		
		
		TextView tv4=new TextView(context);
		ViewGroup.LayoutParams tv4_param=new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		tv4.setLayoutParams(tv4_param);
		tv4.setTextSize((int)(14*pro));
		rowView.addView(tv4);
		
		
		TextView tv5=new TextView(context);
		ViewGroup.LayoutParams tv5_param=new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		tv5.setLayoutParams(tv5_param);
		tv5.setTextSize((int)(14*pro));
		rowView.addView(tv5);
		
		
		TextView tv6=new TextView(context);
		ViewGroup.LayoutParams tv6_param=new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		tv6.setLayoutParams(tv6_param);
		tv6.setTextSize((int)(14*pro));
		rowView.addView(tv6);
		
		TextView tv7=new TextView(context);
		ViewGroup.LayoutParams tv7_param=new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		tv7.setLayoutParams(tv7_param);
		tv7.setTextSize((int)(14*pro));
		rowView.addView(tv7);
		
		
		WeekXmlView week1=new WeekXmlView(context,pro,screenW,screenH);
		calendar_grid.addView(week1);
		
		WeekXmlView week2=new WeekXmlView(context,pro,screenW,screenH);
		calendar_grid.addView(week2);
		
		WeekXmlView week3=new WeekXmlView(context,pro,screenW,screenH);
		calendar_grid.addView(week3);
		
		WeekXmlView week4=new WeekXmlView(context,pro,screenW,screenH);
		calendar_grid.addView(week4);
		
		WeekXmlView week5=new WeekXmlView(context,pro,screenW,screenH);
		calendar_grid.addView(week5);
		
		WeekXmlView week6=new WeekXmlView(context,pro,screenW,screenH);
		calendar_grid.addView(week6);
		
		
	}

}
