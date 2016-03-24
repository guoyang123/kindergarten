package com.kinder.check.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

import com.kinder.check.viewsxml.CheckUserFragmentXml;
import com.squareup.interfaces.OnClickOtherDateListener;
import com.squareup.timessquare.CalendarPickerView.FluentInitializer;
import com.squareup.timessquare.CalendarPickerView.MonthCellWithMonthIndex;
import com.squareup.timessquare.CalendarPickerView.OnDateSelectedListener;
import com.squareup.timessquare.CalendarPickerView.SelectionMode;
import com.squareup.timessquare.MonthDescriptor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.kinder.bean.BabyCheckModel;
import cn.kinder.bean.BabyCheckTimeModel;
import cn.kinder.bean.BabyModel;
import cn.kinder.util.TimeUtils;

public class CheckUserFragmentXmlView extends CheckUserFragmentXml {

	private FluentInitializer fluentInitializer;
	private int currentIndex;
	private final Calendar nextYear;
	private final Calendar lastYear;
	public CheckUserFragmentXmlView(Context context, float pro, float screenW,
			float screenH,OnClickOtherDateListener onClickOtherDateListener) {
		super(context, pro, screenW, screenH,onClickOtherDateListener);
		   
		this.canledarView.setListener(null);//不可点击
		    nextYear = Calendar.getInstance();
		    nextYear.add(Calendar.YEAR, 1);

		    lastYear = Calendar.getInstance();
		    lastYear.add(Calendar.YEAR, -1);

		    Date date=new Date();
		     fluentInitializer=  canledarView.init(lastYear.getTime(), nextYear.getTime()) //
		    .inMode(SelectionMode.MULTIPLE)    
		    .withSelectedDate(date);
		    
		   MonthCellWithMonthIndex monthindex= canledarView.getMonthCellWithIndexByDate(date);
		   if(monthindex!=null)
		   {
			   int index= monthindex.monthIndex;
			   this.currentIndex=index;
			   changeTime(index);
				
		   }
		   
		   this.canledarView.setSelection(currentIndex);//item+1 currentIndex
	}

	
	public void setListener(OnClickListener onClickListener,OnDateSelectedListener onDateSelectedListener,
			OnPageChangeListener onPageChangeListener)
	{
		this.send_Button.setOnClickListener(onClickListener);
		this.calTitleView.setListener(onClickListener);
	}

	public void initViewData(BabyCheckModel dataSource) {
		// TODO Auto-generated method stub
		if(dataSource==null||dataSource.getBabyModel()==null)
		{
			return;
		}
		BabyModel babyModel=dataSource.getBabyModel();
		String babyname=babyModel.getBabyname();
		if(babyname!=null&&!babyname.equals(""))
		{
			this.babyname_TextView.setText(babyname);
		}
		List<BabyCheckTimeModel> models=dataSource.getBabyCheckTimeModel();
		refreshCalendarData(models);
	}
	
	/**更新日历*/
	public void refreshCalendarData(List<BabyCheckTimeModel> models) {
		// TODO Auto-generated method 
//		Log.e("buzz1", "更新日历:"+models+"_size:"+models.size());
		//计算请假天数
		setLeaveDays(models);
		List<Date> dates=new ArrayList<Date>();
		if(models==null)
		{
			return;
		}
		int size=models.size();
		for(int i=0;i<size;i++)//BabyCheckTimeModel model:models
		{
			BabyCheckTimeModel model=models.get(i);
			String starttime=model.getCheckstart();
			String endtime=model.getCheckend();
			
			if(starttime==null||starttime.equals("")||endtime==null||endtime.equals(""))
			{
				Log.e("buzz1", "continue");
				continue;
			}
			long start=-1l;
			long end=-2l;
			
		    try{
		    	
		    	
String startstr=	TimeUtils.getActivityDetailTime(starttime);
String endstr=TimeUtils.getActivityDetailTime(endtime);
Log.e("buzz1", "startstr:"+startstr);
Log.e("buzz1", "endstr:"+endstr);
		    	  start=Long.parseLong(starttime);
		    	  end=Long.parseLong(endtime);
		    	 if(start==end)
		    	 {
		    		 dates.add(new Date(start*1000));
		    		 continue;
		    	 }
		    	  dates.add(new Date(start*1000));
		    	  //计算中间隔得天数
		    	 long del=  (end-start)/86400;
		    	 if(del>1)//请三天以上的假期
		    	 {
		    		 for(int j=0;j<del-1;j++)
		    		 {
		    			long next= start+(j+1)*86400;
		    			 dates.add(new Date((next)*1000));
		    		 }
		    	 }
    			 
		    	  dates.add(new Date(end*1000));
		    }catch(Exception e){
		    	Log.e("buzz1", "error");
		    }
		}
		
		if(fluentInitializer!=null)
		{
		 	Log.e("buzz1", "size:"+dates.size());
			fluentInitializer.withSelectedDates(dates);
		}
		
	
		
	}
	
	/**计算请假天数*/
	public void setLeaveDays(List<BabyCheckTimeModel> models)
	{
		long days=0;
		if(models!=null)
		{
			for(int i=0;i<models.size();i++)
			{
				BabyCheckTimeModel babycheckmodel=models.get(i);
				long start=0l;
				long end=0l;
				
				try{
					start=Long.parseLong(babycheckmodel.getCheckstart());
					end=Long.parseLong(babycheckmodel.getCheckend());
				}catch(Exception e)
				{
					 start=0l;
					 end=0l;
				}
				
				long del=(end-start);
				if(del==0)
				{
					days+=1;
				}else
				{
					days+=(((del)/86400)+1);
				}
				
			}
			this.month_TextView.setText((this.getMonthInfo().getMonth()+1)+"月请假天数:");
			this.days_TextView.setText(days+"天");
			Log.e("buzz1", "days:"+days);
		}
	}
	
	
	/**改变viewpager的状态*/
	public void changeViewpagerStatus(int position)
	{
		//int item=this.canledarView.getFirstVisiblePosition();
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
		}else if(position==OnClickOtherDateListener.NEXT_MONTH)//下月
		{
			if(currentIndex<(totalcount-1))//item currentIndex
			{
				currentIndex++;
				this.canledarView.setSelection(currentIndex);//item+1 currentIndex
				changeTime(currentIndex);//item+1 currentIndex
			}
		}
	}
	
	/**修改时间*/
	@SuppressLint("NewApi")
	public void changeTime(int p)
	{
		int size=canledarView.getMonths().size();
		if(p<=0)
		{p=0;}else if(p>=size)
		{
			p=size-1;
		}
		MonthDescriptor month=canledarView.getMonths().get(p);
		this.calTitleView.title.setText(month.getLabel());
	}
	
	
	/**获取当前月份信息*/
	public MonthDescriptor getMonthInfo()
	{
		int item=currentIndex;//this.canledarView.getFirstVisiblePosition();
		int size=canledarView.getMonths().size();
		if(item<(size-1))
		{
	     MonthDescriptor desc=this.canledarView.getMonths().get(item);
			return desc;	
		}
		 return null;
	}
}
