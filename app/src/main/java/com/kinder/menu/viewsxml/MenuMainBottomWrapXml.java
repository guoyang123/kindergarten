package com.kinder.menu.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

public class MenuMainBottomWrapXml extends MyRelativeLayout {

	//育儿
	public  RelativeLayout parent_RelativeLayout;
	public ImageView parent_icon_ImageView;
	public TextView parent_txt_TextView;
	//聊天
	public RelativeLayout  chat_RelativeLayout;
	public ImageView chat_icon_ImageView;
	public TextView chat_txt_TextView;
	public TextView unreadLabel_TextView;
	//考勤
	public RelativeLayout  check_RelativeLayout;
	public ImageView check_icon_ImageView;
	public TextView check_txt_TextView;
	//通知
	public RelativeLayout  notice_RelativeLayout;
	public ImageView notice_icon_ImageView;
	public TextView notice_txt_TextView;
	
	
	public MenuMainBottomWrapXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.parseColor("#ffffff"));
		
		
		//育儿
		parent_RelativeLayout=productRelativeLayout(context, pro, 111,
				80, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, this);
		//parent_RelativeLayout.setBackgroundColor(Color.BLACK);
		
		parent_icon_ImageView=productImageView(context, pro, 112,
				20, 20,
				0, 0, 0, 0, 
				0, CENTER_HORIZONTAL, 0, 
				0, 0, 0, 0,
				0, 5, 0, 0, parent_RelativeLayout);
		parent_icon_ImageView.setBackgroundResource(R.getRCode("drawable", "home_parent_selected"));
		parent_txt_TextView=productTextView(context, pro, 113, 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, parent_icon_ImageView.getId(),
				0, CENTER_HORIZONTAL, 0, 
				0, 5, 0, 0, 
				"育儿", 10, "#6ccfa9", parent_RelativeLayout);
		//聊天
		chat_RelativeLayout=productRelativeLayout(context, pro, 114,
				80, LayoutParams.WRAP_CONTENT,
				0, parent_RelativeLayout.getId(), 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, this);
	
		chat_icon_ImageView=productImageView(context, pro, 115,
				20, 20,
				0, 0, 0, 0, 
				0, CENTER_HORIZONTAL, 0, 
				0, 0, 0, 0,
				0, 5, 0, 0, chat_RelativeLayout);
		chat_icon_ImageView.setBackgroundResource(R.getRCode("drawable", "home_chat"));
		
		chat_txt_TextView=productTextView(context, pro, 116, 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, chat_icon_ImageView.getId(),
				0, CENTER_HORIZONTAL, 0, 
				0, 5, 0, 0, 
				"聊天", 10, "#6ccfa9", chat_RelativeLayout);
		unreadLabel_TextView=productTextView(context, pro, 117, 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				0, 0, 0, 
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 5, 10, 0, 
				"100", 10, "#6ccfa9", chat_RelativeLayout);
		
		
		
		//考勤
		check_RelativeLayout=productRelativeLayout(context, pro, 118,
				80, LayoutParams.WRAP_CONTENT,
				0, chat_RelativeLayout.getId(), 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, this);
	
		check_icon_ImageView=productImageView(context, pro, 119,
				20, 20,
				0, 0, 0, 0, 
				0, CENTER_HORIZONTAL, 0, 
				0, 0, 0, 0,
				0, 5, 0, 0, check_RelativeLayout);
		check_icon_ImageView.setBackgroundResource(R.getRCode("drawable", "home_check"));
		
		check_txt_TextView=productTextView(context, pro, 120, 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, check_icon_ImageView.getId(),
				0, CENTER_HORIZONTAL, 0, 
				0, 5, 0, 0, 
				"考勤", 10, "#6ccfa9", check_RelativeLayout);
		
		
		//通知
		notice_RelativeLayout=productRelativeLayout(context, pro, 121,
				80, LayoutParams.WRAP_CONTENT,
				0, check_RelativeLayout.getId(), 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, this);
	
		notice_icon_ImageView=productImageView(context, pro, 122,
				20, 20,
				0, 0, 0, 0, 
				0, CENTER_HORIZONTAL, 0, 
				0, 0, 0, 0,
				0, 5, 0, 0, notice_RelativeLayout);
		notice_icon_ImageView.setBackgroundResource(R.getRCode("drawable", "home_notice"));
		
		notice_txt_TextView=productTextView(context, pro, 123, 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, notice_icon_ImageView.getId(),
				0, CENTER_HORIZONTAL, 0, 
				0, 5, 0, 0, 
				"通知", 10, "#6ccfa9", notice_RelativeLayout);
		
	
	}

}
