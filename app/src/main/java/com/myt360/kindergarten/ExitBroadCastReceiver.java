package com.myt360.kindergarten;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public class ExitBroadCastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		 String action= intent.getAction();
		 if(action.equals("exit_app"))
		 {
			 //System.exit(0);
			// android.os.Process.killProcess(android.os.Process.myPid());
			 Intent i = context.getPackageManager()  
				        .getLaunchIntentForPackage(context.getPackageName());  
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
				context.startActivity(i);  
		 }
	}

}
