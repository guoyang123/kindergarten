package com.kinder.setting.customviews;

import android.content.Context;
import android.view.View;

import com.kinder.setting.viewsxml.SettingWrapXml;

public class SettingWrapXmlView extends SettingWrapXml {

	public SettingWrapXmlView(Context context, float pro, float screenW,
			float screenH, int icon_width, int icon_height) 
	{
		super(context, pro, screenW, screenH, icon_width, icon_height);
		// TODO Auto-generated constructor stub
	}

	/**设置缓存大小*/
	public void setCacheData(String cacheData)
	{
		
			cache_TextView.setVisibility(View.VISIBLE);
			cache_TextView.setText(cacheData);
		
		
	}
}
