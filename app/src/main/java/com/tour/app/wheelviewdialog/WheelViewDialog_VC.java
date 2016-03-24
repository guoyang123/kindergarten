package com.tour.app.wheelviewdialog;

import java.util.List;

import com.myt360.kindergarten.R;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class WheelViewDialog_VC extends WheelViewDialog_BC implements View.OnClickListener
{

	//private static  CalendarDialog_VC calendarDialog;
	private float pro,screenW,screenH;
	private Context context;
	private int operationtype;
	public WheelViewDialog_VC(Context context,float pro,float screenW,float screenH,int operationtype) 
	{
	//	super(context);
		super(context);//, R.style.Transparent
		this.context=context;
		this.pro=pro;
		this.screenW=screenW;
		this.screenH=screenH;
		this.operationtype=operationtype;
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
		mainView=new WheelViewDialog_MainViewXmlView(context,pro,screenW,screenH);
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
		}else if(id==mainView.sure_Button.getId())
		{
			if(wheelViewDialogListener!=null)
			{
				
				int currentItem=mainView.wheel_WheelView.getCurrentItem();
				
				wheelViewDialogListener.onClickBtn(WheelViewDialogListener.SURE_BUTTON,currentItem,operationtype);
			}
			dismiss();
		}
	}
	
	/**设置标题栏颜色*/
	public void setTitle(String text)
	{
		//mainView.setTitle(text);
	}
	/**设置数据
	 * @param <T>*/
	public <T> void setDatas(List<BasicInfoModel> models )
	{
		mainView.setDatas(models);
	}
}
