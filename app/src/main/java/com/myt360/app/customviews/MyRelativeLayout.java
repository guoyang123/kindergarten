package com.myt360.app.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.kinder.app.tools.Kinder_Bitmap;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import net.tsz.afinal.FinalBitmap;

import cn.com.iucd.iucdframe.utils.DensityUtil;
import cn.com.iucd.iucdframe.utils.RUtil;

/**
 * 
 * 
 * 用于产生各种控件，将控件的大小以及位置都已确定
 * 
 * */
public class MyRelativeLayout extends RelativeLayout{

	
	protected RUtil R=null;
	public MyRelativeLayout(Context context) {
		super(context);
		 R=new RUtil(context);
		 
		
	}
	public MyRelativeLayout(Context context,float pro,float screenW,float screenH) {
		super(context);
		 R=new RUtil(context);
		 
		
	
	}


	/**
	 * 
	 * 本地图片加入到缓存中
	 * 
	 * 
	 * */
	
	public Bitmap getBitmapFromCache(Context context,String picname){
		 FinalBitmap fb=Kinder_Bitmap.getInstance(context);
		Bitmap bp= fb.getBitmapFromCache(picname);
		if(bp==null)
		{
			 Bitmap bitmap=BitmapFactory.decodeResource(context.getResources(),R.getRCode("drawable", picname));
			 fb.addBitmapToMemoryCache(picname,bitmap );//
			 bp=bitmap;
		}
		   
		    return bp;
	}
	
	

	/*****************************View类*******************************************/
	/**
	 * 生产TextView
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param text 文字
	 * @param size 文字大小
	 * @param color 文字颜色
	 * @param parent 父控件
	 * */
	protected  TextView productTextView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
		int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,String text,int size,String color,RelativeLayout	parent)
	 {
		TextView textView =new TextView(mContext);
		textView.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		textView.setLayoutParams(params);
		//设置TextView的文字 大小 颜色
		setViewTextAttr(pro,textView,text,size,color);
		parent.addView(textView);
		return textView;
	}

	
	protected  MeasureTextView productMeasureTextView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,String text,int size,String color,RelativeLayout	parent)
		 {
			MeasureTextView textView =new MeasureTextView(mContext,pro);
			textView.setId(id);
			LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
			//设置控件的相对位置
			setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
			//设置控件物理间距
			setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
			textView.setLayoutParams(params);
			//设置TextView的文字 大小 颜色
			setViewTextAttr(pro,textView,text,size,color);
			parent.addView(textView);
			return textView;
		}

	//
	protected  TextView productTextView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int ALIGN_PARENT_LEFT,int ALIGN_PARENT_RIGHT,int ALIGN_PARENT_TOP,int ALIGN_PARENT_BOTTOM, int left,int top,int right,int bottom,String text,int size,String color,RelativeLayout	parent)
		 {
			TextView textView =new TextView(mContext);
			textView.setId(id);
			LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
			//设置控件的相对位置
			setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT,ALIGN_PARENT_LEFT,ALIGN_PARENT_RIGHT,ALIGN_PARENT_TOP,ALIGN_PARENT_BOTTOM);
			//设置控件物理间距
			setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
			textView.setLayoutParams(params);
			//设置TextView的文字 大小 颜色
			setViewTextAttr(pro,textView,text,size,color);
			parent.addView(textView);
			return textView;
		}
	protected  TextTextView productTextTextView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int ALIGN_PARENT_LEFT,int ALIGN_PARENT_RIGHT,int ALIGN_PARENT_TOP,int ALIGN_PARENT_BOTTOM, int left,int top,int right,int bottom,String text,int size,String color,RelativeLayout	parent)
		 {
		TextTextView textView =new TextTextView(mContext);
			textView.setId(id);
			LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
			//设置控件的相对位置
			setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT,ALIGN_PARENT_LEFT,ALIGN_PARENT_RIGHT,ALIGN_PARENT_TOP,ALIGN_PARENT_BOTTOM);
			//设置控件物理间距
			setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
			textView.setLayoutParams(params);
			//设置TextView的文字 大小 颜色
			setViewTextAttr(pro,textView,text,size,color);
			parent.addView(textView);
			return textView;
		}

    /**
     * 
     * BetterSpinner
     * */
	protected  BetterSpinner productBetterSpinner(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int ALIGN_PARENT_LEFT,int ALIGN_PARENT_RIGHT,int ALIGN_PARENT_TOP,int ALIGN_PARENT_BOTTOM, int left,int top,int right,int bottom,String text,int size,String color,RelativeLayout	parent)
		 {
		BetterSpinner textView =new BetterSpinner(mContext);
			textView.setId(id);
			LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
			//设置控件的相对位置
			setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT,ALIGN_PARENT_LEFT,ALIGN_PARENT_RIGHT,ALIGN_PARENT_TOP,ALIGN_PARENT_BOTTOM);
			//设置控件物理间距
			setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
			textView.setLayoutParams(params);
			//设置TextView的文字 大小 颜色
			setViewTextAttr(pro,textView,text,size,color);
			parent.addView(textView);
			return textView;
		}

	/**
	 * 生产ImageView
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param CENTER_HORIZONTAL 本控件在父控件中水平方向居中
	 * @param CENTER_IN_PARENT 本控件在父控件居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * */
	protected  ImageView productImageView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		ImageView imageView =new ImageView(mContext);
		imageView.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_HORIZONTAL);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		imageView.setLayoutParams(params);
		parent.addView(imageView);
		return imageView;
	}
	/**
	 * 生产CircularImage
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param CENTER_HORIZONTAL 本控件在父控件中水平方向居中
	 * @param CENTER_IN_PARENT 本控件在父控件居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * */
	protected  CircularImage productCircularImage(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		CircularImage imageView =new CircularImage(mContext,pro);
		imageView.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		imageView.setLayoutParams(params);
		parent.addView(imageView);
		return imageView;
	}
	protected  CircularImage productCircularImage(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int ALIGN_PARENT_LEFT,int ALIGN_PARENT_RIGHT,int ALIGN_PARENT_TOP,int ALIGN_PARENT_BOTTOM, 
			int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		CircularImage imageView =new CircularImage(mContext,pro);
		imageView.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT,ALIGN_PARENT_LEFT,ALIGN_PARENT_RIGHT,ALIGN_PARENT_TOP,ALIGN_PARENT_BOTTOM);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		imageView.setLayoutParams(params);
		parent.addView(imageView);
		return imageView;
	}

	/**
	 * 生产ImageView
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本控件在父控件中垂直方向居中
	 * @param CENTER_HORIZONTAL 本控件在父控件中水平方向居中
	 * @param CENTER_IN_PARENT 本控件在父控件居中
	 * @param ALIGN_PARENT_LEFT 在父控件最左侧
	 * @param ALIGN_PARENT_RIGHT 在父控件最右侧
	 * @param ALIGN_PARENT_TOP 在父控件最顶侧
	 * @param ALIGN_PARENT_BOTTOM 在父控件最底侧
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * */
	protected  ImageView productImageView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int ALIGN_PARENT_LEFT,int ALIGN_PARENT_RIGHT,int ALIGN_PARENT_TOP,int ALIGN_PARENT_BOTTOM, 
			int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		ImageView imageView =new ImageView(mContext);
		imageView.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT,ALIGN_PARENT_LEFT,ALIGN_PARENT_RIGHT,ALIGN_PARENT_TOP,ALIGN_PARENT_BOTTOM);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		imageView.setLayoutParams(params);
		parent.addView(imageView);
		return imageView;
	}
	
	
	
	/**
	 * 生产Button
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * */
	protected  Button productButton(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,String text,int size,String color,RelativeLayout parent)
	 {
		
		Button btn =new Button(mContext);
		btn.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		btn.setLayoutParams(params);
		setViewTextAttr(pro,btn, text, size, color);
		parent.addView(btn);
		return btn;
	}
	
	
	
	/**
	 * 生产Button
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本控件在父控件中垂直方向居中
	 * @param CENTER_HORIZONTAL 本控件在父控件中水平方向居中
	 * @param CENTER_IN_PARENT 本控件在父控件居中
	 * @param ALIGN_PARENT_LEFT 在父控件最左侧
	 * @param ALIGN_PARENT_RIGHT 在父控件最右侧
	 * @param ALIGN_PARENT_TOP 在父控件最顶侧
	 * @param ALIGN_PARENT_BOTTOM 在父控件最底侧
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * */
	protected  Button productButton(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,
			int  ALIGN_PARENT_LEFT,int ALIGN_PARENT_RIGHT,int ALIGN_PARENT_TOP,int ALIGN_PARENT_BOTTOM,int left,int top,int right,int bottom,String text,int size,String color,RelativeLayout parent)
	 {
		
		Button btn =new Button(mContext);
		btn.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT,ALIGN_PARENT_LEFT,ALIGN_PARENT_RIGHT,ALIGN_PARENT_TOP,ALIGN_PARENT_BOTTOM);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		btn.setLayoutParams(params);
		setViewTextAttr(pro,btn, text, size, color);
		parent.addView(btn);
		return btn;
	}
	
	protected  TextButton productTextButton(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,
			int  ALIGN_PARENT_LEFT,int ALIGN_PARENT_RIGHT,int ALIGN_PARENT_TOP,int ALIGN_PARENT_BOTTOM,int left,int top,int right,int bottom,String text,int size,String color,RelativeLayout parent)
	 {
		
		TextButton btn =new TextButton(mContext);
		btn.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT,ALIGN_PARENT_LEFT,ALIGN_PARENT_RIGHT,ALIGN_PARENT_TOP,ALIGN_PARENT_BOTTOM);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		btn.setLayoutParams(params);
		setViewTextAttr(pro,btn, text, size, color);
		parent.addView(btn);
		return btn;
	}
	/**
	 * 生产Button
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * */
	protected  Button productButton(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		Button btn =new Button(mContext);
		btn.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		btn.setLayoutParams(params);
		
		parent.addView(btn);
		return btn;
	}
	
	
	/**
	 * 生产Button
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本控件在父控件中垂直方向居中
	 * @param CENTER_HORIZONTAL 本控件在父控件中水平方向居中
	 * @param CENTER_IN_PARENT 本控件在父控件居中
	 * @param ALIGN_PARENT_LEFT 在父控件最左侧
	 * @param ALIGN_PARENT_RIGHT 在父控件最右侧
	 * @param ALIGN_PARENT_TOP 在父控件最顶侧
	 * @param ALIGN_PARENT_BOTTOM 在父控件最底侧
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * */
	protected  Button productButton(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,
			int  ALIGN_PARENT_LEFT,int ALIGN_PARENT_RIGHT,int ALIGN_PARENT_TOP,int ALIGN_PARENT_BOTTOM,int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		Button btn =new Button(mContext);
		btn.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT,ALIGN_PARENT_LEFT,ALIGN_PARENT_RIGHT,ALIGN_PARENT_TOP,ALIGN_PARENT_BOTTOM);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		btn.setLayoutParams(params);
		
		parent.addView(btn);
		return btn;
	}
	
	/**
	 * 生产RadioButton
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * */
	protected  RadioButton productRadioButton(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,String text,int size,String color,RadioGroup parent)
	 {
		
		RadioButton btn =new RadioButton(mContext);
		btn.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		btn.setLayoutParams(params);
		setViewTextAttr(pro,btn, text, size, color);
		parent.addView(btn);
		
		return btn;
	}
	
	/**
	 * 生产EditText
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * @param isshowpino true:弹出键盘 false:不显示键盘
	 * */
	protected  EditText productEditText(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,String text,int size,String color,RelativeLayout parent,
			boolean isshowpino)
	 {
		
		EditText editText =new EditText(mContext);
		editText.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		editText.setLayoutParams(params);
		setViewTextAttr(pro,editText, text, size, color);
		
		parent.addView(editText);
		if(!isshowpino){//是否显示键盘
			parent.setFocusable(true);
			parent.setFocusableInTouchMode(true);
		}
		return editText;
	}
	/**
	 * 生产EditText
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * @param isshowpino true:弹出键盘 false:不显示键盘
	 * @hint 提示文字
	 * */
	protected  EditText productEditText(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,String text,int size,String color,RelativeLayout parent,
			boolean isshowpino,String hint)
	 {
		
		EditText editText =new EditText(mContext);
		editText.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		editText.setLayoutParams(params);
		setViewTextAttr(pro,editText, text, size, color);
		if(hint!=null&&!hint.equals("")){
			editText.setHint(hint);
		}
		parent.addView(editText);
		if(!isshowpino){//是否显示键盘
			parent.setFocusable(true);
			parent.setFocusableInTouchMode(true);
		}
		return editText;
	}
	
	
	protected  EditText productEditText(Context mContext,float pro,int id,
			int viewWidth,int viewHeight,
			int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,
			int  ALIGN_PARENT_LEFT,int ALIGN_PARENT_RIGHT,int ALIGN_PARENT_TOP,int ALIGN_PARENT_BOTTOM,
			int left,int top,int right,int bottom,
			String text,int size,String color,RelativeLayout parent,
			boolean isshowpino,String hint)
	 {
		
		EditText editText =new EditText(mContext);
		editText.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT,ALIGN_PARENT_LEFT,ALIGN_PARENT_RIGHT,ALIGN_PARENT_TOP,ALIGN_PARENT_BOTTOM);
		
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		editText.setLayoutParams(params);
		setViewTextAttr(pro,editText, text, size, color);
		if(hint!=null&&!hint.equals("")){
			editText.setHint(hint);
		}
		parent.addView(editText);
		if(!isshowpino){//是否显示键盘
			parent.setFocusable(true);
			parent.setFocusableInTouchMode(true);
		}
		return editText;
	}
	
	/**
	 * 生产一条线
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * @param isshowpino true:弹出键盘 false:不显示键盘
	 * */
	protected  View productView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		View view =new View(mContext);
		view.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		view.setLayoutParams(params);
		
		parent.addView(view);
		
		return view;
	}
	

	
	protected  ListView productListView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		ListView view =new ListView(mContext);
		view.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		view.setLayoutParams(params);
		
		parent.addView(view);
		
		return view;
	}
	
//	/**
//	 * 生产LoadMoreListView
//	 * @param  id 控件id
//	 * @param  viewWidth 控件宽度
//	 * @param  viewHeight 控件高度
//	 * @param toleft 本控件位于id为toleft控件的左侧
//	 * @param toright 本控件位于id为toright控件的右侧
//	 * @param above 本控件位于id为above控件的上方
//	 * @param below 本控件位于id为below控件的下方
//	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
//	 * @param left 本控件位于兄弟控件左侧距离
//	 * @param top 本控件位于兄弟控件上侧距离
//	 * @param right 本控件位于兄弟控件右侧距离
//	 * @param bottom 本控件位于兄弟控件下侧距离
//	 * @param parent 父控件
//	 * 
//	 * */
//	protected  LoadMoreListView productLoadListView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
//			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,RelativeLayout parent)
//	 {
//		
//		LoadMoreListView view =new LoadMoreListView(mContext);
//		view.setId(id);
//		RelativeLayout.LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
//		//设置控件的相对位置
//		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
//		//设置控件物理间距
//		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
//		view.setLayoutParams(params);
//		
//		parent.addView(view);
//		
//		return view;
//	}
	
	/**
	 * 生产一条线
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * @param isshowpino true:弹出键盘 false:不显示键盘
	 * */
	protected  View productView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		View view =new View(mContext);
		view.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,0,0,0);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		view.setLayoutParams(params);
		
		parent.addView(view);
		
		return view;
	}
	
	
	/**
	 * 生产一条线
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * @param isshowpino true:弹出键盘 false:不显示键盘
	 * */
	protected  View productView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int  ALIGN_PARENT_LEFT,int ALIGN_PARENT_RIGHT,int ALIGN_PARENT_TOP,int ALIGN_PARENT_BOTTOM,int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		View view =new View(mContext);
		view.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,0,0,0,ALIGN_PARENT_LEFT,ALIGN_PARENT_RIGHT,ALIGN_PARENT_TOP,ALIGN_PARENT_BOTTOM);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		
		view.setLayoutParams(params);
		
		parent.addView(view);
		
		return view;
	}
	protected  View productView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,
			int  ALIGN_PARENT_LEFT,int ALIGN_PARENT_RIGHT,int ALIGN_PARENT_TOP,int ALIGN_PARENT_BOTTOM,int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		View view =new View(mContext);
		view.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT,ALIGN_PARENT_LEFT,ALIGN_PARENT_RIGHT,ALIGN_PARENT_TOP,ALIGN_PARENT_BOTTOM);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		
		view.setLayoutParams(params);
		
		parent.addView(view);
		
		return view;
	}
	/**
	 * 生产ViewPager
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * 
	 * */
	protected  ViewPager productViewPager(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		ViewPager viewPager =new ViewPager(mContext);
		viewPager.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,0,0,0);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		viewPager.setLayoutParams(params);
		
		parent.addView(viewPager);
		
		return viewPager;
	}
	
	
	/**
	 * 生产ViewPager
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * 
	 * */
//	protected  ImageShowViewPager productImageShowViewPager(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
//			int left,int top,int right,int bottom,RelativeLayout parent)
//	 {
//		
//		ImageShowViewPager viewPager =new ImageShowViewPager(mContext);
//		viewPager.setId(id);
//		RelativeLayout.LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
//		//设置控件的相对位置
//		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
//		//设置控件物理间距
//		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
//		viewPager.setLayoutParams(params);
//		
//		parent.addView(viewPager);
//		
//		return viewPager;
//	}
	//CustomViewPager
//	/**
//	 * 生产CustomViewPager
//	 * @param  id 控件id
//	 * @param  viewWidth 控件宽度
//	 * @param  viewHeight 控件高度
//	 * @param toleft 本控件位于id为toleft控件的左侧
//	 * @param toright 本控件位于id为toright控件的右侧
//	 * @param above 本控件位于id为above控件的上方
//	 * @param below 本控件位于id为below控件的下方
//	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
//	 * @param left 本控件位于兄弟控件左侧距离
//	 * @param top 本控件位于兄弟控件上侧距离
//	 * @param right 本控件位于兄弟控件右侧距离
//	 * @param bottom 本控件位于兄弟控件下侧距离
//	 * @param parent 父控件
//	 * 
//	 * */
//	protected  CustomViewPager productCustomViewPager(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
//			int left,int top,int right,int bottom,RelativeLayout parent)
//	 {
//		
//		CustomViewPager viewPager =new CustomViewPager(mContext);
//		viewPager.setId(id);
//		RelativeLayout.LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
//		//设置控件的相对位置
//		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
//		//设置控件物理间距
//		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
//		viewPager.setLayoutParams(params);
//		
//		parent.addView(viewPager);
//		
//		return viewPager;
//	}
	/*****************************ViewGroup类*******************************************/
	
	/**
	 * 生产RelativeLayout
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * */
	protected  RelativeLayout productRelativeLayout(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,Object parent)
	 {
		
		RelativeLayout relativeLayout =new RelativeLayout(mContext);
		relativeLayout.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		relativeLayout.setLayoutParams(params);
		if(parent instanceof RelativeLayout){
			((RelativeLayout)parent).addView(relativeLayout);
		}else if(parent instanceof ScrollView){
			((ScrollView)parent).addView(relativeLayout);
		}else if(parent instanceof HorizontalScrollView){
			((HorizontalScrollView)parent).addView(relativeLayout);
		}
		
		return relativeLayout;
	}
	
	/**
	 * 生产RelativeLayout
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * */
	protected  RelativeLayout productRelativeLayout(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,
			int  ALIGN_PARENT_LEFT,int ALIGN_PARENT_RIGHT,int ALIGN_PARENT_TOP,int ALIGN_PARENT_BOTTOM,int left,int top,int right,int bottom,Object parent)
	 {
		
		RelativeLayout relativeLayout =new RelativeLayout(mContext);
		relativeLayout.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT,ALIGN_PARENT_LEFT,ALIGN_PARENT_RIGHT,ALIGN_PARENT_TOP,ALIGN_PARENT_BOTTOM);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		relativeLayout.setLayoutParams(params);
		if(parent instanceof RelativeLayout){
			((RelativeLayout)parent).addView(relativeLayout);
		}else if(parent instanceof ScrollView){
			((ScrollView)parent).addView(relativeLayout);
		}else if(parent instanceof HorizontalScrollView){
			((HorizontalScrollView)parent).addView(relativeLayout);
		}
		
		return relativeLayout;
	}
	
	/**
	 * 生产ScrollView
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * */
	protected  ScrollView productScrollView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		ScrollView scrollView =new ScrollView(mContext);
		scrollView.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		scrollView.setLayoutParams(params);
		parent.addView(scrollView);
		return scrollView;
	}
	
	protected  ForbidScrollView productForbidScrollView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		ForbidScrollView scrollView =new ForbidScrollView(mContext);
		scrollView.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		scrollView.setLayoutParams(params);
		parent.addView(scrollView);
		return scrollView;
	}
	
//	/**
//	 * 生产ScrollView
//	 * @param  id 控件id
//	 * @param  viewWidth 控件宽度
//	 * @param  viewHeight 控件高度
//	 * @param toleft 本控件位于id为toleft控件的左侧
//	 * @param toright 本控件位于id为toright控件的右侧
//	 * @param above 本控件位于id为above控件的上方
//	 * @param below 本控件位于id为below控件的下方
//	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
//	 * @param left 本控件位于兄弟控件左侧距离
//	 * @param top 本控件位于兄弟控件上侧距离
//	 * @param right 本控件位于兄弟控件右侧距离
//	 * @param bottom 本控件位于兄弟控件下侧距离
//	 * @param parent 父控件
//	 * */
//	protected  TopicPlug_VerticalScrollView productTopicPlug_VerticalScrollView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
//			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,RelativeLayout parent)
//	 {
//		
//		TopicPlug_VerticalScrollView scrollView =new TopicPlug_VerticalScrollView(mContext);
//		scrollView.setId(id);
//		RelativeLayout.LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
//		//设置控件的相对位置
//		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
//		//设置控件物理间距
//		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
//		scrollView.setLayoutParams(params);
//		parent.addView(scrollView);
//		return scrollView;
//	}
	
//	/**
//	 * 生产ScrollView
//	 * @param  id 控件id
//	 * @param  viewWidth 控件宽度
//	 * @param  viewHeight 控件高度
//	 * @param toleft 本控件位于id为toleft控件的左侧
//	 * @param toright 本控件位于id为toright控件的右侧
//	 * @param above 本控件位于id为above控件的上方
//	 * @param below 本控件位于id为below控件的下方
//	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
//	 * @param left 本控件位于兄弟控件左侧距离
//	 * @param top 本控件位于兄弟控件上侧距离
//	 * @param right 本控件位于兄弟控件右侧距离
//	 * @param bottom 本控件位于兄弟控件下侧距离
//	 * @param parent 父控件
//	 * */
//	protected  VerticalScrollView productVerticalScrollView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
//			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,RelativeLayout parent)
//	 {
//		
//		VerticalScrollView scrollView =new VerticalScrollView(mContext);
//		scrollView.setId(id);
//		RelativeLayout.LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
//		//设置控件的相对位置
//		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
//		//设置控件物理间距
//		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
//		scrollView.setLayoutParams(params);
//		parent.addView(scrollView);
//		return scrollView;
//	}
//	
//	/**
//	 * 生产ScrollView
//	 * @param  id 控件id
//	 * @param  viewWidth 控件宽度
//	 * @param  viewHeight 控件高度
//	 * @param toleft 本控件位于id为toleft控件的左侧
//	 * @param toright 本控件位于id为toright控件的右侧
//	 * @param above 本控件位于id为above控件的上方
//	 * @param below 本控件位于id为below控件的下方
//	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
//	 * @param left 本控件位于兄弟控件左侧距离
//	 * @param top 本控件位于兄弟控件上侧距离
//	 * @param right 本控件位于兄弟控件右侧距离
//	 * @param bottom 本控件位于兄弟控件下侧距离
//	 * @param parent 父控件
//	 * */
//	protected  ActivityPlug_VerticalScrollView productActivityPlug_VerticalScrollView(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
//			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,RelativeLayout parent)
//	 {
//		
//		ActivityPlug_VerticalScrollView scrollView =new ActivityPlug_VerticalScrollView(mContext);
//		scrollView.setId(id);
//		RelativeLayout.LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
//		//设置控件的相对位置
//		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
//		//设置控件物理间距
//		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
//		scrollView.setLayoutParams(params);
//		parent.addView(scrollView);
//		return scrollView;
//	}
	/**
	 * 生产RadioGroup
	 * @param  id 控件id
	 * @param  viewWidth 控件宽度
	 * @param  viewHeight 控件高度
	 * @param toleft 本控件位于id为toleft控件的左侧
	 * @param toright 本控件位于id为toright控件的右侧
	 * @param above 本控件位于id为above控件的上方
	 * @param below 本控件位于id为below控件的下方
	 * @param CENTER_VERTICAL 本空间在父控件中垂直方向居中
	 * @param left 本控件位于兄弟控件左侧距离
	 * @param top 本控件位于兄弟控件上侧距离
	 * @param right 本控件位于兄弟控件右侧距离
	 * @param bottom 本控件位于兄弟控件下侧距离
	 * @param parent 父控件
	 * */
	protected  RadioGroup productRadioGroup(Context mContext,float pro,int id,int viewWidth,int viewHeight,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int left,int top,int right,int bottom,RelativeLayout parent)
	 {
		
		RadioGroup radioGroup =new RadioGroup(mContext);
		radioGroup.setId(id);
		LayoutParams params=getParam(mContext,pro,viewWidth,viewHeight);
		//设置控件的相对位置
		setRelativePosition(params,toleft,toright,above,below,CENTER_VERTICAL,CENTER_HORIZONTAL,CENTER_IN_PARENT);
		//设置控件物理间距
		setViewAbsolutePosition(mContext,pro,params,left,top,right,bottom);
		radioGroup.setLayoutParams(params);
		parent.addView(radioGroup);
		return radioGroup;
	}
	
/***************************************************************************************************	
	
	
	
	/**
	 * 
	 * 设置控件的布局参数
	 * 
	 * */
	protected  LayoutParams getParam(Context context,float pro,int width,int height){
		LayoutParams params;
		
		if(width==LayoutParams.WRAP_CONTENT&&height==LayoutParams.WRAP_CONTENT){
			params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		    return params;
		}
		if(width==LayoutParams.MATCH_PARENT&&height==LayoutParams.MATCH_PARENT){
			params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		    return params;
		}
		if(width==LayoutParams.MATCH_PARENT&&height==LayoutParams.WRAP_CONTENT){
			params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		    return params;
		}
		
		if(width==LayoutParams.MATCH_PARENT&&(height!=LayoutParams.MATCH_PARENT||height!=LayoutParams.WRAP_CONTENT)){
			params=new LayoutParams(LayoutParams.MATCH_PARENT,(int)(DensityUtil.dip2px(context, height) * pro));
		    return params;
		}
		if((width!=LayoutParams.MATCH_PARENT||width!=LayoutParams.WRAP_CONTENT)&&(height==LayoutParams.MATCH_PARENT||height==LayoutParams.WRAP_CONTENT)){
			params=new LayoutParams((int)(DensityUtil.dip2px(context,width) * pro),height);
		}
		params=new LayoutParams((int)(DensityUtil.dip2px(context,width) * pro),(int)(DensityUtil.dip2px(context,height) * pro));
		return params;
		
	}
	/**
	 * 
	 * 设置控件的相对位置
	 * 
	 * */
	
	private static void setRelativePosition(LayoutParams params,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT){
		if(toleft!=0){
			params.addRule(RelativeLayout.LEFT_OF,toleft);
		}
		if(toright!=0){
			params.addRule(RelativeLayout.RIGHT_OF,toright);
		}
		if(above!=0){
			params.addRule(RelativeLayout.ABOVE,above);
		}
		if(below!=0){
			params.addRule(RelativeLayout.BELOW,below);
		}
		if(CENTER_VERTICAL!=0){
			params.addRule(RelativeLayout.CENTER_VERTICAL);
			
		}
		if(CENTER_HORIZONTAL!=0){
			params.addRule(RelativeLayout.CENTER_HORIZONTAL);
			
		}
		if(CENTER_IN_PARENT!=0){
			params.addRule(RelativeLayout.CENTER_IN_PARENT);
			
		}
		
	}
	
	/**
	 * 
	 * 设置控件的相对位置
	 * 
	 * */
	
	private static void setRelativePosition(LayoutParams params,int toleft,int toright,int above,int below,
			int CENTER_VERTICAL,int CENTER_HORIZONTAL,int CENTER_IN_PARENT,int ALIGN_PARENT_LEFT,
			int ALIGN_PARENT_RIGHT,int ALIGN_PARENT_TOP, int ALIGN_PARENT_BOTTOM){
		if(toleft!=0){
			params.addRule(RelativeLayout.LEFT_OF,toleft);
		}
		if(toright!=0){
			params.addRule(RelativeLayout.RIGHT_OF,toright);
		}
		if(above!=0){
			params.addRule(RelativeLayout.ABOVE,above);
		}
		if(below!=0){
			params.addRule(RelativeLayout.BELOW,below);
		}
		if(CENTER_VERTICAL!=0){
			params.addRule(RelativeLayout.CENTER_VERTICAL);
			
		}
		if(CENTER_HORIZONTAL!=0){
			params.addRule(RelativeLayout.CENTER_HORIZONTAL);
			
		}
		if(CENTER_IN_PARENT!=0){
			params.addRule(RelativeLayout.CENTER_IN_PARENT);
		}
		if(ALIGN_PARENT_LEFT!=0){
			params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		}
		
		if(ALIGN_PARENT_RIGHT!=0){
			params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		}
		if(ALIGN_PARENT_TOP!=0){
			params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		}
		if(ALIGN_PARENT_BOTTOM!=0){
			params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		}
		
	}
	/**
	 * 
	 * 设置控件物理位置
	 * 
	 * */
	private static void setViewAbsolutePosition(Context context,float pro,LayoutParams params,int left,int top,int right,int bottom ){
		params.setMargins((int)(DensityUtil.dip2px(context,left) * pro), (int)(DensityUtil.dip2px(context,top) * pro), (int)(DensityUtil.dip2px(context,right) * pro), (int)(DensityUtil.dip2px(context,bottom) * pro));
	}
	
	/**
	 * 
	 * 设置控件文字、大小、颜色
	 * 
	 * */
	private static void setViewTextAttr(float pro,Object obj,String text,int size,String color){
		if(obj instanceof TextView){
			TextView view=(TextView) obj;
			if(text!=null&&!text.equals("")){
				view.setText(text);
			}
			if(color!=null&&!color.equals("")){
				view.setTextColor(Color.parseColor(color));
			}
			if(size>0){
				view.setTextSize((int)size*pro);
			}
			
		}else if(obj instanceof Button){
			Button view=(Button) obj;
			if(text!=null&&!text.equals("")){
				view.setText(text);
			}
			if(color!=null&&!color.equals("")){
				view.setTextColor(Color.parseColor(color));
			}
			if(size>0){
				view.setTextSize((int)size*pro);
			}
			
		}else if(obj instanceof EditText){
			EditText view=(EditText) obj;
			if(text!=null&&!text.equals("")){
				view.setText(text);
			}
			if(color!=null&&!color.equals("")){
				view.setTextColor(Color.parseColor(color));
			}
			if(size>0){
				view.setTextSize((int)size*pro);
			}
			
		}
	}
}
