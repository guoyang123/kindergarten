package com.kinder.parent;

import java.util.List;

import android.widget.Toast;
import cn.kinder.bean.Kinder_DataSource;

import com.kinder.app.tools.KinderNetWork;
import com.kinder.notice.model.NoticeListModel;
import com.kinder.parent.customviews.ParentMainViewXmlView;
import com.kinder.parent.model.ArticleListModel;
import com.kinder.parent.model.Article_DataSource;
import com.myt360.kindergarten.Kinder_BaseFragment;

public  abstract class ParentFragment_BC extends Kinder_BaseFragment {

	protected ParentMainViewXmlView mainView;
	protected Article_DataSource dataSource;
	
	protected void interface_getArticle_byNetWork(String keyword,String from,String operationtype)
	{
		KinderNetWork.interface_getArticle_byNetWork(getActivity(), getEventMessage(), keyword, from, String.valueOf(Kinder_DataSource.NUM), operationtype);
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
		if(obj!=null&&obj instanceof Article_DataSource)
		{
			Article_DataSource source=(Article_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				//this.dataSource=source;
				initMainViewData(source);
			}else 
			{
				Toast.makeText(getActivity(), source.getErrorMsg(), 0).show();
			}
		}
	}
	/**失败获取数据*/
	protected void fail_getData(Object obj)
	{
		stopLoading();
	}
	/**数据初始化*/
	protected  void initMainViewData(Article_DataSource source)
	{
		
		//mainView.initViewData(source.getArticleListModel());
		mainView.listView.onRefreshComplete();
		String type=source.getOperationType();
		if(type!=null&&type.equals(Kinder_DataSource.OPERATION_NORMAL))
		{
			if(this.dataSource!=null&&this.dataSource.getArticleListModel()!=null)
			{
				this.dataSource.getArticleListModel().clear();
			}
			this.dataSource=source;
			mainView.initViewData(dataSource.getArticleListModel());
		}else if(type.equals(Kinder_DataSource.OPERATION_LOADMORE))//加载更多
		{
			List<ArticleListModel> models=source.getArticleListModel();
			if(models==null)
			{
				mainView.refreshAdapter();
				return;
			}
			if(this.dataSource==null||this.dataSource.getArticleListModel()==null)
			{
				this.dataSource=source;
				mainView.initViewData(dataSource.getArticleListModel());
				return;
			}
			this.dataSource.getArticleListModel().addAll(source.getArticleListModel());
			mainView.refreshAdapter();
		}
	}
	
	protected void logic_clickItem(int position) {
		// TODO Auto-generated method stub
		ArticleListModel model=this.dataSource.getArticleListModel().get(position-1);

		if(model!=null)
		{
			skip2Activity(ParentDetailActivity_VC.class,"articleListModel",model);//articleListModel
		}
		
	}
}
