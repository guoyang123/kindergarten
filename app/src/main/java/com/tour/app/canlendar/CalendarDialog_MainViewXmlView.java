package com.tour.app.canlendar;

import java.util.Calendar;
import java.util.Date;

import com.squareup.interfaces.OnClickOtherDateListener;
import com.squareup.timessquare.CalendarPickerView.OnDateSelectedListener;
import com.squareup.timessquare.MonthDescriptor;
import com.squareup.timessquare.CalendarPickerView.FluentInitializer;
import com.squareup.timessquare.CalendarPickerView.MonthCellWithMonthIndex;
import com.squareup.timessquare.CalendarPickerView.SelectionMode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Toast;

public class CalendarDialog_MainViewXmlView extends CalendarDialog_MainViewXml {

	private Context context;
	public FluentInitializer fluentInitializer;
	private int currentIndex=0;
	public CalendarDialog_MainViewXmlView(Context context, float pro,
			float screenW, float screenH,OnDateSelectedListener onDateSelectedListener) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		final Calendar nextYear = Calendar.getInstance();
	    nextYear.add(Calendar.YEAR, 1);

	    final Calendar lastYear = Calendar.getInstance();
	    lastYear.add(Calendar.YEAR, -1);

	    Date date=new Date();
	    //mainView.canledarView
	    this.canledarView.setOnDateSelectedListener(onDateSelectedListener);
	     fluentInitializer=  canledarView.init(lastYear.getTime(), nextYear.getTime()) //
	    .inMode(SelectionMode.SINGLE)    
	    .withSelectedDate(date);
	     MonthCellWithMonthIndex monthindex= canledarView.getMonthCellWithIndexByDate(date);
	    
	    
	   if(monthindex!=null)
	   {
		   int index= monthindex.monthIndex;
		   this.currentIndex=index;
		   changeTime(index);
	   }
	   this.canledarView.setSelection(currentIndex);
	
	}
	


	/**设置监听*/
	public void setListener(OnClickListener listener)
	{
		this.calTitleView.setListener(listener);
	}
	
	
	
	/**修改时间*/
	@SuppressLint("NewApi")
	public void changeTime(int p)
	{
		if(p<=0)
		{p=0;}
		MonthDescriptor month=canledarView.getMonths().get(p);
		this.calTitleView.title.setText(month.getLabel());
	}
	
	/**改变viewpager的状态*/
	public void changeViewpagerStatus(int position)
	{
		int item=this.canledarView.getFirstVisiblePosition();
		int totalcount=this.canledarView.getAdapter().getCount();
		if(position==OnClickOtherDateListener.BEFORE_MONTH)//上月
		{
			this.currentIndex--;
			if(currentIndex<=0)
			{
				currentIndex=0;
			}
			this.canledarView.setSelection(currentIndex);// currentIndex item-1
			changeTime(currentIndex);//item-1 currentIndex
//			this.canledarView.setSelection(item-1);
//			changeTime(item-1);
		}else if(position==OnClickOtherDateListener.NEXT_MONTH)//下月
		{
			if(currentIndex<(totalcount-1))//item currentIndex
			{
				currentIndex++;
				this.canledarView.setSelection(currentIndex);//item+1 currentIndex
				changeTime(currentIndex);//item+1 currentIndex
			}
//			if(item<totalcount)
//			{
//				this.canledarView.setSelection(item+1);
//				changeTime(item+1);
//			}
		}
	}
	
}
