package com.kinder.noticedetail.viewsxml;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

/**发现页面，GridView的适配器布局*/
public class NoticeDetail_GridView_AdapterXml extends MyRelativeLayout {

	public ImageView photo_ImageView;
	public TextView name_TextView;
	public NoticeDetail_GridView_AdapterXml(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		this.setId(1250);
		
		photo_ImageView=productImageView(context, pro, 1251,
				44, 44, 
				0, 0, 0, 0, 
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		photo_ImageView.setScaleType(ScaleType.CENTER_CROP);
		photo_ImageView.setImageBitmap(getBitmapFromCache(context, "user_default"));
		
		name_TextView=productTextView(context, pro, 1252,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, photo_ImageView.getId(),
				0, CENTER_HORIZONTAL, 0, 
				0, 5, 0, 0, 
				"", 12, "#545454", this);
		
	}

}
