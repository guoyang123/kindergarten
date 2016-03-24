package com.kinder.chat.adapter;

import java.util.List;

import cn.kinder.bean.ContactListModel;
import cn.kinder.bean.UserModel;

import com.kinder.chat.customviews.ChatUserContactlistAdapterLinearLayout;
import com.kinder.chat.customviews.ContactUsers_AdapterLinearLayout;
import com.kinder.chat.customviews.GroupDetail_AdapterLinearLayout;
import com.kinder.chat.model.ContactModel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GroupDetailAdapter extends BaseAdapter {

	private Context context;
	private float pro,screenW,screenH;
	private List<ContactModel> models;
	public GroupDetailAdapter(Context context,float pro,float screenW,float screenH)
	{
		this.context=context;
		this.pro=pro;
		this.screenW=screenW;
		this.screenH=screenH;
	}
	
	public void setModels(List<ContactModel> models) {
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
			convertView=new GroupDetail_AdapterLinearLayout(context,pro,screenW,screenH);
		}
		GroupDetail_AdapterLinearLayout adapter=(GroupDetail_AdapterLinearLayout)convertView;
		adapter.contactlistAdapterView.initViewData(models.get(position));
		
		return convertView;
	}

}
