package com.kinder.check.customviews;

import android.content.Context;
import cn.kinder.bean.BabyModel;
import cn.kinder.bean.CheckModel;
import cn.kinder.bean.DiseaseModel;
import cn.kinder.user.DbOperationModel;

import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.check.viewsxml.Check_BabyLeaveXml;

public class Check_BabyLeaveXmlView extends Check_BabyLeaveXml {

	private Context context;
	public Check_BabyLeaveXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	/**数据初始化*/
	public void initViewData(CheckModel checkModel) {
		// TODO Auto-generated method stub
		
		if(checkModel==null)
		{
			return;
		}
		//家长姓名
		name_TextView.setText(DbOperationModel.getUserInfo(context).getUsername());
		String checktype=checkModel.getChecktype();
		String dieasetype=null;
		if(checktype!=null&&!checktype.equals(""))
		{
			if(checktype.equals("0"))//病假
			{
				DiseaseModel diseaseModel=checkModel.getDiseaseModel();
				if(diseaseModel!=null)
				{
					dieasetype="病假"+"  "+checkModel.getCheckhospital()+"  "+diseaseModel.getDiseaserem();
				}else
				{
					dieasetype="病假"+"  "+checkModel.getCheckhospital();
				}
				
			}else if(checktype.equals("1"))//事假
			{
				dieasetype="事假";
			}else if(checktype.equals("2"))//休学
			{
				dieasetype="休学";
			}
		}
		this.leave_TextView.setText(dieasetype);
		this.desc_TextView.setText(checkModel.getCheckremark());
		
		BabyModel babyModel=checkModel.getBabyModel();
		if(babyModel==null)
		{
			return;
		}
		sexView.initViewData(babyModel);
		
		//用户头像
		String userpic=babyModel.getBabypic();
		if(userpic!=null&&!userpic.equals(""))
		{
			Kinder_Bitmap.getInstance(context).display(baby_CircularImage, userpic, getBitmapFromCache(context, "user_default"), getBitmapFromCache(context, "user_default"));
		}
	}

}
