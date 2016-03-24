package com.kinder.perfect.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.myt360.app.customviews.MyRelativeLayout;

public class PerfectNameInfoXml extends MyRelativeLayout 
{

	public EditText name_EditText;
	public Button del_Button;
	public PerfectNameInfoXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.parseColor("#ffffff"));
		
		
		del_Button=productButton(context, pro, 471,
				44, 44,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0,ALIGN_PARENT_RIGHT,0,0,
				0, 0, 0, 0,
				"", 0, null, this);
		del_Button.setBackgroundResource(R.getRCode("drawable", "del_selector"));
		
		name_EditText=productEditText(context, pro, 472, 
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				del_Button.getId(), 0, 0, 0, 
				0, 0, 0,
				0, 0, 0, 0, 
				"姓名", 14, "#313131", this, false);
		name_EditText.setPadding((int)(DensityUtil.dip2px(context,20) * pro), 0, 0, 0);
		name_EditText.setGravity(Gravity.CENTER_VERTICAL);
		name_EditText.setBackgroundColor(Color.parseColor("#ffffff"));
	}

}
