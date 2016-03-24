package com.kinder.menu.customviews;

import android.content.Context;

import com.kinder.menu.interfaces.OnSearchListener;
import com.kinder.menu.viewsxml.MenuMainViewXml;

public class MenuMainViewXmlView extends MenuMainViewXml {

	public MenuMainViewXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	
	/**设置监听*/
	public void setListener(OnClickListener onClickListener,OnSearchListener onSearchListener)
	{
		this.titleBarView.setListener(onClickListener,onSearchListener);
		this.bottomWrap.setListener(onClickListener);
		
	}
	
	public void refreshIcon(int ps)
	{
		this.bottomWrap.refreshIcon(ps);
	}


	/**根据位置显示相对应的titlebar*/
	public void refreshTitleBar(int position) {
		// TODO Auto-generated method stub
		this.titleBarView.refreshTitleBar(position);
		
	}
	
}
