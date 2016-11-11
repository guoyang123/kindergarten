package com.kinder.parent.customviews;

import android.content.Context;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.kinder.parent.adapter.ParentAdapter;
import com.kinder.parent.model.ArticleListModel;
import com.kinder.parent.viewsxml.ParentMainViewXml;
import com.kinder.perfect.model.PerfectDataSource;

import java.util.List;

import cn.kinder.bean.BabyModel;
import cn.kinder.bean.UserModel;

public class ParentMainViewXmlView extends ParentMainViewXml 
{

	private ParentAdapter adapter;
	public ParentMainViewXmlView(Context context, float pro, float screenW,
			float screenH,UserModel user) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		adapter=new ParentAdapter(context, pro, screenW, screenH,user);
		this.listView.setAdapter(adapter);
	}

	public void setListener(OnItemClickListener onItemClickListener,OnRefreshListener2<ListView> onrefreshListener)
	{
		this.listView.setOnItemClickListener(onItemClickListener);
		this.listView.setOnRefreshListener(onrefreshListener);
	}
	
	/**数据初始化*/
	public void initViewData(List<ArticleListModel> models) {
		// TODO Auto-generated method stub
		adapter.setModels(models);
		adapter.notifyDataSetChanged();
		
	}

	public void refreshAdapter() {
		// TODO Auto-generated method stub
		adapter.notifyDataSetChanged();
		this.listView.onRefreshComplete();
	}



}
