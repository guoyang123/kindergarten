package com.kinder.mycollect;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.kinder.app.tools.KinderEventMessage;
import com.kinder.mycollect.customviews.MyCollectMainViewXmlView;
import com.kinder.parent.customviews.ParentSearchMainViewXmlView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.Kinder_DataSource;

public   class MyCollectActivity_VC extends MyCollectActivity_BC 
implements OnItemClickListener,OnRefreshListener2<ListView>
{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new MyCollectMainViewXmlView(this,app.pro,app.screenW,app.screenH);
	    mainView.setListener(this,this,this);
		setContentView(mainView);
		interface_getCollects_byNetWork("0",Kinder_DataSource.OPERATION_NORMAL);
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
		int id=v.getId();
		if(id==mainView.titleBarView.back_Button.getId())
		{
			this.finish();
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
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		logic_clickItem(position);
	}
	@Override
	public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		
	}

	
}
