package com.kinder.chat.customviews;

import java.util.List;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;
import cn.kinder.bean.BabyModel;
import cn.kinder.bean.ClassesModel;
import cn.kinder.bean.UserModel;

import com.kinder.chat.viewsxml.ChatUserMainViewXml;
import com.kinder.perfect.customviews.PerfectChildInfoXmlView;
import com.kinder.perfect.model.PerfectDataSource;
import com.kinder.userdetail.customviews.UserDetail_TeacherInfoXmlView;
import com.myt360.app.consts.RuleConst;

public class ChatUserMainViewXmlView extends ChatUserMainViewXml {

	private Context context;
	private float pro,screenW,screenH;
	public ChatUserMainViewXmlView(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.pro=pro;
		this.screenW=screenW;
		this.screenH=screenH;
	}

	/**设置监听*/
	public void setListener(OnClickListener onClickListener)
	{
		this.titlebarView.setListener(onClickListener);
		this.talk_RelativeLayout.setOnClickListener(onClickListener);
	}
	
	/**数据初始化*/
	public void initMainViewData(PerfectDataSource dataSource)
	{
		
		this.userInfoView.initData(dataSource);
		
		UserModel userModel=dataSource.getUserModel();
		if(userModel==null)
		{
			return;
		}
		String usertype=userModel.getUsertype();
		if(usertype.equals(RuleConst.USER))//家长
		{
			//初始化baby视图以及数据
			List<BabyModel> babys=dataSource.getBabyModel();
			if(babys!=null&&babys.size()>0)
			{
				initBabyView(babys);
			}
		}else {//老师
			List<ClassesModel> models=dataSource.getClassesModel();
			initTeachersView(models);
		}
	}
	
	
	/**添加baby视图以及数据的初始化*/
	public void initBabyView(List<BabyModel> babys)
	{
		for(int i=0;i<babys.size();i++)
		{
			BabyModel baby=babys.get(i);
			
			
			ChatUser_ChildInfoXmlView childInfoView=new ChatUser_ChildInfoXmlView(context,pro,screenW,screenH);
			childInfoView.setId(15+i);
			LayoutParams childInfoView_param=new LayoutParams
					(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
			if(i==0)
			{
				//childInfoView_param.addRule(RelativeLayout.BELOW,clauseView.getId());
			}else
			{
				childInfoView_param.addRule(RelativeLayout.BELOW,15+i-1);
			}
			
			//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
			childInfoView.setLayoutParams(childInfoView_param);
			container_RelativeLayout.addView(childInfoView);
			
			childInfoView.initData(baby);
			
		}
	}
	/**添加老师视图以及数据的初始化*/
	public void initTeachersView(List<ClassesModel> babys)
	{
		for(int i=0;i<babys.size();i++)
		{
			ClassesModel teacher=babys.get(i);
			
			
			TeacherInfoXmlView childInfoView=new TeacherInfoXmlView(context,pro,screenW,screenH);
			childInfoView.setId(55+i);
			LayoutParams childInfoView_param=new LayoutParams
					(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
			if(i==0)
			{
//				childInfoView_param.addRule(RelativeLayout.BELOW,userInfoView.getId());
//				childInfoView_param.setMargins(0, (int)(DensityUtil.dip2px(context,20) * pro), 0, 0);
			}else
			{
				childInfoView_param.addRule(RelativeLayout.BELOW,55+i-1);
			}
			childInfoView.setLayoutParams(childInfoView_param);
			container_RelativeLayout.addView(childInfoView);
			
			childInfoView.initData(teacher);
			
		}
	}

}
