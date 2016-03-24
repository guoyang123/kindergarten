package com.kinder.check;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;
import android.widget.Toast;

import cn.kinder.bean.BabyCheckModel;
import cn.kinder.bean.BabyCheckTimeModel;
import cn.kinder.util.TimeUtils;

import com.kinder.app.tools.KinderNetWork;
import com.kinder.check.customviews.CheckUserFragmentXmlView;
import com.kinder.check.model.CheckBabyMonth_DataSource;
import com.kinder.check.model.CheckBaby_DataSource;
import com.kinder.check.model.CheckTeacher_DataSource;
import com.myt360.kindergarten.Kinder_BaseFragment;
import com.squareup.interfaces.OnClickOtherDateListener;

public abstract class CheckUserFragment_BC extends Kinder_BaseFragment {

	protected CheckUserFragmentXmlView mainView;

	/**家长考勤*/
	protected BabyCheckModel dataSource;
	
	protected CheckBabyMonth_DataSource babymonth_DataSource;
	
	public Map<String,List<BabyCheckTimeModel>> months=new HashMap<String,List<BabyCheckTimeModel>>();
	/**宝宝某月考勤接口*/
	protected void interface_getBabyMonth_ByNetWork(String babyid,String time)
	{
		KinderNetWork.getCheckBaby_byNetWork(getActivity(), getEventMessage(), babyid, time);
	}
	
	/**发送安全码接口*/
	protected void interface_sendCode_ByNetWork(String babyid,String saftycode,String tel)
	{
		KinderNetWork.interface_sendSafeCode_byNetWork(getActivity(), getEventMessage(), babyid, saftycode, tel);
	}
	
	protected void start_getUserBabyMonthData(Object obj)
	{
		startLoading();
	}
	/**成功获取数据*/
	protected void succ_getUserBabyMonthData(Object obj)
	{
		stopLoading();
		if(obj!=null&&obj instanceof CheckBabyMonth_DataSource)
		{
			CheckBabyMonth_DataSource source=(CheckBabyMonth_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				this.babymonth_DataSource=source;
				cacheMonthData(source);
				mainView.refreshCalendarData(source.getBabyCheckTimeModel());
			}else 
			{
				Toast.makeText(getActivity(), source.getErrorMsg(), Toast.LENGTH_SHORT).show();
			}
		}
	}
	/**失败获取数据*/
	protected void fail_getUserBabyMonthData(Object obj)
	{
		stopLoading();
	}
	
	
	protected void start_sendCode(Object obj)
	{
		startLoading();
	}
	/**成功获取数据*/
	protected void succ_sendCode(Object obj)
	{
		stopLoading();
		if(obj!=null&&obj instanceof CheckBabyMonth_DataSource)
		{
			CheckBabyMonth_DataSource source=(CheckBabyMonth_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				Toast.makeText(getActivity(), "发送成功", 0).show();
			}else 
			{
				Toast.makeText(getActivity(), source.getErrorMsg(), 0).show();
			}
		}
	}
	/**失败获取数据*/
	protected void fail_sendCode(Object obj)
	{
		stopLoading();
	}
	
	
	/**缓存数据*/
	protected void cacheMonthData(CheckBabyMonth_DataSource source)
	{
		String time=source.getTime();
		months.put(time, source.getBabyCheckTimeModel());
	}
	
	/**获取考勤数据*/
	protected void getMonthData(String time)
	{
		List<BabyCheckTimeModel> checks=months.get(time);
		boolean iscontainkey=months.containsKey(time);
//		if(!iscontainkey)//接口
//		{
			interface_getBabyMonth_ByNetWork
			(String.valueOf(this.dataSource.getBabyModel().getBabyid()),time);
//		}else
//		{
//			Log.e("buzz1", "缓存的时间time:"+time+"_"+checks);
//			mainView.refreshCalendarData(checks);
//		}
	}
}
