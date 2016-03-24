package com.kinder.chat.customviews;

import android.content.Context;

import cn.kinder.bean.ClassesModel;

import com.kinder.chat.viewsxml.TeacherInfoXml;

public class TeacherInfoXmlView extends TeacherInfoXml {

	public TeacherInfoXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	/**数据初始化*/
	public void initData(ClassesModel teacher) {
		// TODO Auto-generated method stub
		if(teacher==null)
		{
			return;
		}
		//幼儿园名称
		this.schoolnameView.initData("幼儿园名称",teacher.getSchoolModel().getSchoolname());
		//幼儿园班级
		this.classnameView.initData("所属班级", teacher.getClassname());
			    
	}

}
