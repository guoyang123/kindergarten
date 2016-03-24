package com.kinder.setpsw;

import android.widget.Toast;

import cn.kinder.bean.Kinder_DataSource;

import com.kinder.app.tools.KinderNetWork;
import com.kinder.login.model.Login_DataSource;
import com.kinder.setpsw.customviews.SetPswMainViewXmlView;
import com.myt360.kindergarten.Kind_BaseActivity;

public abstract class SetPswActivity_BC extends Kind_BaseActivity {

	protected SetPswMainViewXmlView mainView;
	protected String vertify;
	protected String usertel;
	/**链接网路接口，请求数据*/
	protected void setPsw_Datas_ByNetWork(String password)
	{
		KinderNetWork.setpsw_byNetWork(this, getEventMessage(), usertel,
				password, vertify);
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
		if(obj!=null&&obj instanceof Kinder_DataSource)
		{
			Kinder_DataSource source=(Kinder_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				Toast.makeText(this, "密码设置成功", 0).show();
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
	/**数据初始化*/
	protected  void initMainViewData(Login_DataSource source)
	{
		
	}
	
	protected void logic_clcikFinishBtn() {
		// TODO Auto-generated method stub
		String psw=mainView.getPsw();
		if(psw!=null)
		{
			setPsw_Datas_ByNetWork(psw);
		}
		
	}
}
