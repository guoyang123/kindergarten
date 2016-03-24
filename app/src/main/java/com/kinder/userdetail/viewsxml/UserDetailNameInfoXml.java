package com.kinder.userdetail.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.myt360.app.customviews.MyRelativeLayout;

public class UserDetailNameInfoXml extends MyRelativeLayout {

	public TextView key_TextView;
	public EditText value_EditText;
	public UserDetailNameInfoXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.parseColor("#ffffff"));
		
		key_TextView=productTextView(context, pro, 501,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0, 
				"姓名", 15, "#3c3c3c", this);
		key_TextView.setPadding((int)(DensityUtil.dip2px(context,20) * pro), 0, 0, 0);
		key_TextView.setGravity(Gravity.CENTER_VERTICAL);
		key_TextView.setBackgroundColor(Color.parseColor("#ffffff"));
		
		
		value_EditText=productEditText(context, pro, 502,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, key_TextView.getId(), 0, 0,
				CENTER_VERTICAL, 0, 0, 
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0, 20, 0,
				"男", 15, "#3c3c3c", this, false,"");
		value_EditText.setGravity(Gravity.RIGHT|Gravity.CENTER_VERTICAL);
		value_EditText.setBackgroundColor(Color.parseColor("#ffffff"));
		
//		value_TextView=productTextView(context, pro, 502,
//				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
//				0, 0, 0, 0,
//				CENTER_VERTICAL, 0, 0,
//				0,ALIGN_PARENT_RIGHT,0,0,
//				0, 0, 18, 0, 
//				"男", 15, "#3c3c3c", this);
		//value_TextView.setPadding((int)(DensityUtil.dip2px(context,20) * pro), 0, 0, 0);
//		value_EditText.setGravity(Gravity.CENTER_VERTICAL);
//		value_EditText.setBackgroundColor(Color.parseColor("#ffffff"));
//		
		
	}

}
