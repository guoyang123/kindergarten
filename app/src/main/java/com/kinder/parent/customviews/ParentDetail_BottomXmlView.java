package com.kinder.parent.customviews;

import android.content.Context;

import com.kinder.parent.model.ArticleListModel;
import com.kinder.parent.model.ArticleModel;
import com.kinder.parent.viewsxml.ParentDetail_BottomXml;

public class ParentDetail_BottomXmlView extends ParentDetail_BottomXml {

	public ParentDetail_BottomXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	
	/**设置监听*/
	public void setLisetner(OnClickListener onClickListener)
	{
		this.praiseView.setOnClickListener(onClickListener);
		this.non_praiseView.setOnClickListener(onClickListener);
		this.collectView.setOnClickListener(onClickListener);
		this.shareView.setOnClickListener(onClickListener);
	}
	
	/**收藏状态改变
	 * 
	 * 0:收藏图
	 * 1：取消收藏图标
	 * */
	public void changeStatus(int status,int collectcount)
	{
		if(status==0)
		{
			this.collectView.icon_ImageView.setImageResource(R.getRCode("drawable", "article_collected"));
		}else if(status==1)
		{
			this.collectView.icon_ImageView.setImageResource(R.getRCode("drawable", "article_collect"));
		}
		this.collectView.count_TextView.setText(String.valueOf(collectcount));
	}

    /**数据初始化*/
	public void initViewData(ArticleListModel listmodel) {
		// TODO Auto-generated method stub
		////当前用户是不是已经收藏这个文章0-是 1-否
		int collect= listmodel.getIscollected();
		   if(collect==0)
		   {
			   this.collectView.icon_ImageView.setImageResource(R.getRCode("drawable", "article_collected"));
		   }else if(collect==1)
		   {
			   this.collectView.icon_ImageView.setImageResource(R.getRCode("drawable", "article_collect"));
		   }
			
		   this.collectView.count_TextView.setText(String.valueOf(listmodel.getColcount()));
	}
	
	/**获取网络数据后，数据初始化*/
	public void initDataAfterNetWork(ArticleModel model)
	{
		 //private int articlup	;//	 	顶的数量
		   this.praiseView.count_TextView.setText(String.valueOf(model.getArticlup()));
		//	private int articldown;// 	踩的数量
	       this.non_praiseView.count_TextView.setText(String.valueOf(model.getArticldown()));
	
	}
	
}
