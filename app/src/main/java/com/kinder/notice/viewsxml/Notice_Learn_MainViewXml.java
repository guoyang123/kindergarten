package com.kinder.notice.viewsxml;

import android.content.Context;
import android.widget.RelativeLayout;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.myt360.app.customviews.MyRelativeLayout;
/**通知主视图*/
public class Notice_Learn_MainViewXml extends MyRelativeLayout {

	public PullToRefreshListView listView;
	public Notice_Learn_MainViewXml(Context context, float pro, float screenW,
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
