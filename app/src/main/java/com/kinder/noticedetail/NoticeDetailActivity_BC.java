package com.kinder.noticedetail;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.Toast;
import cn.kinder.bean.BabyModel;

import com.kinder.app.tools.KinderNetWork;
import com.kinder.notice.model.JoinModel;
import com.kinder.notice.model.NoticeListModel;
import com.kinder.noticedetail.customviews.NoticeDetailMainViewXmlView;
import com.kinder.noticedetail.model.NoticeDetail_DataSource;
import com.myt360.kindergarten.Kind_BaseActivity;
import com.tour.app.sign.SignDialogListener;
import com.tour.app.sign.SignDialog_VC;

public abstract class NoticeDetailActivity_BC extends Kind_BaseActivity {

	protected NoticeDetailMainViewXmlView mainView;

	protected NoticeDetail_DataSource dataSource;
	protected NoticeListModel noticelistmodel;
	protected String keyword;//关键词收索
	
	
	/**获取bundle数据*/
	public void initParam()
	{
		Bundle bundle=getIntent().getBundleExtra("bundle");
		noticelistmodel=(NoticeListModel)bundle.getSerializable("noticelistmodel");
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
		if(obj!=null&&obj instanceof NoticeDetail_DataSource)
		{
			NoticeDetail_DataSource source=(NoticeDetail_DataSource)obj;
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
	
	/**成功获取数据*/
	protected void succ_signData(Object obj)
	{
		stopLoading();
		if(obj!=null&&obj instanceof NoticeDetail_DataSource)
		{
			NoticeDetail_DataSource source=(NoticeDetail_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				Toast.makeText(this, "报名成功", 0).show();
				//将报名的baby显示到已报名的baby集合中
				mainView.partView.refreshAdapter(dataSource);
				
				//this.finish();
			}else 
			{
				Toast.makeText(this, source.getErrorMsg(), 0).show();
			}
		}
	}
	/**数据初始化*/
	protected  void initMainViewData()
	{
		mainView.initMainViewData(this.dataSource);
	}
	
	protected void logic_part(SignDialogListener listener) {
		// TODO Auto-generated method stub
		if(this.dataSource!=null)
		{
			List<BabyModel> babyModels=this.dataSource.getHomeBabyModel();
			if(babyModels!=null&&babyModels.size()>0)
			{
				if(babyModels.size()==1)
				{
					addBabyToDatasource(babyModels);
					JoinModel joinModel=new JoinModel("1",babyModels.get(0).getBabyid()+"");
					KinderNetWork.interface_Sign_byNetWork(this, getEventMessage(), joinModel.getBabyids(), joinModel.getIsjoin(),noticelistmodel.getNoticeid()+"");
					
				}else
				{
					new SignDialog_VC(this, app.pro, app.screenW, app.screenH,babyModels ,"1")
					.setSignDialogListener(listener);
				}
			}
			
		}
	}
	protected void logic_nopart(SignDialogListener listener) {
		// TODO Auto-generated method stub
		if(this.dataSource!=null)
		{
			List<BabyModel> babyModels=this.dataSource.getHomeBabyModel();
			if(babyModels!=null&&babyModels.size()>0)
			{
				if(babyModels.size()==1)
				{
					JoinModel joinModel=new JoinModel("2",babyModels.get(0).getBabyid()+"");
					KinderNetWork.interface_Sign_byNetWork(this, getEventMessage(), joinModel.getBabyids(), joinModel.getIsjoin(),noticelistmodel.getNoticeid()+"");
				}else
				{
					new SignDialog_VC(this, app.pro, app.screenW, app.screenH,babyModels ,"2")
					.setSignDialogListener(listener);
				}
			}
			
		}
	}
	
	/**数据源中添加报名宝宝数据*/
	protected void addBabyToDatasource(List<BabyModel> model)
	{
		if(this.dataSource!=null)
		{
			List<BabyModel> models=this.dataSource.getBabyModel();
			if(models!=null)
			{
				models.addAll(model);
			}else
			{
				models=new ArrayList<BabyModel>();
				models.addAll(model);
			}
			this.dataSource.setBabynum((dataSource.getBabynum()+1));
			this.dataSource.setParentnum((dataSource.getParentnum()+1));
		}
	}
}
