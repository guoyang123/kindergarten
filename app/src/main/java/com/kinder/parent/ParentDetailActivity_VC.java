package com.kinder.parent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import com.kinder.app.tools.KinderEventMessage;
import com.kinder.app.tools.ShareUtils;
import com.kinder.parent.customviews.ParentDetailMainViewXmlView;
import com.kinder.parent.model.PraiseShare_DataSource;
import com.umeng.socialize.sso.UMSsoHandler;

public class ParentDetailActivity_VC extends ParentDetailActivity_BC {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initParam(savedInstanceState);
		mainView=new ParentDetailMainViewXmlView(this,app.pro,app.screenW,app.screenH);
		mainView.setListener(this);
		mainView.initViewBeforeData(articleListModel);
		setContentView(mainView);
		interface_getArticleDetail_byNetWork();
	}
	
	
	@Override
	protected void onSaveInstanceState(Bundle outState) 
	{
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putSerializable("articleListModel", articleListModel);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mainView.onDestroy();
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
			KinderEventMessage msg=(KinderEventMessage)object;
			switch(msg.getCode())
			{
			case KinderEventMessage.MSG_GETARTICLEDETAIL_START:
				start_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GETARTICLEDETAIL_SUCCESS:
				succ_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GETARTICLEDETAIL_FAIL:
				fail_getData(msg.getObj());
				break;
				
			case KinderEventMessage.MSG_PRAISESHARE_START://顶踩分享
				start_praiseshareData(msg.getObj());
				break;
			case KinderEventMessage.MSG_PRAISESHARE_SUCCESS:
				succ_praiseshareData(msg.getObj());
				break;
			case KinderEventMessage.MSG_PRAISESHARE_FAIL:
				fail_praiseshareData(msg.getObj());
				break;
			case KinderEventMessage.MSG_COLLECT_START://收藏
				start_collectData(msg.getObj());
				break;
			case KinderEventMessage.MSG_COLLECT_SUCCESS://收藏
				succ_collectData(msg.getObj());
				break;
			case KinderEventMessage.MSG_COLLECT_FAIL://收藏
				fail_collectData(msg.getObj());
				break;
			}
		}
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		int id=v.getId();
		if(id==mainView.titleBarView.back_Button.getId())
		{
			this.finish();
		}else if(id==mainView.bottomView.praiseView.getId())//顶逻辑处理
		{
			logic_clickUpBtn(PraiseShare_DataSource.TOP);//
			//interface_praiseshare_byNetWork(PraiseShare_DataSource.TOP);
		}else if(id==mainView.bottomView.non_praiseView.getId())//踩
		{
			logic_clickUpBtn(PraiseShare_DataSource.STEP);
			//interface_praiseshare_byNetWork(PraiseShare_DataSource.STEP);
		}else if(id==mainView.bottomView.collectView.getId())//收藏
		{
			logic_clickCollectBtn();
		}else if(id==mainView.bottomView.shareView.getId())//分享
		{
			//interface_praiseshare_byNetWork(PraiseShare_DataSource.SHARE);
			logic_click_share();
		}
	}



	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		 /**使用SSO授权必须添加如下代码 */
	    UMSsoHandler ssoHandler = ShareUtils.mController.getConfig().getSsoHandler(requestCode) ;
	    if(ssoHandler != null){
	       ssoHandler.authorizeCallBack(requestCode, resultCode, data);
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

}
