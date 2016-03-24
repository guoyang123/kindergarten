package cn.kinder.bean;

import java.io.Serializable;

public class Kinder_DataSource implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1180651368717366134L;
	
	public static final String OPERATION_NORMAL="normal";
	public static final String OPERATION_REFRESH="refresh";
	public static final String OPERATION_LOADMORE="loadmore";
	
	//分页加载的数据量
	public static final int NUM=10;
	
	private String operationType;

	private String errorCode;
	private String errorMsg;
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
	

	
}
