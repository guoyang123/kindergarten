package com.kinder.parent.customviews;

import android.content.Context;

import cn.kinder.util.TimeUtils;

import com.kinder.parent.model.ArticleListModel;
import com.kinder.parent.model.ArticleModel;
import com.kinder.parent.viewsxml.ParentDetail_InfoXml;

public class ParentDetail_InfoXmlView extends ParentDetail_InfoXml {

	public ParentDetail_InfoXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	/**数据初始化*/
	public void initViewData(ArticleListModel model)
	{
		this.title_TextView.setText(model.getArtiletitle());
		//
		//this.desc_TextView.setText("来源:"+model.getArticlefrom()+"  类型:"+getArticleFrom(model.getArticletype())+"     时间:"+TimeUtils.getActivityDetailTime(model.getAddtime()));
		setInfo(model.getArticlefrom(),getArticleFrom(model.getArticletype()),model.getAddtime());
	}
//	
	public void setInfo(String from,String type,String time)
	{
		this.desc_TextView.setText("来源:"+from+"  类型:"+type+"     时间:"+TimeUtils.getActivityDetailTime(time));
	}
	/**获取来源*/
	public String getArticleFrom(String type)
	{
		String from=null;
		if(type!=null&&!type.equals(""))
		{
			if(type.equals("0"))
			{
				from="普通";
			}else if(type.equals("1"))
			{
				from="抓取";
			}else if(type.equals("2"))
			{
				from="转发";
			}
		}
		return from;
	}
}
