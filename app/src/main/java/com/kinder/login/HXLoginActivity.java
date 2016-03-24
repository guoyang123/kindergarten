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
import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.UserModel;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;
import com.easemob.chatuidemo.Constant;
import com.easemob.chatuidemo.DemoApplication;
import com.easemob.chatuidemo.DemoHXSDKHelper;
import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.db.UserDao;
import com.easemob.chatuidemo.domain.User;
import com.easemob.chatuidemo.utils.CommonUtils;
import com.kinder.menu.MenuActivity_VC;
import com.kinder.perfect.PerfectActivity_VC;
import com.myt360.kindergarten.Kind_BaseActivity;
import com.myt360.kindergarten.KinderApplication;
/**环信登陆*/
public abstract class HXLoginActivity extends Kind_BaseActivity {
	
	protected boolean autoLogin;
	private boolean progressShow;
	protected void hxLogin(UserModel userModel)
	{
		// 如果用户名密码都有，直接进入主页面
		if (DemoHXSDKHelper.getInstance().isLogined())
		{
			autoLogin = true;
Log.e("buzz1", "getEasemobid:"+userModel.getEasemobid()+"getEasemobpwd:"+userModel.getEasemobpwd());

			startActivity(new Intent(this, MenuActivity_VC.class));
           this.finish();
        
			return;
		}
		login(userModel);
	}
	
	
	private void login(final UserModel userModel)
	{
		if (!CommonUtils.isNetWorkConnected(this)) {
			Toast.makeText(this, R.string.network_isnot_available, Toast.LENGTH_SHORT).show();
			return;
		}
	final 	String currentUsername = userModel.getEasemobid();//libeigefeng
	final	String currentPassword = userModel.getEasemobpwd();//111111
Log.e("buzz1", "getEasemobid:"+userModel.getEasemobid()+"getEasemobpwd:"+userModel.getEasemobpwd());

    

       if (TextUtils.isEmpty(currentUsername)) {
			Toast.makeText(this, R.string.User_name_cannot_be_empty, Toast.LENGTH_SHORT).show();
			return;
		}
		if (TextUtils.isEmpty(currentPassword)) {
			Toast.makeText(this, R.string.Password_cannot_be_empty, Toast.LENGTH_SHORT).show();
			return;
		}

		progressShow = true;
		final ProgressDialog pd = new ProgressDialog(this);
		pd.setCanceledOnTouchOutside(false);
		pd.setOnCancelListener(new OnCancelListener() {

			@Override
			public void onCancel(DialogInterface dialog) {
				progressShow = false;
			}
		});
		pd.setMessage(getString(R.string.Is_landing));
		pd.show();

		final long start = System.currentTimeMillis();
		// 调用sdk登陆方法登陆聊天服务器
		EMChatManager.getInstance().login(currentUsername, currentPassword, new EMCallBack() {

			@Override
			public void onSuccess() {
				if (!progressShow) {
					return;
				}
				// 登陆成功，保存用户名密码
				KinderApplication.getInstance().setUserName(currentUsername);
				KinderApplication.getInstance().setPassword(currentPassword);

				try {
					// ** 第一次登录或者之前logout后再登录，加载所有本地群和回话
					// ** manually load all local groups and
				    EMGroupManager.getInstance().loadAllGroups();
					EMChatManager.getInstance().loadAllConversations();
					// 处理好友和群组
					initializeContacts();
					int logcount=userModel.getLogcount();
					if(logcount>1)
					{
						//跳转到主页面
						skipActivity(MenuActivity_VC.class);
					}else
					{
						//跳转到完善信息
						skipActivity(PerfectActivity_VC.class);
					}
					finish();
	
				} catch (Exception e) {
					e.printStackTrace();
					// 取好友或者群聊失败，不让进入主页面
					runOnUiThread(new Runnable() {
						public void run() {
							pd.dismiss();
							DemoApplication.getInstance().logout(null);
							Toast.makeText(getApplicationContext(), R.string.login_failure_failed, 1).show();
						}
					});
					return;
				}
				// 更新当前用户的nickname 此方法的作用是在ios离线推送时能够显示用户nick
				boolean updatenick = EMChatManager.getInstance().updateCurrentUserNick(
						DemoApplication.currentUserNick.trim());
				if (!updatenick) {
					Log.e("LoginActivity", "update current user nick fail");
				}
				if (!HXLoginActivity.this.isFinishing() && pd.isShowing()) {
					pd.dismiss();
				}
				// 进入主页面
//				Intent intent = new Intent(LoginActivity_BC.this,
//						MenuActivity_VC.class);
//				startActivity(intent);
				
				finish();
			}

			@Override
			public void onProgress(int progress, String status) {
			}

			@Override
			public void onError(final int code, final String message) {
				if (!progressShow) {
					return;
				}
				runOnUiThread(new Runnable() {
					public void run() {
						pd.dismiss();
						Toast.makeText(getApplicationContext(), getString(R.string.Login_failed) + message,
								Toast.LENGTH_SHORT).show();
					}
				});
			}
		});
	}
	
	private void initializeContacts() {
		Map<String, User> userlist = new HashMap<String, User>();
		// 添加user"申请与通知"
		User newFriends = new User();
		newFriends.setUsername(Constant.NEW_FRIENDS_USERNAME);
		String strChat = getResources().getString(
				R.string.Application_and_notify);
		newFriends.setNick(strChat);

		userlist.put(Constant.NEW_FRIENDS_USERNAME, newFriends);
		// 添加"群聊"
		User groupUser = new User();
		String strGroup = getResources().getString(R.string.group_chat);
		groupUser.setUsername(Constant.GROUP_USERNAME);
		groupUser.setNick(strGroup);
		groupUser.setHeader("");
		userlist.put(Constant.GROUP_USERNAME, groupUser);
		
		// 添加"Robot"
		User robotUser = new User();
		String strRobot = getResources().getString(R.string.robot_chat);
		robotUser.setUsername(Constant.CHAT_ROBOT);
		robotUser.setNick(strRobot);
		robotUser.setHeader("");
		userlist.put(Constant.CHAT_ROBOT, robotUser);
		
		// 存入内存
		DemoApplication.getInstance().setContactList(userlist);
		// 存入db
		UserDao dao = new UserDao(HXLoginActivity.this);
		List<User> users = new ArrayList<User>(userlist.values());
		dao.saveContactList(users);
	}
	

}
