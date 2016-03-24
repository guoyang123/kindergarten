package com.kinder.noticedetail.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;

import com.myt360.app.customviews.MyRelativeLayout;

public class NoticeDetail_BottomXml extends MyRelativeLayout {

	
	public Button nopart_Button;
	public Button part_Button;
	
	public NoticeDetail_BottomXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		
		nopart_Button=productButton(context, pro, 5451,
				160, 42,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0,
				"不参加", 13, "#ffffff", this);
		nopart_Button.setBackgroundColor(Color.parseColor("#dcdcdc"));
		
		part_Button=productButton(context, pro, 5452,
				160, 42,
				0, nopart_Button.getId(), 0, 0,
				0, 0, 0,
				0, 0, 0, 0,
				"参加", 13, "#ffffff", this);
		part_Button.setBackgroundColor(Color.parseColor("#6ccfa9"));
		
		
	}

}
