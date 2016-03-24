package cn.kinder.bean;

import java.io.Serializable;

public class ContactListUserModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8207081701012795633L;

	
	private UserModel userModel;
	private BabyModel babyModel;
	private RelationModel relationModel;
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public BabyModel getBabyModel() {
		return babyModel;
	}
	public void setBabyModel(BabyModel babyModel) {
		this.babyModel = babyModel;
	}
	public RelationModel getRelationModel() {
		return relationModel;
	}
	public void setRelationModel(RelationModel relationModel) {
		this.relationModel = relationModel;
	}
	
	
}
