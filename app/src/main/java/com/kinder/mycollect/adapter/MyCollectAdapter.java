package com.kinder.mycollect.adapter;

import java.io.Serializable;
import java.util.List;

import cn.kinder.bean.UserModel;

import com.kinder.mycollect.customviews.MyCollectAdapterLinearLayout;
import com.kinder.parent.customviews.ParentAdapterLinearLayout;
import com.kinder.parent.model.ArticleListModel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MyCollectAdapter extends BaseAdapter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5604854248277013732L;

	private Context context;
	private float pro,screenW,screenH;
	private List<ArticleListModel> models;

	public MyCollectAdapter(Context context, float pro, float screenW,
			float screenH) {
		super();
		this.context = context;
		this.pro = pro;
		this.screenW = screenW;
		this.screenH = screenH;
	}
	public void setModels(List<ArticleListModel> models) {
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
			convertView=new MyCollectAdapterLinearLayout(context,pro,screenW,screenH);
		}
		MyCollectAdapterLinearLayout adapterview=(MyCollectAdapterLinearLayout)convertView;
		adapterview.parentAdapterView.initAdapterData(this.models.get(position));
		
		return convertView;
	}

}
