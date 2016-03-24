package com.kinder.app.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.myt360.app.consts.ShareConst;
import com.myt360.kindergarten.R;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.exception.SocializeException;
import com.umeng.socialize.media.QQShareContent;
import com.umeng.socialize.media.SinaShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.sso.QZoneSsoHandler;
import com.umeng.socialize.sso.SinaSsoHandler;
import com.umeng.socialize.sso.UMQQSsoHandler;
import com.umeng.socialize.weixin.controller.UMWXHandler;
import com.umeng.socialize.weixin.media.CircleShareContent;
import com.umeng.socialize.weixin.media.WeiXinShareContent;



/**
 * 
 * 分享类封装
 * 
 * 
 * */
public class ShareUtils {

	
	/**
	 * 
	 * 
	 * 社会化组件
	 * 
	 * 
	 * */
	public static  UMSocialService mController;
	
	private static UMSocialService getInstance(Context context){
		if(mController==null){
			mController = UMServiceFactory.getUMSocialService("com.umeng.share");
			mController.getConfig().setSinaCallbackUrl(ShareConst.REDIRECT_URL);
			
			 //设置新浪SSO handler
	 	      mController.getConfig().setSsoHandler(new SinaSsoHandler());
			 // 添加微信平台
	        UMWXHandler wxHandler = new UMWXHandler(context,ShareConst.weixin_appID,ShareConst.weixin_secret);
	        wxHandler.addToSocialSDK();
	        // 支持微信朋友圈
	        UMWXHandler wxCircleHandler = new UMWXHandler(context,ShareConst.weixin_appID,ShareConst.weixin_secret);
	        wxCircleHandler.setToCircle(true);
	        wxCircleHandler.addToSocialSDK();
	        //支持qq平台
	      //参数1为当前Activity，参数2为开发者在QQ互联申请的APP ID，参数3为开发者在QQ互联申请的APP kEY.
	        UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler((FragmentActivity)context, ShareConst.QQ_appID,
	        		 ShareConst.QQ_secret);
	        qqSsoHandler.addToSocialSDK(); 
//	        QZoneSsoHandler  QZoneSsoHandler=new QZoneSsoHandler((FragmentActivity)context, ShareConst.QQ_appID, ShareConst.QQ_secret);
//    		    QZoneSsoHandler.addToSocialSDK();
		}
		return mController;
	}
	
	

	
	/**
	 * 
	 * 打开面板
	 * 
	 * 
	 * */
	@SuppressWarnings("static-access")
	public static void openShare(final Context context,final String title,final String content,
			final String interfaceurl,final String thumb){
		
		mController= getInstance(context);
		// 设置分享内容
		//mController.setShareContent(title);
		
		mController.getConfig().removePlatform( SHARE_MEDIA.RENREN, SHARE_MEDIA.DOUBAN,SHARE_MEDIA.TENCENT,SHARE_MEDIA.QZONE);//,SHARE_MEDIA.QQ,SHARE_MEDIA.QZONE
		mController.getConfig().setPlatformOrder(SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.SINA,SHARE_MEDIA.QQ);//// SHARE_MEDIA.QZONE,SHARE_MEDIA.QQ, SHARE_MEDIA.SINA
		// 是否只有已登录用户才能打开分享选择页
		
		 mController.openShare((FragmentActivity)context,false);
		 
		 
        share_To_WX(context,title,content,interfaceurl,thumb);
        share_To_F(context,title,content,interfaceurl,thumb);
      //检查sina微博是否授权且token没有过期 
      	share_To_Sina(context,title,content,interfaceurl,thumb);
      	share_To_QQ(context,title,content,interfaceurl,thumb);
	}
	
	
	/**
	 * 
	 * 
	 * 分享到微信
	 * 
	 * */
	private static void share_To_WX(Context context,String title,String content,String interfaceurl, String thumb){
//		String url=gerUrl(context,interfaceurl,id,"w");
//		 Log.e("buzz1", "shareurl+w:"+url);
        //微信
        WeiXinShareContent wxsharecontent=new WeiXinShareContent(getUMImage(context,thumb));
       ////设置分享内容跳转URL
        wxsharecontent.setTargetUrl(interfaceurl);
        wxsharecontent.setShareContent(content);
        wxsharecontent.setTitle(title);
        mController.setShareMedia(wxsharecontent);
	}
	
	private static UMImage getUMImage(Context context,String imageurl) {
		// TODO Auto-generated method stub
		
		return new UMImage(context,imageurl);
	}




	/**
	 * 
	 * 
	 * 分享到朋友圈
	 * 
	 * */
	private static void share_To_F(Context context,String title,String content,String interfaceurl, String thumb){
		 Log.e("buzz1", "targeturl:"+interfaceurl);
		 //朋友圈
        CircleShareContent circleMedia = new CircleShareContent();
        circleMedia.setTargetUrl(interfaceurl);
        circleMedia.setShareContent(content);
        //设置朋友圈title
        circleMedia.setTitle(title);
        circleMedia.setShareImage(getUMImage(context,thumb));
        
        mController.setShareMedia(circleMedia);
      
        
	}
	/**
	 * 
	 * 
	 * 分享到qq
	 * 
	 * */
	private static void share_To_QQ(Context context,String title,String content,String interfaceurl, String thumb ){
		 //qq
		
		QQShareContent circleMedia = new QQShareContent();
        circleMedia.setShareContent(content);
        //设置朋友圈title
        circleMedia.setTitle(title);
       circleMedia.setShareImage(getUMImage(context,thumb));
        circleMedia.setTargetUrl(interfaceurl);
        mController.setShareMedia(circleMedia);
      
        
	}
	/**
	 * 
	 * 
	 * 分享到sina
	 * 
	 * */
	private static void share_To_Sina(Context context,String title,String content,String interfaceurl, String thumb){
		//String url=gerUrl(context,interfaceurl,id,"s");
//Log.e("buzz1", "shareurl:"+url);
		 SinaShareContent sinaMedia=new SinaShareContent();
	        sinaMedia.setShareContent(content+interfaceurl);
	        //设置新浪 title
	        ///新浪
	        mController.setShareMedia(sinaMedia);
	      
	}
	
	

	


	
	
	
}
