package cn.kinder.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.commons.codec.binary.Base64;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import cn.kinder.util.MD5;

/**用户登陆后返回登陆时间等信息*/
public class LogininfoModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3176302349092847363L;
	public final static String TAG = "Logininfo";
	private String userid;
	private String time;
	private String device;//设备号
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	
	
	/**
	 * 持久登录算法
	 * @param logininfo_Model
	 * @param time
	 * @return
	 */
    public static String getYueHuToken(LogininfoModel logininfo_Model,String logininfo_userid){
//    	保持登录：logininfo_userid 用户id    logininfo_device机码  logininfo_time当前时间  logininfo_sign 加密的md5信息
    	String deviceFrag =String.valueOf(logininfo_userid+logininfo_Model.getDevice()+logininfo_Model.getTime());
    	String yuehuTokenString = MD5.string2MD5(deviceFrag);
    	return yuehuTokenString;
    }
	
	public  boolean save(Context context){
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			// 将Product对象转换成byte数组，并将其进行base64编码
			String productBase64 = new String(Base64.encodeBase64(baos.toByteArray()));
			SharedPreferences.Editor editor = context.getSharedPreferences(TAG, Activity.MODE_PRIVATE).edit();
			// 将编码后的字符串写到base64.xml文件中
			editor.putString(TAG, productBase64);
			editor.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
	
	public static LogininfoModel readFromFile(Context context) {
		
		LogininfoModel config_Model = null;
		try {
			String productBase64 = context.getSharedPreferences(TAG, Activity.MODE_PRIVATE).getString(TAG, "");
			// 对Base64格式的字符串进行解码
			byte[] base64Bytes = Base64.decodeBase64(productBase64.getBytes());
			ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			// 从ObjectInputStream中读取Product对象
			config_Model = (LogininfoModel) ois.readObject();
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return config_Model;
	}
	
	public boolean islogin(){
		if (userid == null || userid.length() <= 0) {
			return false;
		}
		return true;
	}
	
}
