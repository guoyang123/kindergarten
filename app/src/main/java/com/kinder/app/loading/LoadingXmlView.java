package com.kinder.app.loading;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

/**
 * 
 * 加载视图
 * 
 * 
 * */
public class LoadingXmlView extends LoadingXml {

	private Context context;
	private Animation operatingAnim ;
	public LoadingXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		this.context=context;
		
	}
	
	/**
	 * 
	 * 
	 * loading动画开始
	 * 
	 * */
	public void startLoading(){
		new CustomThread().start();
		
	}
	
	/**
	 * 
	 * 子线程
	 * 
	 * 
	 * */
	
	public class CustomThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			 operatingAnim = AnimationUtils.loadAnimation(context, com.myt360.kindergarten.R.anim.route);  
				LinearInterpolator lin = new LinearInterpolator();  
				operatingAnim.setInterpolator(lin); 
				if(operatingAnim!=null){
					loading.startAnimation(operatingAnim);
				}
			
			
		}
	}
	
	
	/**
	 * 
	 * 结束动画
	 * 
	 * */
	public void stopLoading(){
		this.loading.clearAnimation();
	}
	

}
