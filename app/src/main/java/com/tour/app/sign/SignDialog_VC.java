package com.tour.app.sign;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import cn.kinder.bean.BabyModel;

import com.myt360.kindergarten.R;

public class SignDialog_VC extends SignDialog_BC implements View.OnClickListener,OnItemClickListener
{

	//private static  CalendarDialog_VC calendarDialog;
	private float pro,screenW,screenH;
	private Context context;
	
	/**
	 * @param isjoin 1:参加 2：不参加
	 * 
	 * */
	public SignDialog_VC(Context context,float pro,float screenW,float screenH,List<BabyModel> models,String isjoin) 
	{
	//	super(context);
		super(context);//, R.style.Transparent
		this.context=context;
		this.pro=pro;
		this.screenW=screenW;
		this.screenH=screenH;
		this.models=models;
		this.isjoin=isjoin;
		Window w=this.getWindow();
		w.setGravity(Gravity.CENTER);
	//	w.setWindowAnimations(R.style.mystyle);
		 this.show();
		 //宽度全屏
//		 WindowManager.LayoutParams lp = this.getWindow().getAttributes();
//		 lp.width = (int)(screenW); //设置宽度
//		 this.getWindow().setAttributes(lp);
		 w.setBackgroundDrawableResource(R.drawable.sign_coner);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new SignDialog_MainViewXmlView(context,pro,screenW,screenH);
		mainView.setListener(this,this);
		mainView.setDatas(models);
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
			if(signDialogListener!=null)
			{
				signDialogListener.onClickBtn(logic_SureBtn());
				dismiss();
			}
		}else if(id==mainView.cancel_Button.getId())
		{
			dismiss();
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		BabyModel model=this.models.get(position);
		model.setSelected(!model.isSelected());
		mainView.adapter.notifyDataSetChanged();
	}
}
