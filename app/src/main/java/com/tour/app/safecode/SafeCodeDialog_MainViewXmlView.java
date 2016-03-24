package com.tour.app.safecode;

import cn.kinder.util.MethodUtils;
import android.content.Context;
import android.widget.Toast;

public class SafeCodeDialog_MainViewXmlView extends SafeCodeDialog_MainViewXml {

	private Context context;
	public SafeCodeDialog_MainViewXmlView(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	/**设置监听*/
	public void setListener(OnClickListener listener)
	{
		this.sure_Button.setOnClickListener(listener);
		this.cancel_Button.setOnClickListener(listener);
	}

	public void initViewData(String safecode) {
		// TODO Auto-generated method stub
		this.code_TextView.setText("安全接送密码:"+safecode);
	}
	
	/**获取安全码以及手机号*/
	public String[] getCodeAndPhone()
	{
		String[] str=new String[2];
		String code=this.code_TextView.getText().toString();
		code=code.substring((code.indexOf(":")+1), code.length());
		String phone=this.phone_EditText.getText().toString();
		if(code==null||code.equals(""))
		{
			Toast.makeText(context, "安全码获取失败", 0).show();
			return null;
		}
		if(phone==null||phone.equals(""))
		{
			Toast.makeText(context, "手机号必填", 0).show();
			return null;
		}
		if(!MethodUtils.isMobileNO(phone))
		{
			Toast.makeText(context, "手机号格式错误", 0).show();
			return null;
		}
		str[0]=code;
		str[1]=phone;
		return str;
	}
}
