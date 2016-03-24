package com.kinder.chat.viewsxml;

import android.content.Context;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.kinder.chat.customviews.ContactUser_TitleBarXmlView;
import com.kinder.parent.customviews.ParentDetail_TitleBarXmlView;
import com.myt360.app.customviews.MyRelativeLayout;


public class ContactUser_MainViewXml extends MyRelativeLayout {

	public ContactUser_TitleBarXmlView titleBarView;
	public ListView listView;
	public ContactUser_MainViewXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	  
		titleBarView=new ContactUser_TitleBarXmlView(context,pro,screenW,screenH);
		titleBarView.setId(430);
		LayoutParams titleBarView_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		titleBarView.setLayoutParams(titleBarView_params);
		this.addView(titleBarView);
		
		
		listView=new ListView(context);
		listView.setId(431);
		LayoutParams listView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		listView_param.addRule(RelativeLayout.BELOW,titleBarView.getId());
		listView.setLayoutParams(listView_param);
		this.addView(listView);
		
	}

}
