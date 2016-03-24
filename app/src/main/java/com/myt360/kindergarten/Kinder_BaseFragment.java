package com.myt360.kindergarten;

import java.io.Serializable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import cn.com.iucd.iucdframe.activity.IUCD_BaseFragment;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.UserModel;
import cn.kinder.user.DbOperationModel;
import cn.kinder.util.MethodUtils;

import com.kinder.app.loading.Buzz_LoadingDialog;
import com.kinder.app.tools.KinderNetWork;
import com.umeng.analytics.MobclickAgent;

/**
 * 程序基础Fragment
 * */
public abstract class Kinder_BaseFragment extends IUCD_BaseFragment {

	protected float pro,screenW,screenH;
	protected EventMessage eventMessage;
	protected KinderApplication app;
	protected Buzz_LoadingDialog buzz_dialog;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    app=(KinderApplication)getActivity().getApplication();
		initScreenPro();
		
		buzz_dialog=Buzz_LoadingDialog.newInstance(getActivity(), app);
//		buzz_dialog.show(getActivity().getSupportFragmentManager(), "bkw_dialog");
		buzz_dialog.setCancelable(false);
		 buzz_dialog.setShowsDialog(false);
	}
	/**初始化屏幕适配参数*/
	private void initScreenPro()
	{
		
	    pro=app.getPro();
	    screenW=app.getScreenW();
	    screenH=app.getScreenH();
	}

	/**获取消息类*/
	public EventMessage getEventMessage() {
		if(eventMessage==null)
		{
			eventMessage=new EventMessage();
		}
		return eventMessage;
	}
	/**注销消息*/
	public void destroyEventMessage()
	{
		if(eventMessage!=null)
		{
			eventMessage.unregister(this);
		}
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		MobclickAgent.onPageStart(Kinder_BaseFragment.class.getSimpleName()); //统计页面
	
	//百度统计
		
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		MobclickAgent.onPageEnd(Kinder_BaseFragment.class.getSimpleName()); //统计页面
	
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		destroyEventMessage();
		buzz_dialog=null;
	}
	
	 @Override
	 public void onMessageMainThread(Object arg0) 
	 {
		MethodUtils.logic_ErrorCode(getActivity(),arg0);
	 }
	/**
	 * 
	 * 启动loading动画
	 * 
	 * */
	protected void startLoading()
	{
//    	    FragmentManager fm=getActivity().getSupportFragmentManager();
//    		FragmentTransaction ft=fm.beginTransaction();
//    		//ft.addToBackStack("bkw_dialog");
//    		ft.commit();
		
    		  
//    			   buzz_dialog.show(getActivity().getSupportFragmentManager(), "bkw_dialog");
//    			   buzz_dialog.setCancelable(false);
//    		  
		    if(!getActivity().isFinishing())
		    {
		    	buzz_dialog.setShowsDialog(true);
		    }
    		   
		
    		
	}
	/**
	 * 
	 * 结束动画
	 * 
	 * */
	protected void stopLoading()
	{
		buzz_dialog.dismiss();
	}
	
	/**页面跳转*/
	protected void skip2Activity(Class cls)
	{
		Intent it=new Intent(getActivity(),cls);
		getActivity().startActivity(it);
	}
	
	/**页面跳转*/
	protected void skip2Activity(Class cls,String key,Serializable s)
	{
		Intent it=new Intent(this.getActivity(),cls);
		Bundle bundle=new Bundle();
		bundle.putSerializable(key, s);
		it.putExtra("bundle",bundle);
		getActivity().startActivity(it);
	}
	

	
	/**获取用户信息*/
	public UserModel getUserInfo()
	{
		return DbOperationModel.getUserInfo(getActivity());
	}
	
	/**获取通知接口*/
   public void interface_getNotices_byNetWork(String keyword,String noticecate,String from,String num,String operationtype)
   {
	   KinderNetWork.interface_getNotices_byNetWork(getActivity(), getEventMessage(), keyword, noticecate,from,num,operationtype);
   }
}
