package com.kinder.noticedetail.customviews;

import java.util.List;

import android.content.Context;

import cn.kinder.bean.BabyModel;
import cn.kinder.util.MeasureViewHeight;

import com.kinder.noticedetail.adapter.NoticeDetail_Adapter;
import com.kinder.noticedetail.model.NoticeDetail_DataSource;
import com.kinder.noticedetail.viewsxml.NoticeDetail_PartXml;

public class NoticeDetail_PartXmlView extends NoticeDetail_PartXml
{
    private NoticeDetail_Adapter adapter;
	public NoticeDetail_PartXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		adapter=new NoticeDetail_Adapter(context,pro,screenW,screenH);
		this.gridView.setAdapter(adapter);
	}
	
	/**数据初始化*/
	public void setDatas(List<BabyModel> models)
	{
		this.adapter.setModels(models);
		this.adapter.notifyDataSetChanged();
		MeasureViewHeight.measureGridViewHeight(gridView);
	}

	/**数据初始化*/
	public void initViewData(NoticeDetail_DataSource dataSource) {
		// TODO Auto-generated method stub
		List<BabyModel> babyModel=dataSource.getBabyModel();
		this.adapter.setModels(babyModel);
		
		refreshAdapter(dataSource);
		
	}
 
	public void refreshAdapter(NoticeDetail_DataSource dataSource)
	{
		this.adapter.notifyDataSetChanged();
		MeasureViewHeight.measureGridViewHeight(gridView);
		this.people_TextView.setText("已报名宝宝:"+dataSource.getBabynum()+"人    "+"已报名家长:"+dataSource.getParentnum()+"人");
	}
}
