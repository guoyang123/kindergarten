package com.kinder.parent;

import android.widget.Toast;
import cn.kinder.bean.Kinder_DataSource;

import com.kinder.app.tools.KinderNetWork;
import com.kinder.parent.customviews.ParentSearchMainViewXmlView;
import com.kinder.parent.model.ArticleListModel;
import com.kinder.parent.model.Article_DataSource;
import com.myt360.kindergarten.Kind_BaseActivity;

public  abstract class ParentSearchActivity_BC extends Kind_BaseActivity {

	protected ParentSearchMainViewXmlView mainView;
	protected Article_DataSource dataSource;
	
	
	
	protected void interface_getArticle_byNetWork(String keyword,String from,String operationtype)
	{
		KinderNetWork.interface_getArticle_byNetWork(this, getEventMessage(), keyword, from, String.valueOf(Kinder_DataSource.NUM), operationtype);
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
				this.dataSource=source;
				initMainViewData(dataSource);
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
	protected  void initMainViewData(Article_DataSource source)
	{
		
		mainView.initViewData(source.getArticleListModel());
	}
	
	protected void logic_clickItem(int position) {
		// TODO Auto-generated method stub
		ArticleListModel model=this.dataSource.getArticleListModel().get(position-1);
		if(model!=null)
		{
			skip2Activity(ParentDetailActivity_VC.class,"articleListModel",model);//articleListModel
		}
	}
	
	/**点击搜索按钮*/
	protected void logic_clickSearchBtn() {
		// TODO Auto-generated method stub
		//Log.e("buzz1", "====");
		String key=mainView.getSearchText();
		interface_getArticle_byNetWork(key,"0",Kinder_DataSource.OPERATION_NORMAL);
	}
}
