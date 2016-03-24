package com.kinder.chat;

import android.widget.Toast;
import cn.kinder.bean.ContactListDataSource;

import com.kinder.app.tools.KinderNetWork;
import com.kinder.chat.customviews.ChatUser_ContactMainViewXmlView;

public abstract class ContactlistActivity_BC extends   ContactlistActivity  {

	protected ChatUser_ContactMainViewXmlView mainView;
	protected ContactListDataSource dataSource;
	
	/**根据班级环信ID获取班级家长*/
	protected void interface_getUsers_byNetWork1(String groupid)
	{
		KinderNetWork.interface_getUsers_byNetWork(this, getEventMessage(),groupid);
	}
	
	
	
	/**通讯录信息获取成功*/
	protected void succ_getContanctList(Object obj) 
	{
		// TODO Auto-generated method stub
		stopLoading();
		if(obj!=null&&obj instanceof ContactListDataSource)
		{
			ContactListDataSource source=(ContactListDataSource)obj;
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
	
	/**数据初始化*/
	private void initMainViewData()
	{
		
		mainView.initMainViewData(this.dataSource.getContactModels());
	}
}
