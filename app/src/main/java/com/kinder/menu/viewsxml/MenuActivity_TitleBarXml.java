package com.kinder.menu.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.menu.customviews.Chat_TitleBarXmlView;
import com.kinder.menu.customviews.Check_TitleBarXmlView;
import com.kinder.menu.customviews.Notice_TitleBarXmlView;
import com.kinder.menu.customviews.Parent_TitleBarXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class MenuActivity_TitleBarXml extends MyRelativeLayout {

	public Parent_TitleBarXmlView parent_Titlebar;
	public Chat_TitleBarXmlView chat_TitleBar;
	public Check_TitleBarXmlView check_Titlebar;
	public Notice_TitleBarXmlView notice_TitleBar;
	
	public MenuActivity_TitleBarXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		parent_Titlebar=new Parent_TitleBarXmlView(context,pro,screenW,screenH);
		parent_Titlebar.setId(2881);
		LayoutParams parent_Titlebar_params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		parent_Titlebar.setLayoutParams(parent_Titlebar_params);
		this.addView(parent_Titlebar);
		parent_Titlebar.setVisibility(View.GONE);
		chat_TitleBar=new Chat_TitleBarXmlView(context,pro,screenW,screenH);
		chat_TitleBar.setId(2882);
		LayoutParams chat_TitleBar_params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		chat_TitleBar.setLayoutParams(chat_TitleBar_params);
		this.addView(chat_TitleBar);
		chat_TitleBar.setVisibility(View.GONE);
		
		check_Titlebar=new Check_TitleBarXmlView(context,pro,screenW,screenH);
		check_Titlebar.setId(2883);
		LayoutParams check_Titlebar_params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		check_Titlebar.setLayoutParams(check_Titlebar_params);
		this.addView(check_Titlebar);
		check_Titlebar.setVisibility(View.GONE);
		
		notice_TitleBar=new Notice_TitleBarXmlView(context,pro,screenW,screenH);
		notice_TitleBar.setId(2884);
		LayoutParams notice_TitleBar_params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		notice_TitleBar.setLayoutParams(notice_TitleBar_params);
		this.addView(notice_TitleBar);
		notice_TitleBar.setVisibility(View.GONE);
		
	}

}
