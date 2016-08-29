package com.kinder.check;

import android.util.Log;
import android.widget.Toast;

import com.kinder.app.tools.KinderNetWork;
import com.kinder.check.customviews.CheckMainViewXmlView;
import com.kinder.check.model.CheckBaby_DataSource;
import com.kinder.check.model.CheckTeacher_DataSource;
import com.kinder.check.model.TeacherWrapModel;
import com.kinder.login.LoginActivity_VC;
import com.myt360.app.consts.RuleConst;
import com.myt360.kindergarten.Kinder_BaseFragment;
import com.tour.app.canlendar.CalendarDialog_VC;

import java.util.Date;
import java.util.List;

import cn.kinder.bean.BabyCheckModel;
import cn.kinder.bean.BabyModel;
import cn.kinder.bean.UserModel;
import cn.kinder.util.TimeUtils;

public  abstract class CheckFragment_BC extends Kinder_BaseFragment {

	protected CheckMainViewXmlView mainView;
	
	/**老师考勤*/
	protected CheckTeacher_DataSource dataSource;
	protected CheckBaby_DataSource babys_DataSource;
	protected CalendarDialog_VC dialog;
	
	/**所有宝宝信息*/
    public CheckBaby_DataSource getBabys_DataSource() {
		return babys_DataSource;
	}
	/**老师考勤，请求数据*/
	protected void get_CheckTeacher_ByNetWork(String time)
	{
		UserModel user=getUserInfo();
		if(user!=null)
		{
			String classid=user.getClassid();
			if(classid!=null&&!classid.equals(""))
			{
				KinderNetWork.getTeacherCheck_byNetWork(getActivity(), getEventMessage(), time, classid);
			}
		}
		
	}
	/**家长下所有宝宝接口数据*/
	protected void get_UserBabys_ByNetWork()
	{
		KinderNetWork.getUserBabys_byNetWork(getActivity(), getEventMessage());
	}
	/**oncreate方法逻辑*/
	protected void logic_onCreate() {
		// TODO Auto-generated method stub
		UserModel userModel=getUserInfo();
		if(userModel!=null)
		{
			String usertype=userModel.getUsertype();
			if(usertype!=null&&!usertype.equals(""))
			{
				if(usertype.equals(RuleConst.USER))
				{
					get_UserBabys_ByNetWork();
				}else
				{
					getDateByInterface(new Date());
				}
			}
		}else
		{
			skip2Activity(LoginActivity_VC.class);
			getActivity().finish();
		}
	}
	
	protected void getDateByInterface(Date date) {
		// TODO Auto-generated method stub
		long time=TimeUtils.getStartTime(date.getTime())/1000;
		get_CheckTeacher_ByNetWork(String.valueOf(time));
	}
	/**开始获取数据*/
	protected void start_getTeacherData(Object obj)
	{
		startLoading();
	}
	/**成功获取数据*/
	protected void succ_getTeacherData(Object obj)
	{
		stopLoading();
		if(obj!=null&&obj instanceof CheckTeacher_DataSource)
		{
			CheckTeacher_DataSource source=(CheckTeacher_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				this.dataSource=source;
				initMainViewData(dataSource);
			}else 
			{
				Toast.makeText(getActivity(), source.getErrorMsg(), Toast.LENGTH_SHORT).show();
			}
		}
	}
	/**失败获取数据*/
	protected void fail_getTeacherData(Object obj)
	{
		stopLoading();
	}
	
	
	
	
	protected void start_getUserBabysData(Object obj)
	{
		startLoading();
	}
	/**成功获取数据*/
	protected void succ_getUserBabysData(Object obj)
	{
		stopLoading();
		if(obj!=null&&obj instanceof CheckBaby_DataSource)
		{
			CheckBaby_DataSource source=(CheckBaby_DataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				this.babys_DataSource=source;
				initBabysMainViewData(babys_DataSource);
			}else 
			{
				Toast.makeText(getActivity(), source.getErrorMsg(), Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	/**失败获取数据*/
	protected void fail_getUserBabysData(Object obj)
	{
		stopLoading();
	}
	/**数据初始化*/
	protected  void initMainViewData(CheckTeacher_DataSource source)
	{
		source.copyData2TeacherWrapModel();
		mainView.initTeacherViewData(source.getTeacherWrapModels());
	}
	/**家长下所有baby*/
	protected void initBabysMainViewData(CheckBaby_DataSource babys_DataSource) {
		// TODO Auto-generated method stub
		mainView.initViewData(babys_DataSource);
		setTagesToUM();
	}
	
	/**点击老师考勤相应的item*/

	protected void logic_clickGridItem(int position) {
		// TODO Auto-generated method stub
		TeacherWrapModel model=this.dataSource.getTeacherWrapModels().get(position);
		 if(model!=null)
		 {
			 int type=model.getType();
			 if(type==TeacherWrapModel.CHECKMODEL)//事假
			 {
			   	 mainView.checkTeacherView.showLeaveView(model.getCheckModel());
			 }else if(type==TeacherWrapModel.SAFTYMODEL)//安全码
			 {
				 mainView.checkTeacherView.showSaftyView(model.getSaftyModel());
			 }
		 }
	}
	
  public void setTagesToUM()
  {
	//设置友盟推送的标签
			List<BabyCheckModel> babyModels=babys_DataSource.getBabyCheckModel();
			for(final BabyCheckModel model:babyModels)
			{
				BabyModel babyModel=model.getBabyModel();
				if(babyModel==null)
				{
					continue;
				}
				final int classid= babyModel.getClassid();
//				if(classModel==null)
//				{
//					continue;
//				}
				 final int kinderid=babyModel.getKinderid();
				 Log.e("buzz1", "标签:class_"+classid+"school_"+String.valueOf(kinderid));
					   new Thread(
							   new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									try {
										app.getmPushAgent().getTagManager().
										add("class_" + classid, "school_" + String.valueOf(kinderid));



									} catch (Exception e) {
										// TODO Auto-generated catch block
										//e.printStackTrace();
									}
								}
							}).start();
					 
				
			}
  }
}
