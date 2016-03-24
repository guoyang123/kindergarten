package com.kinder.parent;

import java.io.Serializable;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import cn.kinder.util.iyuehuPreference;

import com.kinder.app.tools.KinderNetWork;
import com.kinder.app.tools.ShareUtils;
import com.kinder.parent.customviews.ParentDetailMainViewXmlView;
import com.kinder.parent.model.ArticleDetail_DataSource;
import com.kinder.parent.model.ArticleListModel;
import com.kinder.parent.model.ArticleModel;
import com.kinder.parent.model.Collect_DataSource;
import com.kinder.parent.model.PraiseShare_DataSource;
import com.myt360.kindergarten.Kind_BaseActivity;
import com.myt360.kindergarten.R;

public  abstract class ParentDetailActivity_BC extends Kind_BaseActivity {

	protected ParentDetailMainViewXmlView mainView;
	protected ArticleDetail_DataSource dataSource;
	protected ArticleListModel articleListModel;
	protected void interface_getArticleDetail_byNetWork()
	{
		if(articleListModel==null)
		{
			return;
		}
		KinderNetWork.interface_getArticleDetail_byNetWork(this, getEventMessage(),String.valueOf(articleListModel.getArticleid()));
	}
	//顶踩分享
	protected void interface_praiseshare_byNetWork(String action)
	{
		KinderNetWork.interface_praiseshare_byNetWork(this, getEventMessage(),String.valueOf(articleListModel.getArticleid()),action);
	}
	//收藏
	protected void interface_collect_byNetWork(String action)
	{
		KinderNetWork.interface_collect_byNetWork(this, getEventMessage(),String.valueOf(articleListModel.getArticleid()),action);
	}
	/**获取bundle数据*/
	public void initParam(Bundle savedInstanceState)
	{
		if(savedInstanceState!=null)
		{
			Serializable s=savedInstanceState.getSerializable("articleListModel");
			if(s!=null&&s instanceof ArticleListModel)
			{
				articleListModel=(ArticleListModel)s;
				Toast.makeText(this, "回复onrestore:"+articleListModel, 0).show();
				Log.e("buzz1", "mainView:"+mainView+"_articleListModel:"+articleListModel);
			}
		}else
		{
			Bundle bundle=getIntent().getBundleExtra("bundle");
			articleListModel=(ArticleListModel)bundle.getSerializable("articleListModel");
			
		}
		
	}
	
	/**开始获取数据*/
	protected void start_getData(Object obj)
	{
		startLoading();
	}
	/**成功获取数据*/
	protected void succ_getData(Object obj)
	{
		stopLoading();
		if(obj!=null&&obj instanceof ArticleDetail_DataSource)
		{
			ArticleDetail_DataSource source=(ArticleDetail_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				this.dataSource=source;
				initMainViewData();
			}else 
			{
				Toast.makeText(this, source.getErrorMsg(), 0).show();
			}
		}
	}
	/**失败获取数据*/
	protected void fail_getData(Object obj)
	{
		stopLoading();
	}
	/**数据初始化*/
	protected  void initMainViewData()
	{
		
		mainView.initViewData(this.dataSource.getArticleModel());
	}
	
	
	/**开始顶踩数据*/
	protected void start_praiseshareData(Object obj)
	{
		startLoading();
	}
	/**成功获取数据*/
	protected void succ_praiseshareData(Object obj)
	{
		stopLoading();
		if(obj!=null&&obj instanceof PraiseShare_DataSource)
		{
			PraiseShare_DataSource source=(PraiseShare_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				logic_topoperation(source);
				
			}else 
			{
				Toast.makeText(this, source.getErrorMsg(), 0).show();
			}
		}
	}
	/**顶踩分享成功后的逻辑处理*/
	private void logic_topoperation(PraiseShare_DataSource source) {
		// TODO Auto-generated method stub
		String action=source.getAction();
		if(action.equals(PraiseShare_DataSource.TOP))
		{
			
			if(this.dataSource!=null)
			{
				this.dataSource.getArticleModel().setIsupdwn(1);
				this.dataSource.getArticleModel().setArticlup(this.dataSource.getArticleModel().getArticlup()+1);
			    this.mainView.bottomView.praiseView.icon_ImageView.setImageResource(R.drawable.article_praised);
			}
			
		}else if(action.equals(PraiseShare_DataSource.STEP))
		{
			
			if(this.dataSource!=null)
			{
				this.dataSource.getArticleModel().setIsupdwn(2);
				this.dataSource.getArticleModel().setArticldown(this.dataSource.getArticleModel().getArticldown()+1);
			}
			
		}
		mainView.refreshTopData(this.dataSource.getArticleModel());
		
		Toast.makeText(this, "成功", 0).show();
	}
	/**失败获取数据*/
	protected void fail_praiseshareData(Object obj)
	{
		stopLoading();
	}
	
	
	protected void logic_clickCollectBtn() {
		// TODO Auto-generated method stub
		if(this.dataSource!=null&&this.dataSource.getArticleModel()!=null)
		{
			ArticleModel model=this.dataSource.getArticleModel();
			int iscollect=model.getIscollected();
			if(iscollect==0)//已收藏，调用取消收藏接口
			{
				interface_collect_byNetWork("2");
			}else
			{
				interface_collect_byNetWork("1");
			}
		}
	}
	/**开始收藏数据*/
	protected void start_collectData(Object obj)
	{
		startLoading();
	}
	/**成功获取数据*/
	protected void succ_collectData(Object obj)
	{
		stopLoading();
		if(obj!=null&&obj instanceof Collect_DataSource)
		{
			Collect_DataSource source=(Collect_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				logic_collectbyNetWork(source);
				
			}else 
			{
				Toast.makeText(this, source.getErrorMsg(), 0).show();
			}
		}
	}
	/**收藏取消收藏成功后的逻辑处理*/
	private void logic_collectbyNetWork(Collect_DataSource source) {
		// TODO Auto-generated method stub
		String collect=source.getCollect();
		if(this.dataSource!=null&&this.dataSource.getArticleModel()!=null)
		{
			ArticleModel model=this.dataSource.getArticleModel();
			if(collect.equals("1"))//收藏
			{
				model.setIscollected(0);
			    model.setColcount(model.getColcount()+1);
				mainView.bottomView.changeStatus(0,model.getColcount());
				
			}else if(collect.equals("2"))//取消收藏
			{
				model.setIscollected(1);
				model.setColcount(model.getColcount()-1);
				mainView.bottomView.changeStatus(1,model.getColcount());
			}
		}
	}
	/**失败获取数据*/
	protected void fail_collectData(Object obj)
	{
		stopLoading();
	}
	
	/**
	 * 分享
	 * */
	
	public void logic_click_share(){
		//
		if(dataSource!=null)
		{
			ArticleModel model=dataSource.getArticleModel();
			 if(model!=null){//model.getTopictitle()
				 
				 ShareUtils.openShare(this,model.getArtiletitle(),
						 model.getArtiletitle(),
						 model.getArticleurl()!=null?model.getArticleurl():model.getRedirctUrl(),
								 model.getThumb());
			 }
		}
	};


	protected void logic_clickUpBtn(String type) {
		// TODO Auto-generated method stub
		if(this.dataSource!=null&&dataSource.getArticleModel()!=null)
		{
			int isUpdwn=dataSource.getArticleModel().getIsupdwn();
			if(isUpdwn==0)//未进行操作
			{
				interface_praiseshare_byNetWork(type);
			}else
			{
				Toast.makeText(this, "只能顶或踩一次", 0).show();
			}
		}
	}
}
