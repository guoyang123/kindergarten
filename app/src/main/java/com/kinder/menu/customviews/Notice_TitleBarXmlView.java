package com.kinder.menu.customviews;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import cn.kinder.util.MethodUtils;

import com.kinder.menu.interfaces.OnSearchListener;
import com.kinder.menu.viewsxml.Notice_TitleBarXml;

public class Notice_TitleBarXmlView extends Notice_TitleBarXml {

	public Context context;
	public OnSearchListener onSearchListener;
	public Notice_TitleBarXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.root_wrap.getBackground().setAlpha(70);
		this.search_EditText.getBackground().setAlpha(10);
		setSearchListener();
	}

	
	public void setListener(OnClickListener onClickListener,OnSearchListener onSearchListener)
	{
		this.onSearchListener=onSearchListener;
		this.rightBtn.setOnClickListener(onClickListener);
		this.search_ImageView.setOnClickListener(onClickListener);
	}
	
	/**
	 * 
	 * 键盘上搜索按钮监听
	 * 
	 * */
	public void setSearchListener(){
		this.search_EditText.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if(keyCode==KeyEvent.KEYCODE_ENTER||keyCode==KeyEvent.KEYCODE_SEARCH){//搜索按钮
					MethodUtils.showanndhide(context, search_EditText);
                 //设置回调
					if(onSearchListener!=null){
						onSearchListener.onSearch();
					}
					return true;
				}
				return false;
			}
		});
	}
}
