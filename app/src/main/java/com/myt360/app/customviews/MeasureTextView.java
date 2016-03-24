package com.myt360.app.customviews;

import com.myt360.kindergarten.KinderApplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MeasureTextView extends TextView {

	private Context context;
	private float pro;
	private KinderApplication local;
	public MeasureTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MeasureTextView(Context context,float pro) {
		super(context);
		this.context=context;
		this.pro=pro;
		local=(KinderApplication)context.getApplicationContext();
	}
	
	@SuppressLint("FloatMath")
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		   Layout layout = getLayout();  
	        if (layout != null) {
	            int height = (int)FloatMath.ceil(getMaxLineHeight(this.getText().toString()))  
	                    + getCompoundPaddingTop() + getCompoundPaddingBottom(); 

 //             int totalheight= (int)(DensityUtil.dip2px(context,height)*pro);
	            int totalheight= height;
		          
	            int width = getMeasuredWidth();              
	            setMeasuredDimension(width, totalheight);  
	        }
	}

	private float getMaxLineHeight(String str) {  
        float height = 0.0f;  
        float screenW = ((FragmentActivity)context).getWindowManager().getDefaultDisplay().getWidth();  
       // float screenW=local.screenW;
        float paddingLeft = ((RelativeLayout)this.getParent()).getPaddingLeft()  ;
        float paddingReft = ((RelativeLayout)this.getParent()).getPaddingRight();  
		
		//这里具体this.getPaint()要注意使用，要看你的TextView在什么位置，这个是拿TextView父控件的Padding的，为了更准确的算出换行  
        int line = (int) Math.ceil( (this.getPaint().measureText(str)/(screenW-paddingLeft-paddingReft)))+1;
		 height = (this.getPaint().getFontMetrics().descent-this.getPaint().getFontMetrics().ascent)*line;
		 return height;
	}  
}
