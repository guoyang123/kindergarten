package com.kinder.userdetail.customviews;

import java.util.List;

import android.content.Context;
import android.view.View;
import cn.kinder.bean.RelationModel;
import cn.kinder.bean.UserModel;

import com.kinder.app.tools.KinderUrlConst;
import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.perfect.model.PerfectDataSource;
import com.kinder.userdetail.viewsxml.UserInfoXml;

public class UserInfoXmlView extends UserInfoXml 
{

	private Context context;
	
	public UserInfoXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	public void setListener(OnClickListener onClickListener)
	{
		this.back_Button.setOnClickListener(onClickListener);
		this.save_Button.setOnClickListener(onClickListener);
		this.userhead_ImageView.setOnClickListener(onClickListener);
		this.sexInfoView.setOnClickListener(onClickListener);
		this.whoInfoView.setOnClickListener(onClickListener);
	}
	
	/**数据初始化*/
	public void initData(PerfectDataSource source) {
		// TODO Auto-generated method stub
		UserModel userModel=source.getUserModel();
		if(userModel==null)
		{
			return;
		}
		//用户头像
		String userpic=userModel.getUserpic();
		if(userpic!=null&&!userpic.equals(""))//KinderUrlConst.PIC_URL+
		{
			Kinder_Bitmap.getInstance(context).display(userhead_ImageView, userpic, getBitmapFromCache(context, "user_defaule"));
		}else
		{
			userhead_ImageView.setImageBitmap(getBitmapFromCache(context, "user_default"));
		}
		//姓名
		this.nameinfoView.initData("姓名",userModel.getUsername());
		this.phoneInfoView.initData("电话", userModel.getUsertel());
		String usersex=userModel.getUsersex();
		if(usersex!=null&&!usersex.equals(""))
		{
			if(usersex.equals("0"))
			{
				this.sexInfoView.initData("请选择性别","女");
				this.sexInfoView.setPosition(0);
			}else
			{
				this.sexInfoView.initData("请选择性别","男");
				this.sexInfoView.setPosition(1);
			}
		}
//		//我是
				int relation=userModel.getRelation();
				List<RelationModel> relationmodels=source.getRelationModel();
				if(relationmodels!=null&&relationmodels.size()>0)
				{
					for(RelationModel model:relationmodels)
					{
						if(relation==model.getRelationid())
						{
							this.whoInfoView.initData("我是",model.getRelationname());
							this.whoInfoView.setModel(model);
						}
					}
				}
		String usertype=userModel.getUsertype();
		if(usertype!=null&&!usertype.equals(""))
		{
			if(usertype.equals("10005"))//家长
			{
				this.whoInfoView.setVisibility(View.VISIBLE);
				//this.whoInfoView.initData(userModel.get)
			}else
			{
				this.whoInfoView.setVisibility(View.GONE);
			}
		}
	}

}
