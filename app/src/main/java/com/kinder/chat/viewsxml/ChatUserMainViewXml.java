package com.kinder.chat.viewsxml;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import cn.com.iucd.iucdframe.utils.DensityUtil;

import com.kinder.chat.customviews.ChatUser_ChildInfoXmlView;
import com.kinder.chat.customviews.ChatUser_UserInfoXmlView;
import com.kinder.chat.customviews.ChatUsr_TitleBarXmlView;
import com.kinder.chat.customviews.TeacherInfoXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class ChatUserMainViewXml extends MyRelativeLayout {

	public ChatUsr_TitleBarXmlView titlebarView;
	public ChatUser_UserInfoXmlView userInfoView;
	public RelativeLayout container_RelativeLayout;
//	public ChatUser_ChildInfoXmlView childInfoView;
//	public TeacherInfoXmlView teacherInfoView;
	public RelativeLayout talk_RelativeLayout;
	public ChatUserMainViewXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		titlebarView=new ChatUsr_TitleBarXmlView(context,pro,screenW,screenH);
		titlebarView.setId(3101);
		LayoutParams titlebarView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context,44) * pro));
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		titlebarView.setLayoutParams(titlebarView_param);
		this.addView(titlebarView);
		
		ScrollView scroll=productScrollView(context, pro, 3102,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0,titlebarView.getId() ,
				0, 0, 0,
				0, 0, 0, 10, this);
		scroll.setBackgroundColor(Color.parseColor("#f0f0f0"));
		RelativeLayout wrap=productRelativeLayout(context, pro, 3103,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0, 0, 
				0, 0, 0, 0, scroll);
		
		userInfoView=new ChatUser_UserInfoXmlView(context,pro,screenW,screenH);
		userInfoView.setId(3104);
		LayoutParams userInfoView_param=new LayoutParams
				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		//titlebarView_param.setMargins(0, (int)(DensityUtil.dip2px(context,45) * pro), 0, 0);
		userInfoView.setLayoutParams(userInfoView_param);
		wrap.addView(userInfoView);
		
		
		container_RelativeLayout=productRelativeLayout(context, pro, 3108,
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT,
				0, 0, 0, userInfoView.getId(),
				0, 0, 0,
				0, 0, 0, 0,
				0, 20, 0, 0, wrap);
		
//		childInfoView=new ChatUser_ChildInfoXmlView(context,pro,screenW,screenH);
//		childInfoView.setId(3105);
//		RelativeLayout.LayoutParams childInfoView_param=new RelativeLayout.LayoutParams
//				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
//		childInfoView_param.setMargins(0, (int)(DensityUtil.dip2px(context,20) * pro), 0, 0);
//		childInfoView_param.addRule(RelativeLayout.BELOW,userInfoView.getId());
//		childInfoView.setLayoutParams(childInfoView_param);
//		wrap.addView(childInfoView);
//		childInfoView.setVisibility(View.GONE);
//		
//		
//		teacherInfoView=new TeacherInfoXmlView(context,pro,screenW,screenH);
//		teacherInfoView.setId(3106);
//		RelativeLayout.LayoutParams teacherInfoView_param=new RelativeLayout.LayoutParams
//				(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
//		teacherInfoView_param.setMargins(0, (int)(DensityUtil.dip2px(context,20) * pro), 0, 0);
//		teacherInfoView_param.addRule(RelativeLayout.BELOW,userInfoView.getId());
//		teacherInfoView.setLayoutParams(teacherInfoView_param);
//		wrap.addView(teacherInfoView);
//		
		talk_RelativeLayout=productRelativeLayout(context, pro, 3107,
				290, 40,
				0, 0, 0, container_RelativeLayout.getId(),
				0, CENTER_HORIZONTAL, 0, 
				0, 0, 0, 0,
				0, 20, 0, 0, wrap);
		talk_RelativeLayout.setBackgroundResource(R.getRCode("drawable", "userlogin_selector"));
		
		productTextView(context, pro, 3109,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				0, 0, 0, 0,
				0, 0, CENTER_IN_PARENT,
				0, 0, 0, 0, 
				"聊天", 14, "#ffffff", talk_RelativeLayout);
		
	}

}
