package com.kinder.chat.customviews;

import android.content.Context;

import com.kinder.chat.viewsxml.GroupDetail_GroupInfoXml;

public class GroupDetail_GroupInfoXmlView extends GroupDetail_GroupInfoXml {

	public GroupDetail_GroupInfoXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setInfo(String key,String value)
	{
		this.key_TextView.setText(key);
		this.value_TextView.setText(value);
	}
}
