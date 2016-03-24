package com.kinder.check;

import java.util.Date;

import android.os.Bundle;
import android.view.View;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.util.TimeUtils;

import com.kinder.app.tools.KinderEventMessage;
import com.kinder.check.customviews.Check_LeaveMainViewXmlView;
import com.kinder.check.model.CheckBaby_DataSource;
import com.squareup.interfaces.OnClickOtherDateListener;
import com.squareup.timessquare.CalendarPickerView.OnDateSelectedListener;

public class LeaveActivity_VC extends LeaveActivity_BC implements OnDateSelectedListener

{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		babys=(CheckBaby_DataSource)getIntent().getSerializableExtra("babys");
		mainView=new Check_LeaveMainViewXmlView(this,app.pro,app.screenW,app.screenH,babys);
	    mainView.setListener(this,this);
		setContentView(mainView);
	    interface_getDieases_byNetWork();
	    
//	    interface_submitLeave_byNetWork("1", "0",
//	    		"1", "一中心", "备注", 
//	    		"10007", (System.currentTimeMillis()/1000)+"", (System.currentTimeMillis()/1000)+"");
	}
	
	@Override
	public void onMessage(Object arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageBackgroundThread(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageMainThread(Object object) {
		// TODO Auto-generated method stub
		//KinderEventMessage.
		if(object!=null&&object instanceof KinderEventMessage)
		{
			KinderEventMessage msg=(KinderEventMessage)object;
			switch(msg.getCode())
			{
			case KinderEventMessage.MSG_DIEASE_START:
				start_getDieaseData(msg.getObj());
				break;
			case KinderEventMessage.MSG_DIEASE_SUCCESS:
				succ_getDieaseData(msg.getObj());
				break;
			case KinderEventMessage.MSG_DIEASE_FAIL:
				fail_getDieaseData(msg.getObj());
				break;
			case KinderEventMessage.MSG_SUBMITLEAVE_START://提交请假
				start_submitLeaveData(msg.getObj());
				break;
			case KinderEventMessage.MSG_SUBMITLEAVE_SUCCESS:
				succ_submitLeaveData(msg.getObj());
				break;
			case KinderEventMessage.MSG_SUBMITLEAVE_FAIL:
				fail_submitLeaveData(msg.getObj());
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		if(id==mainView.titleBarView.leftBtn.getId())
		{
			this.finish();
		}else if(id==mainView.save_Button.getId())
		{
			logic_clickSaveBtn();
		}else if(id==mainView.calTitleView.beforeyear_Buttton.getId())//上个月
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
	//String str=TimeUtils.getActivityDetailTime(String.valueOf(date.getTime()/1000));
	  checkend=TimeUtils.getStartTime(date.getTime())/1000;
	  
	}

	@Override
	public void onDateUnselected(Date date) {
		// TODO Auto-generated method stub
		
	}

}
