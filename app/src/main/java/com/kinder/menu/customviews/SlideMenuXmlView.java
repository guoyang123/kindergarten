package com.kinder.menu.customviews;

import java.util.List;

import android.content.Context;
import android.widget.AdapterView.OnItemClickListener;

import cn.kinder.bean.UserModel;
import cn.kinder.user.DbOperationModel;
import cn.kinder.util.MeasureViewHeight;

import com.kinder.app.tools.KinderUrlConst;
import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.menu.adapter.SlideAdapter;
import com.kinder.menu.model.SlideModel;
import com.kinder.menu.viewsxml.SlideMenuXml;

public class SlideMenuXmlView extends SlideMenuXml {

	private Context context;
	private SlideAdapter adapter;
	public SlideMenuXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		adapter=new SlideAdapter(context,pro,screenW,screenH);
		this.listView.setAdapter(adapter);
	}

	/**设置监听*/
	public void setListener(OnClickListener onClickListener,OnItemClickListener onItemClickListener)
	{
		this.head_ImageView.setOnClickListener(onClickListener);
		this.listView.setOnItemClickListener(onItemClickListener);
	}
	
	/**数据初始化*/
	public void initData()
	{
		UserModel userModel=DbOperationModel.getUserInfo(context);
		if(userModel!=null)
		{
			String userpic=userModel.getUserpic();
			if(userpic!=null&&!userpic.equals(""))
			{//KinderUrlConst.PIC_URL+
				Kinder_Bitmap.getInstance(context).display(head_ImageView, userpic,getBitmapFromCache(context, "user_default"));
			}
			this.name_TextView.setText(userModel.getUsername());
		}
	}
	
	/**初始化左侧栏数据*/
	public void initSlideData(List<SlideModel> models)
	{
		this.adapter.setDatas(models);
		this.adapter.notifyDataSetChanged();
		MeasureViewHeight.measureListViewHeight(listView);
	}
	public void refreshData()
	{
		if(adapter==null)
		{
			return;
		}
		this.adapter.notifyDataSetChanged();
	}
}
