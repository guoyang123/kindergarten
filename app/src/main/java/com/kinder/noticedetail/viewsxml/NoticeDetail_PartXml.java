package com.kinder.noticedetail.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.myt360.app.customviews.MyRelativeLayout;

public class NoticeDetail_PartXml extends MyRelativeLayout {

	public TextView people_TextView;
	public GridView gridView;
	public NoticeDetail_PartXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		people_TextView=productTextView(context, pro, 5431,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, 0, 0, 0, 
				0, CENTER_HORIZONTAL, 0, 
				0, 3, 0, 0,
				"", 12, "#545454", this);
		View view=productView(context, pro, 5432,
				LayoutParams.MATCH_PARENT, 1, 
				0, 0, 0, people_TextView.getId(), 
				0, 0, 0,
				0, 0, 0, 0, 
				10, 10, 10, 0, this);
		view.setBackgroundColor(Color.parseColor("#dadada"));
		
		gridView=new GridView(context);//ForbidScroll
		gridView.setId(5433);
	    LayoutParams pic_GridView_param=getParam(context, pro, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
	    pic_GridView_param.addRule(RelativeLayout.BELOW,view.getId());
	    pic_GridView_param.setMargins((int)(DensityUtil.dip2px(context,3) * pro), 
	    		(int)(DensityUtil.dip2px(context,10) * pro),(int)(DensityUtil.dip2px(context,3) * pro), 0);
	    gridView.setLayoutParams(pic_GridView_param);
	    gridView.setNumColumns(6);
	    gridView.setColumnWidth((int)(DensityUtil.dip2px(context,44) * pro));
	    gridView.setHorizontalSpacing((int)(DensityUtil.dip2px(context,10) * pro));
	    gridView.setVerticalSpacing((int)(DensityUtil.dip2px(context,10) * pro));
	    this.addView(gridView);
	    //gridView.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
		
	}

}
