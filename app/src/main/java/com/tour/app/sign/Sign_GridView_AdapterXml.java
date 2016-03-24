package com.tour.app.sign;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

/**发现页面，GridView的适配器布局*/
public class Sign_GridView_AdapterXml extends MyRelativeLayout {
	public ImageView photo_ImageView;
	public ImageView icon_ImageView;
	public TextView name_TextView;
	public Sign_GridView_AdapterXml(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		this.setId(1250);
		
		photo_ImageView=productImageView(context, pro, 1251,
				40, 40, 
				0, 0, 0, 0, 
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		photo_ImageView.setScaleType(ScaleType.CENTER_CROP);
		photo_ImageView.setImageBitmap(getBitmapFromCache(context, "user_default"));
		
		icon_ImageView=productImageView(context, pro, 1252,
				12, 12, 
				0, 0, 0, 0, 
				0, 0, 0,
				0, ALIGN_PARENT_RIGHT, 0, 0,
				0, 8, 0, 0, this);
		icon_ImageView.setImageResource(R.getRCode("drawable", "baby_unselected"));
	//	icon_ImageView.setScaleType(ScaleType.CENTER_CROP);
		//icon_ImageView.setVisibility(View.GONE);
		name_TextView=productTextView(context, pro, 1253,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, photo_ImageView.getId(),
				0, CENTER_HORIZONTAL, 0, 
				0, 5, 0, 0, 
				"", 12, "#545454", this);
	}

}
