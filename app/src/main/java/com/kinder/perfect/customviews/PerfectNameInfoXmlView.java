package com.kinder.perfect.customviews;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

import com.kinder.perfect.viewsxml.PerfectNameInfoXml;

public class PerfectNameInfoXmlView  extends PerfectNameInfoXml{

	public PerfectNameInfoXmlView(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.del_Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				name_EditText.setText("");
			}
		});
	}
	
	public void setListener(OnClickListener onClickListener  )
	{
		this.del_Button.setOnClickListener(onClickListener);
	}

	/**数据初始化*/
	public void initData(String username) {
		// TODO Auto-generated method stub
		this.name_EditText.setText(username);
	}

	
	
	
}
