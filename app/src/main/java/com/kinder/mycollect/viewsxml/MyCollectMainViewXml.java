package com.kinder.mycollect.viewsxml;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.kinder.mycollect.customviews.MyCollect_TitleBarXmlView;
import com.kinder.parent.customviews.ParentDetail_TitleBarXmlView;
import com.myt360.app.customviews.MyRelativeLayout;


public class MyCollectMainViewXml extends MyRelativeLayout {

	public MyCollect_TitleBarXmlView titleBarView;
	public PullToRefreshListView listView;
	public MyCollectMainViewXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		titleBarView=new MyCollect_TitleBarXmlView(context,pro,screenW,screenH);
		titleBarView.setId(400);
		LayoutParams titleBarView_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		titleBarView.setLayoutParams(titleBarView_params);
		this.addView(titleBarView);
		
		listView=new PullToRefreshListView(context);
		LayoutParams listView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		listView_param.addRule(RelativeLayout.BELOW,titleBarView.getId());
		listView.setLayoutParams(listView_param);
		listView.setMode(Mode.DISABLED);
		this.addView(listView);
		
	}

}
