package cn.kinder.bean;

import java.io.Serializable;

public class DiseaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5305600049287880868L;

	private String diseaseid;
	private String diseaserem;
	
	
	
	
	public String getDiseaseid() {
		return diseaseid;
	}
	public void setDiseaseid(String diseaseid) {
		this.diseaseid = diseaseid;
	}
	public String getDiseaserem() {
		return diseaserem;
	}
	public void setDiseaserem(String diseaserem) {
		this.diseaserem = diseaserem;
	}
	
	
}
