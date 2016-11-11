package com.kinder.app.tools;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
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
import com.kinder.noticedetail.model.NoticeDetail_Non_DataSource;
import com.kinder.parent.model.ArticleDetail_DataSource;
import com.kinder.parent.model.Article_DataSource;
import com.kinder.parent.model.Collect_DataSource;
import com.kinder.parent.model.PraiseShare_DataSource;
import com.kinder.perfect.model.PerfectDataSource;
import com.kinder.perfect.model.UploadDataSource;

import cn.kinder.bean.ContactListDataSource;
import cn.kinder.bean.Kinder_DataSource;
import customviews.dialog.CheckVersionModel;


/**
 * 
 *  字符串json解析类
 * 
 * */
public class KinderJsonParser {

	/**登陆接口返回数据源*/
	public static Login_DataSource  parserLoginData(final Context context,Object obj){
		Login_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, Login_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "登陆接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	//
	/**获取用户信息返回数据源*/
	public static PerfectDataSource  parserUserInfoData(final Context context,Object obj){
		PerfectDataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, PerfectDataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "个人信息接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	
	
	/**短信验证码返回数据源*/
	public static VerfityDataSource  parserVerfityData(final Context context,Object obj){
		VerfityDataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, VerfityDataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "获取短信验证码接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	
	/**图片上传接口*/
	public static UploadDataSource  parserUploadpicData(final Context context,Object obj){
		UploadDataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, UploadDataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "图片上传接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	
	/**设置密码接口*/
	public static Kinder_DataSource  parserSetPswData(final Context context,Object obj){
		Kinder_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, Kinder_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "设置密码接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	
	//
	/**老师考勤接口*/
	public static CheckTeacher_DataSource  parserCheckTeacherModelData(final Context context,Object obj){
		CheckTeacher_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, CheckTeacher_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "老师考勤返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	
	//
	/**家长下所有宝宝接口*/
	public static CheckBaby_DataSource  parserCheckBaby_DataSourceData(final Context context,Object obj){
		CheckBaby_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, CheckBaby_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "家长下所有宝宝接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	//CheckBabyMonth_DataSource
	/**宝宝某有考勤接口*/
	public static CheckBabyMonth_DataSource  parserCheckBabyMonth_DataSourceData(final Context context,Object obj){
		CheckBabyMonth_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			json=json.replaceAll("BabyCheckTimeModel ", "BabyCheckTimeModel");

			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, CheckBabyMonth_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "宝宝某月考勤接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	//
	/**获取疾病接口*/
	public static DieaseDataSource  parserDieaseDataSource(final Context context,Object obj){
		DieaseDataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, DieaseDataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "获取疾病接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	
	//ContactListDataSource
	public static ContactListDataSource  parserContactListDataSource(final Context context,Object obj){
		ContactListDataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, ContactListDataSource.class);
				model.copyData2ContactModels();
				Log.e("buzz1", "size:"+model.getContactModels().size());
			}catch(Exception e)
			{
				Toast.makeText(context, "获取通讯录接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	
	public static FeedBack_DataSource  parserFeedBack_DataSource(final Context context,Object obj){
		FeedBack_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, FeedBack_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "意见反馈接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	//
	public static Notice_DataSource  parserNotice_DataSource(final Context context,Object obj){
		Notice_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, Notice_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "获取通知接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	public static NoticeDetail_Non_DataSource  parserNotice_Non_DataSource(final Context context,Object obj){
		NoticeDetail_Non_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, NoticeDetail_Non_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "获取通知详细接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	
	public static NoticeDetail_DataSource  parserNoticeDetails_DataSource(final Context context,Object obj){
		NoticeDetail_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, NoticeDetail_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "获取通知详细之活动接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	
	//
	public static Article_DataSource  parserArticle_DataSource(final Context context,Object obj){
		Article_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, Article_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "获取文章列表接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	
	public static ArticleDetail_DataSource  parserArticleDetail_DataSource(final Context context,Object obj){
		ArticleDetail_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, ArticleDetail_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "获取文章详细接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	
	public static ContactUser_DataSource  parserContactUser_DataSource(final Context context,Object obj){
		ContactUser_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			json=json.replaceAll("UberModelList ", "UberModelList");

			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, ContactUser_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "根据班级环信ID获取班级家长接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	
	public static PraiseShare_DataSource  parserPraiseShare_DataSource(final Context context,Object obj){
		PraiseShare_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, PraiseShare_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "顶踩分享接口返回数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}
	public static Collect_DataSource  parserCollect_DataSource(final Context context,Object obj){
		Collect_DataSource model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, Collect_DataSource.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "收藏数据有问题", 0).show();
				return null;
			}
			
		}
		
		return model;
	}

	//CheckVersionModel
	public static CheckVersionModel parserCheckVersionModel(final Context context,Object obj){
		CheckVersionModel model=null;
		if(obj!=null){
			String json=(String)obj;
			Gson gson=new Gson();
			try{
				model=gson.fromJson(json, CheckVersionModel.class);
			}catch(Exception e)
			{
				Toast.makeText(context, "检测版本更新数据有问题", 0).show();
				return null;
			}

		}

		return model;
	}
}
