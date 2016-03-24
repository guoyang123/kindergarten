package com.kinder.parent.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.RelativeLayout;

import com.kinder.parent.customviews.Article_WrapXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class ParentDetail_BottomXml extends MyRelativeLayout {

	
	public Article_WrapXmlView praiseView;
	public Article_WrapXmlView non_praiseView;
	public Article_WrapXmlView collectView;
	public Article_WrapXmlView shareView;
	
	public ParentDetail_BottomXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.parseColor("#ffffff"));
		praiseView=new Article_WrapXmlView(context, pro, screenW, screenH,20,19,"article_praise");
		praiseView.setId(481);
		LayoutParams praiseView_params = new LayoutParams
				(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		praiseView.setLayoutParams(praiseView_params);
		this.addView(praiseView);
		
		
		non_praiseView=new Article_WrapXmlView(context, pro, screenW, screenH,20,19,"article_non_praise");
		non_praiseView.setId(482);
		LayoutParams non_praiseView_params = new LayoutParams
				(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		non_praiseView_params.addRule(RelativeLayout.RIGHT_OF,praiseView.getId());
		non_praiseView.setLayoutParams(non_praiseView_params);
		this.addView(non_praiseView);
		
		
		collectView=new Article_WrapXmlView(context, pro, screenW, screenH,20,19,"article_collect");
		collectView.setId(483);
		LayoutParams collectView_params = new LayoutParams
				(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		collectView_params.addRule(RelativeLayout.RIGHT_OF,non_praiseView.getId());
		collectView.setLayoutParams(collectView_params);
		this.addView(collectView);
		
		
		shareView=new Article_WrapXmlView(context, pro, screenW, screenH,20,20,"article_share");
		shareView.setId(484);
		LayoutParams shareView_params = new LayoutParams
				(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		shareView_params.addRule(RelativeLayout.RIGHT_OF,collectView.getId());
		shareView.setLayoutParams(shareView_params);
		this.addView(shareView);
		
	}

}
