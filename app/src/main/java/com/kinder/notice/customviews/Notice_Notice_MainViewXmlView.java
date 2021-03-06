package com.kinder.notice.customviews;

import java.util.List;

import android.content.Context;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.kinder.notice.adapter.NoticeContentAdapter;
import com.kinder.notice.model.NoticeListModel;
import com.kinder.notice.viewsxml.Notice_Notice_MainViewXml;

public class Notice_Notice_MainViewXmlView extends Notice_Notice_MainViewXml {

	private NoticeContentAdapter adapter;
	public Notice_Notice_MainViewXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		adapter=new NoticeContentAdapter(context,pro,screenW,screenH);
		this.listView.setAdapter(adapter);
	}

	public void setListener(OnItemClickListener onItemClickListener ,OnRefreshListener2<ListView> onrefreshListener)
	{
		// TODO Auto-generated method stub
		this.listView.setOnItemClickListener(onItemClickListener);
		this.listView.setOnRefreshListener(onrefreshListener);
	}
	
	/**数据初始化*/
	public void initViewData(List<NoticeListModel> models)
	{
		this.adapter.setModels(models);
		refreshAdapter();
	}
	
	
	public void refreshAdapter() {
		// TODO Auto-generated method stub
		adapter.notifyDataSetChanged();
		this.listView.onRefreshComplete();
	}
}
