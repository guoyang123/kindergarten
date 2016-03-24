package cn.kinder.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class ContactListDataSource extends Kinder_DataSource implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4039510087964515640L;

	
	private List<ClassModel> ClassModels;
	private List<ContactListUserModel> ContactListUserModels;
	
	private List<ContactListModel> contactModels=new ArrayList<ContactListModel>();
	
	public List<ClassModel> getClassModels() {
		return ClassModels;
	}
	public void setClassModels(List<ClassModel> classModels) {
		ClassModels = classModels;
	}
	public List<ContactListUserModel> getContactListUserModels() {
		return ContactListUserModels;
	}
	public void setContactListUserModels(
			ArrayList<ContactListUserModel> contactListUserModels) {
		ContactListUserModels = contactListUserModels;
	}
	public List<ContactListModel> getContactModels() {
		return contactModels;
	}
	public void setContactModels(List<ContactListModel> contactModels) {
		this.contactModels = contactModels;
	}
	
	
  
	/**手工设置数据源*/
	public void copyData2ContactModels()
	{
		if(ClassModels!=null)
		{
			for(int i=0;i<ClassModels.size();i++)
			{
				ClassModel classModel=ClassModels.get(i);
				SchoolModel schoolmodel=classModel.getSchoolModel();
				if(schoolmodel!=null)
				{
					String mark=schoolmodel.getSchoolmark();
					
					if(mark!=null&&!mark.equals(""))
					{
						if(mark.equals("0"))//开群
						{
							ContactListModel model=new ContactListModel(ContactListModel.GROUP,classModel,null);
							contactModels.add(model);
						}
					}
				}
			}
		}
		
		if(ContactListUserModels!=null&&ContactListUserModels.size()>0)
		{
			for(int i=0;i<ContactListUserModels.size();i++)
			{
				 ContactListUserModel usermodel=ContactListUserModels.get(i);
				 ContactListModel model=new ContactListModel(ContactListModel.USER,null,usermodel);
				
				 contactModels.add(model);
			}
		}
	}
	
}
