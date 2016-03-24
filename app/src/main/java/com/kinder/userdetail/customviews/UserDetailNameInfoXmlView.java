package com.kinder.userdetail.customviews;

import android.content.Context;

import com.kinder.userdetail.viewsxml.UserDetailNameInfoXml;

public class UserDetailNameInfoXmlView extends UserDetailNameInfoXml {

	public UserDetailNameInfoXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	/**数据初始化*/
	public void initData(String string, String username) {
		// TODO Auto-generated method stub
		this.key_TextView.setText(string);
		this.value_EditText.setText(username);
	}

}
