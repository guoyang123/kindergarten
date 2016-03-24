package com.kinder.forgetpsw.customviews;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.widget.Toast;
import cn.kinder.util.MD5;
import cn.kinder.util.MethodUtils;

import com.kinder.forgetpsw.viewsxml.ForgetPswWrapXml;

public class ForgetPswWrapXmlView extends ForgetPswWrapXml {

	private Context context;
	private boolean isClick=true;
	private int leaveTime=60;
	public ForgetPswWrapXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	
	private Handler mHandler=new Handler()
	{
		public void handleMessage(android.os.Message msg) 
		{
			switch(msg.what)
			{
			case 100:
				leaveTime--;
				getVertify_Button.setText(String.valueOf(leaveTime)+"秒");
				if(leaveTime<=0)
				{
					isClick=true;
					leaveTime=60;
					getVertify_Button.setClickable(true);
					setBtnStatus(isClick);
				}
			
				break;
			}
		};
	};

	


	/**改变验证码按钮状态*/
	public void setBtnStatus(final boolean isClic)
	{
		this.isClick=isClic;
		if(!isClick)//不可点击
		{
			this.getVertify_Button.setClickable(false);
			this.getVertify_Button.setBackgroundColor(Color.parseColor("#8e8e8e"));
		     new Timer().schedule(new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(!isClick)
					{
						mHandler.sendEmptyMessage(100);
					}
					
				}
			}, 0, 1000);
		     
		}else//可点击
		{
			this.getVertify_Button.setClickable(true);
			this.getVertify_Button.setBackgroundResource(R.getRCode("drawable", "getvcard_coner"));
			this.getVertify_Button.setText("获取验证码");
		    
		}
	}
	
	/**点击注册后信息验证*/
	public String checkInfo(String code)
	{
		//判断验证码输入是否正确
		String vertify=this.vertify_EditText.getText().toString();
		if(vertify!=null&&!vertify.equals(""))
		{
			vertify=vertify.toUpperCase();
			 String vertify1=MD5.string2MD5(vertify);
			 if(vertify1.equals(code))
			 {
				 return vertify;
			 }else
			 {
					Toast.makeText(context, "输入的验证码不正确", 0).show();
					return null;
			}
			
		}else
		{
			Toast.makeText(context, "请输入验证码", 0).show();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**设置监听*/
	public void setListener(OnClickListener onClickListener)
	{
		this.getVertify_Button.setOnClickListener(onClickListener);
	}
	/**获取手机号*/
	public String getPhone()
	{
		String phone=this.phone_EditText.getText().toString();
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
		return phone;
	}
}
