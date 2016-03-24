package com.squareup.customviews;

import android.content.Context;

import com.squareup.interfaces.OnClickOtherDateListener;
import com.squareup.viewsxml.CalTitleXml;

import android.view.View;
import android.view.View.OnClickListener;
public class CalTitleXmlView extends CalTitleXml {

	
	public CalTitleXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
	}

	public void setListener(OnClickListener listener) {
		
		this.beforemonth_Buttton.setOnClickListener(listener);
		this.beforeyear_Buttton.setOnClickListener(listener);
		this.nextmonth_Buttton.setOnClickListener(listener);
		this.nextyear_Buttton.setOnClickListener(listener);
	}
//	@Override
//	public void onClick(View v) {
//		// TODO Auto-generated method stub
//		int id=v.getId();
//		if(listener==null)
//		{
//			return;
//		}
//		if(id==this.beforeyear_Buttton.getId())//上个月
//		{
//			listener.onClickOtherDate(OnClickOtherDateListener.BEFORE_MONTH);
//		}else if(id==this.beforemonth_Buttton.getId())//上年
//		{
//			listener.onClickOtherDate(OnClickOtherDateListener.BEFORE_YEAR);
//		}else if(id==this.nextmonth_Buttton.getId())//下年
//		{
//			listener.onClickOtherDate(OnClickOtherDateListener.NEXT_YEAR);
//		}else if(id==this.nextyear_Buttton.getId())//下月
//		{
//			listener.onClickOtherDate(OnClickOtherDateListener.NEXT_MONTH);
//		}
//	}

}
