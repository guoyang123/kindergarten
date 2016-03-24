package com.kinder.feedback;

import com.kinder.app.tools.KinderEventMessage;
import com.kinder.feedback.customviews.FeedBackMainViewXmlView;

import android.os.Bundle;
import android.view.View;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;

public class Menu_FeedBackActivity_VC extends Menu_FeedBackActivity_BC {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new FeedBackMainViewXmlView(this,app.pro,app.screenW,app.screenH);
	    setContentView(mainView);
	    mainView.setListener(this);
	
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
			case KinderEventMessage.MSG_FEEDBACK_START:
				start_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_FEEDBACK_SUCCESS:
				succ_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_FEEDBACK_FAIL:
				fail_getData(msg.getObj());
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		int id=v.getId();
		if(id==mainView.titleBarView.leftBtn.getId())
		{
			this.finish();
		}else if(id==mainView.submit_Button.getId())
		{
			logic_clickSubmit();
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
