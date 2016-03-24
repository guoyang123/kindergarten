package com.kinder.setpsw.customviews;

import android.content.Context;
import android.widget.Toast;

import cn.kinder.util.MD5;

import com.kinder.forgetpsw.viewsxml.ForgetPswWrapXml;
import com.kinder.setpsw.viewsxml.SetPswWrapXml;

public class SetPswWrapXmlView extends SetPswWrapXml {

	private Context context;
	public SetPswWrapXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	
	public String getPsw()
	{
		String psw=this.phone_EditText.getText().toString();
		String confirmpsw=this.confirmpsw_EditText.getText().toString();
		if(psw==null||psw.equals(""))
		{
			Toast.makeText(context, "密码不能为空", 0).show();
			return null;
		}
		
		if(confirmpsw==null||confirmpsw.equals(""))
		{
			Toast.makeText(context, "确认密码不能为空", 0).show();
			return null;
		}
		
		if(psw.length()!=6)
		{
			Toast.makeText(context, "密码需为6位数字", 0).show();
			return null;
		}
		
		if(!psw.equals(confirmpsw))
		{
			Toast.makeText(context, "密码与确认密码不一致", 0).show();
			return null;
		}
		psw=MD5.string2MD5(psw);//13672138493
		return psw;
	}
	
}
