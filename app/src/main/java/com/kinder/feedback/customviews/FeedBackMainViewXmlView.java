package com.kinder.feedback.customviews;

import android.content.Context;

import com.kinder.feedback.viewsxml.FeedBackMainViewXml;

public class FeedBackMainViewXmlView extends FeedBackMainViewXml 
{

	public FeedBackMainViewXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	
	/**设置监听*/
	public void setListener(OnClickListener onClickListener)
	{
		this.titleBarView.leftBtn.setOnClickListener(onClickListener);
		this.submit_Button.setOnClickListener(onClickListener);
	}


	public String getFeedText() {
		// TODO Auto-generated method stub
		String text=this.feedback_EditText.getText().toString();
		if(text!=null&&!text.equals(""))
		{
			return text;
		}
		return null;
	}
}
