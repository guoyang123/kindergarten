package com.kinder.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import cn.kinder.bean.LogininfoModel;
import cn.kinder.bean.UserModel;
import cn.kinder.user.DbOperationModel;
import cn.kinder.util.iyuehuPreference;

import com.easemob.EMCallBack;
import com.easemob.EMError;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;
import com.easemob.chatuidemo.Constant;
import com.easemob.chatuidemo.DemoApplication;
import com.easemob.chatuidemo.DemoHXSDKHelper;
import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.activity.LoginActivity;
import com.easemob.chatuidemo.activity.MainActivity;
import com.easemob.chatuidemo.activity.RegisterActivity;
import com.easemob.chatuidemo.db.UserDao;
import com.easemob.chatuidemo.domain.User;
import com.easemob.chatuidemo.utils.CommonUtils;
import com.easemob.exceptions.EaseMobException;
import com.kinder.app.tools.DevicePlug_Util;
import com.kinder.app.tools.KinderNetWork;
import com.kinder.login.customviews.LoginMainViewXmlView;
import com.kinder.login.model.Login_DataSource;
import com.kinder.menu.MenuActivity_VC;
import com.kinder.perfect.PerfectActivity_VC;
import com.myt360.kindergarten.Kind_BaseActivity;
import com.myt360.kindergarten.KinderApplication;

public abstract class LoginActivity_BC extends HXLoginActivity {

	public LoginMainViewXmlView mainView;
	protected Login_DataSource dataSource;
	/**链接网路接口，请求数据*/
	protected void get_Login_ByNetWork(String usertel,String password)
	{
		KinderNetWork.get_Login_ByNetWork(this, getEventMessage(),usertel,password);
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
		if(obj!=null&&obj instanceof Login_DataSource)
		{
			Login_DataSource source=(Login_DataSource)obj;
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
	protected  void initMainViewData(Login_DataSource source)
	{
		//将数据存到数据库
		LogininfoModel infoModel=source.getLogininfoModel();
		UserModel userModel=source.getUserModel();
		//将设备信息存入文件
		if(infoModel!=null)
		{
			//infoModel.setDevice(infoModel.getDevice().replaceAll(":", ","));
			String device=new DevicePlug_Util(this).getDeviceIMEI();
			infoModel.setDevice(device.replaceAll(":", ","));
			infoModel.save(this);
		}
		if(userModel!=null)
		{
			UserModel user=DbOperationModel.getUserInfo(this);
			if(user!=null)
			{
				DbOperationModel.deleteUserInfo(this, user);
			}
			//
			//用户信息存入数据库
			DbOperationModel.saveUserInfo(this, userModel);
			//跳转到完善信息
			//skipActivity(PerfectActivity_VC.class);
			hxLogin(userModel);
			
			
		}
		
		
	}
	
	/**点击登陆按钮*/
	protected void logic_clickBtn() 
	{
		// TODO Auto-generated method stub
		String[] infos=mainView.getInfos();
		if(infos!=null)
		{
			get_Login_ByNetWork(infos[0], infos[1]);
		}
	}
	
	
	/**
	 * 注册
	 * 
	 * @param view
	 */
	public void register() {
		final String username = "18722167404";
		final String pwd = "123456";

		if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(pwd)) {
			final ProgressDialog pd = new ProgressDialog(this);
			pd.setMessage(getResources().getString(R.string.Is_the_registered));
			pd.show();

			new Thread(new Runnable() {
				public void run() {
					try {
						// 调用sdk注册方法
						EMChatManager.getInstance().createAccountOnServer(username, pwd);
						runOnUiThread(new Runnable() {
							public void run() {
								if (!LoginActivity_BC.this.isFinishing())
									pd.dismiss();
								// 保存用户名
								KinderApplication.getInstance().setUserName(username);
								Toast.makeText(getApplicationContext(), getResources().getString(R.string.Registered_successfully), 0).show();
								finish();
							}
						});
					} catch (final EaseMobException e) {
						runOnUiThread(new Runnable() {
							public void run() {
								if (!LoginActivity_BC.this.isFinishing())
									pd.dismiss();
								int errorCode=e.getErrorCode();
								if(errorCode==EMError.NONETWORK_ERROR){
									Toast.makeText(getApplicationContext(), getResources().getString(R.string.network_anomalies), Toast.LENGTH_SHORT).show();
								}else if(errorCode == EMError.USER_ALREADY_EXISTS){
									Toast.makeText(getApplicationContext(), getResources().getString(R.string.User_already_exists), Toast.LENGTH_SHORT).show();
								}else if(errorCode == EMError.UNAUTHORIZED){
									Toast.makeText(getApplicationContext(), getResources().getString(R.string.registration_failed_without_permission), Toast.LENGTH_SHORT).show();
								}else if(errorCode == EMError.ILLEGAL_USER_NAME){
								    Toast.makeText(getApplicationContext(), getResources().getString(R.string.illegal_user_name),Toast.LENGTH_SHORT).show();
								}else{
									Toast.makeText(getApplicationContext(), getResources().getString(R.string.Registration_failed) + e.getMessage(), Toast.LENGTH_SHORT).show();
								}
							}
						});
					}
				}
			}).start();

		}
	}
}
