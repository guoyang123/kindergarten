package com.kinder.check.customviews;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import cn.kinder.bean.BabyCheckModel;
import cn.kinder.bean.BabyModel;
import cn.kinder.bean.DiseaseModel;

import com.kinder.check.model.CheckBaby_DataSource;
import com.kinder.check.model.DieaseDataSource;
import com.kinder.check.viewsxml.Check_LeaveMainViewXml;
import com.squareup.interfaces.OnClickOtherDateListener;
import com.squareup.timessquare.MonthDescriptor;
import com.squareup.timessquare.CalendarPickerView.FluentInitializer;
import com.squareup.timessquare.CalendarPickerView.MonthCellWithMonthIndex;
import com.squareup.timessquare.CalendarPickerView.OnDateSelectedListener;
import com.squareup.timessquare.CalendarPickerView.SelectionMode;

public class Check_LeaveMainViewXmlView extends Check_LeaveMainViewXml {

	private Context context;
	//疾病
	private List<DiseaseModel> dieaseModels;
	private int diease_position;
	
	//宝宝姓名
	private List<BabyModel> babyModels;
	private int baby_position;
	
	//请假类型
	private int type_position;
	
	
    private FluentInitializer fluentInitializer;
	
	public Check_LeaveMainViewXmlView(Context context, float pro,
			float screenW, float screenH,CheckBaby_DataSource babys) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		String[] list = {"病假","事假","休学"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_dropdown_item_1line, list);
        
        this.leave_type.setAdapter(adapter);
        leave_type.setText(list[0]);
        this.diseasename.setAdapter(adapter);
       
        this.babyname_BetterSpinner.setAdapter(adapter);
        babyname_BetterSpinner.setOnItemClickListener(new OnItemClickListener() 
        {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				baby_position=position;
			}
		});
        diseasename.setOnItemClickListener(new OnItemClickListener() 
        {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				diease_position=position;
			}
		});
        leave_type.setOnItemClickListener(new OnItemClickListener() 
        {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				type_position=position;
				logic_clickLeaveItem(position);
			}
		});
       
        if(babys!=null)
        {
         List<BabyCheckModel> babycheckmodels= 	babys.getBabyCheckModel();
         if(babycheckmodels!=null&&babycheckmodels.size()>0)
         {
        	 int size=babycheckmodels.size();
        	 String[] babynames=new String[size];
        	 babyModels=new ArrayList<BabyModel>();
        	   for(int i=0;i<size;i++)
        	   {
        		  BabyModel model= babycheckmodels.get(i).getBabyModel();
        		   babyModels.add(model);
        		   babynames[i]= model.getBabyname();
        	   }
        	   ArrayAdapter<String> babysadapter = new ArrayAdapter<String>(context,
                       android.R.layout.simple_dropdown_item_1line, babynames);
        	   this.babyname_BetterSpinner.setAdapter(babysadapter);
        	   babyname_BetterSpinner.setText(babynames[0]);
         }
        }
        
        
        final Calendar nextYear = Calendar.getInstance();
	    nextYear.add(Calendar.YEAR, 1);

	    final Calendar lastYear = Calendar.getInstance();
	    lastYear.add(Calendar.YEAR, -1);

	    Date date=new Date();
	    MonthCellWithMonthIndex monthindex= canledarView.getMonthCellWithIndexByDate(date);
		  
	     fluentInitializer=  canledarView.init(lastYear.getTime(), nextYear.getTime()) //
	    .inMode(SelectionMode.RANGE)    
	    .withSelectedDate(date);
	    if(monthindex!=null)
	   {
		   int index= monthindex.monthIndex;
		 //  
		   changeTime(index);
	   }
	    
        
	}

	public void setListener(OnClickListener onClickListener,OnDateSelectedListener onDateSelectedListener)
	{
		this.titleBarView.setListener(onClickListener);
		this.save_Button.setOnClickListener(onClickListener);
		this.calTitleView.setListener(onClickListener);
//		this.canledarView.setOnDateSelectedListener(onDateSelectedListener);
		
	}
	
	protected void logic_clickLeaveItem(int position) {
		// TODO Auto-generated method stub
		if(position!=0)//事假
		{
			diseasename.setVisibility(View.GONE);
			this.holidayname_EditText.setVisibility(View.GONE);
		}else
		{
			diseasename.setVisibility(View.VISIBLE);
			this.holidayname_EditText.setVisibility(View.VISIBLE);
		}
	}


	/**数据初始化*/
	public void initMainViewData(DieaseDataSource dataSource) {
		// TODO Auto-generated method stub
		dieaseModels=dataSource.getDiseaseModel();
		if(dieaseModels!=null&&dieaseModels.size()>0)
		{
			int size=dieaseModels.size();
			String[] datas=new String[size];
			for( int i=0;i<size;i++)
			{
				datas[i]=dieaseModels.get(i).getDiseaserem();
			}
			  ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
		                android.R.layout.simple_dropdown_item_1line, datas);
			  this.diseasename.setAdapter(adapter);
			  adapter.notifyDataSetChanged();
			  diseasename.setText(datas[0]);
		}
	    
	
	}
	

	/**获取宝宝姓名所对应的babyid*/
	public String getBabyID()
	{
	 if(babyModels!=null&&babyModels.size()>0)
	 {
		BabyModel model= babyModels.get(baby_position);
		return String.valueOf(model.getBabyid());
	 }
	 return null;
	}
	
	/**获取疾病对应的id*/
	public String getDieaseID()
	{
		if(this.dieaseModels!=null&&this.dieaseModels.size()>0)
		{
			DiseaseModel model=this.dieaseModels.get(diease_position);
			return model.getDiseaseid();
		}
		return null;
	}
	/**获取请假类型*/
	public String getTypeID()
	{
		return String.valueOf(type_position);
	}
	
	/**获取医院名称*/
	public String getHospitalName()
	{
		return this.holidayname_EditText.getText().toString();
	}
	
	/**改变viewpager的状态*/
	public void changeViewpagerStatus(int position)
	{
		int item=this.canledarView.getFirstVisiblePosition();
		int totalcount=this.canledarView.getAdapter().getCount();
		if(position==OnClickOtherDateListener.BEFORE_MONTH)//上月
		{
			this.canledarView.setSelection(item-1);
			changeTime(item-1);
		}else if(position==OnClickOtherDateListener.NEXT_MONTH)//下月
		{
			if(item<totalcount)
			{
				this.canledarView.setSelection(item+1);
				changeTime(item+1);
			}
		}
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
	
	
	/**获取选择的请假时间*/
	public List<Date> getLeaveTimes()
	{
		List<Date> dates=this.canledarView.getSelectedDates();
		return dates;
	}
}
