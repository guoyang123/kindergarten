package com.kinder.chat;

import android.widget.Toast;

import com.kinder.app.tools.KinderNetWork;
import com.kinder.chat.customviews.ContactUser_MainViewXmlView;
import com.kinder.chat.model.ContactUser_DataSource;

public abstract class ContactUsersActivity_BC extends   ContactlistActivity  {

	protected ContactUser_MainViewXmlView mainView;
	protected ContactUser_DataSource dataSource;
	
	/**根据班级环信ID获取班级家长*/
	protected void interface_getUsers_byNetWork()
	{
		KinderNetWork.interface_getUsers_byNetWork(this, getEventMessage(),getIntent().getStringExtra("groupId"));
	}
	
	
	
	/**通讯录信息获取成功*/
	protected void succ_getContanctList(Object obj) 
	{
		// TODO Auto-generated method stub
		stopLoading();
			
		if(obj!=null&&obj instanceof ContactUser_DataSource)
		{
			ContactUser_DataSource source=(ContactUser_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals("")||errorCode.trim().equals(""))
			{
				this.dataSource=source;
				initMainViewData();
			}else
			{
				Toast.makeText(this, source.getErrorMsg(), 0).show();
			}
		}
	}
	
	/**数据初始化*/
	private void initMainViewData()
	{
		
		mainView.initMainViewData(this.dataSource.getUberModelList());
	}
}
