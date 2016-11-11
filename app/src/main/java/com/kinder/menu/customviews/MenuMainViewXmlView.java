package com.kinder.menu.customviews;

import android.content.Context;

import com.kinder.menu.interfaces.OnSearchListener;
import com.kinder.menu.viewsxml.MenuMainViewXml;
import com.kinder.perfect.model.PerfectDataSource;

import java.util.List;

import cn.kinder.bean.BabyModel;
import cn.kinder.bean.UserModel;

public class MenuMainViewXmlView extends MenuMainViewXml {

	public MenuMainViewXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	
	/**设置监听*/
	public void setListener(OnClickListener onClickListener,OnSearchListener onSearchListener)
	{
		this.titleBarView.setListener(onClickListener,onSearchListener);
		this.bottomWrap.setListener(onClickListener);
		
	}
	
	public void refreshIcon(int ps)
	{
		this.bottomWrap.refreshIcon(ps);
	}


	/**根据位置显示相对应的titlebar*/
	public void refreshTitleBar(int position) {
		// TODO Auto-generated method stub
		this.titleBarView.refreshTitleBar(position);
		
	}


	/**数据初始化*/
	public void initSchoolData(PerfectDataSource dataSource)
	{
		UserModel userModel=dataSource.getUserModel();
		if(userModel==null)
		{
			return;
		}
		String usertype=userModel.getUsertype();
		if(usertype!=null&&!usertype.equals(""))
		{
			if(usertype.equals("10005"))//家长
			{
				//初始化baby视图以及数据
				List<BabyModel> babys=dataSource.getBabyModel();
				if(babys!=null&&babys.size()>0)
				{
                  this.titleBarView.parent_Titlebar.centerTextView.setText(babys.get(0).getClassesModel().getSchoolModel().getSchoolname());
				}
			}else{//老师
				this.titleBarView.parent_Titlebar.centerTextView.setText(dataSource.getClassesModel().get(0).getSchoolModel().getSchoolname());


			}
		}
	}
}
