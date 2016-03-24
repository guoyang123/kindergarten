package com.kinder.chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

import android.util.Log;
import android.util.Pair;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.kinder.bean.ContactListDataSource;
import cn.kinder.bean.ContactListModel;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMGroup;
import com.easemob.chatuidemo.domain.User;
import com.kinder.app.tools.KinderNetWork;
import com.kinder.chat.adapter.ChatAllHistoryAdapter;
import com.kinder.chat.customviews.ChatMainViewXmlView;
import com.kinder.parent.customviews.ParentMainViewXmlView;
import com.myt360.kindergarten.Kinder_BaseFragment;

public  abstract class ChatFragment_BC extends Kinder_BaseFragment {

	//protected ChatMainViewXmlView mainView;
	
	protected ListView listView;
	protected ChatAllHistoryAdapter adapter;
	protected RelativeLayout errorItem;
	protected TextView errorText;
	
	protected boolean hidden;
	protected List<EMConversation> conversationList = new ArrayList<EMConversation>();
    	protected List<ContactListModel> contactListModels=new ArrayList<ContactListModel>();
	
    	protected void logic_callInterface() {
    		// TODO Auto-generated method stub
    		String[] str=getGroupids();
    		if(str!=null)
    		{
    			KinderNetWork.interface_getChatList_byNetWork(getActivity(), getEventMessage(), str[0],
    					str[1]);
    		}
    	}
    	
    	public void refresh()
	{
//		conversationList.clear();
//		conversationList.addAll(loadConversationsWithRecentChat());
//		if(adapter != null)
//		    adapter.notifyDataSetChanged();
    		logic_callInterface();
	}
	
	public void refresh2()
	{
		//contactListModels.clear();
		//conversationList.addAll(loadConversationsWithRecentChat());
		if(adapter != null)
		    adapter.notifyDataSetChanged();
	}
	/**
	 * 获取所有会话
	 * 
	 * @param context
	 * @return
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        +	 */
	protected List<EMConversation> loadConversationsWithRecentChat() 
	{
		// 获取所有会话，包括陌生人
		Hashtable<String, EMConversation> conversations = EMChatManager.getInstance().
		        getAllConversations();
		// 过滤掉messages size为0的conversation
		/**
		 * 如果在排序过程中有新消息收到，lastMsgTime会发生变化
		 * 影响排序过程，Collection.sort会产生异常
		 * 保证Conversation在Sort过程中最后一条消息的时间不变 
		 * 避免并发问题
		 */
		List<Pair<Long, EMConversation>> sortList = new ArrayList<Pair<Long, EMConversation>>();
		synchronized (conversations) {
			for (EMConversation conversation : conversations.values()) {
				if (conversation.getAllMessages().size() != 0) {
					//if(conversation.getType() != EMConversationType.ChatRoom){
						sortList.add(new Pair<Long, EMConversation>(conversation.getLastMessage().getMsgTime(), conversation));
					//}
				}
			}
		}
		try {
			// Internal is TimSort algorithm, has bug
			sortConversationByLastChatTime(sortList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<EMConversation> list = new ArrayList<EMConversation>();
		for (Pair<Long, EMConversation> sortItem : sortList) 
		{
			list.add(sortItem.second);
		}
		
		return list;
	}

	/**
	 * 根据最后一条消息的时间排序
	 * 
	 * @param usernames
	 */
	protected void sortConversationByLastChatTime(List<Pair<Long, EMConversation>> conversationList) {
		Collections.sort(conversationList, new Comparator<Pair<Long, EMConversation>>() {
			@Override
			public int compare(final Pair<Long, EMConversation> con1, final Pair<Long, EMConversation> con2) {

				if (con1.first == con2.first) {
					return 0;
				} else if (con2.first > con1.first) {
					return 1;
				} else {
					return -1;
				}
			}

		});
	}

	
	
	/**获取群组id集合
	 * [0]:groupids
	 * [1]:userids
	 * 
	 * */
	protected String[] getGroupids()
	{
		List<EMConversation>  css=loadConversationsWithRecentChat();
		StringBuffer groups=new StringBuffer();
		StringBuffer users=new StringBuffer();
		String[] ids=new String[2];
		if(css!=null&&css.size()>0)
		{
			for(EMConversation cs:css )
			{
				boolean isGroup=cs.isGroup();
				if(isGroup)
				{
					groups.append(cs.getUserName()+",");
				}else
				{
					users.append(cs.getUserName()+",");
				}
			}

		    String groupstr=	groups.toString();
		    if(groupstr!=null&&groupstr.length()>0)
		    {
		    	  groupstr= groupstr.substring(0, groupstr.length()-1);
				   
		    }
		   String userstr=	users.toString();
		   if(userstr!=null&&userstr.length()>0)
		    {
			   userstr= userstr.substring(0, userstr.length()-1);
				   
		    }
		    if(groupstr!=null&&groupstr.length()>0)
		    {
		    	  ids[0]=groupstr;
		    }
		    if(userstr!=null&&userstr.length()>0)
		    {
		    	  ids[1]=userstr;
		    }
			return ids;
		}
		
		return null;
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
				prase(source);
				refresh2();
				
			}else
			{
				Toast.makeText(getActivity(), source.getErrorMsg(), 0).show();
			}
		}
		
	}
	
	/**将EMConversation数据与ContactListModel结合*/
	public void prase(ContactListDataSource source)
	{
		
		List<EMConversation> ems=loadConversationsWithRecentChat();
		List<ContactListModel> models=source.getContactModels();
		List<ContactListModel> clearModels=new ArrayList<ContactListModel>();
		if(models!=null&&models.size()>0&&ems!=null&&ems.size()>0)
		{
			for(ContactListModel model:models)
			{
				int type=model.getType();
			    String emsid=null;
				if(type==ContactListModel.USER)
				{
					emsid=model.getContactUserModel().getUserModel().getEasemobid();
				}else
				{
					emsid=model.getClassModel().getGroupid();
				}
		//	Log.e("buzz1", "==ems size:"+ems.size());
				for(EMConversation em:ems )
				{
					if(emsid!=null&&!emsid.equals(""))
					{
						if(em.getUserName().equals(emsid))
						{
							model.seteMConversation(em);
						}
					}
				}
			}
			//
		
			for(ContactListModel model:models)
			{
				if(model.geteMConversation()==null)
				{
					clearModels.add(model);
				}
			}
			
			models.removeAll(clearModels);
		}
		this.contactListModels=models;
		adapter = new ChatAllHistoryAdapter(getActivity(), 1, this.contactListModels);
//		// 设置adapter
		listView.setAdapter(adapter);
	}
	
	
	
}
