package com.kinder.menu.customviews;

import android.content.Context;
import android.view.View;

import cn.kinder.bean.UserModel;
import cn.kinder.user.DbOperationModel;

import com.kinder.menu.interfaces.OnSearchListener;
import com.kinder.menu.viewsxml.MenuActivity_TitleBarXml;
import com.myt360.app.consts.RuleConst;

public class MenuActivity_TitleBarXmlView extends MenuActivity_TitleBarXml
{

	private Context context;
	public MenuActivity_TitleBarXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	/**设置监听*/
	public void setListener(OnClickListener onClickListener,OnSearchListener onSearchListener)
	{
		this.parent_Titlebar.setListener(onClickListener);
		this.chat_TitleBar.setListener(onClickListener);
		this.check_Titlebar.setListener(onClickListener);
		this.notice_TitleBar.setListener(onClickListener,onSearchListener);
	}

	public void refreshTitleBar(int position) 
	{
		// TODO Auto-generated method stub
		this.parent_Titlebar.setVisibility(View.GONE);
		this.chat_TitleBar.setVisibility(View.GONE);
		this.check_Titlebar.setVisibility(View.GONE);
		this.notice_TitleBar.setVisibility(View.GONE);
		if(position==1)//育儿
		{
			this.parent_Titlebar.setVisibility(View.VISIBLE);
		}else if(position==2)//聊天
		{
			this.chat_TitleBar.setVisibility(View.VISIBLE);
		}else if(position==3)//考勤
		{
			this.check_Titlebar.setVisibility(View.VISIBLE);
			logic_check();
		}else if(position==4)//通知
		{
			this.notice_TitleBar.setVisibility(View.VISIBLE);
		}
	}
	
	/**考勤用户与老师逻辑*/
	private void logic_check()
	{
		UserModel userModel=DbOperationModel.getUserInfo(context);
		if(userModel!=null)
		{
			String usertype=userModel.getUsertype();
			if(usertype!=null&&!usertype.equals(""))
			{
				if(usertype.equals(RuleConst.USER))
				{
					this.check_Titlebar.rightBtn.setVisibility(View.VISIBLE);
				}else
				{
					this.check_Titlebar.rightBtn.setVisibility(View.GONE);
				}
			}
		}
	}
}
