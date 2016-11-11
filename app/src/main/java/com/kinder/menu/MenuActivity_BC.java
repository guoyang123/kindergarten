package com.kinder.menu;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.kinder.app.tools.KinderNetWork;
import com.kinder.chat.ChatFragment_VC;
import com.kinder.chat.ContactlistActivity_VC;
import com.kinder.check.CheckFragment_VC;
import com.kinder.check.LeaveActivity_VC;
import com.kinder.check.model.CheckBaby_DataSource;
import com.kinder.feedback.Menu_FeedBackActivity_VC;
import com.kinder.menu.customviews.MenuMainViewXmlView;
import com.kinder.menu.customviews.SlideMenuXmlView;
import com.kinder.menu.model.SlideModel;
import com.kinder.mycollect.MyCollectActivity_VC;
import com.kinder.notice.NoticeFragment_VC;
import com.kinder.parent.ParentFragment_VC;
import com.kinder.parent.ParentSearchActivity_VC;
import com.kinder.perfect.model.PerfectDataSource;
import com.kinder.setting.SettingActivity_VC;
import com.myt360.app.consts.KinderConst;
import com.myt360.app.consts.RuleConst;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.kinder.bean.UserModel;
import cn.kinder.util.iyuehuPreference;
import customviews.dialog.CheckVersionDialog;
import customviews.dialog.CheckVersionModel;

public abstract class MenuActivity_BC extends MenuChatActivity {

	//首页
	public static final String PARENTFRAGMENT="parent";
	//聊天
	public static final String CHATFRAGMENT="chat";
	//考勤
	public static final String CHECKFRAGMENT="check";
	//通知
	public static final String NOTICEFRAGMENT="notice";
	public int  selected=1;
	protected SlidingMenu localSlidingMenu ;
	protected SlideMenuXmlView slideMenuView;
	protected MenuMainViewXmlView mainView;
	
	//
	protected ParentFragment_VC parentFragment_VC;
	protected CheckFragment_VC checkFragment_VC;
	protected NoticeFragment_VC noticeFragment_VC;
	
	protected String  notify;//推送通知

	protected CheckVersionDialog checkVersionDialog;
	protected CheckVersionModel checkVersionModel;
	/**点击侧边栏按钮*/
	protected void logic_clickSlideMenu() {
		// TODO Auto-generated method stub
		if(localSlidingMenu!=null)
		{
			localSlidingMenu.showMenu();
		}
	}
	/**点击请假按钮*/
	protected void logic_clickLeaveBtn() {
		// TODO Auto-generated method stub
		if(checkFragment_VC!=null)
		{
			CheckBaby_DataSource source=checkFragment_VC.getBabys_DataSource();
			skipActivity(LeaveActivity_VC.class,"babys",source);
		}
		
	}
	
	/**点击底部按钮，完成Fragment的切换*/
	protected void logic_switchFragment(int position)
	{
		this.selected=position;
		mainView.refreshTitleBar(position);
		FragmentManager fm=getSupportFragmentManager();
		FragmentTransaction ft=fm.beginTransaction();
		Fragment parentFragment=fm.findFragmentByTag(PARENTFRAGMENT);
		Fragment chatFragment=fm.findFragmentByTag(CHATFRAGMENT);
		Fragment checkFragment=fm.findFragmentByTag(CHECKFRAGMENT);
		Fragment noticeFragment=fm.findFragmentByTag(NOTICEFRAGMENT);
		
		
		if(parentFragment!=null&&position!=1)
		{
			ft.hide(parentFragment);
		}
		
		if(chatFragment!=null&&position!=2)
		{
			ft.hide(chatFragment);
		}
		
		if(checkFragment!=null&&position!=3)
		{
			ft.hide(checkFragment);
		}
		
		if(noticeFragment!=null&&position!=4)
		{
			ft.hide(noticeFragment);
		}
		showoraddFragment(position,ft);
		ft.commitAllowingStateLoss();
		
		mainView.refreshIcon(position);
	}
	
	
	/**添加或显示某个Fragment*/
	private void showoraddFragment(int position,FragmentTransaction ft)
	{
		parentFragment_VC=(ParentFragment_VC)getSupportFragmentManager().findFragmentByTag(PARENTFRAGMENT);
		if(position==1)//育儿文章
		{
			if(parentFragment_VC==null)
			{
				parentFragment_VC=new ParentFragment_VC();
				ft.add(mainView.frameLayout.getId(),parentFragment_VC , PARENTFRAGMENT);
			}else
			{
				ft.show(parentFragment_VC);//(ParentFragment_VC)
			}
		}
		//消息
		 chatFragment=(ChatFragment_VC)getSupportFragmentManager().findFragmentByTag(CHATFRAGMENT);
		if(position==2)
		{
			if(chatFragment==null)
			{
				chatFragment=new ChatFragment_VC();
				ft.add(mainView.frameLayout.getId(),chatFragment , CHATFRAGMENT);
			}else
			{
				ft.show(chatFragment);//(ChatFragment_VC)
			}
		}
		
		//考勤
		Fragment checkFragment=getSupportFragmentManager().findFragmentByTag(CHECKFRAGMENT);
		if(position==3)
		{
			if(checkFragment==null)
			{
				checkFragment_VC=new CheckFragment_VC();
				ft.add(mainView.frameLayout.getId(), checkFragment_VC, CHECKFRAGMENT);
			}else
			{
				ft.show(checkFragment_VC);
			}
		}
		//通知
		noticeFragment_VC=(NoticeFragment_VC)getSupportFragmentManager().findFragmentByTag(NOTICEFRAGMENT);
		if(position==4)
		{
			if(noticeFragment_VC==null)
			{
				noticeFragment_VC=new NoticeFragment_VC(this.notify);
				ft.add(mainView.frameLayout.getId(), noticeFragment_VC, NOTICEFRAGMENT);
			}else
			{
				ft.show(noticeFragment_VC);//(NoticeFragment_VC)
				noticeFragment_VC.setNotify(this.notify);
			}
		}
	}
	
/**点击通讯录按钮*/
	protected void logic_clickAddress() {
		// TODO Auto-generated method stub
	   skipActivity(ContactlistActivity_VC.class);
	}
	
	protected List<SlideModel> datas=new ArrayList<SlideModel>();
	/**构造左侧栏数据模型*/
	public void getSlideDatas()
	{
		UserModel userModel=getUserInfo();
		if(userModel!=null)
		{
			//文件中读取提示音、推送通知设置参数
			iyuehuPreference.ensureIntializePreference(this);
			boolean iswarn=iyuehuPreference.read("warn", false);
			boolean isnotice=iyuehuPreference.read("notice", false);
			String type=userModel.getUsertype();
			if(type!=null&&type.equals(RuleConst.USER))
			{
				datas.add(new SlideModel("mycollect","我的收藏",false,false));
				datas.add(new SlideModel("warn","提示音",true,iswarn));
				//datas.add(new SlideModel("notice","幼儿园通知推送",true,isnotice));
				datas.add(new SlideModel("mycontactlist","我的通讯录",false,false));
				datas.add(new SlideModel("setting","设置",false,false));
				datas.add(new SlideModel("feedback","意见反馈",false,false));
			}else
			{
				datas.add(new SlideModel("circle","转发文章",false,false));
				datas.add(new SlideModel("mycollect","我的收藏",false,false));
				datas.add(new SlideModel("mycircle","我转发的文章",false,false));
				datas.add(new SlideModel("warn","提示音",true,false));
				//datas.add(new SlideModel("notice","幼儿园通知推送",true,false));
				datas.add(new SlideModel("mycontactlist","我的通讯录",false,false));
				datas.add(new SlideModel("setting","设置",false,false));
				datas.add(new SlideModel("feedback","意见反馈",false,false));
			}
		}
		
	}
	
	protected void logic_clcikSlideItem(int position) {
		// TODO Auto-generated method stub
		
		UserModel userModel=getUserInfo();
		if(userModel!=null)
		{
			String type=userModel.getUsertype();
			if(type!=null&&type.equals(RuleConst.USER))
			{
				if(position==0)//我的收藏
				{
					skipActivity(MyCollectActivity_VC.class);
				}else if(position==1)//提示音
				{
					logic_warn(1);
				}
//				else if(position==2)//幼儿园推送通知
//				{
//					SlideModel model=datas.get(2);
//					model.setIsline(!model.isIsline());
//					slideMenuView.refreshData();
//					iyuehuPreference.ensureIntializePreference(this);
//					iyuehuPreference.save("notice", model.isIsline());
//				}
				else if(position==2)//我的通讯录
				{
					skipActivity(ContactlistActivity_VC.class);
				}else if(position==3)//设置
				{
					skipActivity(SettingActivity_VC.class);
				}else if(position==4)//意见反馈
				{
					skipActivity(Menu_FeedBackActivity_VC.class);
				}
			}else
			{
				if(position==1)//我的收藏
				{
					skipActivity(MyCollectActivity_VC.class);
				}else if(position==3)//提示音
				{
					logic_warn(3);
				}else if(position==4)//通讯录
				{
					skipActivity(ContactlistActivity_VC.class);
				}
				else if(position==5)//设置
				{
					skipActivity(SettingActivity_VC.class);
				}else if(position==6)//意见反馈
				{
					skipActivity(Menu_FeedBackActivity_VC.class);
				}
			}
	    }
		
		
		
	}
	/**点击通知栏的搜索按钮*/
	protected void logic_clickSearchBtn() {
		// TODO Auto-generated method stub
		String search=mainView.titleBarView.notice_TitleBar.search_EditText.getText().toString();
	    this.noticeFragment_VC.setSearchText(search);
	}
	
	protected void logic_clickSearchParent() {
		// TODO Auto-generated method stub
		skipActivity(ParentSearchActivity_VC.class);
	}
	
	protected void logic_notify(Intent intent) {
		// TODO Auto-generated method stub
		
		 notify=intent.getStringExtra("notify");
		//Toast.makeText(this,"logic_notify:"+ notify, Toast.LENGTH_LONG).show();
		if(notify!=null)
		{ 	
			logic_switchFragment(4);
		}else
		{
			logic_switchFragment(selected);
		}
	}
	
	
/**提示音逻辑*/
	public void logic_warn(int position)
	{
		SlideModel model=datas.get(position);
		model.setIsline(!model.isIsline());
		slideMenuView.refreshData();
		iyuehuPreference.ensureIntializePreference(this);
		iyuehuPreference.save("warn", model.isIsline());
	}



	/**开始获取数据*/
	protected void start_getData(Object obj)
	{
		startLoading();
	}
	/**成功获取数据*/
	protected void succ_getData(Object obj)
	{
		stopLoading();
		if(obj!=null&&obj instanceof CheckVersionModel)
		{
			CheckVersionModel source=(CheckVersionModel)obj;
			String errorCode=source.getErrorCode();
		       /**
				0-不需要更新
			    1-需要更新
				-3-系统错误
                */
			if(errorCode!=null&&errorCode.equals("1"))//需要更新
			{
                this.checkVersionModel=source;
				showCommentDialog(source);

			}else
			{
				Toast.makeText(this, source.getErrorMsg(), 0).show();
			}
		}
	}
	/**失败获取数据*/
	protected void fail_getData(Object obj)
	{
		stopLoading();
	}



	protected void showCommentDialog(Object obj){
		FragmentManager fragmentManager= this.getSupportFragmentManager();
		FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

		if(checkVersionDialog==null){
			checkVersionDialog=new CheckVersionDialog(getEventMessage());
			checkVersionDialog.setCancelable(false);


		}
		checkVersionDialog.setDatas(obj);
		checkVersionDialog.show(fragmentTransaction, "checkVersionDialog");

	}


	protected void hideCommentDialog(){
		FragmentManager fragmentManager= this.getSupportFragmentManager();
		Fragment fragment=fragmentManager.findFragmentByTag("checkVersionDialog");
		FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
		if(fragment !=null){
			fragmentTransaction.remove(fragment);
			fragmentTransaction.commitAllowingStateLoss();
			fragment=null;
		}

	}

	/**下载逻辑*/
	protected void logic_download() {

		String apkpath=KinderConst.getSDPath()+"/kinder.apk";
		File file=new File(apkpath);
		if(!file.exists()){
			try {
				file.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		KinderNetWork.download_apkFile_ByNetwork(this, getEventMessage(), checkVersionModel.getDownloadUrl(), file);
		hideCommentDialog();

	}

	/**开始下载数据*/
	protected void start_getapkData()
	{
		Toast.makeText(MenuActivity_BC.this, "开始下载...", Toast.LENGTH_SHORT).show();
	}
	/**失败下载获取数据*/
	protected void fail_getapkData()
	{
		Toast.makeText(MenuActivity_BC.this, "下载失败...", Toast.LENGTH_SHORT).show();
	}
	protected void succ_getapkData(Object obj) {
		if(obj!=null&&obj instanceof  File){
			openFile((File)obj);
		}
	}
	private void openFile(File file) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(file),
				"application/vnd.android.package-archive");
		startActivity(intent);
	}


	/****获取学校信息**/
	/**链接网路接口，请求数据*/
	protected void get_UserInfo_Datas_ByNetWork()
	{
		KinderNetWork.get_UserInfo_ByNetWork(this, getEventMessage());
	}

	/**成功获取数据*/
	protected void succ_getUserInfoData(Object obj)
	{
		stopLoading();
		if(obj!=null&&obj instanceof PerfectDataSource)
		{
			PerfectDataSource source=(PerfectDataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				mainView.initSchoolData(source);
			}else
			{
				Toast.makeText(this, source.getErrorMsg(), Toast.LENGTH_SHORT).show();
			}
		}
	}

}
