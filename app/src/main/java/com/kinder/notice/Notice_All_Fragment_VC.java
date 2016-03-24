package com.kinder.notice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.Kinder_DataSource;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.kinder.app.tools.KinderEventMessage;
import com.kinder.notice.customviews.Notice_All_MainViewXmlView;
import com.kinder.notice.model.NoticeListModel;
import com.kinder.noticedetail.NoticeDetailActivity_VC;

@SuppressLint("ValidFragment")
public class Notice_All_Fragment_VC extends Notice_All_Fragment_BC 
implements OnItemClickListener ,OnRefreshListener2<ListView>
{

	
	private String title;
	
	public Notice_All_Fragment_VC()
	{
		
	}
	
	public Notice_All_Fragment_VC(String title)
	{
		super();
		this.title=title;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		interface_getNotices_byNetWork(keyword, "", "0", String.valueOf(Kinder_DataSource.NUM), Kinder_DataSource.OPERATION_NORMAL);
	
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		if(mainView==null)
		{
			mainView=new Notice_All_MainViewXmlView(getActivity(),app.pro,app.screenW,app.screenH);
			mainView.setListener(this,this);
		}
			
		return mainView;
	}
	
	@Override
	public void onDestroyView()
	{    super .onDestroyView();
	if (null != mainView) 
	{         
		((ViewGroup) mainView.getParent()).removeView(mainView); 
	}
	}
	
	@Override
	public void transferMsg(Object... arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onResume() 
	{
		// TODO Auto-generated method stub
		super.onResume();
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
			case KinderEventMessage.MSG_GETNOTICE_START:
				start_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GETNOTICE_SUCCESS:
				succ_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GETNOTICE_FAIL:
				fail_getData(msg.getObj());
				break;
			}
		}
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
		return getEventMessage();
	}

	@Override
	public EventMessage initPlugEventMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	//下拉刷新
	@Override
	public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		interface_getNotices_byNetWork(keyword, "", "0", String.valueOf(Kinder_DataSource.NUM), Kinder_DataSource.OPERATION_NORMAL);
		
	}
   //加载更多
	@Override
	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		if(this.dataSource==null||this.dataSource.getNoticeListModel()==null)
		{
			interface_getNotices_byNetWork(keyword, "", "0", String.valueOf(Kinder_DataSource.NUM), Kinder_DataSource.OPERATION_LOADMORE);
			
		}else
		{
			interface_getNotices_byNetWork(keyword, "", String.valueOf(this.dataSource.getNoticeListModel().size()), String.valueOf(Kinder_DataSource.NUM), Kinder_DataSource.OPERATION_LOADMORE);
			
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		skip2Activity(NoticeDetailActivity_VC.class, "noticelistmodel", this.dataSource.getNoticeListModel().get(position-1));
	}

	public void searchLogic(String searchText) {
		// TODO Auto-generated method stub
		interface_getNotices_byNetWork(searchText, "", "0", String.valueOf(Kinder_DataSource.NUM), Kinder_DataSource.OPERATION_NORMAL);
	}

	public void notifydetail(NoticeListModel model) {
		// TODO Auto-generated method stub
		if(getActivity()!=null)
		{
			skip2Activity(NoticeDetailActivity_VC.class, "noticelistmodel", model);
		}
		
	}
}
