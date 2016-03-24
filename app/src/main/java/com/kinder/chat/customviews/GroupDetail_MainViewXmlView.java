package com.kinder.chat.customviews;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.widget.AdapterView.OnItemClickListener;

import com.easemob.chat.EMGroup;
import com.kinder.chat.adapter.GroupDetailAdapter;
import com.kinder.chat.model.ContactModel;
import com.kinder.chat.viewsxml.GroupDetail_MainViewXml;

public class GroupDetail_MainViewXmlView extends GroupDetail_MainViewXml {

	private EMGroup emGroup ;
	public GroupDetail_MainViewXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
	}

	/**设置监听*/
	public void setListener(OnClickListener onClickListener,OnItemClickListener onItemClickListener)
	{
		this.titleBarView.setListener(onClickListener);
		this.exit_Button.setOnClickListener(onClickListener);
		
	}

	/**数据初始化*/
	public void initMainViewData(List<ContactModel> uberModelList) {
		// TODO Auto-generated method stub
		if(uberModelList==null)
		{
			return;
		}
	   this.userswrapview.initViewData(uberModelList);
	   
	   if(emGroup!=null)
	   {
		   for(ContactModel contactModel:uberModelList)
		   {
			   String easemobid=contactModel.getUserModel().getEasemobid();
			   if(easemobid.equals(emGroup.getOwner()))
			   {
				   this.groupuserview.setInfo("群主",contactModel.getUserModel().getUsername() );
			   }
		   }
	   }
	}

	/**初始化群信息*/
	public void initMainViewDataBeforeNetWork(EMGroup emGroup) {
		// TODO Auto-generated method stub
		if(emGroup==null)
		{
			return;
		}
		this.emGroup=emGroup;
		this.groupnameview.setInfo("群名称", emGroup.getGroupName());
		this.groupuserview.setInfo("群主", emGroup.getOwner());
		this.groupdescview.setInfo("群介绍", emGroup.getDescription());
	}
}
