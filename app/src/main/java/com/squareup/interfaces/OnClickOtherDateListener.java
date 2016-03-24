package com.squareup.interfaces;


/**点击上个月、上一年、下个月、下一年的监听*/
public interface OnClickOtherDateListener  {

	
	
	public static final int BEFORE_MONTH=1;
	public static final int BEFORE_YEAR=2;
	public static final int NEXT_MONTH=3;
	public static final int NEXT_YEAR=4;
	
	void onClickOtherDate(int position);
}
