package com.tour.app.sign;

import java.util.List;

import cn.kinder.bean.BabyModel;
import cn.kinder.util.MeasureViewHeight;
import android.content.Context;
import android.widget.AdapterView.OnItemClickListener;

public class SignDialog_MainViewXmlView extends SignDialog_MainViewXml {

	public SignAdapter adapter;
	public SignDialog_MainViewXmlView(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		adapter=new SignAdapter(context,pro,screenW,screenH);
		this.gridView.setAdapter(adapter);
	}

	/**设置监听*/
	public void setListener(OnClickListener listener,OnItemClickListener onItemClickListener)
	{
		this.gridView.setOnItemClickListener(onItemClickListener);
		this.sure_Button.setOnClickListener(listener);
		this.cancel_Button.setOnClickListener(listener);
	}
	/***/
	/**数据初始化*/
	public void setDatas(List<BabyModel> models)
	{
		this.adapter.setModels(models);
		this.adapter.notifyDataSetChanged();
		MeasureViewHeight.measureGridViewHeight(gridView);
	}
}
