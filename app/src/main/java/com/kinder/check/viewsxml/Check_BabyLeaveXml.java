package com.kinder.check.viewsxml;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.check.customviews.Check_LeaveSexXmlView;
import com.myt360.app.customviews.CircularImage;
import com.myt360.app.customviews.MyRelativeLayout;


public class Check_BabyLeaveXml extends MyRelativeLayout {

	public CircularImage baby_CircularImage;
	public TextView name_TextView;
	public Check_LeaveSexXmlView sexView;
	public TextView leave_TextView;
	public TextView desc_TextView;
	
	public Check_BabyLeaveXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		baby_CircularImage=productCircularImage(context, pro, 3601,
				60, 60,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0, 
				0, 0, 0, 0,
				10, 0, 0, 0, this);
		baby_CircularImage.setImageResource(R.getRCode("drawable", "user_default"));
		name_TextView=productTextView(context, pro, 3602,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, baby_CircularImage.getId(), 0, 0,
				0, 0, 0,
				8, 13, 0, 0, 
				"", 12, "#3c3c3c", this);
		
		
		sexView=new Check_LeaveSexXmlView(context,pro,screenW,screenH);
		sexView.setId(3603);
		LayoutParams sexView_param=new LayoutParams
				(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		sexView_param.addRule(RelativeLayout.RIGHT_OF,name_TextView.getId());
		sexView_param.setMargins((int)(DensityUtil.dip2px(context,20) * pro), (int)(DensityUtil.dip2px(context,12) * pro), 0, 0);
		sexView.setLayoutParams(sexView_param);
		this.addView(sexView);
		
		
		leave_TextView=productTextView(context, pro, 3604,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, baby_CircularImage.getId(), 0, 0,
				CENTER_VERTICAL, CENTER_HORIZONTAL, CENTER_IN_PARENT,
				8, 8, 0, 0,
				"", 12, "#6ccfa9", this);
		
		desc_TextView=productTextView(context, pro, 3605,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, baby_CircularImage.getId(), 0, leave_TextView.getId(), 
				0, 0, 0,
				8, 10, 0, 0, 
				"", 12, "#797979", this);
	}

}
