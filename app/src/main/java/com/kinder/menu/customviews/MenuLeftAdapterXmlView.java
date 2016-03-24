package com.kinder.menu.customviews;

import android.content.Context;
import android.view.View;

import com.kinder.menu.model.SlideModel;
import com.kinder.menu.viewsxml.MenuLeftAdapterXml;

public class MenuLeftAdapterXmlView extends MenuLeftAdapterXml {

	public MenuLeftAdapterXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	/**数据初始化*/
	public void initData(SlideModel slideModel) {
		// TODO Auto-generated method stub
		if(slideModel==null)
		{
			return;
		}
		boolean isshow=slideModel.isIsshow();
		if(isshow)
		{
			this.switch_ImageView.setVisibility(View.VISIBLE);
		}else
		{
			this.switch_ImageView.setVisibility(View.GONE);
		}
		
		boolean isline=slideModel.isIsline();
		if(isline)//已开
		{
			this.switch_ImageView.setImageResource(R.getRCode("drawable", "switch_online"));
		}else//已关
		{
			this.switch_ImageView.setImageResource(R.getRCode("drawable", "switch_offline"));
		}
		
		
		
		String icon=slideModel.getIcon();
		this.icon_ImageView.setImageResource(R.getRCode("drawable", icon));
		String text=slideModel.getText();
		this.text_TextView.setText(text);
		
		
	}

}
