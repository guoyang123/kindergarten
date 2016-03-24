package com.kinder.chat.customviews;

import java.util.List;

import android.content.Context;
import android.widget.AdapterView.OnItemClickListener;

import cn.kinder.bean.ContactListModel;
import cn.kinder.util.MeasureViewHeight;

import com.kinder.chat.adapter.ChatUser_ContactListAdapter;
import com.kinder.chat.viewsxml.ChatUser_ContactMainViewXml;


public class ChatUser_ContactMainViewXmlView extends
		ChatUser_ContactMainViewXml {
	private ChatUser_ContactListAdapter adapter;
	public ChatUser_ContactMainViewXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		adapter=new ChatUser_ContactListAdapter(context,pro,screenW,screenH);
	    this.listview.setAdapter(adapter);
	}

	public void setListener(OnClickListener listener,OnItemClickListener onItemClickListener)
	{
	  this.titleBarView.setlistener(listener);
	  this.listview.setOnItemClickListener(onItemClickListener);
	}

	/**初始化数据*/
	public void initMainViewData(List<ContactListModel> models) 
	{
		// TODO Auto-generated method stub
		if(models!=null&&models.size()>0)
		{
			adapter.setModels(models);
			adapter.notifyDataSetChanged();
			MeasureViewHeight.measureListViewHeight(listview);
		}
		
	}
}
