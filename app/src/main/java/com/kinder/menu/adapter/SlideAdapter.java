package com.kinder.menu.adapter;

import java.util.List;

import com.kinder.menu.customviews.MenuLeftAdapterXmlView;
import com.kinder.menu.customviews.SlideMenuAdapterLinearLayout;
import com.kinder.menu.model.SlideModel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SlideAdapter extends BaseAdapter {

	private Context context;
	private float pro,screenW,screenH;
	private List<SlideModel> datas;
	
	
	
	public SlideAdapter(Context context, float pro, float screenW, float screenH) {
		super();
		this.context = context;
		this.pro = pro;
		this.screenW = screenW;
		this.screenH = screenH;
	}

	public void setDatas(List<SlideModel> datas) {
		this.datas = datas;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(datas!=null)
		{
			return datas.size();
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
			convertView=new SlideMenuAdapterLinearLayout(context,pro,screenW,screenH);
		}
		//
		SlideMenuAdapterLinearLayout view=(SlideMenuAdapterLinearLayout)convertView;
		view.slideMenuAdapterView.initData(datas.get(position));
		return convertView;
	}

}
