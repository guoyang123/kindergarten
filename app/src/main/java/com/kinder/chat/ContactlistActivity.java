/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kinder.chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import android.os.Bundle;
import android.view.View;

import com.easemob.chat.EMContactManager;
import com.easemob.chat.EMGroup;
import com.easemob.chat.EMGroupManager;
import com.easemob.chatuidemo.Constant;
import com.easemob.chatuidemo.DemoApplication;
import com.easemob.chatuidemo.domain.User;
import com.kinder.app.tools.KinderNetWork;
import com.myt360.kindergarten.Kind_BaseActivity;

/**
 * 联系人列表页
 * 
 */
public abstract class ContactlistActivity extends Kind_BaseActivity {
	public static final String TAG = "ContactlistFragment";
	private List<User> contactList;
	protected List<EMGroup> grouplist;
	private List<String> blackList;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		init(savedInstanceState);
	}
	
    private void init(Bundle savedInstanceState)
    {
    	//防止被T后，没点确定按钮然后按了home键，长期在后台又进app导致的crash
		if(savedInstanceState != null && savedInstanceState.getBoolean("isConflict", false))
		{
			return;
		}
		//获取群组信息
		grouplist = EMGroupManager.getInstance().getAllGroups();
		//黑名单列表
		blackList = EMContactManager.getInstance().getBlackListUsernames();
		contactList = new ArrayList<User>();
		// 获取设置contactlist
		getContactList();
		
		
		KinderNetWork.interface_getContactList_byNetWork(this, getEventMessage(), getGroupids(), getUserIds());
		
		
    }
	@Override
	public void onResume() {
		super.onResume();
		
	}
	// 刷新ui
	public void refresh() {
//		try {
//			// 可能会在子线程中调到这方法
//			ContactlistActivity.this.runOnUiThread(new Runnable() {
//				public void run() {
//					getContactList();
//					adapter.notifyDataSetChanged();
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void onDestroy() {
		
		super.onDestroy();
	}
	
	

	/**
	 * 获取联系人列表，并过滤掉黑名单和排序
	 */
	private void getContactList() {
		contactList.clear();
		//获取本地好友列表
		Map<String, User> users = DemoApplication.getInstance().getContactList();
		Iterator<Entry<String, User>> iterator = users.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, User> entry = iterator.next();
			if (!entry.getKey().equals(Constant.NEW_FRIENDS_USERNAME)
			        && !entry.getKey().equals(Constant.GROUP_USERNAME)
			        && !entry.getKey().equals(Constant.CHAT_ROOM)
					&& !entry.getKey().equals(Constant.CHAT_ROBOT)
					&& !blackList.contains(entry.getKey()))
				contactList.add(entry.getValue());
		}
		// 排序
		Collections.sort(contactList, new Comparator<User>() {

			@Override
			public int compare(User lhs, User rhs) {
				return lhs.getUsername().compareTo(rhs.getUsername());
			}
		});
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	}
	
	
	
	/**获取群组id集合*/
	private String getGroupids()
	{
		StringBuffer sb=new StringBuffer();
		if(grouplist!=null&&grouplist.size()>0)
		{
			for(EMGroup group:grouplist)
			{
				sb.append(group.getGroupId()+",");
			}
		    String str=	sb.toString();
			return str.substring(0, str.length()-1);
		}
		
		return null;
	}
	
	/**获取用户id集合*/
	private String getUserIds()
	{
		StringBuffer sb=new StringBuffer();
		if(contactList!=null&&contactList.size()>0)
		{
			for(User group:contactList)
			{
				sb.append(group.getUsername()+",");
			}
		    String str=	sb.toString();
			return str.substring(0, str.length()-1);
		}
		
		return null;
	}
	
}
