package com.kinder.check;

import java.util.Date;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.util.TimeUtils;

import com.kinder.app.tools.KinderEventMessage;
import com.kinder.check.customviews.CheckMainViewXmlView;
import com.squareup.timessquare.CalendarPickerView.OnDateSelectedListener;
import com.tour.app.canlendar.CalendarDialog_VC;

public class CheckFragment_VC extends CheckFragment_BC implements OnItemClickListener
,OnDateSelectedListener
{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		logic_onCreate();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mainView=new CheckMainViewXmlView(getActivity(),app.pro,app.screenW,
				app.screenH,getFragmentManager());
		mainView.setListener(this,this);
		mainView.initDataBefore();
		return mainView;
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
	}
	@Override
	public void onHiddenChanged(boolean hidden) {
		// TODO Auto-generated method stub
		super.onHiddenChanged(hidden);
		if(!hidden)//显示
		{
			logic_onCreate();
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
			case KinderEventMessage.MSG_CHECKTEACHER_START:
				start_getTeacherData(msg.getObj());
				break;
			case KinderEventMessage.MSG_CHECKTEACHER_SUCCESS:
				succ_getTeacherData(msg.getObj());
				break;
			case KinderEventMessage.MSG_CHECKTEACHER_FAIL:
				fail_getTeacherData(msg.getObj());
				break;
			case KinderEventMessage.MSG_USERBABAYS_START:
				start_getUserBabysData(msg.getObj());
				break;
			case KinderEventMessage.MSG_USERBABYS_SUCCESS:
				succ_getUserBabysData(msg.getObj());
				break;
			case KinderEventMessage.MSG_USERBABYS_FAIL:
				fail_getUserBabysData(msg.getObj());
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		int id=v.getId();
		
		if(id==mainView.checkTeacherView.date_RelativeLayout.getId())
		{
			dialog=new CalendarDialog_VC(getActivity(), app.pro, app.screenW, app.screenH,this);
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
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		logic_clickGridItem(position);
	}

	@Override
	public void onDateSelected(Date date) {
		// TODO Auto-generated method stub
		mainView.checkTeacherView.date_TextView.setText(TimeUtils.getTeacherCheckTime(date));
		getDateByInterface(date);
		dialog.dismiss();
	}

	@Override
	public void onDateUnselected(Date date) {
		// TODO Auto-generated method stub
		dialog.dismiss();
	}

	
}
