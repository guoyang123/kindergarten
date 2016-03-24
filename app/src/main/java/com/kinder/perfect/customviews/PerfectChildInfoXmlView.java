package com.kinder.perfect.customviews;

import android.content.Context;
import android.view.View;

import cn.kinder.bean.BabyModel;

import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.perfect.viewsxml.PerfectChildInfoXml;

public class PerfectChildInfoXmlView extends PerfectChildInfoXml {

	private Context context;
	public PerfectChildInfoXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.nameinfoView.del_Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				nameinfoView.initData("");
			}
		});
	}

	
	/**数据初始化*/
	public void initData(BabyModel babyModel)
	{
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
		this.nameinfoView.initData(babyModel.getBabyname());
		//幼儿园名称
		this.sexInfoView.initData("幼儿园名称",babyModel.getClassesModel().getSchoolModel().getSchoolname());
		//幼儿园班级
		this.whoInfoView.initData("所属班级", babyModel.getClassesModel().getClassname());
	}
}
