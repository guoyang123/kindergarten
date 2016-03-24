package com.kinder.check.model;

import java.io.Serializable;
import java.util.List;
import cn.kinder.bean.DiseaseModel;
import cn.kinder.bean.Kinder_DataSource;

public class DieaseDataSource extends Kinder_DataSource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5469512020522466995L;

	private List<DiseaseModel> DiseaseModel;

	public List<DiseaseModel> getDiseaseModel() {
		return DiseaseModel;
	}

	public void setDiseaseModel(List<DiseaseModel> diseaseModel) {
		DiseaseModel = diseaseModel;
	}
	
	
}
