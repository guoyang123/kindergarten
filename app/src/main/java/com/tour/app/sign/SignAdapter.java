package com.tour.app.sign;

import java.util.List;

import com.kinder.noticedetail.customviews.NoticeDetail_GridView_Adapterxml_LinearLayout;

import cn.kinder.bean.BabyModel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SignAdapter extends BaseAdapter {

	
	private List<BabyModel> models;
	private Context context;
	private float pro,screenW,screenH;
	
	
	
	public SignAdapter(Context context, float pro, float screenW,
			float screenH) {
		super();
		this.context = context;
		this.pro = pro;
		this.screenW = screenW;
		this.screenH = screenH;
	}

	public void setModels(List<BabyModel> models) {
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
			convertView=new Sign_GridView_Adapterxml_LinearLayout(context,pro,screenW,screenH);
		}
		Sign_GridView_Adapterxml_LinearLayout adapter=(Sign_GridView_Adapterxml_LinearLayout)convertView;
		adapter.adapterXmlView.initViewData(models.get(position));
		return convertView;
	}

}
