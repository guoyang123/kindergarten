package com.kinder.userdetail.customviews;

import android.content.Context;

import cn.kinder.bean.BabyModel;
import cn.kinder.bean.ClassesModel;

import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.userdetail.viewsxml.UserDetail_TeacherInfoXml;

public class UserDetail_TeacherInfoXmlView extends UserDetail_TeacherInfoXml {

	public UserDetail_TeacherInfoXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	
	/**数据初始化*/
	public void initData(ClassesModel classesModel)
	{
		if(classesModel==null)
		{
			return;
		}
		//幼儿园名称
		this.schoolnameView.initData("幼儿园名称",classesModel.getSchoolModel().getSchoolname());
		//幼儿园班级
		this.classesView.initData("所属班级", classesModel.getClassname());
	}
}
