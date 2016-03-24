package com.kinder.chat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.easemob.chat.EMGroup;
import com.easemob.chat.EMGroupManager;
import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.activity.ChatActivity;
import com.easemob.chatuidemo.activity.ExitGroupDialog;
import com.kinder.app.tools.KinderNetWork;
import com.kinder.chat.customviews.ContactUser_MainViewXmlView;
import com.kinder.chat.customviews.GroupDetail_MainViewXmlView;
import com.kinder.chat.model.ContactUser_DataSource;

public abstract class GroupDetailActivity_BC extends   ContactlistActivity  {

	public static final int REQUEST_CODE_EXIT = 1;
	
	protected GroupDetail_MainViewXmlView mainView;
	protected ContactUser_DataSource dataSource;
	protected ProgressDialog progressDialog;
	/**根据班级环信ID获取班级家长*/
	protected void interface_getUsers_byNetWork()
	{
		KinderNetWork.interface_getUsers_byNetWork(this, getEventMessage(),getIntent().getStringExtra("groupId"));
	}
	
	/**根据环信群号获取环信群信息*/
	protected EMGroup getEMGroup()
	{
		String groupId=getIntent().getStringExtra("groupId");
		if(grouplist!=null&&grouplist.size()>0)
		{
			for(EMGroup group:grouplist)
			{
				if(groupId!=null&&groupId.equals(group.getGroupId()))
				{
					return group;
				}
			}
		}
		return null;
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
	
	/**
	 * 点击退出群组按钮
	 * 
	 * @param view
	 */
	public void exitGroup() {
		startActivityForResult(new Intent(this, ExitGroupDialog.class), REQUEST_CODE_EXIT);
	}
	
	/**
	 * 退出群组
	 * 
	 * @param groupId
	 */
	protected void exitGrop() {
		String st1 = getResources().getString(R.string.Exit_the_group_chat_failure);
		new Thread(new Runnable() {
			public void run() {
				try {
					String groupId=getIntent().getStringExtra("groupId");
Log.e("buzz1", "groupId:"+groupId);
				    EMGroupManager.getInstance().exitFromGroup(groupId);
					runOnUiThread(new Runnable() 
					{
						public void run() 
						{
							progressDialog.dismiss();
							setResult(RESULT_OK);
							finish();
							if(ChatActivity.activityInstance != null)
							    ChatActivity.activityInstance.finish();
						}
					});
				} catch (final Exception e) {
					runOnUiThread(new Runnable() {
						public void run() {
							progressDialog.dismiss();
							Toast.makeText(getApplicationContext(), getResources().getString(R.string.Exit_the_group_chat_failure) + " " + e.getMessage(), 1).show();
						}
					});
				}
			}
		}).start();
	}
}
