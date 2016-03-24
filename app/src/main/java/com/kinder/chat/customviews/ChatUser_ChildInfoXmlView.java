package com.kinder.chat.customviews;

import android.content.Context;

import cn.kinder.bean.BabyModel;

import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.chat.viewsxml.ChatUser_ChildInfoXml;

public class ChatUser_ChildInfoXmlView extends ChatUser_ChildInfoXml {

	private Context context;
	public ChatUser_ChildInfoXmlView(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	/**数据初始化*/
	public void initData(BabyModel babyModel) {
		// TODO Auto-generated method stub
		if(babyModel==null)
		{
			return;
		}
		String babypic=babyModel.getBabypic();
		if(babypic!=null&&!babypic.equals(""))
		{
			Kinder_Bitmap.getInstance(context).display(head_ImageView, babypic, getBitmapFromCache(context, "user_defaule"));
		}else
		{
			head_ImageView.setImageBitmap(getBitmapFromCache(context, "user_default"));
		}
		
		//姓名
		this.childname_TextView.setText(babyModel.getBabyname());
		//幼儿园名称
		this.sexInfoView.initData("幼儿园名称",babyModel.getClassesModel().getSchoolModel().getSchoolname());
		//幼儿园班级
		this.whoInfoView.initData("所属班级", babyModel.getClassesModel().getClassname());
	    
		String babysex=babyModel.getBabysex();
	    if(babysex!=null&&!babysex.equals(""))
	    {
	    	 if(babysex.equals("0"))//女
	    	 {
	    		 this.childsex_ImageView.setImageResource(R.getRCode("drawable", "girl"));
	    	 }else if(babysex.equals("1"))
	    	 {
	    		 this.childsex_ImageView.setImageResource(R.getRCode("drawable", "man"));
	    	 }
	    }
	}

}
