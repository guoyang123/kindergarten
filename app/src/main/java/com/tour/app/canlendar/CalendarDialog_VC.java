package com.tour.app.canlendar;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.myt360.kindergarten.R;
import com.squareup.interfaces.OnClickOtherDateListener;
import com.squareup.timessquare.CalendarPickerView.OnDateSelectedListener;

public class CalendarDialog_VC extends CalendarDialog_BC implements View.OnClickListener
{

	//private static  CalendarDialog_VC calendarDialog;
	private float pro,screenW,screenH;
	private Context context;
	private OnDateSelectedListener onDateSelectedListener;
	public CalendarDialog_VC(Context context,float pro,float screenW,float screenH,OnDateSelectedListener onDateSelectedListener) 
	{
	//	super(context);
		super(context);//, R.style.Transparent
		this.context=context;
		this.pro=pro;
		this.screenW=screenW;
		this.screenH=screenH;
		this.onDateSelectedListener=onDateSelectedListener;
		Window w=this.getWindow();
		w.setGravity(Gravity.CENTER);
		//w.setWindowAnimations(R.style.mystyle);
		 this.show();
		 //宽度全屏
		 WindowManager.LayoutParams lp = this.getWindow().getAttributes();
		 lp.width = (int)(screenW); //设置宽度
		 this.getWindow().setAttributes(lp);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new CalendarDialog_MainViewXmlView(context,pro,screenW,screenH,onDateSelectedListener);
		mainView.setListener(this);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(mainView);
	}

	
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		if(id==mainView.calTitleView.beforeyear_Buttton.getId())//上个月
		{
			mainView.changeViewpagerStatus(OnClickOtherDateListener.BEFORE_MONTH);
		}else if(id==mainView.calTitleView.beforemonth_Buttton.getId())//上年
		{
			
		}else if(id==mainView.calTitleView.nextmonth_Buttton.getId())//下年
		{
			
		}else if(id==mainView.calTitleView.nextyear_Buttton.getId())//下月
		{
			mainView.changeViewpagerStatus(OnClickOtherDateListener.NEXT_MONTH);
		}
	}
}
