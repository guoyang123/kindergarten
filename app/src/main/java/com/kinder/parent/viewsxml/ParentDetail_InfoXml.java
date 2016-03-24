package com.kinder.parent.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

import com.myt360.app.customviews.MyRelativeLayout;

public class ParentDetail_InfoXml extends MyRelativeLayout {

	public TextView title_TextView;
	public TextView desc_TextView;
	public ParentDetail_InfoXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		title_TextView=productTextView(context, pro, 5321,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, 0, 0, 0,
				0, 0, 0,
				11, 10, 11, 0,
				"", 13, "#3c3c3c", this);
		
		desc_TextView=productTextView(context, pro, 5322,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, 0, 0, title_TextView.getId(),
				0, 0, 0,
				11, 4, 11, 0,
				"", 10, "#797979", this);
		//、、
	  View view=productView(context, pro, 5323,
			  LayoutParams.MATCH_PARENT, 1,
			  0, 0, 0, desc_TextView.getId(),
			  0, 0, 0,
			  0, 0, 0, 0,
			  11, 10, 11, 0, this);
	  view.setBackgroundColor(Color.parseColor("#e3e3e3"));
	}

}
