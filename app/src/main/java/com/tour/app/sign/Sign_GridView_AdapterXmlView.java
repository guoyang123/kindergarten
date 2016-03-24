package com.tour.app.sign;

import android.content.Context;
import android.view.View;

import cn.kinder.bean.BabyModel;

import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.noticedetail.viewsxml.NoticeDetail_GridView_AdapterXml;

public class Sign_GridView_AdapterXmlView extends
		Sign_GridView_AdapterXml {

	private Context context;
	public Sign_GridView_AdapterXmlView(Context context, float pro,
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
			Kinder_Bitmap.getInstance(context).display(photo_ImageView, userpic, getBitmapFromCache(context, "user_defaule"));
		}
		this.name_TextView.setText(babyModel.getBabyname());
		boolean isSelected=babyModel.isSelected();
		if(isSelected)
		{
			this.icon_ImageView.setImageResource(R.getRCode("drawable", "baby_selected"));
		}else
		{
			this.icon_ImageView.setImageResource(R.getRCode("drawable", "baby_unselected"));
		}
	}

}
