package com.kinder.notice;

import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;

import com.google.gson.Gson;
import com.kinder.notice.customviews.NoticeMainViewXmlView;
import com.kinder.notice.model.NoticeListModel;
import android.annotation.SuppressLint;
public class NoticeFragment_VC extends NoticeFragment_BC implements OnPageChangeListener{

	
	public NoticeFragment_VC(){}
	@SuppressLint("ValidFragment")
	public NoticeFragment_VC(String notify)
	{
		if(notify!=null)
		{
			Gson gson=new Gson();
			noticeListModel=gson.fromJson(notify, NoticeListModel.class);
		}
	}
	public void setNotify(String notify)
	{
		if(notify!=null)
		{
		 Gson gson=new Gson();
		 noticeListModel=gson.fromJson(notify, NoticeListModel.class);
		 mainView.initViewData(noticeListModel);
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mainView=new NoticeMainViewXmlView(getActivity(),app.pro,app.screenW,app.screenH,getActivity().getSupportFragmentManager());
		mainView.setListener(this);
		mainView.initViewData(noticeListModel);
		return mainView;
		
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		//logic_notify();
	}
	@Override
	public void transferMsg(Object... arg0) {
		// TODO Auto-generated method stub
		
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
	protected void onWindowFocusChanged() {
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
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		
	}
	public void setSearchText(String searchText) {
		// TODO Auto-generated method stub
		mainView.searchLogic(searchText);
		
	}

}
