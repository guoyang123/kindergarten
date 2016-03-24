package com.kinder.about;

import android.os.Bundle;
import android.view.View;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;

import com.kinder.about.customviews.AboutMainViewXmlView;
import com.kinder.noticedetail.customviews.Webviewplug_webviewxmlView;
import com.kinder.parent.customviews.ParentDetailMainViewXmlView;

public class AboutActivity_VC extends AboutActivity_BC {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new AboutMainViewXmlView(this,app.pro,app.screenW,app.screenH);
	    mainView.setListener(this);
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
	public void onMessageMainThread(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		int id=v.getId();
		if(id==mainView.titleBarView.leftBtn.getId())
		{
			this.finish();
		}else if(id==mainView.score_RelativeLayout.getId())
		{
			scroing();
		}
				
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

}
