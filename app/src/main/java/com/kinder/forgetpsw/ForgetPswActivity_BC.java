package com.kinder.forgetpsw;

import android.widget.Toast;

import com.kinder.app.tools.KinderNetWork;
import com.kinder.forgetpsw.customviews.ForgetPswMainViewXmlView;
import com.kinder.forgetpsw.model.VerfityDataSource;
import com.kinder.login.model.Login_DataSource;
import com.kinder.setpsw.SetPswActivity_VC;
import com.myt360.kindergarten.Kind_BaseActivity;

public abstract class ForgetPswActivity_BC extends Kind_BaseActivity {

	protected ForgetPswMainViewXmlView mainView;
	protected VerfityDataSource dataSource;
	protected String type;//updatepsw修改密码 null:忘记密码
	public void initParam()
	{
		type=getIntent().getStringExtra("type");
	}
	public  void get_Vertify_ByNetWork(String usertel) 
	{
		KinderNetWork.get_Vertify_ByNetWork(this,getEventMessage() , usertel);
	}
	
	/**获取验证码接口*/
	protected void logic_clickVertifyBtn() 
	{
		// TODO Auto-generated method stub
		String phone=mainView.getPhone();
		
		if(phone!=null)
		{
			mainView.setBtnStatus(false);//设置为不可点击
			get_Vertify_ByNetWork(phone);
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
		if(obj!=null&&obj instanceof VerfityDataSource)
		{
			VerfityDataSource source=(VerfityDataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				this.dataSource=source;
			}else 
			{
				mainView.setBtnStatus(true);
				Toast.makeText(this, source.getErrorMsg(), 0).show();
			}
		}
	}
	/**失败获取数据*/
	protected void fail_getData(Object obj)
	{
		stopLoading();
		mainView.setBtnStatus(true);
	}
	/**数据初始化*/
	protected  void initMainViewData(Login_DataSource source)
	{
		
	}
	/**点击下一步*/
	protected void logic_clickNextBtn() {
		// TODO Auto-generated method stub
		if(this.dataSource!=null&&this.dataSource.getSmscode()!=null&&!this.dataSource.getSmscode().equals(""))
		{
			String vertify=mainView.wrapView.checkInfo(dataSource.getSmscode());
			String phone=mainView.getPhone();
			if(vertify!=null&&phone!=null)
			{
				skipActivity(SetPswActivity_VC.class, "vertify", vertify,"usertel",phone,"type",type);
				this.finish();
			}
		}else
		{
			Toast.makeText(this, "请先获取验证码", 0).show();
			return;
		}
	}
}
