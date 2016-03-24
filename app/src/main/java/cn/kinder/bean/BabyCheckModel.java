package cn.kinder.bean;

import java.io.Serializable;
import java.util.List;

public class BabyCheckModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6963312075240749628L;

	private BabyModel babyModel;
	private List<BabyCheckTimeModel> babyCheckTimeModel;
	public BabyModel getBabyModel() {
		return babyModel;
	}
	public void setBabyModel(BabyModel babyModel) {
		this.babyModel = babyModel;
	}
	public List<BabyCheckTimeModel> getBabyCheckTimeModel() {
		return babyCheckTimeModel;
	}
	public void setBabyCheckTimeModel(List<BabyCheckTimeModel> babyCheckTimeModel) {
		this.babyCheckTimeModel = babyCheckTimeModel;
	}
	
	

	
	
}
