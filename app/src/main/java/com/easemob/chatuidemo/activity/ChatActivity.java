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
package com.easemob.chatuidemo.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.easemob.EMChatRoomChangeListener;
import com.easemob.EMError;
import com.easemob.EMEventListener;
import com.easemob.EMNotifierEvent;
import com.easemob.EMValueCallBack;
import com.easemob.applib.controller.HXSDKHelper;
import com.easemob.applib.model.GroupRemoveListener;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMChatRoom;
import com.easemob.chat.EMContactManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMConversation.EMConversationType;
import com.easemob.chat.EMGroup;
import com.easemob.chat.EMGroupManager;
import com.easemob.chat.EMMessage;
import com.easemob.chat.EMMessage.ChatType;
import com.easemob.chat.ImageMessageBody;
import com.easemob.chat.LocationMessageBody;
import com.easemob.chat.NormalFileMessageBody;
import com.easemob.chat.TextMessageBody;
import com.easemob.chat.VideoMessageBody;
import com.easemob.chat.VoiceMessageBody;
import com.easemob.chatuidemo.DemoApplication;
import com.easemob.chatuidemo.DemoHXSDKHelper;
import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.adapter.ExpressionAdapter;
import com.easemob.chatuidemo.adapter.ExpressionPagerAdapter;
import com.easemob.chatuidemo.adapter.MessageAdapter;
import com.easemob.chatuidemo.adapter.VoicePlayClickListener;
import com.easemob.chatuidemo.domain.RobotUser;
import com.easemob.chatuidemo.utils.CommonUtils;
import com.easemob.chatuidemo.utils.ImageUtils;
import com.easemob.chatuidemo.utils.SmileUtils;
import com.easemob.chatuidemo.widget.ExpandGridView;
import com.easemob.chatuidemo.widget.PasteEditText;
import com.easemob.exceptions.EaseMobException;
import com.easemob.util.EMLog;
import com.easemob.util.PathUtil;
import com.easemob.util.VoiceRecorder;
import com.kinder.app.tools.KinderEventMessage;
import com.kinder.app.tools.KinderNetWork;
import com.kinder.chat.ChatUserActivity_VC;
import com.kinder.chat.GruopDetailActivity_VC;
import com.kinder.chat.model.ContactModel;
import com.kinder.chat.model.ContactUser_DataSource;
import com.kinder.perfect.model.PerfectDataSource;
import com.myt360.kindergarten.Kind_BaseActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.UserModel;
import cn.kinder.user.DbOperationModel;

/**
 *
 * 
 */
public  class ChatActivity extends Kind_BaseActivity implements  OnClickListener,EMEventListener{
	private static final String TAG = "buzz1";
	private static final int REQUEST_CODE_EMPTY_HISTORY = 2;
	public static final int REQUEST_CODE_CONTEXT_MENU = 3;
	private static final int REQUEST_CODE_MAP = 4;
	public static final int REQUEST_CODE_TEXT = 5;
	public static final int REQUEST_CODE_VOICE = 6;
	public static final int REQUEST_CODE_PICTURE = 7;
	public static final int REQUEST_CODE_LOCATION = 8;
	public static final int REQUEST_CODE_NET_DISK = 9;
	public static final int REQUEST_CODE_FILE = 10;
	public static final int REQUEST_CODE_COPY_AND_PASTE = 11;
	public static final int REQUEST_CODE_PICK_VIDEO = 12;
	public static final int REQUEST_CODE_DOWNLOAD_VIDEO = 13;
	public static final int REQUEST_CODE_VIDEO = 14;
	public static final int REQUEST_CODE_DOWNLOAD_VOICE = 15;
	public static final int REQUEST_CODE_SELECT_USER_CARD = 16;
	public static final int REQUEST_CODE_SEND_USER_CARD = 17;
	public static final int REQUEST_CODE_CAMERA = 18;
	public static final int REQUEST_CODE_LOCAL = 19;
	public static final int REQUEST_CODE_CLICK_DESTORY_IMG = 20;
	public static final int REQUEST_CODE_GROUP_DETAIL = 21;
	public static final int REQUEST_CODE_SELECT_VIDEO = 23;
	public static final int REQUEST_CODE_SELECT_FILE = 24;
	public static final int REQUEST_CODE_ADD_TO_BLACKLIST = 25;

	public static final int RESULT_CODE_COPY = 1;
	public static final int RESULT_CODE_DELETE = 2;
	public static final int RESULT_CODE_FORWARD = 3;
	public static final int RESULT_CODE_OPEN = 4;
	public static final int RESULT_CODE_DWONLOAD = 5;
	public static final int RESULT_CODE_TO_CLOUD = 6;
	public static final int RESULT_CODE_EXIT_GROUP = 7;

	public static final int CHATTYPE_SINGLE = 1;
	public static final int CHATTYPE_GROUP = 2;
	public static final int CHATTYPE_CHATROOM = 3;

	public static final String COPY_IMAGE = "EASEMOBIMG";
	private View recordingContainer;
	private ImageView micImage;
	private TextView recordingHint;
	private ListView listView;
	private PasteEditText mEditTextContent;
	private View buttonSetModeKeyboard;
	private View buttonSetModeVoice;
	private View buttonSend;
	private View buttonPressToSpeak;
	// private ViewPager expressionViewpager;
	private LinearLayout emojiIconContainer;
	private LinearLayout btnContainer;
	private ImageView locationImgview;
	private View more;
	private int position;
	private ClipboardManager clipboard;
	private ViewPager expressionViewpager;
	private InputMethodManager manager;
	private List<String> reslist;
	private Drawable[] micImages;
	private int chatType;
	private EMConversation conversation;
	public static ChatActivity activityInstance = null;
	public String toChatUsername;
	public String nickName;
	private VoiceRecorder voiceRecorder;
	private MessageAdapter adapter;
	private File cameraFile;
	static int resendPos;

	private GroupListener groupListener;

	private ImageView iv_emoticons_normal;
	private ImageView iv_emoticons_checked;
	private RelativeLayout edittext_layout;
	private ProgressBar loadmorePB;
	private boolean isloading;
	private final int pagesize = 20;
	private boolean haveMoreData = true;
	private Button btnMore;
	public String playMsgId;

	private SwipeRefreshLayout swipeRefreshLayout;

	private Handler micImageHandler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			micImage.setImageDrawable(micImages[msg.what]);
		}
	};
	public EMGroup group;
	public EMChatRoom room;
	public boolean isRobot;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		activityInstance = this;
		initView();
		setUpView();
	}

	protected void interface_getUsers_byNetWork(String groupid)
	{
		KinderNetWork.interface_getUsers_byNetWork(this, getEventMessage(),groupid);
	}
	protected void interface_get_UserInfo_ByNetWork(String easemobid)
	{
		KinderNetWork.get_UserInfo_ByNetWork(this, getEventMessage(),easemobid);
	}
	
	/**
	 * initView
	 */
	protected void initView() {
		recordingContainer = findViewById(R.id.recording_container);
		micImage = (ImageView) findViewById(R.id.mic_image);
		recordingHint = (TextView) findViewById(R.id.recording_hint);
		listView = (ListView) findViewById(R.id.list);
		mEditTextContent = (PasteEditText) findViewById(R.id.et_sendmessage);
		buttonSetModeKeyboard = findViewById(R.id.btn_set_mode_keyboard);
		edittext_layout = (RelativeLayout) findViewById(R.id.edittext_layout);
		buttonSetModeVoice = findViewById(R.id.btn_set_mode_voice);
		buttonSend = findViewById(R.id.btn_send);
		buttonPressToSpeak = findViewById(R.id.btn_press_to_speak);
		expressionViewpager = (ViewPager) findViewById(R.id.vPager);
		emojiIconContainer = (LinearLayout) findViewById(R.id.ll_face_container);
		btnContainer = (LinearLayout) findViewById(R.id.ll_btn_container);
		locationImgview = (ImageView) findViewById(R.id.btn_location);
		iv_emoticons_normal = (ImageView) findViewById(R.id.iv_emoticons_normal);
		iv_emoticons_checked = (ImageView) findViewById(R.id.iv_emoticons_checked);
		loadmorePB = (ProgressBar) findViewById(R.id.pb_load_more);
		btnMore = (Button) findViewById(R.id.btn_more);
		iv_emoticons_normal.setVisibility(View.VISIBLE);
		iv_emoticons_checked.setVisibility(View.INVISIBLE);
		more = findViewById(R.id.more);
		edittext_layout.setBackgroundResource(R.drawable.input_bar_bg_normal);
		voiceCallBtn = (ImageView) findViewById(R.id.btn_voice_call);
		videoCallBtn = (ImageView) findViewById(R.id.btn_video_call);

		micImages = new Drawable[] { getResources().getDrawable(R.drawable.record_animate_01),
				getResources().getDrawable(R.drawable.record_animate_02),
				getResources().getDrawable(R.drawable.record_animate_03),
				getResources().getDrawable(R.drawable.record_animate_04),
				getResources().getDrawable(R.drawable.record_animate_05),
				getResources().getDrawable(R.drawable.record_animate_06),
				getResources().getDrawable(R.drawable.record_animate_07),
				getResources().getDrawable(R.drawable.record_animate_08),
				getResources().getDrawable(R.drawable.record_animate_09),
				getResources().getDrawable(R.drawable.record_animate_10),
				getResources().getDrawable(R.drawable.record_animate_11),
				getResources().getDrawable(R.drawable.record_animate_12),
				getResources().getDrawable(R.drawable.record_animate_13),
				getResources().getDrawable(R.drawable.record_animate_14), };

		reslist = getExpressionRes(35);
		List<View> views = new ArrayList<View>();
		View gv1 = getGridChildView(1);
		View gv2 = getGridChildView(2);
		views.add(gv1);
		views.add(gv2);
		expressionViewpager.setAdapter(new ExpressionPagerAdapter(views));
		edittext_layout.requestFocus();
		voiceRecorder = new VoiceRecorder(micImageHandler);
		buttonPressToSpeak.setOnTouchListener(new PressToSpeakListen());
		mEditTextContent.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					edittext_layout.setBackgroundResource(R.drawable.input_bar_bg_active);
				} else {
					edittext_layout.setBackgroundResource(R.drawable.input_bar_bg_normal);
				}

			}
		});
		mEditTextContent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) 
			{
				edittext_layout.setBackgroundResource(R.drawable.input_bar_bg_active);
				more.setVisibility(View.GONE);
				iv_emoticons_normal.setVisibility(View.VISIBLE);
				iv_emoticons_checked.setVisibility(View.INVISIBLE);
				emojiIconContainer.setVisibility(View.GONE);
				btnContainer.setVisibility(View.GONE);
			}
		});
		// 
		mEditTextContent.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (!TextUtils.isEmpty(s)) {
					btnMore.setVisibility(View.GONE);
					buttonSend.setVisibility(View.VISIBLE);
				} else {
					btnMore.setVisibility(View.VISIBLE);
					buttonSend.setVisibility(View.GONE);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
		 
		 swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.chat_swipe_layout);

		 swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
		                 android.R.color.holo_orange_light, android.R.color.holo_red_light);

		 swipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
		         @Override
		         public void onRefresh() {
		                 new Handler().postDelayed(new Runnable() {

		                         @Override
		                         public void run() {
		                                 if (listView.getFirstVisiblePosition() == 0 && !isloading && haveMoreData) {
		                                         List<EMMessage> messages;
		                                         try {
	                                                 if (chatType == CHATTYPE_SINGLE){
                                                         messages = conversation.loadMoreMsgFromDB(adapter.getItem(0).getMsgId(), pagesize);
	                                                 }
	                                                 else{
                                                         messages = conversation.loadMoreGroupMsgFromDB(adapter.getItem(0).getMsgId(), pagesize);
	                                                 }
		                                         } catch (Exception e1) {
	                                                 swipeRefreshLayout.setRefreshing(false);
	                                                 return;
		                                         }
		                                         
		                                         if (messages.size() > 0) {
	                                                 adapter.notifyDataSetChanged();
	                                                 adapter.refreshSeekTo(messages.size() - 1);
	                                                 if (messages.size() != pagesize){
	                                                     haveMoreData = false;
	                                                 }
		                                         } else {
		                                             haveMoreData = false;
		                                         }
		                                         
		                                         isloading = false;

		                                 }else{
		                                     Toast.makeText(ChatActivity.this, getResources().getString(R.string.no_more_messages), Toast.LENGTH_SHORT).show();
		                                 }
		                                 swipeRefreshLayout.setRefreshing(false);
		                         }
		                 }, 1000);
		         }
		 });
	}

	private void setUpView() {
		iv_emoticons_normal.setOnClickListener(this);
		iv_emoticons_checked.setOnClickListener(this);
		// position = getIntent().getIntExtra("position", -1);
		clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		wakeLock = ((PowerManager) getSystemService(Context.POWER_SERVICE)).newWakeLock(
				PowerManager.SCREEN_DIM_WAKE_LOCK, "demo");
		chatType = getIntent().getIntExtra("chatType", CHATTYPE_SINGLE);

		if (chatType == CHATTYPE_SINGLE) { // 锟斤拷锟斤拷锟斤拷
			toChatUsername = getIntent().getStringExtra("userId");
		    nickName=getIntent().getStringExtra("nickname");
		    interface_get_UserInfo_ByNetWork(toChatUsername);
			Map<String,RobotUser> robotMap=((DemoHXSDKHelper)HXSDKHelper.getInstance()).getRobotList();
			if(robotMap!=null&&robotMap.containsKey(toChatUsername)){
				isRobot = true;
				String nick = robotMap.get(toChatUsername).getNick();
				if(!TextUtils.isEmpty(nick)){
					((TextView) findViewById(R.id.name)).setText(nickName);//nick
				}else{
					((TextView) findViewById(R.id.name)).setText(nickName);//toChatUsername
				}
			}else{
				((TextView) findViewById(R.id.name)).setText(nickName);//toChatUsername
			}
		} else {
			findViewById(R.id.container_to_group).setVisibility(View.VISIBLE);
			findViewById(R.id.container_remove).setVisibility(View.GONE);
			findViewById(R.id.container_voice_call).setVisibility(View.GONE);
			//findViewById(R.id.container_video_call).setVisibility(View.GONE);
			toChatUsername = getIntent().getStringExtra("groupId");
			interface_getUsers_byNetWork(toChatUsername);
			
//			List<ContactListUserModel> usermodels=(List<ContactListUserModel>) getIntent().getSerializableExtra("usermodels");
			if(chatType == CHATTYPE_GROUP){
			    onGroupViewCreation();
			}else{ 
			    onChatRoomViewCreation();
			}
		}
        
		// for chatroom type, we only init conversation and create view adapter on success
		if(chatType != CHATTYPE_CHATROOM){
		    onConversationInit();
	        
	        onListViewCreation();
	        
	        // show forward message if the message is not null
	        String forward_msg_id = getIntent().getStringExtra("forward_msg_id");
	        if (forward_msg_id != null) {
	            forwardMessage(forward_msg_id);
	        }
		}
	}

	protected void onConversationInit(){
	    if(chatType == CHATTYPE_SINGLE){
	        conversation = EMChatManager.getInstance().getConversationByType(toChatUsername,EMConversationType.Chat);
	    }else if(chatType == CHATTYPE_GROUP){
	        conversation = EMChatManager.getInstance().getConversationByType(toChatUsername,EMConversationType.GroupChat);
	    }else if(chatType == CHATTYPE_CHATROOM){
	        conversation = EMChatManager.getInstance().getConversationByType(toChatUsername,EMConversationType.ChatRoom);
	    }
	     
        conversation.markAllMessagesAsRead();

        final List<EMMessage> msgs = conversation.getAllMessages();
        int msgCount = msgs != null ? msgs.size() : 0;
        if (msgCount < conversation.getAllMsgCount() && msgCount < pagesize) {
            String msgId = null;
            if (msgs != null && msgs.size() > 0) {
                msgId = msgs.get(0).getMsgId();
            }
            if (chatType == CHATTYPE_SINGLE) {
                conversation.loadMoreMsgFromDB(msgId, pagesize);
            } else {
                conversation.loadMoreGroupMsgFromDB(msgId, pagesize);
            }
        }
        
        EMChatManager.getInstance().addChatRoomChangeListener(new EMChatRoomChangeListener(){

            @Override
            public void onChatRoomDestroyed(String roomId, String roomName) {
                if(roomId.equals(toChatUsername)){
                    finish();
                }
            }

            @Override
            public void onMemberJoined(String roomId, String participant) {                
            }

            @Override
            public void onMemberExited(String roomId, String roomName,
                    String participant) {
                
            }

            @Override
            public void onMemberKicked(String roomId, String roomName,
                    String participant) {
                if(roomId.equals(toChatUsername)){
                    String curUser = EMChatManager.getInstance().getCurrentUser();
                    if(curUser.equals(participant)){
                        EMChatManager.getInstance().leaveChatRoom(toChatUsername);
                        finish();
                    }
                }
            }
            
        });
	}
	
	protected void onListViewCreation(){
        adapter = new MessageAdapter(ChatActivity.this, toChatUsername, chatType);
        listView.setAdapter(adapter);
//        List<ContactListUserModel> usermodels=(List<ContactListUserModel>) getIntent().getSerializableExtra("usermodels");
//        adapter.setUserModels(usermodels);
        listView.setOnScrollListener(new ListScrollListener());
        adapter.refreshSelectLast();

        listView.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                more.setVisibility(View.GONE);
                iv_emoticons_normal.setVisibility(View.VISIBLE);
                iv_emoticons_checked.setVisibility(View.INVISIBLE);
                emojiIconContainer.setVisibility(View.GONE);
                btnContainer.setVisibility(View.GONE);
                return false;
            }
        });
	}
	
	protected void onGroupViewCreation()
	{
	    group = EMGroupManager.getInstance().getGroup(toChatUsername);
        nickName=getIntent().getStringExtra("nickname");
        if (group != null){
            ((TextView) findViewById(R.id.name)).setText(nickName);//group.getGroupName()
        }else{
            ((TextView) findViewById(R.id.name)).setText(nickName);//toChatUsername
        }
        
        groupListener = new GroupListener();
        EMGroupManager.getInstance().addGroupChangeListener(groupListener);
	}
	
	protected void onChatRoomViewCreation(){
        findViewById(R.id.container_to_group).setVisibility(View.GONE);
        
        final ProgressDialog pd = ProgressDialog.show(this, "", "Joining......");
        EMChatManager.getInstance().joinChatRoom(toChatUsername, new EMValueCallBack<EMChatRoom>() {
        
        @Override
        public void onSuccess(EMChatRoom value) {
            // TODO Auto-generated method stub
             runOnUiThread(new Runnable(){
                   @Override
                   public void run(){
                        pd.dismiss();
                        room = EMChatManager.getInstance().getChatRoom(toChatUsername);
                        if(room !=null){
                            ((TextView) findViewById(R.id.name)).setText(room.getName());
                        }else{
                            ((TextView) findViewById(R.id.name)).setText(nickName);//toChatUsername
                        }
                        EMLog.d(TAG, "join room success : " + room.getName());
                        
                        onConversationInit();
                        
                        onListViewCreation();
                   }
               });
        }
        
        @Override
        public void onError(final int error, String errorMsg) {
                // TODO Auto-generated method stub
                EMLog.d(TAG, "join room failure : " + error);
               runOnUiThread(new Runnable(){
                   @Override
                   public void run(){
                       pd.dismiss();
                   }
               });
               finish();
            }
        });
	}
	
	/**
	 * onActivityResult
	 */
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_CODE_EXIT_GROUP) {
			setResult(RESULT_OK);
			finish();
			return;
		}
		if (requestCode == REQUEST_CODE_CONTEXT_MENU) {
			switch (resultCode) {
			case RESULT_CODE_COPY: //
				EMMessage copyMsg = ((EMMessage) adapter.getItem(data.getIntExtra("position", -1)));
				// clipboard.setText(SmileUtils.getSmiledText(ChatActivity.this,
				// ((TextMessageBody) copyMsg.getBody()).getMessage()));
				clipboard.setText(((TextMessageBody) copyMsg.getBody()).getMessage());
				break;
			case RESULT_CODE_DELETE: //
				EMMessage deleteMsg = (EMMessage) adapter.getItem(data.getIntExtra("position", -1));
				conversation.removeMessage(deleteMsg.getMsgId());
				adapter.refreshSeekTo(data.getIntExtra("position", adapter.getCount()) - 1);
				break;

			case RESULT_CODE_FORWARD: //
				EMMessage forwardMsg = (EMMessage) adapter.getItem(data.getIntExtra("position", 0));
				Intent intent = new Intent(this, ForwardMessageActivity.class);
				intent.putExtra("forward_msg_id", forwardMsg.getMsgId());
				startActivity(intent);
				
				break;

			default:
				break;
			}
		}
		if (resultCode == RESULT_OK) { //
			if (requestCode == REQUEST_CODE_EMPTY_HISTORY) {
				EMChatManager.getInstance().clearConversation(toChatUsername);
				adapter.refresh();
			} else if (requestCode == REQUEST_CODE_CAMERA) { //
				if (cameraFile != null && cameraFile.exists())
					sendPicture(cameraFile.getAbsolutePath());
			} else if (requestCode == REQUEST_CODE_SELECT_VIDEO) {
				int duration = data.getIntExtra("dur", 0);
				String videoPath = data.getStringExtra("path");
				File file = new File(PathUtil.getInstance().getImagePath(), "thvideo" + System.currentTimeMillis());
				Bitmap bitmap = null;
				FileOutputStream fos = null;
				try {
					if (!file.getParentFile().exists()) {
						file.getParentFile().mkdirs();
					}
					bitmap = ThumbnailUtils.createVideoThumbnail(videoPath, 3);
					if (bitmap == null) {
						EMLog.d("chatactivity", "problem load video thumbnail bitmap,use default icon");
						bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.app_panel_video_icon);
					}
					fos = new FileOutputStream(file);

					bitmap.compress(CompressFormat.JPEG, 100, fos);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (fos != null) {
						try {
							fos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						fos = null;
					}
					if (bitmap != null) {
						bitmap.recycle();
						bitmap = null;
					}

				}
				sendVideo(videoPath, file.getAbsolutePath(), duration / 1000);

			} else if (requestCode == REQUEST_CODE_LOCAL) {
				if (data != null) {
					Uri selectedImage = data.getData();
					if (selectedImage != null) {
						sendPicByUri(selectedImage);
					}
				}
			} else if (requestCode == REQUEST_CODE_SELECT_FILE) { //
				if (data != null) {
					Uri uri = data.getData();
					if (uri != null) {
						sendFile(uri);
					}
				}

			} else if (requestCode == REQUEST_CODE_MAP) { //
				double latitude = data.getDoubleExtra("latitude", 0);
				double longitude = data.getDoubleExtra("longitude", 0);
				String locationAddress = data.getStringExtra("address");
				if (locationAddress != null && !locationAddress.equals("")) {
				    toggleMore(more);
					sendLocationMsg(latitude, longitude, "", locationAddress);
				} else {
					String st = getResources().getString(R.string.unable_to_get_loaction);
					Toast.makeText(this, st, 0).show();
				}
				// 锟斤拷锟斤拷锟斤拷濞戯拷锟斤拷锟�
			} else if (requestCode == REQUEST_CODE_TEXT || requestCode == REQUEST_CODE_VOICE
					|| requestCode == REQUEST_CODE_PICTURE || requestCode == REQUEST_CODE_LOCATION
					|| requestCode == REQUEST_CODE_VIDEO || requestCode == REQUEST_CODE_FILE) {
				resendMessage();
			} else if (requestCode == REQUEST_CODE_COPY_AND_PASTE) {
				// 缁拷鐠愶拷
				if (!TextUtils.isEmpty(clipboard.getText())) {
					String pasteText = clipboard.getText().toString();
					if (pasteText.startsWith(COPY_IMAGE)) {
						// 锟斤拷锟斤拷锟藉墽锟斤拷锟斤拷锟界紓锟斤拷锟界粯锟斤拷閿涳拷鏉╋拷锟斤拷锟斤拷锟斤拷濮濓絽鐖讹拷锟斤拷path
						sendPicture(pasteText.replace(COPY_IMAGE, ""));
					}

				}
			} else if (requestCode == REQUEST_CODE_ADD_TO_BLACKLIST) { // 缁夎锟姐儵锟斤拷锟斤拷锟斤拷锟斤拷
				EMMessage deleteMsg = (EMMessage) adapter.getItem(data.getIntExtra("position", -1));
				addUserToBlacklist(deleteMsg.getFrom());
			} else if (conversation.getMsgCount() > 0) {
				adapter.refresh();
				setResult(RESULT_OK);
			} else if (requestCode == REQUEST_CODE_GROUP_DETAIL) {
				adapter.refresh();
			}
		}
	}

	/**
	 * 濞戯拷锟斤拷锟斤拷锟界偓锟斤拷锟斤拷鐟帮拷璁筹拷锟芥禒锟�
	 * 
	 * @param view
	 */
	@Override
	public void onClick(View view) {
		String st1 = getResources().getString(R.string.not_connect_to_server);
		int id = view.getId();
		if (id == R.id.btn_send) {// 锟斤拷鐟帮拷璇诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷(锟斤拷锟斤拷锟斤拷鐎涳拷锟斤拷锟界悰銊︼拷锟�)
			String s = mEditTextContent.getText().toString();
			sendText(s);
		} else if (id == R.id.btn_take_picture) {
			selectPicFromCamera();// 锟斤拷鐟帮拷鑽わ拷褏锟界锟界偓锟斤拷
		} else if (id == R.id.btn_picture) {
			selectPicFromLocal(); // 锟斤拷鐟帮拷璇诧拷鍓э拷锟斤拷锟界偓锟斤拷
		} else if (id == R.id.btn_location) { // 娴ｏ拷缂冿拷
			startActivityForResult(new Intent(this, BaiduMapActivity.class), REQUEST_CODE_MAP);
		} else if (id == R.id.iv_emoticons_normal) { // 锟斤拷鐟帮拷缁橈拷鍓с仛鐞涖劍锟斤拷濡楋拷
			more.setVisibility(View.VISIBLE);
			iv_emoticons_normal.setVisibility(View.INVISIBLE);
			iv_emoticons_checked.setVisibility(View.VISIBLE);
			btnContainer.setVisibility(View.GONE);
			emojiIconContainer.setVisibility(View.VISIBLE);
			hideKeyboard();
		} else if (id == R.id.iv_emoticons_checked) { // 锟斤拷鐟帮拷濠氾拷锟斤拷锟斤拷鐞涖劍锟斤拷濡楋拷
			iv_emoticons_normal.setVisibility(View.VISIBLE);
			iv_emoticons_checked.setVisibility(View.INVISIBLE);
			btnContainer.setVisibility(View.VISIBLE);
			emojiIconContainer.setVisibility(View.GONE);
			more.setVisibility(View.GONE);

		} else if (id == R.id.btn_video) {
			// 锟斤拷鐟帮拷缁橈拷锟斤拷锟斤拷锟斤拷鐐拷锟�
			Intent intent = new Intent(ChatActivity.this, ImageGridActivity.class);
			startActivityForResult(intent, REQUEST_CODE_SELECT_VIDEO);
		} else if (id == R.id.btn_file) { // 锟斤拷鐟帮拷缁橈拷锟芥禒璺猴拷鐐拷锟�
			selectFileFromLocal();
		} else if (id == R.id.btn_voice_call) { // 锟斤拷鐟帮拷鏄忥拷锟斤拷锟藉磭锟戒絻锟斤拷锟斤拷鐐拷锟�
			if (!EMChatManager.getInstance().isConnected())
				Toast.makeText(this, st1, 0).show();
			else{
				startActivity(new Intent(ChatActivity.this, VoiceCallActivity.class).putExtra("username",
						toChatUsername).putExtra("isComingCall", false));
				voiceCallBtn.setEnabled(false);
				toggleMore(null);
			}
		} else if (id == R.id.btn_video_call) { // 鐟欙拷妫帮拷锟斤拷锟界拠锟�
			if (!EMChatManager.getInstance().isConnected())
				Toast.makeText(this, st1, 0).show();
			else{
				startActivity(new Intent(this, VideoCallActivity.class).putExtra("username", toChatUsername).putExtra(
						"isComingCall", false));
				videoCallBtn.setEnabled(false);
				toggleMore(null);
			}
		}
	}

	/**
	 * 娴滐拷娴犲墎锟斤拷锟斤拷锟�
	 * 
	 * see {@link EMNotifierEvent}
     */
    @Override
    public void onEvent(EMNotifierEvent event) {
        switch (event.getEvent()) {
        case EventNewMessage:
        {
            //锟斤拷宄帮拷锟斤拷锟斤拷message
            EMMessage message = (EMMessage) event.getData();
            
            String username = null;
            //缂囥倗锟斤拷濞戯拷锟斤拷锟�
            if(message.getChatType() == ChatType.GroupChat || message.getChatType() == ChatType.ChatRoom){
                username = message.getTo();
            }
            else{
                //锟斤拷锟斤拷锟斤拷濞戯拷锟斤拷锟�
                username = message.getFrom();
            }

            //婵★拷锟斤拷锟斤拷锟斤拷瑜帮拷锟斤拷锟芥导锟界拠锟斤拷锟斤拷濞戯拷锟斤拷锟介敍锟斤拷锟介攱锟芥媽锟斤拷婢垛晠銆夛拷锟斤拷
            if(username.equals(getToChatUsername())){
                refreshUIWithNewMessage();
                //婢逛即锟藉啿锟斤拷锟斤拷锟斤拷锟姐劍锟斤拷缁�鐑橈拷锟斤拷锟界増锟斤拷锟斤拷锟�
                HXSDKHelper.getInstance().getNotifier().viberateAndPlayTone(message);
            }else{
                //婵★拷锟斤拷锟藉☉锟斤拷锟斤拷娑擄拷锟斤拷锟斤拷锟斤拷瑜帮拷锟斤拷锟斤拷锟斤拷婢讹拷ID锟斤拷锟藉☉锟斤拷锟斤拷
                HXSDKHelper.getInstance().getNotifier().onNewMsg(message);
            }

            break;
        }
        case EventDeliveryAck:
        {
            //锟斤拷宄帮拷锟斤拷锟斤拷message
            EMMessage message = (EMMessage) event.getData();
            refreshUI();
            break;
        }
        case EventReadAck:
        {
            //锟斤拷宄帮拷锟斤拷锟斤拷message
            EMMessage message = (EMMessage) event.getData();
            refreshUI();
            break;
        }
        case EventOfflineMessage:
        {
            //a list of offline messages 
            //List<EMMessage> offlineMessages = (List<EMMessage>) event.getData();
            refreshUI();
            break;
        }
        default:
            break;
        }
        
    }
	
	
	private void refreshUIWithNewMessage(){
	    if(adapter == null){
	        return;
	    }
	    
	    runOnUiThread(new Runnable() {
            public void run() {
                adapter.refreshSelectLast();
            }
        });
	}

	private void refreshUI() {
	    if(adapter == null){
            return;
        }
	    
		runOnUiThread(new Runnable() {
			public void run() {
				adapter.refresh();
			}
		});
	}

	/**
	 * 锟斤拷褏锟芥瓕锟藉嘲锟斤拷锟斤拷鍓э拷锟�
	 */
	public void selectPicFromCamera() {
		if (!CommonUtils.isExitsSdcard()) {
			String st = getResources().getString(R.string.sd_card_does_not_exist);
			Toast.makeText(getApplicationContext(), st, 0).show();
			return;
		}

		cameraFile = new File(PathUtil.getInstance().getImagePath(), DemoApplication.getInstance().getUserName()
				+ System.currentTimeMillis() + ".jpg");
		cameraFile.getParentFile().mkdirs();
		startActivityForResult(
				new Intent(MediaStore.ACTION_IMAGE_CAPTURE).putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(cameraFile)),
				REQUEST_CODE_CAMERA);
	}

	/**
	 * 锟斤拷锟斤拷锟解晜锟斤拷娴狅拷
	 */
	private void selectFileFromLocal() {
		Intent intent = null;
		if (Build.VERSION.SDK_INT < 19) {
			intent = new Intent(Intent.ACTION_GET_CONTENT);
			intent.setType("*/*");
			intent.addCategory(Intent.CATEGORY_OPENABLE);

		} else {
			intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		}
		startActivityForResult(intent, REQUEST_CODE_SELECT_FILE);
	}

	/**
	 * 娴狅拷锟斤拷鎯э拷锟斤拷锟藉嘲锟斤拷锟斤拷鍓э拷锟�
	 */
	public void selectPicFromLocal() {
		Intent intent;
		if (Build.VERSION.SDK_INT < 19) {
			intent = new Intent(Intent.ACTION_GET_CONTENT);
			intent.setType("image/*");

		} else {
			intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		}
		startActivityForResult(intent, REQUEST_CODE_LOCAL);
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷濞戯拷锟斤拷锟�
	 * 
	 * @param content
	 *            message content
	 * @param isResend
	 *            boolean resend
	 */
	public void sendText(String content) {

		if (content.length() > 0) {
			EMMessage message = EMMessage.createSendMessage(EMMessage.Type.TXT);
			UserModel userModel=DbOperationModel.getUserInfo(this);
			if(userModel!=null)
			{
				message.setAttribute("userpic", userModel.getUserpic());
			}
			// 婵★拷锟斤拷锟斤拷锟斤拷缂囥倛锟斤拷閿涳拷鐠佸墽鐤哻hattype,姒涳拷鐠併倖锟斤拷锟斤拷锟斤拷锟斤拷
			if (chatType == CHATTYPE_GROUP){
			    message.setChatType(ChatType.GroupChat);
			}else if(chatType == CHATTYPE_CHATROOM){
			    message.setChatType(ChatType.ChatRoom);
			}
			if(isRobot){
				message.setAttribute("em_robot_message", true);
			}
			TextMessageBody txtBody = new TextMessageBody(content);
			// 鐠佸墽鐤嗗☉锟斤拷锟斤拷body
			message.addBody(txtBody);
			// 鐠佸墽鐤嗙憰锟斤拷锟斤拷缂侊拷鐠嬶拷,锟斤拷銊︼拷锟絬sername锟斤拷锟斤拷锟斤拷缂囥倛锟斤拷groupid
			message.setReceipt(toChatUsername);
			// 锟斤拷锟絤essgage锟斤拷锟斤拷锟斤拷conversation娑擄拷
			conversation.addMessage(message);
			// 锟斤拷锟斤拷锟斤拷adapter锟斤拷锟藉☉锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷閿涳拷adapter娴硷拷锟斤拷瑙勶拷锟斤拷锟斤拷锟斤拷銉э拷锟芥潻锟斤拷锟斤拷message锟斤拷鍓с仛濞戯拷锟斤拷锟斤拷锟斤拷鐠嬶拷锟斤拷锟絪dk锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟借锟斤拷
			adapter.refreshSelectLast();
			mEditTextContent.setText("");

			setResult(RESULT_OK);

		}
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷鐠囷拷锟斤拷锟�
	 * 
	 * @param filePath
	 * @param fileName
	 * @param length
	 * @param isResend
	 */
	private void sendVoice(String filePath, String fileName, String length, boolean isResend) {
		if (!(new File(filePath).exists())) {
			return;
		}
		try {
			final EMMessage message = EMMessage.createSendMessage(EMMessage.Type.VOICE);
			UserModel userModel=DbOperationModel.getUserInfo(this);
			if(userModel!=null)
			{
				message.setAttribute("userpic", userModel.getUserpic());
			}
			// 婵★拷锟斤拷锟斤拷锟斤拷缂囥倛锟斤拷閿涳拷鐠佸墽鐤哻hattype,姒涳拷鐠併倖锟斤拷锟斤拷锟斤拷锟斤拷
			if (chatType == CHATTYPE_GROUP){
				message.setChatType(ChatType.GroupChat);
				}else if(chatType == CHATTYPE_CHATROOM){
				    message.setChatType(ChatType.ChatRoom);
				}
			message.setReceipt(toChatUsername);
			int len = Integer.parseInt(length);
			VoiceMessageBody body = new VoiceMessageBody(new File(filePath), len);
			message.addBody(body);
			if(isRobot){
				message.setAttribute("em_robot_message", true);
			}
			conversation.addMessage(message);
			adapter.refreshSelectLast();
			setResult(RESULT_OK);
			// send file
			// sendVoiceSub(filePath, fileName, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷鍓э拷锟�
	 * 
	 * @param filePath
	 */
	private void sendPicture(final String filePath) {
		String to = toChatUsername;
		// create and add image message in view
		final EMMessage message = EMMessage.createSendMessage(EMMessage.Type.IMAGE);
		UserModel userModel=DbOperationModel.getUserInfo(this);
		if(userModel!=null)
		{
			message.setAttribute("userpic", userModel.getUserpic());
		}
		// 婵★拷锟斤拷锟斤拷锟斤拷缂囥倛锟斤拷閿涳拷鐠佸墽鐤哻hattype,姒涳拷鐠併倖锟斤拷锟斤拷锟斤拷锟斤拷
		if (chatType == CHATTYPE_GROUP){
			message.setChatType(ChatType.GroupChat);
		}else if(chatType == CHATTYPE_CHATROOM){
		    message.setChatType(ChatType.ChatRoom);
		}

		message.setReceipt(to);
		ImageMessageBody body = new ImageMessageBody(new File(filePath));
		// 姒涳拷鐠併倛锟斤拷鏉╋拷100k锟斤拷锟斤拷锟藉墽锟斤拷娴硷拷锟斤拷锟界紓鈺侊拷锟斤拷锟斤拷缂侊拷鐎佃锟界櫢锟斤拷锟斤拷锟芥禒銉拷鍓х枂锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
		// body.setSendOriginalImage(true);
		message.addBody(body);
		if(isRobot){
			message.setAttribute("em_robot_message", true);
		}
		conversation.addMessage(message);

		listView.setAdapter(adapter);
		adapter.refreshSelectLast();
		setResult(RESULT_OK);
		// more(more);
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷鐟欙拷妫帮拷濞戯拷锟斤拷锟�
	 */
	private void sendVideo(final String filePath, final String thumbPath, final int length) {
		final File videoFile = new File(filePath);
		if (!videoFile.exists()) {
			return;
		}
		try {
			EMMessage message = EMMessage.createSendMessage(EMMessage.Type.VIDEO);
			UserModel userModel=DbOperationModel.getUserInfo(this);
			if(userModel!=null)
			{
				message.setAttribute("userpic", userModel.getUserpic());
			}
			// 婵★拷锟斤拷锟斤拷锟斤拷缂囥倛锟斤拷閿涳拷鐠佸墽鐤哻hattype,姒涳拷鐠併倖锟斤拷锟斤拷锟斤拷锟斤拷
			if (chatType == CHATTYPE_GROUP){
				message.setChatType(ChatType.GroupChat);
			}else if(chatType == CHATTYPE_CHATROOM){
			    message.setChatType(ChatType.ChatRoom);
			}
			String to = toChatUsername;
			message.setReceipt(to);
			VideoMessageBody body = new VideoMessageBody(videoFile, thumbPath, length, videoFile.length());
			message.addBody(body);
			if(isRobot){
				message.setAttribute("em_robot_message", true);
			}
			conversation.addMessage(message);
			listView.setAdapter(adapter);
			adapter.refreshSelectLast();
			setResult(RESULT_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 锟斤拷瑙勶拷锟斤拷锟芥儳锟斤拷锟斤拷鍓э拷锟絬ri锟斤拷锟斤拷锟斤拷锟斤拷鍓э拷锟�
	 * 
	 * @param selectedImage
	 */
	private void sendPicByUri(Uri selectedImage) {
		// String[] filePathColumn = { MediaStore.Images.Media.DATA };
		Cursor cursor = getContentResolver().query(selectedImage, null, null, null, null);
		String st8 = getResources().getString(R.string.cant_find_pictures);
		if (cursor != null) {
			cursor.moveToFirst();
			int columnIndex = cursor.getColumnIndex("_data");
			String picturePath = cursor.getString(columnIndex);
			cursor.close();
			cursor = null;

			if (picturePath == null || picturePath.equals("null")) {
				Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
				return;
			}
			sendPicture(picturePath);
		} else {
			File file = new File(selectedImage.getPath());
			if (!file.exists()) {
				Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
				return;

			}
			sendPicture(file.getAbsolutePath());
		}

	}

	/**
	 * 锟斤拷锟斤拷锟斤拷娴ｏ拷缂冿拷娣団剝锟斤拷
	 * 
	 * @param latitude
	 * @param longitude
	 * @param imagePath
	 * @param locationAddress
	 */
	private void sendLocationMsg(double latitude, double longitude, String imagePath, String locationAddress) {
		EMMessage message = EMMessage.createSendMessage(EMMessage.Type.LOCATION);
		// 婵★拷锟斤拷锟斤拷锟斤拷缂囥倛锟斤拷閿涳拷鐠佸墽鐤哻hattype,姒涳拷鐠併倖锟斤拷锟斤拷锟斤拷锟斤拷
		if (chatType == CHATTYPE_GROUP){
			message.setChatType(ChatType.GroupChat);
		}else if(chatType == CHATTYPE_CHATROOM){
		    message.setChatType(ChatType.ChatRoom);
		}
		LocationMessageBody locBody = new LocationMessageBody(locationAddress, latitude, longitude);
		message.addBody(locBody);
		message.setReceipt(toChatUsername);
		if(isRobot){
			message.setAttribute("em_robot_message", true);
		}
		conversation.addMessage(message);
		listView.setAdapter(adapter);
		adapter.refreshSelectLast();
		setResult(RESULT_OK);

	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟芥禒锟�
	 * 
	 * @param uri
	 */
	private void sendFile(Uri uri) {
		String filePath = null;
		if ("content".equalsIgnoreCase(uri.getScheme())) {
			String[] projection = { "_data" };
			Cursor cursor = null;

			try {
				cursor = getContentResolver().query(uri, projection, null, null, null);
				int column_index = cursor.getColumnIndexOrThrow("_data");
				if (cursor.moveToFirst()) {
					filePath = cursor.getString(column_index);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("file".equalsIgnoreCase(uri.getScheme())) {
			filePath = uri.getPath();
		}
		File file = new File(filePath);
		if (file == null || !file.exists()) {
			String st7 = getResources().getString(R.string.File_does_not_exist);
			Toast.makeText(getApplicationContext(), st7, 0).show();
			return;
		}
		if (file.length() > 10 * 1024 * 1024) {
			String st6 = getResources().getString(R.string.The_file_is_not_greater_than_10_m);
			Toast.makeText(getApplicationContext(), st6, 0).show();
			return;
		}

		// 锟斤拷锟藉杞帮拷锟芥稉锟斤拷锟斤拷娴犺埖锟斤拷锟斤拷锟�
		EMMessage message = EMMessage.createSendMessage(EMMessage.Type.FILE);
		// 婵★拷锟斤拷锟斤拷锟斤拷缂囥倛锟斤拷閿涳拷鐠佸墽鐤哻hattype,姒涳拷鐠併倖锟斤拷锟斤拷锟斤拷锟斤拷
		if (chatType == CHATTYPE_GROUP){
			message.setChatType(ChatType.GroupChat);
		}else if(chatType == CHATTYPE_CHATROOM){
		    message.setChatType(ChatType.ChatRoom);
		}

		message.setReceipt(toChatUsername);
		// add message body
		NormalFileMessageBody body = new NormalFileMessageBody(new File(filePath));
		message.addBody(body);
		if(isRobot){
			message.setAttribute("em_robot_message", true);
		}
		conversation.addMessage(message);
		listView.setAdapter(adapter);
		adapter.refreshSelectLast();
		setResult(RESULT_OK);
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷濞戯拷锟斤拷锟�
	 */
	private void resendMessage() {
		EMMessage msg = null;
		msg = conversation.getMessage(resendPos);
		// msg.setBackSend(true);
		msg.status = EMMessage.Status.CREATE;

		adapter.refreshSeekTo(resendPos);
	}

	/**
	 * 锟斤拷鍓с仛鐠囷拷锟斤拷鍐诧拷鐐拷锟斤拷锟斤拷锟斤拷锟�
	 * 
	 * @param view
	 */
	public void setModeVoice(View view) {
		hideKeyboard();
		edittext_layout.setVisibility(View.GONE);
		more.setVisibility(View.GONE);
		view.setVisibility(View.GONE);
		buttonSetModeKeyboard.setVisibility(View.VISIBLE);
		buttonSend.setVisibility(View.GONE);
		btnMore.setVisibility(View.VISIBLE);
		buttonPressToSpeak.setVisibility(View.VISIBLE);
		iv_emoticons_normal.setVisibility(View.VISIBLE);
		iv_emoticons_checked.setVisibility(View.INVISIBLE);
		btnContainer.setVisibility(View.VISIBLE);
		emojiIconContainer.setVisibility(View.GONE);

	}

	/**
	 * 锟斤拷鍓с仛锟斤拷锟斤拷锟斤拷锟斤拷鐐拷锟�
	 * 
	 * @param view
	 */
	public void setModeKeyboard(View view) {
		// mEditTextContent.setOnFocusChangeListener(new OnFocusChangeListener()
		// {
		// @Override
		// public void onFocusChange(View v, boolean hasFocus) {
		// if(hasFocus){
		// getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
		// }
		// }
		// });
		edittext_layout.setVisibility(View.VISIBLE);
		more.setVisibility(View.GONE);
		view.setVisibility(View.GONE);
		buttonSetModeVoice.setVisibility(View.VISIBLE);
		// mEditTextContent.setVisibility(View.VISIBLE);
		mEditTextContent.requestFocus();
		// buttonSend.setVisibility(View.VISIBLE);
		buttonPressToSpeak.setVisibility(View.GONE);
		if (TextUtils.isEmpty(mEditTextContent.getText())) {
			btnMore.setVisibility(View.VISIBLE);
			buttonSend.setVisibility(View.GONE);
		} else {
			btnMore.setVisibility(View.GONE);
			buttonSend.setVisibility(View.VISIBLE);
		}

	}

	/**
	 * 锟斤拷鐟帮拷缁橈拷銉э拷锟斤拷锟姐劍锟借渹淇婏拷锟斤拷
	 * 
	 * @param view
	 */
	public void checkUserInfo(View view) {
//		String st5 = getResources().getString(R.string.Whether_to_empty_all_chats);
//		startActivityForResult(new Intent(this, AlertDialog.class).putExtra("titleIsCancel", true).putExtra("msg", st5)
//				.putExtra("cancel", true), REQUEST_CODE_EMPTY_HISTORY);
		String userid=getIntent().getStringExtra("userId"); 
		if(userid!=null&&!userid.equals(""))
		{
			skipActivity(ChatUserActivity_VC.class, "userId", userid);
		}
		
	}

	/**
	 * 锟斤拷鐟帮拷鏄忥拷锟斤拷锟姐儳鍏㈢紒锟界拠锟斤拷锟斤拷
	 * 
	 * @param view
	 */
	public void toGroupDetails(View view) {
		if (room == null && group == null) {
			Toast.makeText(getApplicationContext(), R.string.gorup_not_found, 0).show();
			return;
		}
		if(chatType == CHATTYPE_GROUP){
//			startActivityForResult((new Intent(this, GroupDetailsActivity.class).putExtra("groupId", toChatUsername)),
//					REQUEST_CODE_GROUP_DETAIL);
			//ContactUsersActivity_VC
			Intent intent = new Intent(this, GruopDetailActivity_VC.class);//ContactUsersActivity_VC.class
			intent.putExtra("groupId", toChatUsername);
			startActivityForResult(intent, 0);
//			
	//			Toast.makeText(this, "缂囥倛锟斤拷缂侊拷娣団剝锟斤拷濮濓絽锟姐劌锟斤拷锟斤拷锟�", 0).show();
			
		}
//		else{
//			startActivityForResult((new Intent(this, ChatRoomDetailsActivity.class).putExtra("roomId", toChatUsername)),
//					REQUEST_CODE_GROUP_DETAIL);
//		}
	}

	/**
	 * 锟斤拷鍓с仛锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟界偓锟斤拷锟斤拷锟斤拷锟斤拷妞わ拷
	 * 
	 * @param view
	 */
	public void toggleMore(View view) {
		if (more.getVisibility() == View.GONE) {
			EMLog.d(TAG, "more gone");
			hideKeyboard();
			more.setVisibility(View.VISIBLE);
			btnContainer.setVisibility(View.VISIBLE);
			emojiIconContainer.setVisibility(View.GONE);
		} else {
			if (emojiIconContainer.getVisibility() == View.VISIBLE) {
				emojiIconContainer.setVisibility(View.GONE);
				btnContainer.setVisibility(View.VISIBLE);
				iv_emoticons_normal.setVisibility(View.VISIBLE);
				iv_emoticons_checked.setVisibility(View.INVISIBLE);
			} else {
				more.setVisibility(View.GONE);
			}

		}

	}

	/**
	 * 锟斤拷鐟帮拷缁橈拷锟界�涳拷鏉堬拷锟斤拷銉︼拷锟�
	 * 
	 * @param v
	 */
	public void editClick(View v) {
		listView.setSelection(listView.getCount() - 1);
		if (more.getVisibility() == View.VISIBLE) {
			more.setVisibility(View.GONE);
			iv_emoticons_normal.setVisibility(View.VISIBLE);
			iv_emoticons_checked.setVisibility(View.INVISIBLE);
		}

	}

	private PowerManager.WakeLock wakeLock;
    private ImageView voiceCallBtn;
    private ImageView videoCallBtn;

	/**
	 * 锟斤拷锟芥担锟界拠纾嬶拷锟絣istener
	 * 
	 */
	class PressToSpeakListen implements OnTouchListener {
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				if (!CommonUtils.isExitsSdcard()) {
					String st4 = getResources().getString(R.string.Send_voice_need_sdcard_support);
					Toast.makeText(ChatActivity.this, st4, Toast.LENGTH_SHORT).show();
					return false;
				}
				try {
					v.setPressed(true);
					wakeLock.acquire();
					if (VoicePlayClickListener.isPlaying)
						VoicePlayClickListener.currentPlayListener.stopPlayVoice();
					recordingContainer.setVisibility(View.VISIBLE);
					recordingHint.setText(getString(R.string.move_up_to_cancel));
					recordingHint.setBackgroundColor(Color.TRANSPARENT);
					voiceRecorder.startRecording(null, toChatUsername, getApplicationContext());
				} catch (Exception e) {
					e.printStackTrace();
					v.setPressed(false);
					if (wakeLock.isHeld())
						wakeLock.release();
					if (voiceRecorder != null)
						voiceRecorder.discardRecording();
					recordingContainer.setVisibility(View.INVISIBLE);
					Toast.makeText(ChatActivity.this, R.string.recoding_fail, Toast.LENGTH_SHORT).show();
					return false;
				}

				return true;
			case MotionEvent.ACTION_MOVE: {
				if (event.getY() < 0) {
					recordingHint.setText(getString(R.string.release_to_cancel));
					recordingHint.setBackgroundResource(R.drawable.recording_text_hint_bg);
				} else {
					recordingHint.setText(getString(R.string.move_up_to_cancel));
					recordingHint.setBackgroundColor(Color.TRANSPARENT);
				}
				return true;
			}
			case MotionEvent.ACTION_UP:
				v.setPressed(false);
				recordingContainer.setVisibility(View.INVISIBLE);
				if (wakeLock.isHeld())
					wakeLock.release();
				if (event.getY() < 0) {
					// discard the recorded audio.
					voiceRecorder.discardRecording();

				} else {
					// stop recording and send voice file
					String st1 = getResources().getString(R.string.Recording_without_permission);
					String st2 = getResources().getString(R.string.The_recording_time_is_too_short);
					String st3 = getResources().getString(R.string.send_failure_please);
					try {
						int length = voiceRecorder.stopRecoding();
						if (length > 0) {
							sendVoice(voiceRecorder.getVoiceFilePath(), voiceRecorder.getVoiceFileName(toChatUsername),
									Integer.toString(length), false);
						} else if (length == EMError.INVALID_FILE) {
							Toast.makeText(getApplicationContext(), st1, Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(getApplicationContext(), st2, Toast.LENGTH_SHORT).show();
						}
					} catch (Exception e) {
						e.printStackTrace();
						Toast.makeText(ChatActivity.this, st3, Toast.LENGTH_SHORT).show();
					}

				}
				return true;
			default:
				recordingContainer.setVisibility(View.INVISIBLE);
				if (voiceRecorder != null)
					voiceRecorder.discardRecording();
				return false;
			}
		}
	}

	/**
	 * 锟斤拷宄帮拷锟界悰銊︼拷锟斤拷锟斤拷gridview锟斤拷锟界�涳拷view
	 * 
	 * @param i
	 * @return
	 */
	private View getGridChildView(int i) {
		View view = View.inflate(this, R.layout.expression_gridview, null);
		ExpandGridView gv = (ExpandGridView) view.findViewById(R.id.gridview);
		List<String> list = new ArrayList<String>();
		if (i == 1) {
			List<String> list1 = reslist.subList(0, 20);
			list.addAll(list1);
		} else if (i == 2) {
			list.addAll(reslist.subList(20, reslist.size()));
		}
		list.add("delete_expression");
		final ExpressionAdapter expressionAdapter = new ExpressionAdapter(this, 1, list);
		gv.setAdapter(expressionAdapter);
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String filename = expressionAdapter.getItem(position);
				try {
					// 锟斤拷锟界�涳拷鏉堬拷锟斤拷銉︼拷锟斤拷锟斤拷鐟欙拷锟斤拷璁癸拷锟斤拷锟斤拷锟斤拷锟芥潏锟斤拷锟姐儴銆冿拷锟斤拷
					// 锟斤拷锟芥担锟界拠纾嬶拷锟斤拷锟斤拷鐟欙拷閿涳拷娑擄拷鐠佲晞锟斤拷锟斤拷銉ㄣ�冿拷锟斤拷
					if (buttonSetModeKeyboard.getVisibility() != View.VISIBLE) {

						if (filename != "delete_expression") { // 娑擄拷锟斤拷锟斤拷锟斤拷锟斤拷銈夛拷锟介敍锟斤拷锟藉墽銇氱悰銊︼拷锟�
							// 鏉╋拷锟斤拷锟斤拷锟姐劎锟斤拷锟斤拷锟界亸锟介敍锟斤拷锟斤拷娴犮儲璐╁ǎ锟斤拷锟斤拷锟斤拷璺猴拷锟芥稉锟界憰锟藉ǎ閿嬶拷锟絊mileUtils鏉╋拷娑擄拷缁拷
							Class clz = Class.forName("com.easemob.chatuidemo.utils.SmileUtils");
							Field field = clz.getField(filename);
							mEditTextContent.append(SmileUtils.getSmiledText(ChatActivity.this,
									(String) field.get(null)));
						} else { // 锟斤拷锟斤拷锟姐倖锟斤拷鐎涳拷锟斤拷锟斤拷锟斤拷鐞涖劍锟斤拷
							if (!TextUtils.isEmpty(mEditTextContent.getText())) {

								int selectionStart = mEditTextContent.getSelectionStart();// 锟斤拷宄帮拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷娴ｏ拷缂冿拷
								if (selectionStart > 0) {
									String body = mEditTextContent.getText().toString();
									String tempStr = body.substring(0, selectionStart);
									int i = tempStr.lastIndexOf("[");// 锟斤拷宄帮拷锟斤拷锟斤拷锟斤拷锟芥稉锟芥稉锟界悰銊︼拷锟斤拷锟斤拷娴ｏ拷缂冿拷
									if (i != -1) {
										CharSequence cs = tempStr.substring(i, selectionStart);
										if (SmileUtils.containsKey(cs.toString()))
											mEditTextContent.getEditableText().delete(i, selectionStart);
										else
											mEditTextContent.getEditableText().delete(selectionStart - 1,
													selectionStart);
									} else {
										mEditTextContent.getEditableText().delete(selectionStart - 1, selectionStart);
									}
								}
							}

						}
					}
				} catch (Exception e) {
				}

			}
		});
		return view;
	}

	public List<String> getExpressionRes(int getSum) {
		List<String> reslist = new ArrayList<String>();
		for (int x = 1; x <= getSum; x++) {
			String filename = "ee_" + x;

			reslist.add(filename);

		}
		return reslist;

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		activityInstance = null;
		if(groupListener != null){
		    EMGroupManager.getInstance().removeGroupChangeListener(groupListener);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (group != null)
			((TextView) findViewById(R.id.name)).setText(nickName);//group.getGroupName()
		voiceCallBtn.setEnabled(true);
		videoCallBtn.setEnabled(true);

		 if(adapter != null){
		     adapter.refresh();
	     }

		DemoHXSDKHelper sdkHelper = (DemoHXSDKHelper) DemoHXSDKHelper.getInstance();
		sdkHelper.pushActivity(this);
		// register the event listener when enter the foreground
		EMChatManager.getInstance().registerEventListener(
				this,
				new EMNotifierEvent.Event[] { EMNotifierEvent.Event.EventNewMessage,EMNotifierEvent.Event.EventOfflineMessage,
						EMNotifierEvent.Event.EventDeliveryAck, EMNotifierEvent.Event.EventReadAck });
	}

	@Override
	protected void onStop() {
		// unregister this event listener when this activity enters the
		// background
		EMChatManager.getInstance().unregisterEventListener(this);

		DemoHXSDKHelper sdkHelper = (DemoHXSDKHelper) DemoHXSDKHelper.getInstance();

		// 锟斤拷锟藉锟絘ctivity 娴狅拷foreground activity 锟斤拷锟界悰銊╋拷锟界粔濠氾拷锟�
		sdkHelper.popActivity(this);
		
		super.onStop();
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (wakeLock.isHeld())
			wakeLock.release();
		if (VoicePlayClickListener.isPlaying && VoicePlayClickListener.currentPlayListener != null) {
			// 锟斤拷锟藉銏ｏ拷锟斤拷锟借櫕锟斤拷锟斤拷锟�
			VoicePlayClickListener.currentPlayListener.stopPlayVoice();
		}

		try {
			// 锟斤拷锟藉銏狅拷锟斤拷锟斤拷
			if (voiceRecorder.isRecording()) {
				voiceRecorder.discardRecording();
				recordingContainer.setVisibility(View.INVISIBLE);
			}
		} catch (Exception e) {
		}
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷鏉烇拷锟斤拷锟斤拷锟斤拷
	 */
	private void hideKeyboard() {
		if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
			if (getCurrentFocus() != null)
				manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	/**
	 * 锟斤拷锟斤拷锟姐儱锟戒即锟斤拷锟斤拷锟斤拷锟斤拷
	 * 
	 * @param username
	 */
	private void addUserToBlacklist(final String username) {
		final ProgressDialog pd = new ProgressDialog(this);
		pd.setMessage(getString(R.string.Is_moved_into_blacklist));
		pd.setCanceledOnTouchOutside(false);
		pd.show();
		new Thread(new Runnable() {
			public void run() {
				try {
					EMContactManager.getInstance().addUserToBlackList(username, false);
					runOnUiThread(new Runnable() {
						public void run() {
							pd.dismiss();
							Toast.makeText(getApplicationContext(), R.string.Move_into_blacklist_success, 0).show();
						}
					});
				} catch (EaseMobException e) {
					e.printStackTrace();
					runOnUiThread(new Runnable() {
						public void run() {
							pd.dismiss();
							Toast.makeText(getApplicationContext(), R.string.Move_into_blacklist_failure, 0).show();
						}
					});
				}
			}
		}).start();
	}

	/**
	 * 鏉╋拷锟斤拷锟�
	 * 
	 * @param view
	 */
	public void back(View view) {
		EMChatManager.getInstance().unregisterEventListener(this);
		if(chatType == CHATTYPE_CHATROOM){
			EMChatManager.getInstance().leaveChatRoom(toChatUsername);
		}
		finish();
	}

	/**
	 * 鐟曪拷锟斤拷锟斤拷锟斤拷锟斤拷楦匡拷锟斤拷锟斤拷锟斤拷锟�
	 */
	@Override
	public void onBackPressed() {
		if (more.getVisibility() == View.VISIBLE) {
			more.setVisibility(View.GONE);
			iv_emoticons_normal.setVisibility(View.VISIBLE);
			iv_emoticons_checked.setVisibility(View.INVISIBLE);
		} else {
			super.onBackPressed();
			if(chatType == CHATTYPE_CHATROOM){
				EMChatManager.getInstance().leaveChatRoom(toChatUsername);
			}
		}
	}

	/**
	 *
	 */
	private class ListScrollListener implements OnScrollListener {

		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {
			switch (scrollState) {
			case OnScrollListener.SCROLL_STATE_IDLE:
				/*if (view.getFirstVisiblePosition() == 0 && !isloading && haveMoreData && conversation.getAllMessages().size() != 0) {
					isloading = true;
					loadmorePB.setVisibility(View.VISIBLE);
					// sdk锟斤拷锟芥慨锟斤拷锟斤拷锟斤拷锟芥潪鐣岋拷锟斤拷锟斤拷婢垛晞锟芥澘锟斤拷娑擄拷20锟斤拷鈽咃拷锟斤拷锟戒即銆婏拷锟借泛锟斤拷db锟斤拷锟斤拷锟藉嘲锟斤拷锟斤拷鏉戯拷锟�					
					List<EMMessage> messages;
					EMMessage firstMsg = conversation.getAllMessages().get(0);
					try {
						// 锟斤拷宄帮拷锟斤拷锟芥潙锟斤拷messges閿涳拷鐠嬶拷锟斤拷銊︼拷銈嗭拷瑙勶拷锟斤拷锟斤拷锟斤拷璺猴拷锟芥禒锟絛b锟斤拷宄帮拷锟斤拷锟斤拷messages
						// sdk娴硷拷锟斤拷锟斤拷锟姐劌锟斤拷锟斤拷銉ワ拷鐗堬拷锟絚onversation娑擄拷
						if (chatType == CHATTYPE_SINGLE)
							messages = conversation.loadMoreMsgFromDB(firstMsg.getMsgId(), pagesize);
						else
							messages = conversation.loadMoreGroupMsgFromDB(firstMsg.getMsgId(), pagesize);
					} catch (Exception e1) {
						loadmorePB.setVisibility(View.GONE);
						return;
					}
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
					}
					if (messages.size() != 0) {
						// 锟斤拷閿嬶拷锟絬i
						if (messages.size() > 0) {
							adapter.refreshSeekTo(messages.size() - 1);
						}
						
						if (messages.size() != pagesize)
							haveMoreData = false;
					} else {
						haveMoreData = false;
					}
					loadmorePB.setVisibility(View.GONE);
					isloading = false;

				}*/
				break;
			}
		}

		@Override
		public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

		}

	}

	@Override
	protected void onNewIntent(Intent intent) {
		// 锟斤拷鐟帮拷锟絥otification bar鏉╋拷锟斤拷銉拷锟芥径鈺呫�夛拷锟斤拷閿涳拷娣囷拷鐠囷拷锟斤拷锟斤拷锟斤拷娑擄拷娑擄拷锟斤拷锟芥径鈺呫�夛拷锟斤拷
		String username = intent.getStringExtra("userId");
		if (toChatUsername.equals(username))
			super.onNewIntent(intent);
		else {
			finish();
			startActivity(intent);
		}

	}

	/**
	 * 鏉烇拷锟斤拷锟藉☉锟斤拷锟斤拷
	 * 
	 * @param forward_msg_id
	 */
	protected void forwardMessage(String forward_msg_id) {
		final EMMessage forward_msg = EMChatManager.getInstance().getMessage(forward_msg_id);
		EMMessage.Type type = forward_msg.getType();
		switch (type) {
		case TXT:
			// 锟斤拷宄帮拷锟藉☉锟斤拷锟斤拷锟斤拷锟界�圭櫢锟斤拷锟斤拷锟斤拷锟斤拷濞戯拷锟斤拷锟�
			String content = ((TextMessageBody) forward_msg.getBody()).getMessage();
			sendText(content);
			break;
		case IMAGE:
			// 锟斤拷锟斤拷锟斤拷锟斤拷鍓э拷锟�
			String filePath = ((ImageMessageBody) forward_msg.getBody()).getLocalUrl();
			if (filePath != null) {
				File file = new File(filePath);
				if (!file.exists()) {
					// 娑擄拷鐎涳拷锟斤拷銊ャ亣锟斤拷鎯э拷锟斤拷锟斤拷缂傗晝锟姐儱锟斤拷
					filePath = ImageUtils.getThumbnailImagePath(filePath);
				}
				sendPicture(filePath);
			}
			break;
		default:
			break;
		}
		
		if(forward_msg.getChatType() == ChatType.ChatRoom){
			EMChatManager.getInstance().leaveChatRoom(forward_msg.getTo());
		}
	}
	
	/**
	 * 锟斤拷锟藉ù锟界紘銈囷拷锟界憴锝嗭拷锝嗭拷锟斤拷锟斤拷鐞氾拷T娴滐拷娴狅拷
	 * 
	 */
	class GroupListener extends GroupRemoveListener{

		@Override
		public void onUserRemoved(final String groupId, String groupName) {
			runOnUiThread(new Runnable() {
				String st13 = getResources().getString(R.string.you_are_group);

				public void run() {
					if (toChatUsername.equals(groupId)) {
						Toast.makeText(ChatActivity.this, st13, 1).show();
						if (GroupDetailsActivity.instance != null)
							GroupDetailsActivity.instance.finish();
						finish();
					}
				}
			});
		}

		@Override
		public void onGroupDestroy(final String groupId, String groupName) {
			// 缂囥倗锟斤拷鐟欙絾锟斤絾锟斤絽銈斤拷锟姐劍锟姐倝銆夛拷锟斤拷閿涳拷锟斤拷锟界粈铏瑰參缂侊拷鐞氾拷鐟欙絾锟斤綇锟斤拷楠烇拷finish濮濄倝銆夛拷锟斤拷
			runOnUiThread(new Runnable() {
				String st14 = getResources().getString(R.string.the_current_group);

				public void run() {
					if (toChatUsername.equals(groupId)) {
						Toast.makeText(ChatActivity.this, st14, 1).show();
						if (GroupDetailsActivity.instance != null)
							GroupDetailsActivity.instance.finish();
						finish();
					}
				}
			});
		}

	}

	public String getToChatUsername() {
		return toChatUsername;
	}

	public ListView getListView() {
		return listView;
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
			case KinderEventMessage.MSG_GETUSERS_START:
				//startLoading();
				break;
			case KinderEventMessage.MSG_GETUSERS_SUCCESS:
				succ_getContanctList(msg.getObj());
				break;
			case KinderEventMessage.MSG_GETUSERS_FAIL:
				//stopLoading();
				break;
			//	
			case KinderEventMessage.MSG_GET_USERIFNO_START:
				//startLoading();
				break;
			case KinderEventMessage.MSG_GET_USERIFNO_SUCCESS:
				succ_getUserInfo(msg.getObj());
				break;
			case KinderEventMessage.MSG_GET_USERIFNO_FAIL:
			}
		}
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

	/**鎴愬姛鑾峰彇鐝骇淇℃伅*/
	private void succ_getContanctList(Object obj)
	{
		//stopLoading();
		if(obj!=null &&obj instanceof ContactUser_DataSource)
		{
			ContactUser_DataSource source=(ContactUser_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				//Toast.makeText(this, "size:"+source.getUberModelList(), 0).show();
				
//				adapter.notifyDataSetChanged();
				 if(adapter != null){
					 adapter.setUserModels(source.getUberModelList());
				     adapter.refresh();
			     }
			}
		}
	}
	
	/**鎴愬姛鑾峰彇鐢ㄦ埛淇℃伅*/
	private void succ_getUserInfo(Object obj)
	{
		//stopLoading();
		if(obj!=null &&obj instanceof PerfectDataSource)
		{
			PerfectDataSource source=(PerfectDataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				//Toast.makeText(this, "size:"+source.getUberModelList(), 0).show();
				List<ContactModel> models=new ArrayList<ContactModel>();
				ContactModel contactmodel=new ContactModel();
				contactmodel.setUserModel(source.getUserModel());
				models.add(contactmodel);
				
				//adapter.notifyDataSetChanged();
				 if(adapter != null){
					 adapter.setUserModels(models);
				     adapter.refresh();
			     }
			}
		}
	}
	
}
