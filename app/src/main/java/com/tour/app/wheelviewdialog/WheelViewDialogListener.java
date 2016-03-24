package com.tour.app.wheelviewdialog;

public interface WheelViewDialogListener {

	int SURE_BUTTON=1;//点击确定
	int CANCEL_BUTTON=2;//点击取消
	
	
	int OPERATIONTYPE_SEX=1;
	int OPERATIONTYPE_WHO=2;
	
	/**
	 * @param type           确定或者取消
	 * @param position       wheelview的子选项
	 * @param operationtype  操作类型，1：性别 2，我是 
	 * 
	 * 
	 * */
	void onClickBtn(int type, int position, int operationtype);
}
