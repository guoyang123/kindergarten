package com.kinder.check;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kinder.app.tools.KinderEventMessage;
import com.kinder.check.customviews.CheckUserFragmentXmlView;
import com.squareup.interfaces.OnClickOtherDateListener;
import com.squareup.timessquare.CalendarPickerView.OnDateSelectedListener;
import com.squareup.timessquare.MonthDescriptor;
import com.tour.app.safecode.SafeCodeDialogListener;
import com.tour.app.safecode.SafeCodeDialog_VC;

import java.util.Date;

import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.BabyCheckModel;
import cn.kinder.bean.BabyModel;
import cn.kinder.util.MethodUtils;
import cn.kinder.util.TimeUtils;

@SuppressLint("ValidFragment")
public class CheckUserFragment_VC extends CheckUserFragment_BC 
implements OnDateSelectedListener,SafeCodeDialogListener,OnClickOtherDateListener,
OnPageChangeListener
{

	
	public CheckUserFragment_VC(BabyCheckModel obj) {
		super();
		// TODO Auto-generated constructor stub
		this.dataSource=obj;
	}
	
	public CheckUserFragment_VC() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mainView=new CheckUserFragmentXmlView(getActivity(),app.pro,app.screenW,app.screenH,this);
		mainView.setListener(this,this,this);
		mainView.initViewData(dataSource);
		return mainView;
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(this.dataSource!=null&&this.dataSource.getBabyModel()!=null)
		{
			interface_getBabyMonth_ByNetWork
			(String.valueOf(this.dataSource.getBabyModel().getBabyid()),TimeUtils.getCheckTime(mainView.getMonthInfo().getDate()));//;
			
		}
		
	}
	@Override
	public void transferMsg(Object... arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessage(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessageBackgroundThread(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessageMainThread(Object object) {
		// TODO Auto-generated method stub
		if(object!=null&&object instanceof KinderEventMessage)
		{
			KinderEventMessage msg=(KinderEventMessage)object;
			switch(msg.getCode())
			{
			case KinderEventMessage.MSG_CHECKBABY_START:
				start_getUserBabyMonthData(msg.getObj());
				break;
			case KinderEventMessage.MSG_CHECKBABY_SUCCESS:
				succ_getUserBabyMonthData(msg.getObj());
				break;
			case KinderEventMessage.MSG_CHECKBABY_FAIL:
				fail_getUserBabyMonthData(msg.getObj());
				break;
			case KinderEventMessage.MSG_SENDCODE_START:
				start_sendCode(msg.getObj());
				break;
			case KinderEventMessage.MSG_SENDCODE_SUCCESS:
				succ_sendCode(msg.getObj());
				break;
			case KinderEventMessage.MSG_SENDCODE_FAIL:
				fail_sendCode(msg.getObj());
				break;
				
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
 
		int id=v.getId();
		if(id==mainView.send_Button.getId())
		{
			new SafeCodeDialog_VC(getActivity(), app.pro, app.screenW, app.screenH,
					MethodUtils.getSafeCode()).setSafeCodeDialogListener(this);
		}else if(id==mainView.calTitleView.beforeyear_Buttton.getId())//上个月
		{
			mainView.changeViewpagerStatus(OnClickOtherDateListener.BEFORE_MONTH);
			MonthDescriptor month=mainView.getMonthInfo();
			if(month!=null)
			{
//				interface_getBabyMonth_ByNetWork
//				(String.valueOf(this.dataSource.getBabyModel().getBabyid()),TimeUtils.getCheckTime(month.getDate()));
				getMonthData(TimeUtils.getCheckTime(month.getDate()));
			}
			
		}else if(id==mainView.calTitleView.beforemonth_Buttton.getId())//上年
		{
			
		}else if(id==mainView.calTitleView.nextmonth_Buttton.getId())//下年
		{
			
		}else if(id==mainView.calTitleView.nextyear_Buttton.getId())//下月
		{
			mainView.changeViewpagerStatus(OnClickOtherDateListener.NEXT_MONTH);
			MonthDescriptor month=mainView.getMonthInfo();
			if(month!=null)
			{
//				interface_getBabyMonth_ByNetWork
//				(String.valueOf(this.dataSource.getBabyModel().getBabyid()),TimeUtils.getCheckTime(month.getDate()));
				getMonthData(TimeUtils.getCheckTime(month.getDate()));
			}
			
		}
	}

	@Override
	protected void onWindowFocusChanged() {
		// TODO Auto-generated method stub

	}

	@Override
	public EventMessage initLocalEventMessage() {
		// TODO Auto-generated method stub
		return getEventMessage();
	}

	@Override
	public EventMessage initPlugEventMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDateSelected(Date date) {
		// TODO Auto-generated method stub
		//Toast.makeText(getActivity(), "onDateSelected"+date.getDay(), 0).show();
	}

	@Override
	public void onDateUnselected(Date date) {
		// TODO Auto-generated method stub
		//Toast.makeText(getActivity(), "onDateUnselected"+date.getDay(), 0).show();
	}

	@Override
	public void onClickBtn(int position, String[] codes) {
		// TODO Auto-generated method stub
		if(this.dataSource!=null&&this.dataSource.getBabyModel()!=null)
		{
			BabyModel model= dataSource.getBabyModel();
			if(codes!=null)
			{
				interface_sendCode_ByNetWork(String.valueOf(model.getBabyid()), codes[0], codes[1]);
			}
			
		}
		
	}

	@Override
	public void onClickOtherDate(int position) 
	{
		// TODO Auto-generated method stub
		mainView.changeViewpagerStatus(position);
	}

	

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int position) 
	{
		// TODO Auto-generated method stub
//		Date date=this.mainView.canledarView.months.get(position).getDate();
//		String label=TimeUtils.getCheckTime(date);
//		interface_getBabyMonth_ByNetWork(String.valueOf(this.dataSource.getBabyModel().getBabyid()),label);
	}

}
