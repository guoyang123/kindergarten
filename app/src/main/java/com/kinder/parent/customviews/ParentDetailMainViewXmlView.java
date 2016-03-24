package com.kinder.parent.customviews;

import android.content.Context;

import com.kinder.parent.model.ArticleListModel;
import com.kinder.parent.model.ArticleModel;
import com.kinder.parent.viewsxml.ParentDetailMainViewXml;

public class ParentDetailMainViewXmlView extends ParentDetailMainViewXml {

	private Context context;
	public ParentDetailMainViewXmlView(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		
	}

	/**设置监听*/
	public void setListener(OnClickListener onClickListener)
	{
		this.titleBarView.setListener(onClickListener);
		this.bottomView.setLisetner(onClickListener);
	}
	
	public void initViewBeforeData(ArticleListModel listmodel)
	{
		if(listmodel==null)
		{
			return;
		}
		this.infoView.initViewData(listmodel);
		this.bottomView.initViewData(listmodel);
	}
	
	/**数据初始化*/
	public void initViewData(ArticleModel model)
	{
		if(model==null)
		{
			return;
		}
		this.bottomView.initDataAfterNetWork(model);
		this.infoView.setInfo(model.getArticlefrom(), model.getMenuName(), model.getAddtime());
		String articletype=model.getArticletype();
		if(articletype!=null&&!articletype.equals(""))
		{
			if(articletype.equals("0"))
			{
				this.webView.setwebviewData(model.getArticlecontent(), "code");
			
			}else
			{
				this.webView.setwebviewData(model.getArticleurl(), "url");
			}
		}
		
	}
	/**顶踩数据更新*/
	public void refreshTopData(ArticleModel model)
	{
		this.bottomView.initDataAfterNetWork(model);
	}

	public void onDestroy() {
		// TODO Auto-generated method stub
		this.webView.webView.destroy();
		//Toast.makeText(context, "已经执行view的销毁方法", 0).show();
	}
}
