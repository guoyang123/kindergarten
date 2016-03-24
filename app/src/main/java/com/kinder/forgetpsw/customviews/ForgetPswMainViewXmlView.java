package com.kinder.forgetpsw.customviews;

import android.content.Context;

import cn.kinder.util.MethodUtils;

import com.kinder.forgetpsw.viewsxml.ForgetPswMainViewXml;

public class ForgetPswMainViewXmlView extends ForgetPswMainViewXml {

	public ForgetPswMainViewXmlView(Context context, float pro, float screenW,
			float screenH,String type) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		if(type!=null&&!type.equals(""))
		{
			if(type.equals("updatepsw"))
			{
				this.titlebarView.desc_TextView.setText("修改密码");
			}
		}
	}

	/**设置监听*/
	public void setListener(OnClickListener onClickListener)
	{
		this.titlebarView.setListener(onClickListener);
		this.next_Button.setOnClickListener(onClickListener);
		this.wrapView.setListener(onClickListener);
		
	}
	/**获取手机号*/
	public String getPhone()
	{
		
		
		return this.wrapView.getPhone();
	}
	
	/**设置验证码状态*/
	public void setBtnStatus(boolean isClick)
	{
		this.wrapView.setBtnStatus(isClick);
	}
}
