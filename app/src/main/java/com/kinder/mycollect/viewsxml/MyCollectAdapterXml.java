package com.kinder.mycollect.viewsxml;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.parent.customviews.ParentCollectWrapXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class MyCollectAdapterXml extends MyRelativeLayout {

	
	public ImageView thumb_ImageView;
	public TextView title_TextView;
	public TextView author_TextView;
	public TextView time_TextView;
	public ParentCollectWrapXmlView collectwrapview;
	public MyCollectAdapterXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		

		RelativeLayout wrap=productRelativeLayout(context, pro, 5221,
				LayoutParams.MATCH_PARENT, 80,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0, this);
		
		thumb_ImageView=productImageView(context, pro, 5222,
				100, 65,
				0, 0, 0, 0,
				CENTER_VERTICAL, 0, 0,
				0, 0, 0, 0,
				11, 0, 0, 0, wrap);
		thumb_ImageView.setScaleType(ScaleType.CENTER_CROP);
		thumb_ImageView.setImageResource(R.getRCode("drawable", "buzz_ppt_default"));
		//thumb_ImageView.setImageBitmap(getBitmapFromCache(context, "user_default"));
		title_TextView=productTextView(context, pro, 5223,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, thumb_ImageView.getId(), 0, 0,
				0, 0, 0,
				20, 7, 0, 0,
				"", 13, "#3c3c3c", wrap);
		title_TextView.setLines(2);
		title_TextView.setEllipsize(TruncateAt.END);
		author_TextView=productTextView(context, pro, 5224,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, thumb_ImageView.getId(), 0, 0,
				0, 0, 0,
				0,0,0,ALIGN_PARENT_BOTTOM,
				20, 0, 0, 10,
				"", 10, "#797979", wrap);
		
		time_TextView=productTextView(context, pro, 5225,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, thumb_ImageView.getId(), author_TextView.getId(), title_TextView.getId(),
				0, 0, 0,
				0,0,0,0,
				20, 0, 0, 0,
				"", 10, "#797979", wrap);
		
		collectwrapview=new ParentCollectWrapXmlView(context,pro,screenW,screenH);
		collectwrapview.setId(5226);
		LayoutParams collectwrapview_param=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		collectwrapview_param.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		collectwrapview_param.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		collectwrapview_param.setMargins(0, 0, (int)(DensityUtil.dip2px(context,10) * pro), (int)(DensityUtil.dip2px(context,10) * pro));
		collectwrapview.setLayoutParams(collectwrapview_param);
		wrap.addView(collectwrapview);
		
	}

}
