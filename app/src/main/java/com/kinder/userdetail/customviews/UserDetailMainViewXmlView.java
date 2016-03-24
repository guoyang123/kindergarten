package com.kinder.userdetail.customviews;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import cn.com.iucd.iucdframe.utils.DensityUtil;
import cn.kinder.bean.BabyModel;
import cn.kinder.bean.ClassesModel;
import cn.kinder.bean.RelationModel;
import cn.kinder.bean.UserModel;
import cn.kinder.bean.UserPicModel;

import com.kinder.perfect.model.PerfectDataSource;
import com.kinder.userdetail.viewsxml.UserDetailMainViewXml;
import com.myt360.app.interfaces.OnUserPicClickListener;

public class UserDetailMainViewXmlView extends UserDetailMainViewXml {

	private Context context;
	private float pro,screenW,screenH;
	private OnUserPicClickListener onUserPicClickListener;
	public UserDetailMainViewXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.pro=pro;
		this.screenW=screenW;
		this.screenH=screenH;
	}

	/**设置监听*/
	public void setListener(OnClickListener onClickListener,OnUserPicClickListener onUserPicClickListener)
	{
		this.userInfoView.setListener(onClickListener);
		this.onUserPicClickListener=onUserPicClickListener;
	}
	
	/**数据初始化*/
	public void initData(PerfectDataSource dataSource) 
	{
	
			UserModel userModel=dataSource.getUserModel();
			this.userInfoView.initData(dataSource);
			String usertype=userModel.getUsertype();
			if(usertype!=null&&!usertype.equals(""))
			{
				if(usertype.equals("10005"))//家长
				{
					//初始化baby视图以及数据
					List<BabyModel> babys=dataSource.getBabyModel();
					if(babys!=null&&babys.size()>0)
					{
						initBabyView(babys);
					}
				}else //老师
				{
					List<ClassesModel> models=dataSource.getClassesModel();
					initTeachersView(models);
				}
			}
		}
		
		
	
	/**获取baby名称*/
	public void getBabaysInfo(PerfectDataSource dataSource)
	{
		if(dataSource==null)
		{
			return;
		}
		List<BabyModel> models=dataSource.getBabyModel();
		if(models!=null&&models.size()>0)
		{
			for(int i=0;i<models.size();i++)
			{
				UserDetailChildInfoXmlView view=(UserDetailChildInfoXmlView)wrap.getChildAt(i+1);//最开始有一个控件，因此从1开始
				String name=view.nameinfoView.name_EditText.getText().toString();
			    models.get(i).setBabyname(name);
			}
			
		}
	}
	
	
		/**添加baby视图以及数据的初始化*/
		public void initBabyView(List<BabyModel> babys)
		{
			for(int i=0;i<babys.size();i++)
			{
				BabyModel baby=babys.get(i);
				
				
				final UserDetailChildInfoXmlView childInfoView=new UserDetailChildInfoXmlView(context,pro,screenW,screenH);
				childInfoView.setId(15+i);
				LayoutParams childInfoView_param=new LayoutParams
						(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
				if(i==0)
				{
					childInfoView_param.addRule(RelativeLayout.BELOW,userInfoView.getId());
				}else
				{
					childInfoView_param.addRule(RelativeLayout.BELOW,15+i-1);
				}
				
				//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
				childInfoView.setLayoutParams(childInfoView_param);
				wrap.addView(childInfoView);
				
				final UserPicModel model=new UserPicModel(i, childInfoView.head_ImageView);
				childInfoView.head_ImageView.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if(onUserPicClickListener!=null)
						{
							onUserPicClickListener.onUserPicClick(model);
						}
					}
				});
				childInfoView.initData(baby);
				
			}
		}

		/**添加老师视图以及数据的初始化*/
		public void initTeachersView(List<ClassesModel> babys)
		{
			for(int i=0;i<babys.size();i++)
			{
				ClassesModel baby=babys.get(i);
				
				
				UserDetail_TeacherInfoXmlView childInfoView=new UserDetail_TeacherInfoXmlView(context,pro,screenW,screenH);
				childInfoView.setId(55+i);
				LayoutParams childInfoView_param=new LayoutParams
						(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
				if(i==0)
				{
					childInfoView_param.addRule(RelativeLayout.BELOW,userInfoView.getId());
					childInfoView_param.setMargins(0, (int)(DensityUtil.dip2px(context,20) * pro), 0, 0);
				}else
				{
					childInfoView_param.addRule(RelativeLayout.BELOW,55+i-1);
				}
				childInfoView.setLayoutParams(childInfoView_param);
				wrap.addView(childInfoView);
				
				childInfoView.initData(baby);
				
			}
		}

		/**选择性别*/
		public void refreshSexData(int position) {
			// TODO Auto-generated method stub
			this.userInfoView.sexInfoView.setPosition(position);
		}
		/**选择我是谁*/
		public void refreshWhoData(RelationModel model) {
			// TODO Auto-generated method stub
			this.userInfoView.whoInfoView.setModel(model);
		}

}
