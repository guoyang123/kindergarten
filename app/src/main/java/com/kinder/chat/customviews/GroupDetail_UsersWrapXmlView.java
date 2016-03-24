package com.kinder.chat.customviews;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

import cn.com.iucd.iucdframe.utils.DensityUtil;
import cn.kinder.util.MeasureViewHeight;

import com.kinder.chat.adapter.GroupDetailAdapter;
import com.kinder.chat.model.ContactModel;
import com.kinder.chat.viewsxml.GroupDetail_UsersWrapXml;

public class GroupDetail_UsersWrapXmlView extends GroupDetail_UsersWrapXml {

	private GroupDetailAdapter adapter;
	private Context context;
	private float pro;
	public GroupDetail_UsersWrapXmlView(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.pro=pro;
		adapter=new GroupDetailAdapter(context,pro,screenW,screenH);
		this.gridView.setAdapter(adapter);
	}
	public void initViewData(List<ContactModel> uberModelList) {
		// TODO Auto-generated method stub
		this.adapter.setModels(uberModelList);
		this.adapter.notifyDataSetChanged();
		measureGridViewHeight(gridView);
		
	}

	
	 /**计算Gridview的高度*/
		public  void measureGridViewHeight(GridView listview){
				ListAdapter listAdapter=listview.getAdapter();
				if (listAdapter == null) {
		            return;
		        }
				int totalHeight = 0;  
				int rem=listAdapter.getCount()%6;
				int totalcount=listAdapter.getCount()/6;
				if(rem!=0){
					totalcount++;
				}
		        for (int i = 0, len = totalcount; i < len; i++) {   
		        View listItem = listAdapter.getView(i, null, listview);
		        listItem.measure(0, 0);
		        totalHeight += listItem.getMeasuredHeight();
		       }
		        ViewGroup.LayoutParams params = listview.getLayoutParams();
		        params.height = totalHeight+(totalcount)*((int)(DensityUtil.dip2px(context,10) * pro));
				Log.e("params.height", listAdapter.getCount()+"--"+params.height+"");
				listview.setLayoutParams(params);
		}
}
