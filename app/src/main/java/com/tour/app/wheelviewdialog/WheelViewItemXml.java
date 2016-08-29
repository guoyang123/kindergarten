package com.tour.app.wheelviewdialog;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

public class WheelViewItemXml extends MyRelativeLayout {

	public TextView desc_TextView;

	public WheelViewItemXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.setId(2500);
		desc_TextView=productTextView(context, pro, 2551,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				"", 16, "#ffffff", this);
		
	}
	
	

}
