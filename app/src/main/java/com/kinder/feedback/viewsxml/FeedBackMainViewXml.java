package com.kinder.feedback.viewsxml;

import android.content.Context;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.kinder.feedback.customviews.FeedBackTitleBarXmlView;
import com.myt360.app.customviews.MyRelativeLayout;

public class FeedBackMainViewXml extends MyRelativeLayout {

	public FeedBackTitleBarXmlView titleBarView;
	public EditText feedback_EditText;
    public Button submit_Button;
	public FeedBackMainViewXml(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		
		titleBarView=new FeedBackTitleBarXmlView(context,pro,screenW,screenH);
		titleBarView.setId(3200);
		LayoutParams titleBarView_param=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		titleBarView.setLayoutParams(titleBarView_param);
		this.addView(titleBarView);
		
		
		feedback_EditText=productEditText(context, pro, 3251,
				290, 165,
				0, 0, 0, titleBarView.getId(),
				0, CENTER_HORIZONTAL, 0,
				0, 10, 0, 0,
				"", 20, "#333333", this, false);
		feedback_EditText.setBackgroundResource(R.getRCode("drawable", "coner"));
		feedback_EditText.setGravity(Gravity.TOP);
	
		submit_Button=productButton(context, pro, 103,
				260, 36, 
				0, 0, 0, feedback_EditText.getId(),
				0, CENTER_HORIZONTAL, 0,
				0, 20, 0, 0,
				"提交", 14, "#ffffff", this);
		submit_Button.setBackgroundResource(R.getRCode("drawable", "userlogin_selector"));
		
	}

}
