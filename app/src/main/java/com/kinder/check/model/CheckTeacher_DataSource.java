package com.kinder.check.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.kinder.bean.Kinder_DataSource;
import cn.kinder.bean.CheckModel;
import cn.kinder.bean.SaftyModel;
public class CheckTeacher_DataSource extends Kinder_DataSource implements
		Serializable 
		{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1196697133858445252L;

	private List<CheckModel> CheckModel;
	private List<SaftyModel> SaftyModel;
	
	private List<TeacherWrapModel> teacherWrapModels;
	
	
	
	public List<CheckModel> getCheckModel() {
		return CheckModel;
	}
	public void setCheckModel(List<CheckModel> checkModel) {
		CheckModel = checkModel;
	}
	public List<SaftyModel> getSaftyModel() {
		return SaftyModel;
	}
	public void setSaftyModel(List<SaftyModel> saftyModel) {
		SaftyModel = saftyModel;
	}
	public List<TeacherWrapModel> getTeacherWrapModels() {
		return teacherWrapModels;
	}
	
	
	/**将CheckModel\SaftyModel合二为一*/
	
	public void copyData2TeacherWrapModel()
	{
		teacherWrapModels=new ArrayList<TeacherWrapModel>();
		if(CheckModel!=null)
		{
			int count=CheckModel.size();
			for(int i=0;i<count;i++)
			{
				teacherWrapModels.add(new TeacherWrapModel(TeacherWrapModel.CHECKMODEL,CheckModel.get(i),null));
			}
		}
		
		if(SaftyModel!=null)
		{
			int count=SaftyModel.size();
			for(int i=0;i<count;i++)
			{
				teacherWrapModels.add(new TeacherWrapModel(TeacherWrapModel.SAFTYMODEL,null,SaftyModel.get(i)));
			}
		}
		
	}
	
}
