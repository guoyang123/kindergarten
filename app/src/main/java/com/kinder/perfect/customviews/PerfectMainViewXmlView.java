package com.kinder.perfect.customviews;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import cn.kinder.bean.BabyModel;
import cn.kinder.bean.RelationModel;
import cn.kinder.bean.UserModel;
import cn.kinder.bean.UserPicModel;

import com.kinder.perfect.model.PerfectDataSource;
import com.kinder.perfect.viewsxml.PerfectMainViewXml;
import com.kinder.userdetail.customviews.UserDetailChildInfoXmlView;
import com.myt360.app.interfaces.OnUserPicClickListener;

public class PerfectMainViewXmlView extends PerfectMainViewXml {

	private Context context;
	private float pro;
	private float screenW;
	private float screenH;
	private OnUserPicClickListener onUserPicClickListener;
	public PerfectMainViewXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.pro=pro;
		this.screenW=screenW;
		this.screenH=screenH;
	}

	
	public void setListener(OnClickListener onClickListener,OnUserPicClickListener onUserPicClickListener)
	{
		
		this.save_Button.setOnClickListener(onClickListener);
		this.userInfoView.setListener(onClickListener);
		this.onUserPicClickListener=onUserPicClickListener;
	}
	
	
	/**数据初始化*/
	public void initData(PerfectDataSource dataSource)
	{
		UserModel userModel=dataSource.getUserModel();
		if(userModel==null)
		{
			return;
		}
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
			}
		}
	}
	
	
	/**添加baby视图以及数据的初始化*/
	public void initBabyView(List<BabyModel> babys)
	{
		
		for(int i=0;i<babys.size();i++)
		{
			BabyModel baby=babys.get(i);
			
			
			PerfectChildInfoXmlView childInfoView=new PerfectChildInfoXmlView(context,pro,screenW,screenH);
			childInfoView.setId(15+i);
			
			LayoutParams childInfoView_param=new LayoutParams
					(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
			if(i==0)
			{
				childInfoView_param.addRule(RelativeLayout.BELOW,clauseView.getId());
			}else
			{
				childInfoView_param.addRule(RelativeLayout.BELOW,15+i-1);
			}
			
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
				PerfectChildInfoXmlView view=(PerfectChildInfoXmlView)wrap.getChildAt(i+2);//最开始有一个控件，因此从1开始
				String name=view.nameinfoView.name_EditText.getText().toString();
			    models.get(i).setBabyname(name);
			}
		}
	}
	
	/**选择性别*/
	public void refreshSexData(int position) {
		// TODO Auto-generated method stub
		this.userInfoView.sexInfoView.setPosition(position);
	}
	/**选择我是谁*/
	public void refreshWhoData(RelationModel model) 
	{
		// TODO Auto-generated method stub
		this.userInfoView.whoInfoView.setModel(model);
	}
}
