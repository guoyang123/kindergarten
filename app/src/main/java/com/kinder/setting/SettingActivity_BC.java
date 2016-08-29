package com.kinder.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.easemob.EMCallBack;
import com.easemob.chatuidemo.DemoApplication;
import com.easemob.chatuidemo.R;
import com.kinder.app.tools.GetFileSizeUtil;
import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.login.LoginActivity_VC;
import com.kinder.setting.customviews.SettingMainViewXmlView;
import com.myt360.app.consts.KinderConst;
import com.myt360.kindergarten.Kind_BaseActivity;

import java.io.File;

import cn.kinder.bean.UserModel;
import cn.kinder.user.DbOperationModel;

public  abstract class SettingActivity_BC extends Kind_BaseActivity {

	
	protected SettingMainViewXmlView mainView;
	
	
	
	/**退出登录*/
	protected void logic_clickExit() {
		// TODO Auto-generated method stub
		//1,退出环信
		logout();
		//2,清空标签
		//app.getmPushAgent().getTagManager().reset();
		try{
			app.getmPushAgent().getTagManager().reset();
		}catch(Exception e){}

		//3,接口
		for(FragmentActivity activity:activitys)
		{
			activity.finish();
		}
		//this.finish();
	}
	
	
	void logout() {
		final ProgressDialog pd = new ProgressDialog(this);
		String st = getResources().getString(R.string.Are_logged_out);
		pd.setMessage(st);
		pd.setCanceledOnTouchOutside(false);
		//pd.show();
		DemoApplication.getInstance().logout(new EMCallBack() {
			
			@Override
			public void onSuccess() {
				runOnUiThread(new Runnable() {
					public void run() {
						if(pd!=null)
						{
							pd.dismiss();
						}
						
						//3,删除本地用户信息
						UserModel userModel=DbOperationModel.getUserInfo(SettingActivity_BC.this);
						if(userModel!=null)
						{
							DbOperationModel.deleteUserInfo(SettingActivity_BC.this, userModel);
						}
						// 重新显示登陆页面
						startActivity(new Intent(SettingActivity_BC.this, LoginActivity_VC.class));
						
					}
				});
			}
			
			@Override
			public void onProgress(int progress, String status) {
				
			}
			
			@Override
			public void onError(int code, String message) {
				Toast.makeText(SettingActivity_BC.this, "退出登录:"+message, Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	
	/*********设置缓存相关的操作**************************************/
	/**
	 * 
	 * 缓存路径
	 * 
	 * 
	 * 
	 */
	public String path=KinderConst.getApkPath();
	
	// 设置缓存大小文字
	protected String setcachetv() {
		GetFileSizeUtil g = new GetFileSizeUtil();
		try {
			long filesize = 0;
			
			File ff = new File(path);
			if (ff.isDirectory()) 
			{ // 如果路径是文件夹的时候
				filesize = g.getFileSize(ff)/10;
                String size=g.FormetFileSize(filesize);
                if(size!=null&&size.startsWith("."))
                {
                	 size="0"+size;
                }
                return size;
			} else 
			{
				filesize = g.getFileSizes(ff);
				return "";
			}
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return "";
	}
	
	protected void logic_clearCache() {
		// TODO Auto-generated method stub
		Kinder_Bitmap.getInstance(this).clearCacheInternalInBackgroud();
		delAllFile(path);
		mainView.cacheView.setCacheData("");
		Toast.makeText(this, "缓存清理完毕", Toast.LENGTH_SHORT).show();
	}
	public void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 鍏堝垹闄ゆ枃浠跺す閲岄潰鐨勬枃浠�
				delFolder(path + "/" + tempList[i]);// 鍐嶅垹闄ょ┖鏂囦欢澶�
			}
		}
	}
	public void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 鍒犻櫎瀹岄噷闈㈡墍鏈夊唴瀹�
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // 鍒犻櫎绌烘枃浠跺す
		} catch (Exception e) {
			//System.out.println("鍒犻櫎鏂囦欢澶规搷浣滃嚭閿�);
			e.printStackTrace();
		}
	}
			
}
