package com.kinder.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.easemob.EMNotifierEvent;
import com.easemob.applib.controller.HXSDKHelper;
import com.easemob.chat.EMMessage;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.kinder.app.tools.KinderEventMessage;
import com.kinder.app.tools.KinderNetWork;
import com.kinder.menu.customviews.MenuMainViewXmlView;
import com.kinder.menu.customviews.SlideMenuXmlView;
import com.kinder.menu.interfaces.OnSearchListener;
import com.kinder.userdetail.UserDetailActivity_VC;
import com.myt360.kindergarten.R;

import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.util.MethodUtils;

public class MenuActivity_VC extends MenuActivity_BC  implements OnItemClickListener
,OnSearchListener 
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 getSlideDatas();
		 slideMenuView=new SlideMenuXmlView(this,app.pro,app.screenW,app.screenH);
		 slideMenuView.setListener(this,this);
		 slideMenuView.initSlideData(datas);
		 mainView=new MenuMainViewXmlView(this,app.pro,app.screenW,app.screenH);
	     mainView.setListener(this,this);
	     unreadLabel=mainView.bottomWrap.unreadLabel_TextView;
	     setContentView(mainView);
	     initSlidingMenu();
	     
	     logic_notify(getIntent());
	   //友盟更新
		//UmengUpdateAgent.update(this);
		//调用更新接口
		KinderNetWork.interface_CheckVersion_byNetWork(this,getEventMessage(), MethodUtils.getVersion(this));

		get_UserInfo_Datas_ByNetWork();
	}
	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		logic_notify(intent);
	}
	@Override
	protected void onResume() 
	{
		// TODO Auto-generated method stub
		super.onResume();
		slideMenuView.initData();
		
		
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
				case KinderEventMessage.MSG_CHECKVERSION_START:
					start_getData(msg.getObj());
					break;
				case KinderEventMessage.MSG_CHECKVERSION_SUCCESS:
					succ_getData(msg.getObj());
					break;
				case KinderEventMessage.MSG_CHECKVERSION_FAIL:
					fail_getData(msg.getObj());
					break;

				case KinderEventMessage.MSG_SURE_BUTTON://确定按钮
                    logic_download();
					break;
				case KinderEventMessage.MSG_CANCEL_BUTTON://取消按钮
                    hideCommentDialog();
					break;
				case KinderEventMessage.MSG_DOWNLOAD_START://下载apk
					start_getapkData();
					break;
				case KinderEventMessage.MSG_DOWNLOAD_LOADING:
					//succ_getData(msg.getObj());
					break;
				case KinderEventMessage.MSG_DOWNLOAD_SUCCESS://下载成功
					succ_getapkData(msg.getObj());
					break;
				case KinderEventMessage.MSG_DOWNLOAD_FAIL:
					fail_getapkData();
					break;


				case KinderEventMessage.MSG_GET_USERIFNO_START:
				//	start_getData(msg.getObj());
					break;
				case KinderEventMessage.MSG_GET_USERIFNO_SUCCESS:
					succ_getUserInfoData(msg.getObj());
					break;
				case KinderEventMessage.MSG_GET_USERIFNO_FAIL:
					fail_getData(msg.getObj());
					break;
			}
		}



	}




	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		if(id==mainView.titleBarView.parent_Titlebar.leftBtn.getId())
		{
			logic_clickSlideMenu();
		}else if(id==mainView.titleBarView.chat_TitleBar.rightBtn.getId())
		{
			logic_clickAddress();
		}
		else if(id==mainView.bottomWrap.parent_RelativeLayout.getId())
		{
			//首页
			logic_switchFragment(1);
		}else if(id==mainView.bottomWrap.chat_RelativeLayout.getId())
		{
			//消息
			logic_switchFragment(2);
		}else if(id==mainView.bottomWrap.check_RelativeLayout.getId())
		{
			//考勤
			logic_switchFragment(3);
		}else if(id==mainView.bottomWrap.notice_RelativeLayout.getId())
		{
			//通知
			logic_switchFragment(4);
		}else if(id==slideMenuView.head_ImageView.getId())
		{
			//用户头衔
			skipActivity(UserDetailActivity_VC.class);//
		}else if(id==mainView.titleBarView.check_Titlebar.rightBtn.getId())
		{
			logic_clickLeaveBtn();
			
		}else if(id==mainView.titleBarView.notice_TitleBar.rightBtn.getId()||
				id==mainView.titleBarView.notice_TitleBar.search_ImageView.getId())
		{
			//搜索
			logic_clickSearchBtn();
		}else if(id==mainView.titleBarView.parent_Titlebar.rightBtn.getId())
		{
			logic_clickSearchParent();
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

	private void initSlidingMenu(){
		localSlidingMenu=new SlidingMenu(this);
		//设置左滑菜单
		localSlidingMenu.setMode(SlidingMenu.LEFT);
		//设置要使菜单滑动，触屏幕的范围
		localSlidingMenu.setTouchModeAbove(localSlidingMenu.LEFT);
		// 设置阴影图片宽度
		localSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);//设置阴影图片的宽度 
		//设置阴影图片
		localSlidingMenu.setShadowDrawable(R.drawable.shadow);
		//设置划出时主页面显示的剩余宽度  
		localSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		//设置滑动时菜单的是否渐变 
		localSlidingMenu.setFadeEnabled(true);
		//使SlidingMenu附加在Activity右边  
		 localSlidingMenu.attachToActivity(MenuActivity_VC.this, SlidingMenu.RIGHT);
		ViewGroup v=(ViewGroup) slideMenuView.getParent();
		if(v!=null)
		{
			v.removeAllViews();
		}
		 //设置menu的布局文件  
		 localSlidingMenu.setMenu(slideMenuView);   
		//动态判断自动关闭或开启SlidingMenu 
        localSlidingMenu.toggle(); 
        localSlidingMenu.showContent();
        localSlidingMenu.setOnOpenedListener(new SlidingMenu.OnOpenedListener() {  
                    public void onOpened() {  

                    }  
                });  
        localSlidingMenu.setOnClosedListener(new SlidingMenu.OnClosedListener() {  
           

			@Override
			public void onClosed() {
				// TODO Auto-generated method stub
			
			}  
        });
	
        
	}
	@Override
	public void onEvent(EMNotifierEvent event) {
		switch (event.getEvent()) {
		case EventNewMessage: // 普通消息
		{
			EMMessage message = (EMMessage) event.getData();
			// 提示新消息
			HXSDKHelper.getInstance().getNotifier().onNewMsg(message);
			refreshUI();
			break;
		}

		case EventOfflineMessage: {
			refreshUI();
			break;
		}

		case EventConversationListChanged: {
		    refreshUI();
		    break;
		}
		
		default:
			break;
		}
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		logic_clcikSlideItem(position);
	}
	//点击键盘的回车按钮，搜索
	@Override
	public void onSearch() {
		// TODO Auto-generated method stub
		logic_clickSearchBtn();
	}
	

}
