package com.kinder.perfect.customviews;

import android.content.Context;

import cn.kinder.bean.RelationModel;

import com.kinder.perfect.viewsxml.PerfectSexInfoXml;
import com.tour.app.wheelviewdialog.BasicInfoModel;

public class PerfectSexInfoXmlView extends PerfectSexInfoXml {

	public int position;//0:女 1;男
	public RelationModel  model;//我是谁
	public PerfectSexInfoXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void initData(String key,String usersex) {
		// TODO Auto-generated method stub
		this.key_TextView.setText(key);
		this.value_TextView.setText(usersex);
	}
	
	

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
		value_TextView.setText(position==0?"女":"男");
		
	}

	public RelationModel getModel() {
		return model;
	}

	public void setModel(RelationModel model) {
		this.model = model;
		this.value_TextView.setText(model.getRelationname());
	}

	

	
}
