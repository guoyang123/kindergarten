package com.kinder.parent.viewsxml;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

public class ParentCollectWrapXml extends MyRelativeLayout {

	public ImageView collect_ImageView;
	public TextView count_TextView;
	public ParentCollectWrapXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		collect_ImageView=productImageView(context, pro, 5601,
				12, 12,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		collect_ImageView.setImageResource(R.getRCode("drawable", "parent_collect"));
		count_TextView=productTextView(context, pro, 5602,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, collect_ImageView.getId(), 0, 0,
				CENTER_VERTICAL, 0, 0,
				5, 0, 0, 0, 
				"10", 9, "#797979", this);
	}

}
