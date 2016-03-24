package com.myt360.app.customviews;

import com.myt360.app.interfaces.ScrollViewListener;

import android.content.Context;
import android.graphics.Rect;
import android.widget.ScrollView;

/**
 * 功能
 * (1)scrollview内的布局发生变化时 禁止scrollview滑动
 * (2)实时监听scrollview滑动距离。
 * 
 * */
public class ForbidScrollView extends ScrollView {

	private ScrollViewListener scrollViewListener;
	public ForbidScrollView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void setScrollViewListener(ScrollViewListener scrollViewListener) 
	{
		this.scrollViewListener = scrollViewListener;
	}
	@Override
	protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
		// 禁止scrollview内布局发生变化后 滚动
		return 0;
	}
	
	/**获取scrollview滑动距离等参数*/
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		// TODO Auto-generated method stub
		super.onScrollChanged(l, t, oldl, oldt);
		if(scrollViewListener!=null)
		{
			scrollViewListener.onScrollChange(l, t, oldl, oldt);
		}
	}
	
}
