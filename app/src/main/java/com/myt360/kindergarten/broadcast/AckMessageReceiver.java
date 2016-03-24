package com.myt360.kindergarten.broadcast;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMMessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AckMessageReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		abortBroadcast();
		String msgid = intent.getStringExtra("msgid");
		String from = intent.getStringExtra("from");
		EMConversation conversation = EMChatManager.getInstance().getConversation(from);
		if (conversation != null) {
			// 把message设为已读
			EMMessage msg = conversation.getMessage(msgid);
			if (msg != null) {
				msg.isAcked = true;
			}
		}
	}

}
