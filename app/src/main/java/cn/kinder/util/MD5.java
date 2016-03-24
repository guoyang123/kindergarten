package cn.kinder.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	/*** 
     * MD5���� ����32λ��дmd5��  
     */  
	 public static String getEncoderByMd5(String sessionid)
		        throws NoSuchAlgorithmException, UnsupportedEncodingException {

		    StringBuffer hexString = null;
		    byte[] defaultBytes = sessionid.getBytes();
		    try {
		        MessageDigest algorithm = MessageDigest.getInstance("MD5");
		        algorithm.reset();
		        algorithm.update(defaultBytes);
		        byte messageDigest[] = algorithm.digest();

		        hexString = new StringBuffer();
		        for (int i = 0; i < messageDigest.length; i++) {
		            if (Integer.toHexString(0xFF & messageDigest[i]).length() == 1) {
		                hexString.append(0);
		            }
		            hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
		        }
		        messageDigest.toString();
		        // System.out.println("sessionid "+sessionid+" md5 version is "+hexString.toString());
		        sessionid = hexString + "";
		    } catch (NoSuchAlgorithmException nsae) {

		    }
		    System.out.println(hexString.toString().toUpperCase());
		    return hexString.toString().toUpperCase();

		}

	 /*** 
	     * MD5���� ����32λСдmd5�� 
	     */  
	    public static String string2MD5(String inStr){  
	        MessageDigest md5 = null;  
	        try{  
	            md5 = MessageDigest.getInstance("MD5");  
	        }catch (Exception e){  
	            System.out.println(e.toString());  
	            e.printStackTrace();  
	            return "";  
	        }  
	        char[] charArray = inStr.toCharArray();  
	        byte[] byteArray = new byte[charArray.length];  
	  
	        for (int i = 0; i < charArray.length; i++)  
	            byteArray[i] = (byte) charArray[i];  
	        byte[] md5Bytes = md5.digest(byteArray);  
	        StringBuffer hexValue = new StringBuffer();  
	        for (int i = 0; i < md5Bytes.length; i++){  
	            int val = ((int) md5Bytes[i]) & 0xff;  
	            if (val < 16)  
	                hexValue.append("0");  
	            hexValue.append(Integer.toHexString(val));  
	        }  
	        return hexValue.toString();  
	  
	    }  
	  
	    /** 
	     *  ���ܽ����㷨 ִ��һ�μ��ܣ����ν��� 
	     */   
	    public static String convertMD5(String inStr){  
	  
	        char[] a = inStr.toCharArray();  
	        for (int i = 0; i < a.length; i++){  
	            a[i] = (char) (a[i] ^ 't');  
	        }  
	        String s = new String(a);  
	        return s;  
	  
	    }  

}
