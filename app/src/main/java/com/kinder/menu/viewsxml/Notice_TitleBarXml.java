package com.kinder.menu.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.myt360.app.customviews.MyRelativeLayout;
import com.myt360.app.customviews.TextButton;

public class Notice_TitleBarXml extends MyRelativeLayout {

       public 	RelativeLayout root_wrap;
	    //左侧按钮
		public Button leftBtn;
		public ImageView search_ImageView;
		//中间文本
		public EditText search_EditText;
		//右侧按钮
		public Button rightBtn;
		
	public Notice_TitleBarXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		RelativeLayout wrap=productRelativeLayout(context, pro, 571,
				LayoutParams.MATCH_PARENT, 44,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, this);
		wrap.setBackgroundColor(Color.parseColor("#6ccfa9"));
		
		
	    rightBtn=new TextButton(context);
	    rightBtn.setId(572);
	    LayoutParams rightBtn_params=new LayoutParams(LayoutParams.WRAP_CONTENT,(int)(DensityUtil.dip2px(context,44) * pro));
	    rightBtn_params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
	    rightBtn.setLayoutParams(rightBtn_params);
	    rightBtn.setText("搜索");
	    rightBtn.setTextColor(Color.parseColor("#ffffff"));
	    rightBtn.setTextSize((int)14*pro);
	    rightBtn.setGravity(Gravity.CENTER_VERTICAL);
	    rightBtn.setBackgroundColor(Color.parseColor("#6dcfa9"));
	    wrap.addView(rightBtn);

		
		 root_wrap=productRelativeLayout(context, pro, 573,
				LayoutParams.MATCH_PARENT, 30, 
				rightBtn.getId(), 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0,
				11, 0, 0, 0, wrap);
		root_wrap.setBackgroundResource(R.getRCode("drawable", "search_coner"));
		
		  // rightBtn.setBackgroundResource(R.getRCode("drawable", "home_search_selector"));
			  
		search_ImageView=productImageView(context, pro, 574,
				30, 30,
				0, 0, 0, 0, 
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, root_wrap);
		search_ImageView.setImageResource(R.getRCode("drawable", "home_search_selector"));
		search_EditText=productEditText(context, pro, 575,
				LayoutParams.MATCH_PARENT, 30,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				30, 0, 0, 0,
				"", 12, "#ffffff", root_wrap, false);
		search_EditText.setHint("请输入关键字搜索");
		search_EditText.setHintTextColor(Color.parseColor("#ffffff"));
		search_EditText.setBackgroundColor(Color.parseColor("#ffffff"));
		search_EditText.setGravity(Gravity.CENTER_VERTICAL);
	}

}
