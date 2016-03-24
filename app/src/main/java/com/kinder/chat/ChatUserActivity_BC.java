package com.kinder.chat;

import android.content.Intent;
import android.widget.Toast;

import com.easemob.chatuidemo.activity.ChatActivity;
import com.kinder.app.tools.KinderNetWork;
import com.kinder.chat.customviews.ChatUserMainViewXmlView;
import com.kinder.login.model.Login_DataSource;
import com.kinder.perfect.model.PerfectDataSource;
import com.myt360.kindergarten.Kind_BaseActivity;

public abstract class ChatUserActivity_BC extends Kind_BaseActivity {

	protected ChatUserMainViewXmlView mainView;
	protected String userid;

	protected PerfectDataSource dataSource;
	/**获取个人信息接口*/
	protected void interface_getUserInfo_ByNetWork()
	{
		if(userid!=null&&!userid.equals(""))
		{
			KinderNetWork.get_UserInfo_ByNetWork(this, getEventMessage(),userid);//qilifengxiang
		}else
		{
			Toast.makeText(this, "userid为空，无法调用接口获取数据", 0).show();
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
		if(obj!=null&&obj instanceof PerfectDataSource)
		{
			PerfectDataSource source=(PerfectDataSource)obj;
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
	protected  void initMainViewData(PerfectDataSource source)
	{
	  if(source!=null)
	  {
		  mainView.initMainViewData(source);
	  }
	}
	
	protected void logic_clickTalkBtn() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, ChatActivity.class);
		 intent.putExtra("userId", userid);
		 startActivity(intent);
	}
}
