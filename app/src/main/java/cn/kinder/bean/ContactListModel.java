package cn.kinder.bean;

import java.io.Serializable;

import com.easemob.chat.EMConversation;

import net.tsz.afinal.annotation.sqlite.Transient;

public class ContactListModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4689339122808452725L;

	public static final int GROUP=1;
	public static final int USER=2;
	private int type;
	private ClassModel classModel;
	private ContactListUserModel contactUserModel;
	private @Transient EMConversation eMConversation;
	
	
	
	
	public ContactListModel(int type, ClassModel classModel,
			ContactListUserModel contactUserModel) {
		super();
		this.type = type;
		this.classModel = classModel;
		this.contactUserModel = contactUserModel;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ClassModel getClassModel() {
		return classModel;
	}
	public void setClassModel(ClassModel classModel) {
		this.classModel = classModel;
	}
	public ContactListUserModel getContactUserModel() {
		return contactUserModel;
	}
	public void setContactUserModel(ContactListUserModel contactUserModel) {
		this.contactUserModel = contactUserModel;
	}
	public EMConversation geteMConversation() {
		return eMConversation;
	}
	public void seteMConversation(EMConversation eMConversation) {
		this.eMConversation = eMConversation;
	}
	
	
}
