package cn.kinder.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kinder.app.tools.KinderEventMessage;
import com.kinder.login.LoginActivity_VC;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.FloatMath;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * 常用方法封装
 * 
 * */
public class MethodUtils {

	
	/**生成安全接送码*/
	public static String getSafeCode()
	{
//		int c=Math.random()*9000+1000;
		
		return String.valueOf((int)(Math.random()*9000)+1000);
	}


	
	/**
	 * 
	 * 
	 * 非空判断
	 * @param text 要判断的字段内容
	 *        warning 若为空，提示语
	 * 
	 * */
	public static void isNull(Context context,String text,String warning){
		if(text==null||text.equals("")){
			Toast.makeText(context, warning, Toast.LENGTH_SHORT).show();
			return;
		}
	}
	
	/**
	 * 
	 * 
	 * 判断是邮箱还是手机号,注册时使用该方法
	 * 
	 * */
	@SuppressLint("ShowToast")
	public static String isEmailorPhone(Context context,String text){
		if(isMobileNO(text)){//手机号
			return "phone";
		}else if(isEmail(text)){//邮箱
			return "email";
		}else{
			Toast.makeText(context, "手机号或邮箱格式错误", Toast.LENGTH_SHORT);
			return null;
		}
		
		
	}
	
	  /**判断手机格式是否正确*/
	public static boolean isMobileNO(String mobiles) {
		Pattern p = Pattern
		.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}
	  /**判断email格式是否正确*/
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	
	
	/**
	 * 
	 * 收起键盘
	 * 
	 * */
	public static void showanndhide(Context context,EditText topicplug_topiccomment_send_EditText){
		InputMethodManager imm = (InputMethodManager)context.getSystemService(context.INPUT_METHOD_SERVICE);  
		imm.hideSoftInputFromWindow(topicplug_topiccomment_send_EditText.getWindowToken(), 0);  
		imm.showSoftInput(topicplug_topiccomment_send_EditText, 0); 
		imm.hideSoftInputFromWindow(topicplug_topiccomment_send_EditText.getWindowToken(), 0);
	}
	
	/**EditText监听*/
	public static TextWatcher editListener(final Context context,final EditText mEditText,final int miniheight){
		 final TextWatcher mTextWatcher = new TextWatcher() {

			private int editStart;

			private int editEnd;

			public void afterTextChanged(Editable s) {
				editStart = mEditText.getSelectionStart();
				editEnd = mEditText.getSelectionEnd();

				// 先去掉监听器，否则会出现栈溢出
				mEditText.removeTextChangedListener(this);

				// 注意这里只能每次都对整个EditText的内容求长度，不能对删除的单个字符求长度
				// 因为是中英文混合，单个字符而言，calculateLength函数都会返回1
			
				mEditText.setText(s);
				mEditText.setSelection(editStart);

				// 恢复监听器
				mEditText.addTextChangedListener(this);

				setEdittextHeight(context,mEditText,miniheight);
				
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

		};
		return mTextWatcher;
	}
	
	/**
	 * 
	 * 动态计算edittext高度
	 * 
	 * */
	public static void setEdittextHeight(Context context,EditText topicplug_topiccomment_send_EditText,int miniheight){
		int height = (int)FloatMath.ceil(getMaxLineHeight(context,topicplug_topiccomment_send_EditText))  
                + topicplug_topiccomment_send_EditText.getCompoundPaddingTop() +topicplug_topiccomment_send_EditText. getCompoundPaddingBottom(); 
		RelativeLayout.LayoutParams params=(RelativeLayout.LayoutParams)topicplug_topiccomment_send_EditText.getLayoutParams();
	  if(height>miniheight){
		  params.height=height;
		   topicplug_topiccomment_send_EditText.setLayoutParams(params);
	  }
		
	
	}
	private static float getMaxLineHeight(Context context,EditText topicplug_topiccomment_send_EditText) {  
        float height = 0.0f;  
        float screenW = ((FragmentActivity)context).getWindowManager().getDefaultDisplay().getWidth();  
        float paddingLeft = ((RelativeLayout)topicplug_topiccomment_send_EditText.getParent()).getPaddingLeft();  
        float paddingReft = ((RelativeLayout)topicplug_topiccomment_send_EditText.getParent()).getPaddingRight();  
		//这里具体this.getPaint()要注意使用，要看你的TextView在什么位置，这个是拿TextView父控件的Padding的，为了更准确的算出换行  
		 int line = (int) Math.ceil( (topicplug_topiccomment_send_EditText.getPaint().measureText(topicplug_topiccomment_send_EditText.getText().toString())/(screenW-paddingLeft-paddingReft)))+1;
		 height = (topicplug_topiccomment_send_EditText.getPaint().getFontMetrics().descent-topicplug_topiccomment_send_EditText.getPaint().getFontMetrics().ascent)*line;
		 
		 return height;
	}

	
	/**检查到设备信息不一致时，需要重新登录*/
	public static void logic_ErrorCode(Context context,Object object)
	{
		if(object!=null&&object instanceof KinderEventMessage)
		{
			KinderEventMessage msg=(KinderEventMessage)object;
			if(msg.getCode()==KinderEventMessage.MSG_RELOGIN)
			{
				Intent it=new Intent(context,LoginActivity_VC.class);
				context.startActivity(it);
			}
			
		}
	}
   
}
