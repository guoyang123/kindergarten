package com.kinder.app.loading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myt360.kindergarten.KinderApplication;

@SuppressLint("ValidFragment") public class Buzz_LoadingDialog extends DialogFragment {

	public static Buzz_LoadingDialog dialog;
	public LoadingXmlView loading_mainview ;
	private KinderApplication local;
	private Context context;
	
	 public Buzz_LoadingDialog(Context context,KinderApplication local)
     {
	    	this.context=context;
	    	this.local=local;
     }
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		loading_mainview=new LoadingXmlView(getActivity(),local.pro,local.screenW,local.screenH);
		loading_mainview.startLoading();
		getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		
		return loading_mainview;
	}
	
	 public  static  Buzz_LoadingDialog newInstance(Context context,KinderApplication local) 
     {
		   	 if(dialog==null)
		   	 {
		   		dialog= new Buzz_LoadingDialog(context,local);
		   		dialog.setStyle(STYLE_NO_TITLE,0);//R.style.dialog
		   	 }
	        return dialog;
	  }
	 
	
	 @Override
	public void dismiss() {
		// TODO Auto-generated method stub
		 try{
			 super.dismiss();
		 }catch(Exception e){}finally{
			 if(loading_mainview!=null){
					loading_mainview.stopLoading();
				} 
		 }
		
		
		
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		loading_mainview.stopLoading();
	}
}
