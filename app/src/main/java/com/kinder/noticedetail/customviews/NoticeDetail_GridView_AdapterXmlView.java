package com.kinder.noticedetail.customviews;

import android.content.Context;

import cn.kinder.bean.BabyModel;

import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.noticedetail.viewsxml.NoticeDetail_GridView_AdapterXml;

public class NoticeDetail_GridView_AdapterXmlView extends
		NoticeDetail_GridView_AdapterXml {

	private Context context;
	public NoticeDetail_GridView_AdapterXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	/**数据初始化*/
	public void initViewData(BabyModel babyModel) {
		// TODO Auto-generated method stub
		String userpic=babyModel.getBabypic();
		if(userpic!=null&&!userpic.equals(""))
		{
			Kinder_Bitmap.getInstance(context).display(photo_ImageView, userpic, getBitmapFromCache(context, "user_default"),getBitmapFromCache(context, "user_default"));
		}
		this.name_TextView.setText(babyModel.getBabyname());
	}

}
