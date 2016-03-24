package com.kinder.setting.customviews;

import android.content.Context;
import android.util.Log;

import com.kinder.setting.viewsxml.SettingMainViewXml;

public class SettingMainViewXmlView extends SettingMainViewXml {

	public SettingMainViewXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setListener(OnClickListener onClickListener)
	{
		this.titleBarView.leftBtn.setOnClickListener(onClickListener);
		this.exit_Button.setOnClickListener(onClickListener);
		this.aboutView.setOnClickListener(onClickListener);
		this.modifyPswView.setOnClickListener(onClickListener);
		this.cacheView.setOnClickListener(onClickListener);
	}
	
	/**数据初始化*/
	public void initMainViewData(String cacheData)
	{
		this.cacheView.setCacheData(cacheData);
	}
}
