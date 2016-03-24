package com.kinder.check.customviews;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;

import cn.kinder.bean.CheckModel;
import cn.kinder.bean.SaftyModel;
import cn.kinder.util.MeasureViewHeight;

import com.kinder.check.adapter.CheckTeacherAdapter;
import com.kinder.check.model.TeacherWrapModel;
import com.kinder.check.viewsxml.CheckTeacherXml;

public class CheckTeacherXmlView extends CheckTeacherXml {

	private CheckTeacherAdapter adapter;
	public CheckTeacherXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		adapter=new CheckTeacherAdapter(context,pro,screenW,screenH);
		this.grideView.setAdapter(adapter);
		MeasureViewHeight.measureGridViewHeight(grideView);
		
	}

	/**设置监听*/
	public void setListener(OnItemClickListener onItemClickListener,OnClickListener listener)
	{
		this.grideView.setOnItemClickListener(onItemClickListener);
		this.date_RelativeLayout.setOnClickListener(listener);
	}
	/**数据初始化*/
	public void setDatas(List<TeacherWrapModel> datas)
	{
		adapter.setDatas(datas);
		adapter.notifyDataSetChanged();
		MeasureViewHeight.measureGridViewHeight(grideView);
		
	}
   /**数据初始化*/
	public void initTeacherViewData(List<TeacherWrapModel> datas) {
		// TODO Auto-generated method stub
		setDatas(datas);
	}
	
	
	/**显示安全码信息*/
	public void showSaftyView(SaftyModel saftyModel)
	{
		this.safeView.setVisibility(View.VISIBLE);
		this.babyLeaveView.setVisibility(View.GONE);
		this.safeView.initViewData(saftyModel);
	}
	
	/**显示事假信息*/
	public void showLeaveView(CheckModel checkModel)
	{
		this.safeView.setVisibility(View.GONE);
		this.babyLeaveView.setVisibility(View.VISIBLE);
		this.babyLeaveView.initViewData(checkModel);
	}
	
}
