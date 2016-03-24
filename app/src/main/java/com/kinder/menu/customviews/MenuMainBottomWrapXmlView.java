package com.kinder.menu.customviews;

import android.content.Context;
import android.graphics.Color;
import android.view.View.OnClickListener;

import com.kinder.menu.viewsxml.MenuMainBottomWrapXml;

public class MenuMainBottomWrapXmlView extends MenuMainBottomWrapXml {

	public MenuMainBottomWrapXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}
	
	/**设置监听*/
	public void setListener(OnClickListener onClickListener)
	{
		this.parent_RelativeLayout.setOnClickListener(onClickListener);
		this.chat_RelativeLayout.setOnClickListener(onClickListener);
		this.check_RelativeLayout.setOnClickListener(onClickListener);
		this.notice_RelativeLayout.setOnClickListener(onClickListener);
	}

	
	/**设置显示图片*/
	public void refreshIcon(int position)
	{
		this.parent_icon_ImageView.setBackgroundResource(R.getRCode("drawable", "home_parent"));
		this.chat_icon_ImageView.setBackgroundResource(R.getRCode("drawable", "home_chat"));
		this.check_icon_ImageView.setBackgroundResource(R.getRCode("drawable", "home_check"));
		this.notice_icon_ImageView.setBackgroundResource(R.getRCode("drawable", "home_notice"));
		
		this.parent_txt_TextView.setTextColor(Color.parseColor("#313131"));
		this.chat_txt_TextView.setTextColor(Color.parseColor("#313131"));
		this.check_txt_TextView.setTextColor(Color.parseColor("#313131"));
		this.notice_txt_TextView.setTextColor(Color.parseColor("#313131"));
		//
		if(position==1)
		{
			this.parent_icon_ImageView.setBackgroundResource(R.getRCode("drawable", "home_parent_selected"));
			this.parent_txt_TextView.setTextColor(Color.parseColor("#6ccfa9"));
			
		}else if(position==2)
		{
			this.chat_icon_ImageView.setBackgroundResource(R.getRCode("drawable", "home_chat_selected"));
			this.chat_txt_TextView.setTextColor(Color.parseColor("#6ccfa9"));
		}else if(position==3)
		{
			this.check_icon_ImageView.setBackgroundResource(R.getRCode("drawable", "home_check_selected"));
			this.check_txt_TextView.setTextColor(Color.parseColor("#6ccfa9"));
		}else if(position==4)
		{
			this.notice_icon_ImageView.setBackgroundResource(R.getRCode("drawable", "home_notice_selected"));
			this.notice_txt_TextView.setTextColor(Color.parseColor("#6ccfa9"));
		}
	}
}
