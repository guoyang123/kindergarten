package com.kinder.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.ContactListModel;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMConversation.EMConversationType;
import com.easemob.chatuidemo.Constant;
import com.easemob.chatuidemo.DemoApplication;
import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.activity.ChatActivity;
import com.easemob.chatuidemo.db.InviteMessgeDao;
import com.kinder.app.tools.KinderEventMessage;
import com.kinder.app.tools.KinderNetWork;
import com.kinder.chat.adapter.ChatAllHistoryAdapter;
import com.kinder.menu.MenuActivity_VC;

public class ChatFragment_VC extends ChatFragment_BC {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_conversation_history, container, false);
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if(savedInstanceState != null && savedInstanceState.getBoolean("isConflict", false))
            return;
		errorItem = (RelativeLayout) getView().findViewById(R.id.rl_error_item);
		errorText = (TextView) errorItem.findViewById(R.id.tv_connect_errormsg);		
		
		conversationList.addAll(loadConversationsWithRecentChat());
		
		//调用接口，获取用户头像等信息
	    logic_callInterface();
		
		
		
		
		listView = (ListView) getView().findViewById(R.id.list);
//		adapter = new ChatAllHistoryAdapter(getActivity(), 1, this.contactListModels);
//		listView.setAdapter(adapter);
				
		
		final String st2 = getResources().getString(R.string.Cant_chat_with_yourself);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				ContactListModel model = adapter.getItem(position);
				EMConversation  conversation=model.geteMConversation();
				String username = conversation.getUserName();
				if (username.equals(DemoApplication.getInstance().getUserName()))
					Toast.makeText(getActivity(), st2, 0).show();
				else {
				    // 进入聊天页面
				    Intent intent = new Intent(getActivity(), ChatActivity.class);
				    if(conversation.isGroup()){
				        if(conversation.getType() == EMConversationType.ChatRoom){
				         // it is group chat
	                        intent.putExtra("chatType", ChatActivity.CHATTYPE_CHATROOM);
	                        intent.putExtra("groupId", username);
				        }else{
				         // it is group chat
	                        intent.putExtra("chatType", ChatActivity.CHATTYPE_GROUP);
	                        intent.putExtra("groupId", username);
				        }
				        
				    }else{
				        // it is single chat
                        intent.putExtra("userId", username);
				    }
				    startActivity(intent);
				}
			}
		});
		// 注册上下文菜单
		registerForContextMenu(listView);

		listView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// 隐藏软键盘
//				hideSoftKeyboard();
				return false;
			}

		});
	}
	

	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		this.hidden = hidden;
		if (!hidden) {
			refresh();
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		if (!hidden && ! ((MenuActivity_VC)getActivity()).isConflict) {
			refresh();
		}
	}

	@Override
    public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
        if(((MenuActivity_VC)getActivity()).isConflict){
        	outState.putBoolean("isConflict", true);
        }else if(((MenuActivity_VC)getActivity()).getCurrentAccountRemoved()){
        	outState.putBoolean(Constant.ACCOUNT_REMOVED, true);
        }
    }

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		// if(((AdapterContextMenuInfo)menuInfo).position > 0){ m,
		getActivity().getMenuInflater().inflate(R.menu.delete_message, menu); 
		// }
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		boolean handled = false;
		boolean deleteMessage = false;
		if (item.getItemId() == R.id.delete_message) {
			deleteMessage = true;
			handled = true;
		} else if (item.getItemId() == R.id.delete_conversation) {
			deleteMessage = false;
			handled = true;
		}
		ContactListModel model = adapter.getItem(((AdapterContextMenuInfo) item.getMenuInfo()).position);
	   EMConversation tobeDeleteCons=model.geteMConversation();
		// 删除此会话
		EMChatManager.getInstance().deleteConversation(tobeDeleteCons.getUserName(), tobeDeleteCons.isGroup(), deleteMessage);
		InviteMessgeDao inviteMessgeDao = new InviteMessgeDao(getActivity());
		inviteMessgeDao.deleteMessage(tobeDeleteCons.getUserName());
		adapter.remove(model);
		adapter.notifyDataSetChanged();

		// 更新消息未读数
		((MenuActivity_VC) getActivity()).updateUnreadLabel();
		
		return handled ? true : super.onContextItemSelected(item);
	}

	@Override
	public void transferMsg(Object... arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageBackgroundThread(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageMainThread(Object object) {
		// TODO Auto-generated method stub
		if(object!=null&&object instanceof KinderEventMessage)
		{
			//
			KinderEventMessage msg=(KinderEventMessage)object;
			switch(msg.getCode())
			{
			case KinderEventMessage.MSG_CONTACTLIST_START:
				startLoading();
				break;
			case KinderEventMessage.MSG_CONTACTLIST_SUCCESS:
				succ_getContanctList(msg.getObj());
				break;
			case KinderEventMessage.MSG_CONTACTLIST_FAIL:
				stopLoading();
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onWindowFocusChanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EventMessage initLocalEventMessage() {
		// TODO Auto-generated method stub
		return getEventMessage();
	}

	@Override
	public EventMessage initPlugEventMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
