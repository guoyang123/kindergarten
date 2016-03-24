package com.tour.app.sign;

import java.util.ArrayList;
import java.util.List;

import com.kinder.notice.model.JoinModel;

import cn.kinder.bean.BabyModel;
import android.app.Dialog;
import android.content.Context;

public abstract class SignDialog_BC extends Dialog {

	protected List<BabyModel> models;
	protected String isjoin;
	public SignDialog_BC(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
	}

//	protected CalendarDialog_MainViewXmlView mainView;
	public SignDialog_BC(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	
	protected SignDialog_MainViewXmlView mainView;

	protected SignDialogListener signDialogListener;
	
	public void setSignDialogListener(
			SignDialogListener signDialogListener) {
		this.signDialogListener = signDialogListener;
	}
	
	protected JoinModel logic_SureBtn()
	{
		StringBuffer babys=new StringBuffer();
		List<BabyModel> babyModels=new ArrayList<BabyModel>();
		if(models!=null)
		{
			for(BabyModel model:models)
			{
				boolean isSelect=model.isSelected();
				if(isSelect)
				{
					babys.append(","+model.getBabyid());
					babyModels.add(model);
				}
			}
			String babystr=babys.toString();
			if(babystr!=null&&!babystr.equals(""))
			{
				return new JoinModel(isjoin,babystr.substring(1, babystr.length()),babyModels);
			}			
		}
		return null;
	}
	

}
