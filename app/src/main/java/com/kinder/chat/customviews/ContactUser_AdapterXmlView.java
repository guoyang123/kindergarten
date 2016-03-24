package com.kinder.chat.customviews;

import android.content.Context;
import android.view.View;
import cn.kinder.bean.BabyModel;
import cn.kinder.bean.RelationModel;
import cn.kinder.bean.UserModel;

import com.kinder.app.tools.KinderUrlConst;
import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.chat.model.ContactModel;
import com.kinder.chat.viewsxml.ContactUser_AdapterXml;

public class ContactUser_AdapterXmlView extends ContactUser_AdapterXml {

	private Context context;
	public ContactUser_AdapterXmlView(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	public void initViewData(ContactModel contactModel)
	{
		
		
		if(contactModel==null)
		{
			return;
		}
		UserModel userModel=contactModel.getUserModel();
		if(userModel!=null)
		{
			String pic=userModel.getUserpic();
			if(pic!=null&&!pic.equals(""))
			{
				Kinder_Bitmap.getInstance(context).display(thumb_ImageView, pic, getBitmapFromCache(context, "user_default"));
			}else
			{
				thumb_ImageView.setImageBitmap(getBitmapFromCache(context, "user_default"));
			}
			this.username_TextView.setText(userModel.getUsername());
		}
		
		
		RelationModel relationModel=contactModel.getRelationModel();
		if(relationModel!=null)
		{
			
				this.classtime_TextView.setText("我是"+relationModel.getRelationname());//+
			
			
		}
		
//		
		BabyModel babyModel=contactModel.getBabyModel();
		if(babyModel!=null)
		{
			String usertype=userModel.getUsertype();
			if(usertype!=null&&!usertype.equals("")&&!usertype.equals("10004"))
			{
				this.babyname_TextView.setText("宝宝:"+babyModel.getBabyname());//
			}else
			{
				this.babyname_TextView.setVisibility(View.INVISIBLE);
			}
			
			
		}
	    
		
		
		
	}
}
