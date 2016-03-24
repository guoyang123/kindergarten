package com.tour.app.camera;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.myt360.kindergarten.R;

public class CameraDialog_VC extends CameraDialog_BC implements View.OnClickListener
{

	//private static  CalendarDialog_VC calendarDialog;
	private float pro,screenW,screenH;
	private Context context;
	
	public CameraDialog_VC(Context context,float pro,float screenW,float screenH) 
	{
	//	super(context);
		super(context);//, R.style.Transparent
		this.context=context;
		this.pro=pro;
		this.screenW=screenW;
		this.screenH=screenH;
		Window w=this.getWindow();
		w.setGravity(Gravity.BOTTOM);
		w.setWindowAnimations(R.style.mystyle);
		 this.show();
		 //宽度全屏
		 WindowManager.LayoutParams lp = this.getWindow().getAttributes();
		 lp.width = (int)(screenW); //设置宽度
		 this.getWindow().setAttributes(lp);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new CameraDialog_MainViewXmlView(context,pro,screenW,screenH);
		mainView.setListener(this);
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
		}else if(id==mainView.camera_Button.getId())
		{
			if(cameraDialogListener!=null)
			{
				cameraDialogListener.onClickBtn(CameraDialogListener.CAMERA_BUTTON);
				dismiss();
			}
		}else if(id==mainView.photo_Button.getId())
		{
			if(cameraDialogListener!=null)
			{
				cameraDialogListener.onClickBtn(CameraDialogListener.PHOTO_BUTTON);
				dismiss();
			}
		}
	}
}
