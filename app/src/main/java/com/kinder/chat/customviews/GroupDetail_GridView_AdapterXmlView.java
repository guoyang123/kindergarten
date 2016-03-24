package com.kinder.chat.customviews;

import android.content.Context;

import cn.kinder.bean.BabyModel;
import cn.kinder.bean.UserModel;

import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.chat.model.ContactModel;
import com.kinder.chat.viewsxml.GroupDetail_GridView_AdapterXml;
import com.kinder.noticedetail.viewsxml.NoticeDetail_GridView_AdapterXml;

public class GroupDetail_GridView_AdapterXmlView extends
		GroupDetail_GridView_AdapterXml {

	private Context context;
	public GroupDetail_GridView_AdapterXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	/**数据初始化*/
	public void initViewData(ContactModel model) {
		// TODO Auto-generated method stub
		UserModel userModel=model.getUserModel();
		if(userModel==null)
		{
			return;
		}
		 String userpic=userModel.getUserpic();
		if(userpic!=null&&!userpic.equals(""))
		{
			Kinder_Bitmap.getInstance(context).display(photo_ImageView, userpic, getBitmapFromCache(context, "user_default"));
		}
		this.name_TextView.setText(userModel.getUsername());
	}

}
