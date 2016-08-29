package com.kinder.notice;

import android.widget.Toast;

import com.kinder.notice.customviews.Notice_All_MainViewXmlView;
import com.kinder.notice.model.NoticeListModel;
import com.kinder.notice.model.Notice_DataSource;
import com.myt360.kindergarten.Kinder_BaseFragment;

import java.util.List;

import cn.kinder.bean.Kinder_DataSource;

public abstract class Notice_All_Fragment_BC extends Kinder_BaseFragment {

	protected Notice_All_MainViewXmlView mainView;

	protected Notice_DataSource dataSource;
	
	protected String keyword;//关键词收索
	
	/**开始获取数据*/
	protected void start_getData(Object obj)
	{
		startLoading();
	}
	/**成功获取数据*/
	protected void succ_getData(Object obj)
	{
		stopLoading();
		if(obj!=null&&obj instanceof Notice_DataSource)
		{
			Notice_DataSource source=(Notice_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				initMainViewData(source);
			}else 
			{
				Toast.makeText(getActivity(), source.getErrorMsg(), Toast.LENGTH_SHORT).show();
			}
		}
	}
	/**失败获取数据*/
	protected void fail_getData(Object obj)
	{
		//stopLoading();
	}
	/**数据初始化*/
	protected  void initMainViewData(Notice_DataSource source)
	{
		mainView.listView.onRefreshComplete();
		String type=source.getOperationType();
		if(type!=null&&type.equals(Kinder_DataSource.OPERATION_NORMAL))
		{
			if(this.dataSource!=null&&this.dataSource.getNoticeListModel()!=null)
			{
				this.dataSource.getNoticeListModel().clear();
			}
			this.dataSource=source;
			mainView.initViewData(dataSource.getNoticeListModel());
		}else if(type.equals(Kinder_DataSource.OPERATION_LOADMORE))//加载更多
		{
			List<NoticeListModel> models=source.getNoticeListModel();
			if(models==null)
			{
				mainView.refreshAdapter();
				return;
			}
			if(this.dataSource==null||this.dataSource.getNoticeListModel()==null)
			{
				this.dataSource=source;
				mainView.initViewData(dataSource.getNoticeListModel());
				return;
			}
			this.dataSource.getNoticeListModel().addAll(source.getNoticeListModel());
			mainView.refreshAdapter();
		}
	}
}
