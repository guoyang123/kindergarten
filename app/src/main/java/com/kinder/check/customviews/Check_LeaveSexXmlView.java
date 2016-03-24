package com.kinder.check.customviews;

import android.content.Context;

import cn.kinder.bean.BabyModel;

import com.kinder.check.viewsxml.Check_LeaveSexXml;

public class Check_LeaveSexXmlView extends Check_LeaveSexXml {

	public Check_LeaveSexXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	
	/**数据初始化*/
	public void initViewData(BabyModel babyModel)
	{
		if(babyModel==null)
		{
			return;
		}
		//this.
		
		this.baby_TextView.setText(babyModel.getBabyname());
	}
}
