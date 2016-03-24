package com.myt360.kindergarten;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.Toast;
import cn.com.iucd.iucdframe.activity.IUCDMainActivityview;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.com.iucd.iucdframe.utils.UIScreenCalculationUtil;

import com.kinder.menu.MenuActivity_VC;
import com.kinder.startup.StartUpActivity_VC;
import com.umeng.common.message.UmengMessageDeviceConfig;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.IUmengUnregisterCallback;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;

/**
 * 
 * 启动页面Activity
 * */
public class MainActivity extends Kind_BaseActivity {

	public IUCDMainActivityview view;
	private PushAgent mPushAgent;
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
//		MemoryService.open(this);
		//LocalBroadcastManager.getInstance(this);
		view = new IUCDMainActivityview(this);
		setContentView(view);
		initScreenPro();
		mPushAgent = PushAgent.getInstance(this);
		app.setmPushAgent(mPushAgent);
		setPushListener();
		mPushAgent.setPushCheck(true);    //默认不检查集成配置文件
		//应用程序启动统计
		//参考集成文档的1.5.1.2
		//http://dev.umeng.com/push/android/integration#1_5_1
		mPushAgent.onAppStart();
		//开启推送并设置注册的回调处理
 	    mPushAgent.enable(mRegisterCallback);
		updateStatus();
		//此处是完全自定义处理设置
		//参考集成文档1.6.5#3
		//http://dev.umeng.com/push/android/integration#1_6_5
		//mPushAgent.setPushIntentServiceClass(MyPushIntentService.class);
		
		
	}
	
//	/**设置监听*/
	private void setPushListener()
	{
		UmengMessageHandler messageHandler = new UmengMessageHandler(){
			/**
			 * 参考集成文档的1.6.3
			 * http://dev.umeng.com/push/android/integration#1_6_3
			 * */
			@Override
			public void dealWithCustomMessage(final Context context, final UMessage msg) {
				new Handler().post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						// 对自定义消息的处理方式，点击或者忽略
						boolean isClickOrDismissed = true;
						if(isClickOrDismissed) {
							//自定义消息的点击统计
							UTrack.getInstance(getApplicationContext()).trackMsgClick(msg);
						} else {
							//自定义消息的忽略统计
							UTrack.getInstance(getApplicationContext()).trackMsgDismissed(msg);
						}
						Toast.makeText(context, msg.custom, Toast.LENGTH_LONG).show();
					}
				});
			}
			
			/**
			 * 参考集成文档的1.6.4
			 * http://dev.umeng.com/push/android/integration#1_6_4
			 * */
			@Override
			public Notification getNotification(Context context,
					UMessage msg) {
				switch (msg.builder_id) {
				case 1:
					NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
					RemoteViews myNotificationView = new RemoteViews(context.getPackageName(), R.layout.notification_view);
					myNotificationView.setTextViewText(R.id.notification_title, msg.title);
					myNotificationView.setTextViewText(R.id.notification_text, msg.text);
					myNotificationView.setImageViewBitmap(R.id.notification_large_icon, getLargeIcon(context, msg));
					myNotificationView.setImageViewResource(R.id.notification_small_icon, getSmallIconId(context, msg));
					builder.setContent(myNotificationView);
					builder.setAutoCancel(true);
					Notification mNotification = builder.build();
					//由于Android v4包的bug，在2.3及以下系统，Builder创建出来的Notification，并没有设置RemoteView，故需要添加此代码
					mNotification.contentView = myNotificationView;
					return mNotification;
				default:
					//默认为0，若填写的builder_id并不存在，也使用默认。
					return super.getNotification(context, msg);
				}
			}
		};
		mPushAgent.setMessageHandler(messageHandler);

		/**
		 * 该Handler是在BroadcastReceiver中被调用，故
		 * 如果需启动Activity，需添加Intent.FLAG_ACTIVITY_NEW_TASK
		 * 参考集成文档的1.6.2
		 * http://dev.umeng.com/push/android/integration#1_6_2
		 * */
		UmengNotificationClickHandler notificationClickHandler = new UmengNotificationClickHandler(){
			
			   @Override
		        public void launchApp(Context context, UMessage msg) {
		        	// TODO Auto-generated method stub
				// Toast.makeText(context, "launchApp:"+msg.custom, Toast.LENGTH_LONG).show();
		        	 Intent it=new Intent(getApplicationContext(),MenuActivity_VC.class);
		    		 it.putExtra("notify", msg.custom);
		    		 startActivity(it);
			   }
			
			
			@Override
			public void dealWithCustomAction(Context context, UMessage msg)
			{
			//	super.dealWithCustomAction(context, msg);
//				 Toast.makeText(context, "custom:"+msg.custom, Toast.LENGTH_LONG).show();
//			 	 Intent it=new Intent(getApplicationContext(),MenuActivity_VC.class);
//	    		     it.putExtra("notify", msg.custom);
//	    		     startActivity(it);
			}
			
		};
		mPushAgent.setNotificationClickHandler(notificationClickHandler);
	}
	private void updateStatus() 
	{
		String info = String.format("enabled:%s  isRegistered:%s  DeviceToken:%s " + 
				"SdkVersion:%s AppVersionCode:%s AppVersionName:%s",
				mPushAgent.isEnabled(), mPushAgent.isRegistered(),
				mPushAgent.getRegistrationId(), MsgConstant.SDK_VERSION,
				UmengMessageDeviceConfig.getAppVersionCode(this), UmengMessageDeviceConfig.getAppVersionName(this));
		Log.e("buzz1", "umeng push:"+info);
		
	}

	public Handler handler = new Handler();
	//此处是注册的回调处理
	//参考集成文档的1.7.10
	//http://dev.umeng.com/push/android/integration#1_7_10
	public IUmengRegisterCallback mRegisterCallback = new IUmengRegisterCallback() {
		@Override
		public void onRegistered(String registrationId) {
			// TODO Auto-generated method stub
			handler.post(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					updateStatus();
				}
			});
		}
	};
	//此处是注销的回调处理
	//参考集成文档的1.7.10
	//http://dev.umeng.com/push/android/integration#1_7_10
	public IUmengUnregisterCallback mUnregisterCallback = new IUmengUnregisterCallback() {
		@Override
		public void onUnregistered(String registrationId) {
			// TODO Auto-generated method stub
			handler.post(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					updateStatus();
				}
			});
		}
	};
	/**
	 * 初始化适配参数
	 * */
	private void initScreenPro()
	{
		 final KinderApplication application = (KinderApplication) getApplication();
		//未初始化过
			
		if (application.pro == 0) 
		{
			
			RelativeLayout body = view.body;
			body.getViewTreeObserver().addOnGlobalLayoutListener(
					new OnGlobalLayoutListener() {
						boolean isFirst = true;// 默认调用两次，这里只让它执行一次回调

						public void onGlobalLayout() {
							if (isFirst) {
								isFirst = false;
								UIScreenCalculationUtil uiScreenCalculation = new UIScreenCalculationUtil();
								DisplayMetrics metric = new DisplayMetrics();
								getWindowManager().getDefaultDisplay().getMetrics(
										metric);
								uiScreenCalculation.putUI_W_H_D(320,480,1.0f);//320, 480, 1.0f
								uiScreenCalculation.putScreen_W_H_D(
										metric.widthPixels, metric.heightPixels,
										metric.density);
								application.pro = uiScreenCalculation
										.getScreenUIProportion();
								application.screenW = uiScreenCalculation.screenW;
								application.screenH = uiScreenCalculation.screenH;
								skip2StartUpActivity();
							}
						}
					}
			);
		}else
		{
			skip2StartUpActivity();
		}
	}
	
	
	/**
	 * 页面跳转到主框架MenuActivity
	 * */
	private void skip2StartUpActivity()
	{
//		 PushManager.startWork(getApplicationContext(),
//	                PushConstants.LOGIN_TYPE_API_KEY,
//	                Utils.getMetaValue(MainActivity.this, "api_key"));
		
		Intent it=new Intent(this,StartUpActivity_VC.class);//StartUpActivity_VC
		startActivity(it);
		finish();
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
	public void onMessageMainThread(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EventMessage initLocalEventMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventMessage initPlugEventMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
	}
	

}
