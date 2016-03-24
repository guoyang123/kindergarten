
package com.myt360.kindergarten.wxapi;

import android.os.Bundle;
import android.widget.Toast;

import com.myt360.app.consts.ShareConst;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.umeng.socialize.weixin.view.WXCallbackActivity;


//
public class WXEntryActivity  extends WXCallbackActivity{

	 // IWXAPI 是第三方app和微信通信的openapi接口  
    private IWXAPI api;  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	 api = WXAPIFactory.createWXAPI(this, ShareConst.weixin_appID, false);  
         api.handleIntent(getIntent(), this);  
    	super.onCreate(savedInstanceState);
    }
    /* 
	 * 微信发送的请求将回调到onReq方法
	 */
	@Override
	public void onReq(BaseReq arg0) {
		// TODO Auto-generated method stub
		
	}

	/* 
	 * 发送到微信请求的响应结果将回调到onResp方法
	 */
	@Override
	public void onResp(BaseResp resp) {
		// TODO Auto-generated method stub
		super.onResp(resp);
		// TODO Auto-generated method stub
		 switch (resp.errCode) {  
	        case BaseResp.ErrCode.ERR_OK:  
	            //分享成功  
	        	Toast.makeText(this, "分享成功", 0).show();
	        	this.finish();
	            break;  
	        case BaseResp.ErrCode.ERR_USER_CANCEL: 
	        	Toast.makeText(this, "分享取消", 0).show();
	        	this.finish();
	            //分享取消  
	            break;  
	        case BaseResp.ErrCode.ERR_AUTH_DENIED:  
	        	Toast.makeText(this, "分享失败", 0).show();
	        	this.finish();
	            //分享拒绝  
	            break;  
	        }  
	}
}
