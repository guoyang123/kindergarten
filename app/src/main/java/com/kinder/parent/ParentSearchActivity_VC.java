package com.kinder.parent;

import com.kinder.app.tools.KinderEventMessage;
import com.kinder.parent.customviews.ParentSearchMainViewXmlView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;

public   class ParentSearchActivity_VC extends ParentSearchActivity_BC 
implements OnItemClickListener
{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new ParentSearchMainViewXmlView(this,app.pro,app.screenW,app.screenH,getUserInfo());
	    mainView.setListener(this,this);
		setContentView(mainView);
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
		if(id==mainView.titleBarView.rightBtn.getId()||
		   id==mainView.titleBarView.search_ImageView.getId())
		{
			logic_clickSearchBtn();
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

	
}
