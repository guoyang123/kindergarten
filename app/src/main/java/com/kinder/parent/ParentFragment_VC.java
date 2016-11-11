package com.kinder.parent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.kinder.app.tools.KinderEventMessage;
import com.kinder.parent.customviews.ParentMainViewXmlView;

import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.Kinder_DataSource;

public class ParentFragment_VC extends ParentFragment_BC  implements OnItemClickListener,OnRefreshListener2<ListView>{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mainView=new ParentMainViewXmlView(getActivity(),app.pro,app.screenW,app.screenH,null);
		mainView.setListener(this, this);
		return mainView;
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		interface_getArticle_byNetWork(null, "0", Kinder_DataSource.OPERATION_NORMAL);
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
	public void onMessageMainThread(Object object) {
		// TODO Auto-generated method stub
		if(object!=null&&object instanceof KinderEventMessage)
		{
			KinderEventMessage msg=(KinderEventMessage)object;
			switch(msg.getCode())
			{
			case KinderEventMessage.MSG_GETARTICLES_START:
				start_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GETARTICLES_SUCCESS:
				succ_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GETARTICLES_FAIL:
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
			interface_getArticle_byNetWork(null,"0",Kinder_DataSource.OPERATION_NORMAL);
		}
	   //家长更多
		@Override
		public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
			// TODO Auto-generated method stub
			if(this.dataSource==null||this.dataSource.getArticleListModel()==null)
			{
				interface_getArticle_byNetWork(null,"0",Kinder_DataSource.OPERATION_LOADMORE);
			}else
			{
				interface_getArticle_byNetWork(null,String.valueOf(this.dataSource.getArticleListModel().size()),Kinder_DataSource.OPERATION_LOADMORE);
			}
			
		}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		logic_clickItem(position);
	}
	

}
