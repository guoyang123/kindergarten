//package cn.buzz.util;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//
//import org.apache.commons.codec.binary.Base64;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.content.SharedPreferences.Editor;
// /**
//  * ��ݵĴ洢�����ļ���
//  * */
// public class iyuehuPreference {
//    private static SharedPreferences iYueHuPreferences;
//    private static String USER_PREFERENCE = "iyuehu_preference";
// 
//    /**
//     * ������
//     * */
//    public static void clearData(){
//    	if(iYueHuPreferences!=null) { 
//    		Editor editor = iYueHuPreferences.edit();
//    		if(editor != null)
//    	    editor.clear();
//    		iYueHuPreferences = null; 
//    	}
//    } 
//    
//    public static void ensureIntializePreference(Context context) {
//        if (iYueHuPreferences != null) { 
//            return;
//        }
//        iYueHuPreferences = context.getSharedPreferences(USER_PREFERENCE, 0);
//    }
//    public static void ensureIntializePreference(Context context,String path) {
//        if (iYueHuPreferences != null) { 
//            return;
//        }
//        USER_PREFERENCE="com.iyuehu";
//        iYueHuPreferences = context.getSharedPreferences(USER_PREFERENCE, 0);
//    }
//	/**
//	 * �����ַ�
//	 * */
//    public static void save(String key, String value) {
//        Editor editor = iYueHuPreferences.edit();
//        editor.putString(key, value);
//        editor.commit(); 
//    }
//	/**
//	 * ����int
//	 * */
//    public static void save(String key, int value) {
//        Editor editor = iYueHuPreferences.edit();
//        editor.putInt(key, value);
//        editor.commit();
//    }
//    /**
//	 * ����boolean
//	 * */
//    public static void save(String key, boolean value) {
//        Editor editor = iYueHuPreferences.edit();
//        editor.putBoolean(key, value);
//        editor.commit();
//    }
//    /**
//	 * ����long
//	 * */
//    public static void save(String key, long value) {
//        Editor editor = iYueHuPreferences.edit();
//        editor.putLong(key, value);
//        editor.commit();
//    }
//    /**
//	 * �������
//	 * */
//    public static boolean save(String key,Object obj){
//		try {
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			ObjectOutputStream oos = new ObjectOutputStream(baos);
//			oos.writeObject(obj);
//			// ��Product����ת����byte���飬���������base64����
//			
//			String value = new String(Base64.encodeBase64(baos.toByteArray()));
//			//SharedPreferences.Editor editor = context.getSharedPreferences("config", Activity.MODE_PRIVATE).edit();
//			// ���������ַ�д��base64.xml�ļ���
//			iYueHuPreferences.edit().putString(key, value)
//			.commit();
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
//    /**
//	 * ��ȡ�ַ�
//	 * */
//    public static String read(String key, String defaultvalue) {
//        return iYueHuPreferences.getString(key, defaultvalue);
//    }
//    /**
//	 * ��ȡint
//	 * */
//    public static int read(String key, int defaultvalue) {
//        return iYueHuPreferences.getInt(key, defaultvalue);
//    }
//    /**
//	 * ��ȡlong
//	 * */
//    public static long read(String key, long defaultvalue) {
//        return iYueHuPreferences.getLong(key, defaultvalue);
//    }
//    /**
//	 * ��ȡboolean
//	 * */
//    public static boolean read(String key, boolean defaultvalue) {
//        return iYueHuPreferences.getBoolean(key, defaultvalue);
//    }
//    /**
//	 * ��ȡ����
//	 * */
//	public static Object readObject(String key, String defaultvalue) {
//		Object config_Model = null;
//		try {
//			String productBase64 = iYueHuPreferences.getString(key, defaultvalue);
//			// ��Base64��ʽ���ַ���н���
//			byte[] base64Bytes =Base64.decodeBase64(productBase64.getBytes());
//			ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
//			ObjectInputStream ois = new ObjectInputStream(bais);
//			// ��ObjectInputStream�ж�ȡProduct����
//			config_Model =  ois.readObject();
//		} catch (Exception e) {
//			// TODO: handle exception
//			return null;
//		}
//		return config_Model;
//	}
//
//}

package cn.kinder.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.codec.binary.Base64;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
 /**
  * 数据的存储，到文件中
  * */
 public class iyuehuPreference {
    private static SharedPreferences iYueHuPreferences;
    private static String USER_PREFERENCE = "iyuehu_preference";
 
    /**
     * 清除数据
     * */
    public static void clearData(){
    	if(iYueHuPreferences!=null) { 
    		Editor editor = iYueHuPreferences.edit();
    		
    		if(editor != null)
    	    editor.clear();
    		iYueHuPreferences = null; 
    	}
    } 
    /**
     * 删除数据
     * */
    public static void deleteObj(String key){
    	if(iYueHuPreferences!=null) { 
    		Editor editor = iYueHuPreferences.edit();
    		
    		if(editor != null)
    	    editor.remove(key);
    		editor.commit();
    		iYueHuPreferences = null; 
    	}
    } 
    public static void ensureIntializePreference(Context context) {
        if (iYueHuPreferences != null) { 
            return;
        }
        iYueHuPreferences = context.getSharedPreferences(USER_PREFERENCE, 0);
    }
    public static void ensureIntializePreference(Context context,String path) {
        if (iYueHuPreferences != null) { 
            return;
        }
        USER_PREFERENCE="com.iyuehu";
        iYueHuPreferences = context.getSharedPreferences(USER_PREFERENCE, 0);
    }
	/**
	 * 保存字符串
	 * */
    public static void save(String key, String value) {
        Editor editor = iYueHuPreferences.edit();
        editor.putString(key, value);
        editor.commit(); 
    }
	/**
	 * 保存int
	 * */
    public static void save(String key, int value) {
        Editor editor = iYueHuPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    /**
	 * 保存boolean
	 * */
    public static void save(String key, boolean value) {
        Editor editor = iYueHuPreferences.edit();
        editor.putBoolean(key, value);
        
        editor.commit();
    }
    /**
	 * 保存long
	 * */
    public static void save(String key, long value) {
        Editor editor = iYueHuPreferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }
    /**
	 * 保存对象
	 * */
    public static boolean save(String key,Object obj){
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			// 将Product对象转换成byte数组，并将其进行base64编码
			
			String value = new String(Base64.encodeBase64(baos.toByteArray()));
//			Log.e("buzz1", "64编码:"+value);
			//SharedPreferences.Editor editor = context.getSharedPreferences("config", Activity.MODE_PRIVATE).edit();
			// 将编码后的字符串写到base64.xml文件中
			iYueHuPreferences.edit().putString(key, value)
			.commit();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
    /**
	 * 获取字符串
	 * */
    public static String read(String key, String defaultvalue) {
        return iYueHuPreferences.getString(key, defaultvalue);
    }
    /**
	 * 获取int
	 * */
    public static int read(String key, int defaultvalue) {
        return iYueHuPreferences.getInt(key, defaultvalue);
    }
    /**
	 * 获取long
	 * */
    public static long read(String key, long defaultvalue) {
        return iYueHuPreferences.getLong(key, defaultvalue);
    }
    /**
	 * 获取boolean
	 * */
    public static boolean read(String key, boolean defaultvalue) {
        return iYueHuPreferences.getBoolean(key, defaultvalue);
    }
    /**
	 * 获取对象
	 * */
	public static Object readObject(String key, String defaultvalue) {
		Object config_Model = null;
		try {
			String productBase64 = iYueHuPreferences.getString(key, defaultvalue);
			// 对Base64格式的字符串进行解码
			byte[] base64Bytes =Base64.decodeBase64(productBase64.getBytes());
			ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			// 从ObjectInputStream中读取Product对象
			config_Model =  ois.readObject();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return config_Model;
	}

}

