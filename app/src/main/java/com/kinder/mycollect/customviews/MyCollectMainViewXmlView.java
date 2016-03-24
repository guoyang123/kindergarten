package com.kinder.mycollect.customviews;

import java.util.List;

import android.content.Context;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.kinder.mycollect.adapter.MyCollectAdapter;
import com.kinder.mycollect.viewsxml.MyCollectMainViewXml;
import com.kinder.parent.model.ArticleListModel;

public class MyCollectMainViewXmlView extends MyCollectMainViewXml {

	private MyCollectAdapter adapter;
	public MyCollectMainViewXmlView(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		adapter=new MyCollectAdapter(context,pro,screenW,screenH);
	   this.listView.setAdapter(adapter);
	}

	public void setListener(OnClickListener onClickListener,OnItemClickListener onItemClickListener,OnRefreshListener2<ListView> onrefreshListener)
	{
		this.titleBarView.setListener(onClickListener);
		this.listView.setOnItemClickListener(onItemClickListener);
		this.listView.setOnRefreshListener(onrefreshListener);
	}
	
	/**数据初始化*/
	public void initViewData(List<ArticleListModel> models) {
		// TODO Auto-generated method stub
		adapter.setModels(models);
		adapter.notifyDataSetChanged();
		
	}
}
