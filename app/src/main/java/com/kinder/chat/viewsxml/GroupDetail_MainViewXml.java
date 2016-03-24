package com.kinder.chat.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.kinder.chat.customviews.GroupDetail_GroupInfoXmlView;
import com.kinder.chat.customviews.GroupDetail_TitleBarXmlView;
import com.kinder.chat.customviews.GroupDetail_UsersWrapXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class GroupDetail_MainViewXml extends MyRelativeLayout {

	public GroupDetail_TitleBarXmlView titleBarView;
	public GroupDetail_UsersWrapXmlView userswrapview;
	public GroupDetail_GroupInfoXmlView groupnameview;
	public GroupDetail_GroupInfoXmlView groupuserview;
	public GroupDetail_GroupInfoXmlView groupdescview;
	public Button exit_Button;
	public GroupDetail_MainViewXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		
		titleBarView=new GroupDetail_TitleBarXmlView(context,pro,screenW,screenH);
		titleBarView.setId(171);
		LayoutParams titleBarView_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		titleBarView.setLayoutParams(titleBarView_params);
		this.addView(titleBarView);
		
		ScrollView scroll=productScrollView(context, pro, 172,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0,titleBarView.getId() ,
				0, 0, 0,
				0, 0, 0, 10, this);
		scroll.setBackgroundColor(Color.parseColor("#f0f0f0"));
		RelativeLayout wrap=productRelativeLayout(context, pro, 173,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, scroll);
		
		userswrapview=new GroupDetail_UsersWrapXmlView(context,pro,screenW,screenH);
		userswrapview.setId(174);
		LayoutParams userswrapview_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		userswrapview.setLayoutParams(userswrapview_params);
		wrap.addView(userswrapview);
		
		
		groupnameview=new GroupDetail_GroupInfoXmlView(context,pro,screenW,screenH);
		groupnameview.setId(175);
		LayoutParams groupnameview_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		groupnameview_params.addRule(RelativeLayout.BELOW,userswrapview.getId());
		groupnameview.setLayoutParams(groupnameview_params);
		wrap.addView(groupnameview);
		
		groupuserview=new GroupDetail_GroupInfoXmlView(context,pro,screenW,screenH);
		groupuserview.setId(176);
		LayoutParams groupuserview_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		groupuserview_params.addRule(RelativeLayout.BELOW,groupnameview.getId());
		groupuserview.setLayoutParams(groupuserview_params);
		wrap.addView(groupuserview);
////		
		groupdescview=new GroupDetail_GroupInfoXmlView(context,pro,screenW,screenH);
		groupdescview.setId(177);
		LayoutParams groupdescview_params = new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		groupdescview_params.addRule(RelativeLayout.BELOW,groupuserview.getId());
		groupdescview.setLayoutParams(groupdescview_params);
		wrap.addView(groupdescview);
////		
		exit_Button=productButton(context, pro, 178,
				260, 44,
				0, 0, 0, groupdescview.getId(), 
				0, CENTER_HORIZONTAL, 0, 
				0, 65, 0, 0,
				"删除并退出", 14, "#ffffff", wrap);
		exit_Button.setBackgroundResource(R.getRCode("drawable", "exitgroup_selector"));
//	
	}

}
