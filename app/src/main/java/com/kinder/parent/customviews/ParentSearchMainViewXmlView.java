package com.kinder.parent.customviews;

import java.util.List;

import android.content.Context;
import android.widget.AdapterView.OnItemClickListener;

import cn.kinder.bean.UserModel;
import cn.kinder.util.MeasureViewHeight;

import com.kinder.parent.adapter.ParentAdapter;
import com.kinder.parent.model.ArticleListModel;
import com.kinder.parent.model.ArticleModel;
import com.kinder.parent.viewsxml.ParentSearchMainViewXml;

public class ParentSearchMainViewXmlView extends ParentSearchMainViewXml {

	private ParentAdapter adapter;
	public ParentSearchMainViewXmlView(Context context, float pro,
			float screenW, float screenH,UserModel user) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		adapter=new ParentAdapter(context,pro,screenW,screenH,user);
		this.listView.setAdapter(adapter);
	}
	
	/**设置监听*/
	public void setListener(OnClickListener onClickListener,OnItemClickListener onItemClickListener)
	{
		this.titleBarView.setListener(onClickListener);
		this.listView.setOnItemClickListener(onItemClickListener);
	}
	/**数据初始化*/
	public void initViewData(List<ArticleListModel> models)
	{
		this.adapter.setModels(models);
		this.adapter.notifyDataSetChanged();
	//	MeasureViewHeight.measureListViewHeight(listView);
	}

	/**获取搜索内容*/
	public String getSearchText()
	{
		return this.titleBarView.search_EditText.getText().toString();
	}
}
