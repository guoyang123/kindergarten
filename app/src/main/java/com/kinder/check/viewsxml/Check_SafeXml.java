package com.kinder.check.viewsxml;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.check.customviews.Check_LeaveSexXmlView;
import com.myt360.app.customviews.CircularImage;
import com.myt360.app.customviews.MyRelativeLayout;

public class Check_SafeXml extends MyRelativeLayout {

	public CircularImage baby_CircularImage;
	public TextView name_TextView;
	public Check_LeaveSexXmlView sexView;
	public TextView desc_TextView;
	public TextView safecode_TextView;
	public Check_SafeXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		
		baby_CircularImage=productCircularImage(context, pro, 3651,
				60, 60,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0, 
				0, 0, 0, 0,
				10, 0, 0, 0, this);
		baby_CircularImage.setImageResource(R.getRCode("drawable", "user_default"));
		name_TextView=productTextView(context, pro, 3652,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, baby_CircularImage.getId(), 0, 0,
				0, 0, 0,
				8, 13, 0, 0, 
				"姓名:张鹏   爷爷", 12, "#3c3c3c", this);
		
		
		sexView=new Check_LeaveSexXmlView(context,pro,screenW,screenH);
		sexView.setId(3653);
		LayoutParams sexView_param=new LayoutParams
				(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		sexView_param.addRule(RelativeLayout.BELOW,name_TextView.getId());
		sexView_param.addRule(RelativeLayout.RIGHT_OF,baby_CircularImage.getId());
		sexView_param.setMargins((int)(DensityUtil.dip2px(context,8) * pro), (int)(DensityUtil.dip2px(context,12) * pro), 0, 0);
		sexView.setLayoutParams(sexView_param);
		this.addView(sexView);
		
		
		desc_TextView=productTextView(context, pro, 3654,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, baby_CircularImage.getId(), 0, sexView.getId(), 
				0, 0, 0,
				8, 10, 0, 0, 
				"接送密码:", 12, "#797979", this);
		
		safecode_TextView=productTextView(context, pro, 3655,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, desc_TextView.getId(), 0, sexView.getId(),
				0, 0, 0,
				8, 10, 0, 0, 
				"1234", 12, "#6ccfa9", this);
	}

}
