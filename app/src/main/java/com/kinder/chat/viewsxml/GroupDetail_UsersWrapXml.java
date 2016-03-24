package com.kinder.chat.viewsxml;

import android.content.Context;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.myt360.app.customviews.MyRelativeLayout;

public class GroupDetail_UsersWrapXml extends MyRelativeLayout {

	public GridView gridView;
	public GroupDetail_UsersWrapXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		TextView text=productTextView(context, pro, 191, 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				0, 0, 0, 
				14, 10, 0, 0,
				"群组成员", 13, "#3c3c3c", this);
		
		gridView=new GridView(context);//ForbidScroll
		gridView.setId(192);
	    LayoutParams pic_GridView_param=getParam(context, pro, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
	    pic_GridView_param.addRule(RelativeLayout.BELOW,text.getId());
	    pic_GridView_param.setMargins((int)(DensityUtil.dip2px(context,14) * pro), 
	    		(int)(DensityUtil.dip2px(context,10) * pro),(int)(DensityUtil.dip2px(context,14) * pro), 0);
	    gridView.setLayoutParams(pic_GridView_param);
	    gridView.setNumColumns(6);
	    gridView.setColumnWidth((int)(DensityUtil.dip2px(context,40) * pro));
	    gridView.setHorizontalSpacing((int)(DensityUtil.dip2px(context,10) * pro));
	    gridView.setVerticalSpacing((int)(DensityUtil.dip2px(context,10) * pro));
	    this.addView(gridView);
	    
	}

}
