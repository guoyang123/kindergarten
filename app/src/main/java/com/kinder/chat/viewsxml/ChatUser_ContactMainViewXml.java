package com.kinder.chat.viewsxml;

import android.content.Context;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.kinder.chat.customviews.Chat_ContactListTitleBarXmlView;
import com.myt360.app.customviews.MyRelativeLayout;
/**通讯录ui*/
public class ChatUser_ContactMainViewXml extends MyRelativeLayout {

	public Chat_ContactListTitleBarXmlView titleBarView;
	public ListView listview;
	public ChatUser_ContactMainViewXml(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		titleBarView=new Chat_ContactListTitleBarXmlView(context,pro,screenW,screenH);
		titleBarView.setId(5000);
		LayoutParams titleBarView_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		titleBarView.setLayoutParams(titleBarView_params);
		this.addView(titleBarView);
		
		
		
		listview=productListView(context, pro, 5001, 
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, titleBarView.getId(),
				0, 0, 0,
				0, 0, 0, 0, this);
	}

}
