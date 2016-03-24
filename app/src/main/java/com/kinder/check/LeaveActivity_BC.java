package com.kinder.check;

import java.util.Date;
import java.util.List;

import android.util.Log;
import android.widget.Toast;

import cn.kinder.bean.UserModel;
import cn.kinder.util.TimeUtils;

import com.kinder.app.tools.KinderNetWork;
import com.kinder.check.customviews.Check_LeaveMainViewXmlView;
import com.kinder.check.model.CheckBaby_DataSource;
import com.kinder.check.model.CheckTeacher_DataSource;
import com.kinder.check.model.DieaseDataSource;
import com.myt360.kindergarten.Kind_BaseActivity;


public abstract class LeaveActivity_BC extends Kind_BaseActivity {

	protected CheckBaby_DataSource babys;
	protected Check_LeaveMainViewXmlView mainView;
	protected DieaseDataSource dataSource;
	
	//请假的开始与结束时间
	protected long checkstart;
	protected long checkend;
	/**获取疾病接口*/
	protected void interface_getDieases_byNetWork()
	{
		KinderNetWork.interface_getDieases_byNetWork(this, getEventMessage());
	}
	/**提交请假接口*/
	protected void interface_submitLeave_byNetWork(String babyid,String checktype,String diseaseid,
			String checkhospital,String checkremark,String parentid,String checkstart,String checkend)
	{
		KinderNetWork.interface_submitLeave_byNetWork(this, getEventMessage(), babyid,
				checktype, diseaseid, checkhospital,
				checkremark, parentid, checkstart, checkend)
				;
	}
	/**开始获取数据*/
	protected void start_getDieaseData(Object obj)
	{
		//startLoading();
	}
	/**成功获取数据*/
	protected void succ_getDieaseData(Object obj)
	{
		
		if(obj!=null&&obj instanceof DieaseDataSource)
		{
			DieaseDataSource source=(DieaseDataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				this.dataSource=source;
				initMainViewData(dataSource);
			}else 
			{
				Toast.makeText(this, source.getErrorMsg(), 0).show();
			}
		}
		stopLoading();
	}
	

	/**失败获取数据*/
	protected void fail_getDieaseData(Object obj)
	{
		stopLoading();
	}
	
	/**初始化疾病数据*/
	private void initMainViewData(DieaseDataSource dataSource) 
	{
		// TODO Auto-generated method stub
		mainView.initMainViewData(dataSource);
	}
	
	
	
	
	/**开始获取数据*/
	protected void start_submitLeaveData(Object obj)
	{
		startLoading();
	}
	/**成功获取数据*/
	protected void succ_submitLeaveData(Object obj)
	{
		stopLoading();
		if(obj!=null&&obj instanceof DieaseDataSource)
		{
			DieaseDataSource source=(DieaseDataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				Toast.makeText(this, "请假提交成功", 0).show();
				this.finish();
			}else 
			{
				Toast.makeText(this, source.getErrorMsg(), 0).show();
			}
		}
	}
	/**失败获取数据*/
	protected void fail_submitLeaveData(Object obj)
	{
		stopLoading();
	}
	
	/**点击确定按钮*/
	protected void logic_clickSaveBtn() {
		// TODO Auto-generated method stub
		
		List<Date> dates=mainView.getLeaveTimes();
		
		if(dates!=null&&dates.size()>0)
		{
			int count=dates.size();
			//step1:获取时间
			long clickstart=dates.get(0).getTime();
			//Log.e("buzz1", "clickstart:"+clickstart);
			
			checkstart=TimeUtils.getStartTime(clickstart)/1000;
			//Log.e("buzz1", "checkstart_time:"+TimeUtils.getTopicDetailTime(String.valueOf(checkstart)));
			
			checkend=TimeUtils.getStartTime(dates.get((count-1)).getTime())/1000;
			long currenttime=System.currentTimeMillis();
			long current=TimeUtils.getStartTime(currenttime)/1000;
			//Log.e("buzz1", "current:"+current);
			
			//Log.e("buzz1", "current_time:"+TimeUtils.getTopicDetailTime(String.valueOf(currenttime/1000)));
			
			
			
			if(current>checkstart)
			{
				Toast.makeText(this, "过去时间不能请假，如需补假请联系老师", 0).show();
				return;
			}
			
		}else
		{
			return;
		}
		if(checkend==0)
		{
			Toast.makeText(this, "请选择结束时间", 0).show();
			return ;
		}
		//获取babyid
		String babyid=mainView.getBabyID();
		if(babyid==null||babyid.equals(""))
		{
			Toast.makeText(this, "包包id获取失败", 0).show();
			return ;
		}
		//获取请假类型
		String checktype=mainView.getTypeID();
		if(checktype==null||checktype.equals(""))
		{
			Toast.makeText(this, "请假类型获取失败", 0).show();
			return ;
		}
		String dieaseid=null;
		String hosptalname=null;
		if(checktype.equals("0"))
		{
			dieaseid=mainView.getDieaseID();
			hosptalname=mainView.getHospitalName();
		}
		
		//备注
		String remark=mainView.remark_EditText.getText().toString();
		//家长id
		String userid=getUserInfo().getUserid();
		
		
		interface_submitLeave_byNetWork(babyid, checktype,
				dieaseid, hosptalname, remark, 
				userid, String.valueOf(checkstart), String.valueOf(checkend));
	}

}
