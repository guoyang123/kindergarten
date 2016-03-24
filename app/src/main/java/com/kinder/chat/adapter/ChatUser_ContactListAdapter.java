package com.kinder.chat.adapter;

import java.util.List;

import cn.kinder.bean.ContactListModel;

import com.kinder.chat.customviews.ChatUserContactlistAdapterLinearLayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ChatUser_ContactListAdapter extends BaseAdapter {

	private Context context;
	private float pro,screenW,screenH;
	private List<ContactListModel> models;
	public ChatUser_ContactListAdapter(Context context,float pro,float screenW,float screenH)
	{
		this.context=context;
		this.pro=pro;
		this.screenW=screenW;
		this.screenH=screenH;
	}
	
	public void setModels(List<ContactListModel> models) {
		this.models = models;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(models!=null)
		{
			return models.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null)
		{
			convertView=new ChatUserContactlistAdapterLinearLayout(context,pro,screenW,screenH);
		}
		ChatUserContactlistAdapterLinearLayout adapter=(ChatUserContactlistAdapterLinearLayout)convertView;
		adapter.contactlistAdapterView.initViewData(models.get(position));
		
		return convertView;
	}

}
