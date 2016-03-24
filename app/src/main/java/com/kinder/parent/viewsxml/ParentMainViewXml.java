package com.kinder.parent.viewsxml;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.myt360.app.customviews.MyRelativeLayout;


public class ParentMainViewXml extends MyRelativeLayout {

	public PullToRefreshListView listView;
	public ParentMainViewXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		listView=new PullToRefreshListView(context);
		LayoutParams listView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		listView.setLayoutParams(listView_param);
		listView.setMode(Mode.BOTH);
		this.addView(listView);
		
	}

}
