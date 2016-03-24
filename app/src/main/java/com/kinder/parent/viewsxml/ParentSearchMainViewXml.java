package com.kinder.parent.viewsxml;

import android.content.Context;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.kinder.parent.customviews.ParentSearch_TitleBarXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class ParentSearchMainViewXml extends MyRelativeLayout {

	public ParentSearch_TitleBarXmlView titleBarView;
//	public ListView listView;
	public PullToRefreshListView listView;
	public ParentSearchMainViewXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		titleBarView=new ParentSearch_TitleBarXmlView(context,pro,screenW,screenH);
		titleBarView.setId(2981);
		LayoutParams parent_Titlebar_params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		titleBarView.setLayoutParams(parent_Titlebar_params);
		this.addView(titleBarView);
		
//		listView=productListView(context, pro, 2982,
//				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
//				0, 0, 0, titleBarView.getId(), 
//				0, 0, 0,
//				0, 0, 0, 0, this);
		listView=new PullToRefreshListView(context);
		listView.setId(2982);
		LayoutParams listView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		listView_param.addRule(RelativeLayout.BELOW,titleBarView.getId());
		listView.setLayoutParams(listView_param);
		listView.setMode(Mode.DISABLED);
		this.addView(listView);
	}

}
