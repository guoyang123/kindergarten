package com.kinder.check.customviews;

import android.content.Context;
import android.widget.TextView;

import cn.kinder.bean.BabyModel;
import cn.kinder.bean.SaftyModel;
import cn.kinder.bean.UserModel;
import cn.kinder.user.DbOperationModel;

import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.check.viewsxml.Check_SafeXml;
import com.myt360.app.customviews.CircularImage;

public class Check_SafeXmlView extends Check_SafeXml {

	private Context context;
	public Check_SafeXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	/**数据初始化*/
	public void initViewData(SaftyModel saftyModel) {
		// TODO Auto-generated method stub
		
		if(saftyModel==null)
		{
			return;
		}
		BabyModel babyModel=saftyModel.getBabyModel();
		
		//this.baby_CircularImage
		
		this.safecode_TextView.setText(saftyModel.getSaftycode());
		UserModel user=DbOperationModel.getUserInfo(context);
		if(user!=null)
		{
			this.name_TextView.setText("姓名:"+user.getUsername()+"   "+user.getRelation());//姓名:张鹏   爷爷
		}
		
		if(babyModel==null)
		{
			return;
		}
		
		this.sexView.initViewData(babyModel);
		//用户头像
		String userpic=babyModel.getBabypic();
		if(userpic!=null&&!userpic.equals(""))
		{
			Kinder_Bitmap.getInstance(context).display(baby_CircularImage, userpic, getBitmapFromCache(context, "user_defaule"));
		}else
		{
			baby_CircularImage.setImageBitmap(getBitmapFromCache(context, "user_default"));
		}
		
		
	}

}
