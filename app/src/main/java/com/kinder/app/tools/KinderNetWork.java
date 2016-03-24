package com.kinder.app.tools;

import android.content.Context;
import android.util.Log;

import com.kinder.chat.model.ContactUser_DataSource;
import com.kinder.check.model.CheckBabyMonth_DataSource;
import com.kinder.check.model.CheckBaby_DataSource;
import com.kinder.check.model.CheckTeacher_DataSource;
import com.kinder.check.model.DieaseDataSource;
import com.kinder.feedback.model.FeedBack_DataSource;
import com.kinder.forgetpsw.model.VerfityDataSource;
import com.kinder.login.model.Login_DataSource;
import com.kinder.notice.model.Notice_DataSource;
import com.kinder.noticedetail.model.NoticeDetail_DataSource;
import com.kinder.parent.model.ArticleDetail_DataSource;
import com.kinder.parent.model.Article_DataSource;
import com.kinder.parent.model.Collect_DataSource;
import com.kinder.parent.model.PraiseShare_DataSource;
import com.kinder.perfect.model.PerfectDataSource;
import com.kinder.perfect.model.UploadDataSource;

import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import java.io.File;

import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.ContactListDataSource;
import cn.kinder.bean.Kinder_DataSource;
import cn.kinder.bean.LogininfoModel;
import cn.kinder.bean.UserModel;
import cn.kinder.bean.UserPicModel;
import cn.kinder.user.DbOperationModel;


public class KinderNetWork 
{

	
	public static void cj_login(Context context,AjaxParams  params)
	{
		/***
		 * 
		 * 持久登陆信息
		 * 
		 * */
		LogininfoModel model=LogininfoModel.readFromFile(context);
		//model.setDevice(model.getDevice().replaceAll(":", ","));
		UserModel userinfo=DbOperationModel.getUserInfo(context);
		if(userinfo!=null){
			params.put("logininfo_userid", userinfo.getUserid());//
		}
		if(model!=null){
			params.put("logininfo_time", model.getTime());
			params.put("logininfo_sign", LogininfoModel.getYueHuToken(model,userinfo!=null?userinfo.getUserid():null));//String.valueOf(System.currentTimeMillis()/1000)
		}
		String device=  new DevicePlug_Util(context).getDeviceIMEI();
		device=device.replaceAll(":", ",");
		params.put("logininfo_device",device);
	
	}
	/**
	 * 
	 * 登陆接口
	 * 
	 * */
	public static void get_Login_ByNetWork(final Context context,final EventMessage eventMessage,
			String usertel,String password) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		params.put("usertel", usertel);
		params.put("password", password);
		cj_login(context,params);
Log.e("buzz1", "usertel:"+usertel);	
Log.e("buzz1", "password:"+password);
		fh.post(KinderUrlConst.LOGIN, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "login:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_LOGIN_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "login:"+t);	
	Login_DataSource model = KinderJsonParser
						.parserLoginData(context,t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_LOGIN_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
				Log.e("buzz1", "onFailure"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_LOGIN_FAIL,
						null));
			}
		});

	}

	//
	/**
	 * 
	 * 获取个人信息接口
	 * 
	 * */
	public static void get_UserInfo_ByNetWork(final Context context,final EventMessage eventMessage) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		//params.put("logininfo_userid", "10001");//
		cj_login(context,params);
		fh.post(KinderUrlConst.GET_USERINFO, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "getuserinfo:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_GET_USERIFNO_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "onSuccess:"+t);
          PerfectDataSource model = KinderJsonParser
						.parserUserInfoData(context,t);
          //Log.e("buzz1", "getuserinfo:onSuccess:"+model.getBabyModel().size());
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_GET_USERIFNO_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "getuserinfo:onStart"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_GET_USERIFNO_FAIL,
						null));
			}
		});

	}
	
	/**
	 * 
	 * 通过环信获取他人信息接口
	 * 
	 * */
	public static void get_UserInfo_ByNetWork(final Context context,final EventMessage eventMessage,final String userid) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		
		cj_login(context,params);
		params.put("easemobid", userid);
		Log.e("buzz1", "easemobid:"+userid);
		fh.post(KinderUrlConst.GET_USERINFOBYEASEMOBID, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "getuserinfoBYEASE:onStart userid:"+userid);
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_GET_USERIFNO_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "onSuccessBYEASE:"+t);
          PerfectDataSource model = KinderJsonParser
						.parserUserInfoData(context,t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_GET_USERIFNO_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "getuserinfoBYEASE:onFailure"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_GET_USERIFNO_FAIL,
						null));
			}
		});

	}
	
	//
	/**
	 * 
	 * 完善家长信息接口
	 * 
	 * */
	public static void perfect_UserInfo_ByNetWork(final Context context,final EventMessage eventMessage,
			String username,String usertel,String usersex,String seniority,String babys,String userpic) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		if(username!=null&&!username.equals(""))
		{
			params.put("username", username);
Log.e("buzz1", "username:"+username);
		}
		
		if(usertel!=null&&!usertel.equals(""))
		{
			params.put("usertel", usertel);
			Log.e("buzz1", "usertel:"+usertel);
		}
		if(usersex!=null&&!usersex.equals(""))
		{
			params.put("usersex", usersex);
			Log.e("buzz1", "usersex:"+usersex);
		}
		if(seniority!=null&&!seniority.equals(""))
		{
			params.put("seniority", seniority);
			Log.e("buzz1", "seniority:"+seniority);
		}
//Log.e("buzz1", "seniority:"+seniority);
		if(babys !=null&&!babys .equals(""))
		{
			params.put("babys", babys );
Log.e("buzz1", "babys:"+babys);
		}
		if(userpic!=null&&!userpic.equals(""))
		{
			params.put("userpic", userpic);
			Log.e("buzz1", "userpic:"+userpic);
		}
		fh.post(KinderUrlConst.PERFECT_USERINFO, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "完善信息:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_PERFECT_USERIFNO_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "完善信息:onSuccess:"+t);	
          PerfectDataSource model = KinderJsonParser
						.parserUserInfoData(context,t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_PERFECT_USERIFNO_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "完善信息:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_PERFECT_USERIFNO_FAIL,
						null));
			}
		});

	}

	/**
	 * 
	 * 发送验证码接口
	 * 
	 * */
	public static void get_Vertify_ByNetWork(final Context context,final EventMessage eventMessage,
			String usertel) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		params.put("usertel", usertel);
		fh.post(KinderUrlConst.GET_VERTIFY, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "获取验证码:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_GET_VERFITY_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "获取验证码:onSuccess:"+t);	
VerfityDataSource model = KinderJsonParser
						.parserVerfityData(context,t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_GET_VERFITY_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "获取验证码:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_GET_VERFITY_FAIL,
						null));
			}
		});

	}
	

	/**
	 * 
	 * 图片上传接口
	 * 
	 * */
	public static void submit_updatepic_byNetWork(final Context context,final EventMessage eventMessage,
			String filename,final UserPicModel userPicModel) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		try{
			params.put("filename", new File(filename));
		}catch(Exception e){
			Log.e("buzz1", "upload fail");
			return
				;}
		fh.post(KinderUrlConst.UPLOADPIC, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "图片上传:onStart");
				super.onStart();
//				userPicModel.setStatus(UserPicModel.UPLOADING);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_UPLOADPIC_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "图片上传:onSuccess:"+t);	
		        UploadDataSource model = KinderJsonParser
								.parserUploadpicData(context,t);
				if(model!=null)
				{
					model.setUserPicModel(userPicModel);
				}
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_UPLOADPIC_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "图片上传:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_UPLOADPIC_FAIL,
						null));
			}
		});

	}
	
	/**
	 * 
	 * 设置密码接口
	 * 
	 * */
	public static void setpsw_byNetWork(final Context context,final EventMessage eventMessage,
			String usertel,String password,String smscode) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		params.put("usertel", usertel);
		params.put("password", password);
		params.put("smscode", smscode);
		Log.e("buzz1", "修改密码usertel:"+usertel);
		Log.e("buzz1", "修改密码password:"+password);
		Log.e("buzz1", "修改密码smscode:"+smscode);
		
		
		fh.post(KinderUrlConst.UPDATE_PSW, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "修改密码:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_SETPSW_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "修改密码:onSuccess:"+t);	
Kinder_DataSource model = KinderJsonParser
						.parserSetPswData(context,t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_SETPSW_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "修改密码:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_SETPSW_FAIL,
						null));
			}
		});
	}
	
	/**获取老师考勤*/
	public static void getTeacherCheck_byNetWork(final Context context,final EventMessage eventMessage,
			String time,String classid) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		params.put("time", time);
		params.put("classid", classid);
		Log.e("buzz1", "time:"+time);
		Log.e("buzz1", "classid:"+classid);
		fh.post(KinderUrlConst.CHECK_TEACHERURL, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "老师考勤:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_CHECKTEACHER_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "老师考勤:onSuccess:"+t);	
CheckTeacher_DataSource model = KinderJsonParser
						.parserCheckTeacherModelData(context,t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_CHECKTEACHER_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "老师考勤:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_CHECKTEACHER_FAIL,
						null));
			}
		});
	}
	
	
	/**获取家长所有宝宝接口*/
	public static void getUserBabys_byNetWork(final Context context,final EventMessage eventMessage) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		
		fh.post(KinderUrlConst.GET_USERBABYSURL, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "家长下所有宝宝接口:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_USERBABAYS_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "家长下所有宝宝接口:onSuccess:"+t);	
CheckBaby_DataSource model = KinderJsonParser
						.parserCheckBaby_DataSourceData(context,t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_USERBABYS_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "家长下所有宝宝接口:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_USERBABYS_FAIL,
						null));
			}
		});
	}
	
	/**获取宝宝某月考勤接口*/
	public static void getCheckBaby_byNetWork(final Context context,final EventMessage eventMessage,
			String babyid,final String time
			) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		params.put("babyid", babyid);
		params.put("time", time);
		Log.e("buzz1", "宝宝某月接口:babyid：" + babyid);
		Log.e("buzz1", "宝宝某月接口:time："+time);
		fh.post(KinderUrlConst.GET_CHECKBABYSURL, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "宝宝某月接口:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_CHECKBABY_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
	
CheckBabyMonth_DataSource model = KinderJsonParser
						.parserCheckBabyMonth_DataSourceData(context,t);
                if(model!=null)
                {
                	 model.setTime(time);
                }
Log.e("buzz1", "宝宝"+time+"月接口:onSuccess:"+t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_CHECKBABY_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "宝宝某月接口:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_CHECKBABY_FAIL,
						null));
			}
		});
	}
	
	
	/**发送验证码接口*/
	public static void interface_sendSafeCode_byNetWork(final Context context,final EventMessage eventMessage,
			String babyid,String saftycode,String tel
			) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		params.put("babyid", babyid);
		params.put("saftycode", saftycode);
		params.put("tel", tel);
		
		Log.e("buzz1", "babyid:"+babyid);
		Log.e("buzz1", "saftycode:"+saftycode);
		Log.e("buzz1", "tel:"+tel);
		
		fh.post(KinderUrlConst.SEND_SAFTYCODEURL, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "发送安全码接口:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_SENDCODE_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "发送安全码接口:onSuccess:"+t);	
CheckBabyMonth_DataSource model = KinderJsonParser
						.parserCheckBabyMonth_DataSourceData(context,t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_SENDCODE_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "发送安全码接口:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_SENDCODE_FAIL,
						null));
			}
		});
	}
	
	/**获取疾病接口*/
	public static void interface_getDieases_byNetWork(final Context context,final EventMessage eventMessage) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		fh.post(KinderUrlConst.GET_DIEASESURL, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "获取疾病接口:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_DIEASE_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "获取疾病接口:onSuccess:"+t);	
DieaseDataSource model = KinderJsonParser
						.parserDieaseDataSource(context,t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_DIEASE_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "获取疾病接口:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_DIEASE_FAIL,
						null));
			}
		});
	}
	
	/**提交请假接口
	 * 
	 * 
	 * */
	public static void interface_submitLeave_byNetWork(final Context context,final EventMessage eventMessage,
			String babyid,String checktype,String diseaseid,String checkhospital,
			String checkremark,String parentid,String checkstart,String checkend) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		params.put("babyid", babyid);
		params.put("checktype", checktype);
		if(diseaseid!=null&&!diseaseid.equals("")&&!diseaseid.trim().equals(""))
		{
			params.put("diseaseid", diseaseid);
		}else
		{
			params.put("diseaseid", "0");
		}
		if(checkhospital!=null&&!checkhospital.equals(""))
		{
			params.put("checkhospital", checkhospital);
		}else
		{
			params.put("checkhospital", "0");
		}
		
		if(checkremark!=null&&!checkremark.equals(""))
		{
			params.put("checkremark", checkremark);
		}else
		{
			params.put("checkremark", "0");
			Log.e("buzz1", "checkremark:0");
		}
		
		params.put("parentid", parentid);
		params.put("checkstart", checkstart);
		params.put("checkend", checkend);
		
		Log.e("buzz1", "babyid:"+babyid);
		Log.e("buzz1", "checktype:"+checktype);
		Log.e("buzz1", "diseaseid:"+diseaseid);
		Log.e("buzz1", "checkhospital:"+checkhospital);
		Log.e("buzz1", "checkremark:"+checkremark);
		Log.e("buzz1", "parentid:"+parentid);
		Log.e("buzz1", "checkstart:"+checkstart);
		Log.e("buzz1", "checkend:"+checkend);
		
		fh.post(KinderUrlConst.SUBMIT_LEAVEURL, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "请假接口:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_SUBMITLEAVE_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "请假接口:onSuccess:"+t);	
DieaseDataSource model = KinderJsonParser
						.parserDieaseDataSource(context,t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_SUBMITLEAVE_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "请假接口:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_SUBMITLEAVE_FAIL,
						null));
			}
		});
	}
	
	/**获取通讯录信息*/
	public static void interface_getContactList_byNetWork(final Context context,final EventMessage eventMessage,
			String groupids,String easymobids) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		params.put("groupids", groupids);//"98187605127987724"
		params.put("easymobids", easymobids);
		
		
		
		Log.e("buzz1", "groupids:"+groupids);
		Log.e("buzz1", "easymobids:"+easymobids);
		
		fh.post(KinderUrlConst.GET_CONTACTLIST_URL, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "通讯录接口:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_CONTACTLIST_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "通讯录接口:onSuccess:"+t);	
ContactListDataSource model = KinderJsonParser
						.parserContactListDataSource(context,t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_CONTACTLIST_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "通讯录接口:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_CONTACTLIST_FAIL,
						null));
			}
		});
	}
	
	//GET_CHATLIST_URL
	/**获取通讯录信息*/
	public static void interface_getChatList_byNetWork(final Context context,final EventMessage eventMessage,
			String groupids,String easymobids) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		params.put("groupids", groupids);//"98187605127987724"
		params.put("easymobids", easymobids);
		
		
		
		Log.e("buzz1", "groupids:"+groupids);
		Log.e("buzz1", "easymobids:"+easymobids);
		
		fh.post(KinderUrlConst.GET_CHATLIST_URL, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "通讯录接口:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_CONTACTLIST_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "聊天列表接口:onSuccess:"+t);	
ContactListDataSource model = KinderJsonParser
						.parserContactListDataSource(context,t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_CONTACTLIST_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "通讯录接口:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_CONTACTLIST_FAIL,
						null));
			}
		});
	}
	/**意见反馈接口*/
	public static void interface_feedback_byNetWork(final Context context,final EventMessage eventMessage,
			String text) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		params.put("text", text);
		
		fh.post(KinderUrlConst.FEEDBACK_URL, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "意见反馈接口:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_FEEDBACK_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "意见反馈接口:onSuccess:"+t);	
FeedBack_DataSource model = KinderJsonParser
						.parserFeedBack_DataSource(context,t);
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_FEEDBACK_SUCCESS,
								model));
			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "意见反馈接口:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_FEEDBACK_FAIL,
						null));
			}
		});
	}
	
	/**获取通知接口*/
	public static void interface_getNotices_byNetWork(final Context context,final EventMessage eventMessage,
			String keyword,final String noticecate,String from,String num,final String operationtype) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		params.put("keyword", keyword);
		params.put("noticecate", noticecate);
		params.put("from", from);
		params.put("num", num);
		fh.post(KinderUrlConst.GET_NOTICE_URL, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "获取通知接口:onStart noticecate:"+noticecate);
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_GETNOTICE_START,operationtype));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "获取通知接口:onSuccess:"+t);	
Notice_DataSource model = KinderJsonParser
						.parserNotice_DataSource(context,t);
			if(model!=null)
			{
				model.setOperationType(operationtype);
			}
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_GETNOTICE_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "获取通知接口:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_GETNOTICE_FAIL,
						null));
			}
		});
	}
	
	
	
	/**
	 * @param type:0(非活动)1：活动
	 * 
	 * */
	public static void interface_getNoticeDetail_byNetWork(final Context context,final EventMessage eventMessage,
			 String noticeid,final String type) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		params.put("noticeid", noticeid);
	
		fh.post(KinderUrlConst.GET_NOTICEDETAIL_URL, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "获取通知详细接口:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_GETNOTICEDETAIL_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "获取通知详细接口:onSuccess:"+t);	

			NoticeDetail_DataSource model = KinderJsonParser
				.parserNoticeDetails_DataSource(context,t);
			if(model!=null)
			{
				model.setType(type);
			}
			eventMessage
				.post(new KinderEventMessage(
						KinderEventMessage.MSG_GETNOTICEDETAIL_SUCCESS,
						model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "获取通知详细接口:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_GETNOTICEDETAIL_FAIL,
						null));
			}
		});
	}
	//首页文章列表接口
	public static void interface_getArticle_byNetWork(final Context context,final EventMessage eventMessage,
			String keyword,String from,String num,final String operationtype) 
	{

		Kinder_Http fh = new Kinder_Http(context);
		AjaxParams params = new AjaxParams();
		cj_login(context, params);
		params.put("keyword", keyword);
		params.put("from", from);
		params.put("num", num);
	Log.e("buzz1", "from:"+from);
		fh.post(KinderUrlConst.GET_ARTICLES_URL, params,new AjaxCallBack<Object>() {
			@Override
			public void onStart() 
			{
				// TODO Auto-generated method stub
Log.e("buzz1", "获取文章列表接口:onStart");
				super.onStart();
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_GETARTICLES_START,null));
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
Log.e("buzz1", "获取文章列表接口:onSuccess:"+t);	
                Article_DataSource model = KinderJsonParser
						.parserArticle_DataSource(context,t);
                if(model!=null)
                {
                 	model.setOperationType(operationtype);
                }
				eventMessage
						.post(new KinderEventMessage(
								KinderEventMessage.MSG_GETARTICLES_SUCCESS,
								model));

			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				super.onFailure(t, errorNo, strMsg);
Log.e("buzz1", "获取文章列表接口:onFailure:"+strMsg);
				eventMessage.post(new KinderEventMessage(
						KinderEventMessage.MSG_GETARTICLES_FAIL,
						null));
			}
		});
	}
	
	//获取我的收藏接口
		public static void interface_getCollects_byNetWork(final Context context,final EventMessage eventMessage,
				String from,String num,final String operationtype) 
		{

			Kinder_Http fh = new Kinder_Http(context);
			AjaxParams params = new AjaxParams();
			cj_login(context, params);
			params.put("from", from);
			params.put("num", num);
		
			fh.post(KinderUrlConst.GET_MYCOLLECTS_URL, params,new AjaxCallBack<Object>() {
				@Override
				public void onStart() 
				{
					// TODO Auto-generated method stub
	Log.e("buzz1", "获取我的收藏接口:onStart");
					super.onStart();
					eventMessage
							.post(new KinderEventMessage(
									KinderEventMessage.MSG_GETARTICLES_START,null));
				}

				@Override
				public void onSuccess(Object t) {
					super.onSuccess(t);
	Log.e("buzz1", "获取我的收藏接口:onSuccess:"+t);	
	                Article_DataSource model = KinderJsonParser
							.parserArticle_DataSource(context,t);
	                if(model!=null)
	                {
	                 	model.setOperationType(operationtype);
	                }
					eventMessage
							.post(new KinderEventMessage(
									KinderEventMessage.MSG_GETARTICLES_SUCCESS,
									model));

				}

				@Override
				public void onFailure(Throwable t, int errorNo, String strMsg) {
					// TODO Auto-generated method stub
					super.onFailure(t, errorNo, strMsg);
	Log.e("buzz1", "获取我的收藏接口:onFailure:"+strMsg);
					eventMessage.post(new KinderEventMessage(
							KinderEventMessage.MSG_GETNOTICEDETAIL_FAIL,
							null));
				}
			});
		}
	//
	//文章详细接口
		public static void interface_getArticleDetail_byNetWork(final Context context,final EventMessage eventMessage,
				String articleid) 
		{

			Kinder_Http fh = new Kinder_Http(context);
			AjaxParams params = new AjaxParams();
			cj_login(context, params);
			params.put("articleid", articleid);
			Log.e("buzz1", "articleid:"+articleid);
			fh.post(KinderUrlConst.GET_ARTICLEDETAIL_URL, params,new AjaxCallBack<Object>() {
				@Override
				public void onStart() 
				{
					// TODO Auto-generated method stub
	Log.e("buzz1", "获取文章详细接口:onStart");
					super.onStart();
					eventMessage
							.post(new KinderEventMessage(
									KinderEventMessage.MSG_GETARTICLEDETAIL_START,null));
				}

				@Override
				public void onSuccess(Object t) {
					super.onSuccess(t);
	Log.e("buzz1", "获取文章详细接口:onSuccess:"+t);	
	ArticleDetail_DataSource   model = KinderJsonParser
							.parserArticleDetail_DataSource(context,t);
	               
					eventMessage
							.post(new KinderEventMessage(
									KinderEventMessage.MSG_GETARTICLEDETAIL_SUCCESS,
									model));

				}

				@Override
				public void onFailure(Throwable t, int errorNo, String strMsg) {
					// TODO Auto-generated method stub
					super.onFailure(t, errorNo, strMsg);
	Log.e("buzz1", "获取文章详细接口:onFailure:"+strMsg);
					eventMessage.post(new KinderEventMessage(
							KinderEventMessage.MSG_GETARTICLEDETAIL_FAIL,
							null));
				}
			});
		}
		
		//根据班级环信ID获取班级家长
				public static void interface_getUsers_byNetWork(final Context context,final EventMessage eventMessage,
						final String groupid) 
				{

					Kinder_Http fh = new Kinder_Http(context);
					AjaxParams params = new AjaxParams();
					cj_login(context, params);
					params.put("groupid", groupid);
					fh.post(KinderUrlConst.GET_USERS_URL, params,new AjaxCallBack<Object>() {
						@Override
						public void onStart() 
						{
							// TODO Auto-generated method stub
			Log.e("buzz1", "根据班级环信ID获取班级家长接口:onStart groupid:"+groupid);
							super.onStart();
							eventMessage
									.post(new KinderEventMessage(
											KinderEventMessage.MSG_GETUSERS_START,null));
						}

						@Override
						public void onSuccess(Object t) {
							super.onSuccess(t);
			Log.e("buzz1", "根据班级环信ID获取班级家长接口:onSuccess:"+t);	
			ContactUser_DataSource   model = KinderJsonParser
									.parserContactUser_DataSource(context,t);
			               
							eventMessage
									.post(new KinderEventMessage(
											KinderEventMessage.MSG_GETUSERS_SUCCESS,
											model));

						}

						@Override
						public void onFailure(Throwable t, int errorNo, String strMsg) {
							// TODO Auto-generated method stub
							super.onFailure(t, errorNo, strMsg);
			Log.e("buzz1", "根据班级环信ID获取班级家长接口:onFailure:"+strMsg);
							eventMessage.post(new KinderEventMessage(
									KinderEventMessage.MSG_GETUSERS_FAIL,
									null));
						}
					});
				}
				//
				public static void interface_praiseshare_byNetWork(final Context context,final EventMessage eventMessage,
						String articleid,final String action) 
				{

					Kinder_Http fh = new Kinder_Http(context);
					AjaxParams params = new AjaxParams();
					cj_login(context, params);
					params.put("articleid", articleid);
					params.put("action", action);
					fh.post(KinderUrlConst.GET_PRAISESHARE_URL, params,new AjaxCallBack<Object>() {
						@Override
						public void onStart() 
						{
							// TODO Auto-generated method stub
			Log.e("buzz1", "顶踩分享接口:onStart");
							super.onStart();
							eventMessage
									.post(new KinderEventMessage(
											KinderEventMessage.MSG_PRAISESHARE_START,null));
						}

						@Override
						public void onSuccess(Object t) {
							super.onSuccess(t);
			Log.e("buzz1", "顶踩分享接口:onSuccess:"+t);	
			PraiseShare_DataSource   model = KinderJsonParser
									.parserPraiseShare_DataSource(context,t);
			               if(model!=null)
			               {
			            	    model.setAction(action);
			               }
							eventMessage
									.post(new KinderEventMessage(
											KinderEventMessage.MSG_PRAISESHARE_SUCCESS,
											model));

						}

						@Override
						public void onFailure(Throwable t, int errorNo, String strMsg) {
							// TODO Auto-generated method stub
							super.onFailure(t, errorNo, strMsg);
			Log.e("buzz1", "顶踩分享接口:onFailure:"+strMsg);
							eventMessage.post(new KinderEventMessage(
									KinderEventMessage.MSG_PRAISESHARE_FAIL,
									null));
						}
					});
				}
				//收藏接口 1：收藏 2：取消收藏
		public static void interface_collect_byNetWork(final Context context,final EventMessage eventMessage,
				String articleid,final String collect) 
		{

			Kinder_Http fh = new Kinder_Http(context);
			AjaxParams params = new AjaxParams();
			cj_login(context, params);
			params.put("articleid", articleid);
			params.put("collect", collect);
Log.e("buzz1", "collect:"+collect);
			fh.post(KinderUrlConst.GET_COLLECT_URL, params,new AjaxCallBack<Object>() {
				@Override
				public void onStart() 
				{
					// TODO Auto-generated method stub
	Log.e("buzz1", "收藏接口:onStart");
					super.onStart();
					eventMessage
							.post(new KinderEventMessage(
									KinderEventMessage.MSG_COLLECT_START,null));
				}

				@Override
				public void onSuccess(Object t) {
					super.onSuccess(t);
	Log.e("buzz1", "收藏接口:onSuccess:"+t);	
	Collect_DataSource   model = KinderJsonParser
							.parserCollect_DataSource(context,t);
	               if(model!=null)
	               {
	            	    model.setCollect(collect);
	               }
					eventMessage
							.post(new KinderEventMessage(
									KinderEventMessage.MSG_COLLECT_SUCCESS,
									model));

				}

				@Override
				public void onFailure(Throwable t, int errorNo, String strMsg) {
					// TODO Auto-generated method stub
					super.onFailure(t, errorNo, strMsg);
	Log.e("buzz1", "收藏接口:onFailure:"+strMsg);
					eventMessage.post(new KinderEventMessage(
							KinderEventMessage.MSG_COLLECT_FAIL,
							null));
				}
			});
        }
		
		/**报名、不报名接口*/
		public static void interface_Sign_byNetWork(final Context context,final EventMessage eventMessage,
				final String babyids,final String isjoin,String noticeid) 
		{

			Kinder_Http fh = new Kinder_Http(context);
			AjaxParams params = new AjaxParams();
			cj_login(context, params);
			params.put("babyids", babyids);
			params.put("isjoin", isjoin);
			params.put("noticeid", noticeid);
Log.e("buzz1", "报名接口:onStart babyids:"+babyids);
Log.e("buzz1", "报名接口:onStart isjoin:"+isjoin);
Log.e("buzz1", "报名接口:onStart noticeid:"+noticeid);
			fh.post(KinderUrlConst.GET_SIGN_URL, params,new AjaxCallBack<Object>() {
				@Override
				public void onStart() 
				{
					// TODO Auto-generated method stub
					super.onStart();
					eventMessage
							.post(new KinderEventMessage(
									KinderEventMessage.MSG_SIGN_START,null));
				}

				@Override
				public void onSuccess(Object t) {
					super.onSuccess(t);
	Log.e("buzz1", "报名接口:onSuccess:"+t);	
	NoticeDetail_DataSource   model = KinderJsonParser
							.parserNoticeDetails_DataSource(context,t);
	             
					eventMessage
							.post(new KinderEventMessage(
									KinderEventMessage.MSG_SIGN_SUCCESS,
									model));

				}

				@Override
				public void onFailure(Throwable t, int errorNo, String strMsg) {
					// TODO Auto-generated method stub
					super.onFailure(t, errorNo, strMsg);
	Log.e("buzz1", "报名接口:onFailure:"+strMsg);
					eventMessage.post(new KinderEventMessage(
							KinderEventMessage.MSG_SIGN_FAIL,
							null));
				}
			});
        }
}
