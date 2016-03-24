package com.kinder.chat.customviews;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.widget.AdapterView.OnItemClickListener;

import cn.kinder.bean.UserModel;
import cn.kinder.util.MeasureViewHeight;

import com.kinder.chat.adapter.ContactUsersAdapter;
import com.kinder.chat.model.ContactModel;
import com.kinder.chat.viewsxml.ContactUser_MainViewXml;

public class ContactUser_MainViewXmlView extends ContactUser_MainViewXml {

	private ContactUsersAdapter adapter;
	public ContactUser_MainViewXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		adapter=new ContactUsersAdapter(context, pro, screenW, screenH);
		this.listView.setAdapter(adapter);
	}

	/**设置监听*/
	public void setListener(OnClickListener onClickListener,OnItemClickListener onItemClickListener)
	{
		this.listView.setOnItemClickListener(onItemClickListener);
		this.titleBarView.setListener(onClickListener);
	}
	
	/**数据初始化*/
	public void initMainViewData(List<ContactModel> models)
	{
		adapter.setModels(models);
		adapter.notifyDataSetChanged();
		MeasureViewHeight.measureListViewHeight(listView);
	}
}
