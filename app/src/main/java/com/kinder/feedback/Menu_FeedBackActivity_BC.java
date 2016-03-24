package com.kinder.feedback;

import android.widget.Toast;

import com.kinder.app.tools.KinderNetWork;
import com.kinder.feedback.customviews.FeedBackMainViewXmlView;
import com.kinder.feedback.model.FeedBack_DataSource;
import com.kinder.login.model.Login_DataSource;
import com.myt360.kindergarten.Kind_BaseActivity;

public  abstract class Menu_FeedBackActivity_BC extends Kind_BaseActivity {

	
	protected FeedBackMainViewXmlView mainView;

	private void interface_feedback_byNetWork(String text)
	{
		KinderNetWork.interface_feedback_byNetWork(this, getEventMessage(), text);
	}
	
	/**点击提交按钮*/
	protected void logic_clickSubmit() {
		// TODO Auto-generated method stub
		String text=mainView.getFeedText();
		if(text!=null)
		{
			interface_feedback_byNetWork(text);
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
		if(obj!=null&&obj instanceof FeedBack_DataSource)
		{
			FeedBack_DataSource source=(FeedBack_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				Toast.makeText(this, "意见反馈成功", 0).show();
				this.finish();
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
}
