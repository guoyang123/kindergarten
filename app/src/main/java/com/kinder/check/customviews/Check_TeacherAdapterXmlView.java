package com.kinder.check.customviews;

import android.content.Context;
import android.view.View;

import cn.kinder.bean.BabyModel;
import cn.kinder.bean.CheckModel;
import cn.kinder.bean.SaftyModel;

import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.check.model.TeacherWrapModel;
import com.kinder.check.viewsxml.Check_TeacherAdapterXml;

public class Check_TeacherAdapterXmlView extends Check_TeacherAdapterXml {

	private Context context;
	public Check_TeacherAdapterXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	/**数据初始化*/
	public void initData(int position,TeacherWrapModel model) {
		// TODO Auto-generated method stub
		int type=model.getType();
		if(type==TeacherWrapModel.CHECKMODEL)
		{
			initLeaveType(model.getCheckModel());
		}
		if(type==TeacherWrapModel.SAFTYMODEL)
		{
			initSaftyType(model.getSaftyModel());
		}
	}

	/**事假类型，数据初始化*/
	private void initLeaveType(CheckModel model)
	{
		if(model==null)
		{
			return;
		}
//		this.safecode_ImageView.setVisibility(View.GONE);
//		this.leave_ImageView.setVisibility(View.VISIBLE);
		//	请假类型0-病假1-事假2-休学
		String checktype=model.getChecktype();
		if(checktype!=null&&!checktype.equals(""))
		{
			if(checktype.equals("0"))//病假
			{
				this.safecode_ImageView.setVisibility(View.GONE);
				this.leave_ImageView.setVisibility(View.VISIBLE);
				this.leave_ImageView.setImageResource(R.getRCode("drawable", "baby_disease"));
			}else if(checktype.equals("1"))//事假
			{
				this.safecode_ImageView.setVisibility(View.GONE);
				this.leave_ImageView.setVisibility(View.VISIBLE);
				this.leave_ImageView.setImageResource(R.getRCode("drawable", "baby_business"));
			}else if(checktype.equals("2"))//休学
			{
				this.safecode_ImageView.setVisibility(View.VISIBLE);
				this.leave_ImageView.setVisibility(View.GONE);
				this.safecode_ImageView.setImageResource(R.getRCode("drawable", "baby_rest"));
			
			}
		}else
		{
			this.safecode_ImageView.setVisibility(View.GONE);
			this.leave_ImageView.setVisibility(View.GONE);
			
		}
		BabyModel babyModel=model.getBabyModel();
		if(babyModel==null)
		{
			return;
		}
			
		this.babyname_TextView.setText(babyModel.getBabyname());
		//用户头像
		String userpic=babyModel.getBabypic();
		if(userpic!=null&&!userpic.equals(""))
		{
			Kinder_Bitmap.getInstance(context).display(baby_CircularImage, userpic, getBitmapFromCache(context, "user_default"),getBitmapFromCache(context, "user_default"));
		}
		
		
	}
	/**安全码类型，数据初始化*/
	private void initSaftyType(SaftyModel model)
	{
		if(model==null)
		{
			return;
		}
		
		this.safecode_ImageView.setVisibility(View.VISIBLE);
		this.leave_ImageView.setVisibility(View.GONE);
		this.safecode_ImageView.setImageResource(R.getRCode("drawable", "baby_safe"));
		
		BabyModel babyModel=model.getBabyModel();
		if(babyModel==null)
		{
			return;
		}
			
		this.babyname_TextView.setText(babyModel.getBabyname());
		//用户头像
		String userpic=babyModel.getBabypic();
		if(userpic!=null&&!userpic.equals(""))
		{
			Kinder_Bitmap.getInstance(context).display(baby_CircularImage, userpic, getBitmapFromCache(context, "user_defaule"));
		}else
		{
			this.baby_CircularImage.setImageBitmap(getBitmapFromCache(context, "user_default"));
		}
	}
}
