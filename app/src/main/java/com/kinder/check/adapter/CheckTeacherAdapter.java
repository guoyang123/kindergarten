package com.kinder.check.adapter;

import java.util.List;

import com.kinder.check.customviews.Check_TeacherAdapterXmlView;
import com.kinder.check.customviews.Check_TeacherAdapterXmlViewLinearLayout;
import com.kinder.check.model.TeacherWrapModel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CheckTeacherAdapter extends BaseAdapter {

	private List<TeacherWrapModel> datas;
	private Context context;
	private float pro,screenW,screenH;
	
	
	public CheckTeacherAdapter(Context context, float pro, float screenW,
			float screenH) {
		super();
		this.context = context;
		this.pro = pro;
		this.screenW = screenW;
		this.screenH = screenH;
	}

	public void setDatas(List<TeacherWrapModel> datas) {
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
		Check_TeacherAdapterXmlViewLinearLayout adapterview=(Check_TeacherAdapterXmlViewLinearLayout)convertView;
		if(adapterview==null)
		{
			adapterview=new Check_TeacherAdapterXmlViewLinearLayout(context,pro,screenW,screenH);
		}
		adapterview.teacherAdapterView.initData(position,datas.get(position));
		return adapterview;
	}

}
