package com.tour.app.safecode;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.myt360.kindergarten.R;

public class SafeCodeDialog_VC extends SafeCodeDialog_BC implements View.OnClickListener
{

	//private static  CalendarDialog_VC calendarDialog;
	private float pro,screenW,screenH;
	private Context context;
	private String safecode;
	public SafeCodeDialog_VC(Context context,float pro,float screenW,float screenH,String safecode) 
	{
	//	super(context);
		super(context);//, R.style.Transparent
		this.safecode=safecode;
		this.context=context;
		this.pro=pro;
		this.screenW=screenW;
		this.screenH=screenH;
		Window w=this.getWindow();
		w.setGravity(Gravity.CENTER);
		 this.show();
//		 //宽度全屏
//		 WindowManager.LayoutParams lp = this.getWindow().getAttributes();
//		 lp.width = (int)(screenW); //设置宽度
//		 this.getWindow().setAttributes(lp);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new SafeCodeDialog_MainViewXmlView(context,pro,screenW,screenH);
		mainView.setListener(this);
		mainView.initViewData(safecode);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(mainView);
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		if(id==mainView.cancel_Button.getId())
		{
			dismiss();
		}else if(id==mainView.sure_Button.getId())
		{
			if(safeCodeDialogListener!=null)
			{
				
				safeCodeDialogListener.onClickBtn(SafeCodeDialogListener.SURE_BUTTON,mainView.getCodeAndPhone());
				dismiss();
			}
		}
	}
}
