package com.kinder.check.customviews;

import java.util.List;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import cn.kinder.bean.BabyCheckModel;
import cn.kinder.bean.UserModel;
import cn.kinder.user.DbOperationModel;

import com.kinder.check.model.CheckBaby_DataSource;
import com.kinder.check.model.TeacherWrapModel;
import com.kinder.check.viewsxml.CheckMainViewXml;
import com.myt360.app.consts.RuleConst;

public class CheckMainViewXmlView extends CheckMainViewXml 
{

	private Context context;
	public CheckMainViewXmlView(Context context, float pro, float screenW,
			float screenH,FragmentManager fm) {
		super(context, pro, screenW, screenH,fm);
		// TODO Auto-generated constructor stub
		this.context=context;
	}
	
	
	public void initDataBefore()
	{
		UserModel model=DbOperationModel.getUserInfo(context);
		if(model!=null)
		{
			String usertype=model.getUsertype();
			if(usertype!=null&&!usertype.equals(""))
			{
				if(usertype.equals(RuleConst.USER))//家长
				{
					this.checkUserView.setVisibility(View.VISIBLE);
					this.checkTeacherView.setVisibility(View.GONE);
				}else
				{
					this.checkUserView.setVisibility(View.GONE);
					this.checkTeacherView.setVisibility(View.VISIBLE);
				}
			}
		}
	}

	/**设置监听*/
	public void setListener(OnItemClickListener onItemClickListener,OnClickListener listener)
	{
		this.checkTeacherView.setListener(onItemClickListener,listener);
		
	}

	public void initViewData(CheckBaby_DataSource babys_DataSource) {
		// TODO Auto-generated method stub
		List<BabyCheckModel> models=babys_DataSource.getBabyCheckModel();
	    this.checkUserView.setDatas(models);
	}
	
	/**初始化老师考勤数据*/
	public void initTeacherViewData(List<TeacherWrapModel> datas)
	{
//		if(datas!=null&&datas.size()>0)
//		{
			this.checkTeacherView.initTeacherViewData(datas);
			this.checkTeacherView.babyLeaveView.setVisibility(View.GONE);
			this.checkTeacherView.safeView.setVisibility(View.GONE);
//		}
		
	}
}
