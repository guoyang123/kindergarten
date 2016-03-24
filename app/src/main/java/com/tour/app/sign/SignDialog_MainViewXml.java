package com.tour.app.sign;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.myt360.app.customviews.MyRelativeLayout;

public class SignDialog_MainViewXml extends MyRelativeLayout {

	public GridView gridView;
	public Button cancel_Button;
	public Button sure_Button;
	public SignDialog_MainViewXml(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
	
	// this.setLayoutParams(getParam(context, pro, LayoutParams.MATCH_PARENT, 160));
	 	
	 RelativeLayout wrap=productRelativeLayout(context, pro, 2381,
			 260, 150,
			 0, 0, 0, 0, 
			 0, 0, 0, 
			 0, 0, 0, 0, 
			 0, 0, 0, 0, this);
	 //wrap.setBackgroundResource(R.getRCode("drawable", "sign_coner"));
		
	 
	 
	 
	    gridView=new GridView(context);//ForbidScroll
		gridView.setId(2382);
	    LayoutParams pic_GridView_param=getParam(context, pro, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	    //pic_GridView_param.addRule(RelativeLayout.BELOW,view.getId());
	    pic_GridView_param.setMargins((int)(DensityUtil.dip2px(context,10) * pro), 
	    		(int)(DensityUtil.dip2px(context,10) * pro),(int)(DensityUtil.dip2px(context,10) * pro), 0);
	    gridView.setLayoutParams(pic_GridView_param);
	    gridView.setNumColumns(4);
	    gridView.setColumnWidth((int)(DensityUtil.dip2px(context,45) * pro));
	    gridView.setHorizontalSpacing((int)(DensityUtil.dip2px(context,20) * pro));
	    gridView.setVerticalSpacing((int)(DensityUtil.dip2px(context,10) * pro));
	    wrap.addView(gridView);
	
	 
	 cancel_Button=productButton(context, pro, 2383,
			 130, 30,
			 0, 0, 0, 0,
			 0, 0, 0,
			 0,0,0,ALIGN_PARENT_BOTTOM,
			 0, 0, 0, 0, 
			 "取消", 12, "#ffffff", wrap);
	// cancel_Button.setBackgroundColor(Color.parseColor("#dcdcdc"));
	 cancel_Button.setBackgroundResource(R.getRCode("drawable", "sign_cancel_coner"));
	 
	 sure_Button=productButton(context, pro, 2384,
			 130, 30,
			 0, cancel_Button.getId(), 0, 0,
			 0, 0, 0,
			 0,0,0,ALIGN_PARENT_BOTTOM,
			 0, 0, 0, 0, 
			 "确定", 12, "#ffffff", wrap);
	 sure_Button.setBackgroundResource(R.getRCode("drawable", "sign_sure_coner"));
	 
	
	}

}
