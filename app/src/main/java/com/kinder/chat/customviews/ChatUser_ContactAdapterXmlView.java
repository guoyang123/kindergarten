package com.kinder.chat.customviews;

import android.content.Context;
import android.view.View;

import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.chat.viewsxml.ChatUser_ContactAdapterXml;

import cn.kinder.bean.BabyModel;
import cn.kinder.bean.ClassModel;
import cn.kinder.bean.ContactListModel;
import cn.kinder.bean.ContactListUserModel;
import cn.kinder.bean.RelationModel;
import cn.kinder.bean.UserModel;
import cn.kinder.user.DbOperationModel;

public class ChatUser_ContactAdapterXmlView extends ChatUser_ContactAdapterXml {

	private Context context;
	public ChatUser_ContactAdapterXmlView(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		
	}

	
	/***/
	/**数据初始化*/
	public void initViewData(ContactListModel model) {
		// TODO Auto-generated method stub
		
		int type=model.getType();
		String pic=null;
		if(type==ContactListModel.GROUP)//群组
		{
			ClassModel classModel=model.getClassModel();
			if(classModel==null)
			{
				return;
			}
			pic=classModel.getClasspic();
			this.classname_TextView.setText(classModel.getClassname());
			String classyear=classModel.getClassyear();
			this.classtime_TextView.setText(classyear+"年");
			this.current_TextView.setVisibility(View.VISIBLE);
			this.babyname_TextView.setVisibility(View.GONE);
		    
		}else if(type==ContactListModel.USER)//用户
		{
			ContactListUserModel userlistmodel=model.getContactUserModel();
			if(userlistmodel==null)
			{
				return ;
			}
			UserModel userModel=userlistmodel.getUserModel();
			if(userModel==null)
			{
				return;
			}
			//判断是否为用户自己
		   UserModel user=DbOperationModel.getUserInfo(context);
			if(userModel.getUserid().equals(user.getUserid()))
			{
				return ;
			}
			
			pic=userModel.getUserpic();
			this.classname_TextView.setText(userModel.getUsername());
			RelationModel relationModel=userlistmodel.getRelationModel();
			if(relationModel==null)
			{
				return;
			}

			BabyModel babyModel=userlistmodel.getBabyModel();
			if(babyModel==null)
			{
				return;
			}
			this.current_TextView.setVisibility(View.GONE);
			this.babyname_TextView.setVisibility(View.VISIBLE);
		    
			String usertype=userModel.getUsertype();
			if(usertype!=null&&!usertype.equals("")&&!usertype.equals("10004"))
			{
				this.babyname_TextView.setText("宝宝:"+babyModel.getBabyname());//
				this.classtime_TextView.setText(babyModel.getBabyname()+"的"+relationModel.getRelationname());

			}else
			{
				this.babyname_TextView.setVisibility(View.INVISIBLE);
			}


		}
		
		
			if(pic!=null&&!pic.equals(""))
			{
				//pic=KinderUrlConst.PIC_URL+pic;
				Kinder_Bitmap.getInstance(context).display(thumb_ImageView, pic, getBitmapFromCache(context, "user_default"));
			}
		
	}
}
