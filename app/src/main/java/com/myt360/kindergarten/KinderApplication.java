package com.myt360.kindergarten;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.easemob.chatuidemo.DemoApplication;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;

public class KinderApplication extends DemoApplication {

	/**
	 * 
	 * 屏幕适配  pro:适配系数  screenH:屏幕高度  screenW:屏幕宽度
	 * 
	 * */
	public float pro, screenH, screenW; // 适配
	
	//友盟推送
	private PushAgent mPushAgent;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		//Toast.makeText(getApplicationContext(), "reasart", 0).show();
		 activityList = new ArrayList<FragmentActivity>();  
		
		mPushAgent = PushAgent.getInstance(this);
		mPushAgent.setDebugMode(true);
		
		//setPushListener();
	}
	
	/**设置监听*/
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
				 Toast.makeText(context, "launchApp:"+msg.custom, Toast.LENGTH_LONG).show();
		        	 Intent it=new Intent(getApplicationContext(),MainActivity.class);//MenuActivity_VC
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

	   
	public float getPro() {
		return pro;
	}

	public void setPro(float pro) {
		this.pro = pro;
	}

	public float getScreenH() {
		return screenH;
	}

	public void setScreenH(float screenH) {
		this.screenH = screenH;
	}

	public float getScreenW() {
		return screenW;
	}

	public void setScreenW(float screenW) {
		this.screenW = screenW;
	}
	
	public PushAgent getmPushAgent() {
		return mPushAgent;
	}
	
	public void setmPushAgent(PushAgent mPushAgent) {
		this.mPushAgent = mPushAgent;
	}
	
	
// ------------------------------activity管理-----------------------//  
	// activity对象列表,用于activity统一管理  
    private List<FragmentActivity> activityList;  
    // activity管理：从列表中移除activity  
    public void removeActivity(FragmentActivity activity) {  
        activityList.remove(activity);  
    }  
  
    // activity管理：添加activity到列表  
    public void addActivity(FragmentActivity activity) {  
        activityList.add(activity);  
    }  
  
	  // activity管理：结束所有activity  
    public void finishAllActivity() {  
        for (FragmentActivity activity : activityList) {  
            if (null != activity) {  
                activity.finish();  
            }  
        }  
    }  
  
    // 结束线程,一般与finishAllActivity()一起使用  
    // 例如: finishAllActivity;finishProgram();  
    public void finishProgram() {  
        android.os.Process.killProcess(android.os.Process.myPid());  
    } 
    
    @Override
    public void onLowMemory() {
    	// TODO Auto-generated method stub
    	super.onLowMemory();
    	if(isApplicationBroughtToBackground(getApplicationContext()))
		{
			finishAllActivity();  
            finishProgram();  
		}
    }
    
    @Override
    public void onTrimMemory(int level) {
    	// TODO Auto-generated method stub
    	super.onTrimMemory(level);
    	if(level==TRIM_MEMORY_COMPLETE)
		{
    		if(isApplicationBroughtToBackground(getApplicationContext()))
    		{
    			finishAllActivity();  
                finishProgram();  
    		}
		}
    
    }
    /**
     *判断当前应用程序处于前台还是后台
     */
    public  boolean isApplicationBroughtToBackground(final Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }
}
