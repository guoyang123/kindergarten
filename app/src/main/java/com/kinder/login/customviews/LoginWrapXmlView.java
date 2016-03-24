package com.kinder.login.customviews;


import android.content.Context;
import android.widget.Toast;
import cn.kinder.util.MD5;

import com.kinder.login.viewsxml.LoginWrapXml;

public class LoginWrapXmlView extends LoginWrapXml {

	private Context context;
	public LoginWrapXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.usernameView.phone_EditText.setHint("请输入手机号");
		this.pswView.phone_EditText.setHint("请输入密码");
//		this.pswView.phone_EditText.setText("000000");
		this.pswView.icon_ImageView.setImageResource(R.getRCode("drawable", "psw_icon"));
		this.usernameView.icon_ImageView.setImageResource(R.getRCode("drawable", "username_icon1"));//username_icon
		
	}

	
	public void setListener(OnClickListener onClickListener)
	{
		this.usernameView.setListener(onClickListener);
		this.pswView.setListener(onClickListener);
	    
	}
	
	/**获取手机号密码*/
	public String[] getInfos()
	{
		String[] infos=new String[2];
		String phone=this.usernameView.phone_EditText.getText().toString();
		String psw=this.pswView.phone_EditText.getText().toString();
		
		if(phone==null||phone.equals(""))
		{
			Toast.makeText(context, "手机号不能为空", 0).show();
			return null;
		}
		if(psw==null||psw.equals(""))
		{
			Toast.makeText(context, "密码不能为空", 0).show();
			return null;
		}
		infos[0]=phone;
		psw=MD5.string2MD5(psw);
		
		//psw=psw.substring(7, 23);
		infos[1]=psw;
		return infos;
	}
}
