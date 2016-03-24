package com.kinder.app.tools;

import java.io.File;
import java.text.DecimalFormat;
import java.io.FileInputStream;

public class GetFileSizeUtil {
	private static GetFileSizeUtil instance;

	public GetFileSizeUtil() {
	}

	public static GetFileSizeUtil getInstance() {
		if (instance == null) {
			instance = new GetFileSizeUtil();
		}
		return instance;
	}

	
	public long getFileSizes(File f) throws Exception {
		long s = 0;
		if (f.exists()) {
			FileInputStream fis = null;
			fis = new FileInputStream(f);
			s = fis.available();
		} else {
			f.createNewFile();
		}
		return s;
	}

	
	public long getFileSize(File f) throws Exception {
		long size = 0;
		File flist[] = f.listFiles();
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isDirectory()) {
				size = size + getFileSize(flist[i]);
			} else {
				size = size + flist[i].length();
			}
		}
		return size;
	}

	/*** 杞崲鏂囦欢澶у皬鍗曚綅(b/kb/mb/gb) ***/
	public String FormetFileSize(long fileS) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024/1024) + "M";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}

	
	public long getlist(File f) {// 閫掑綊姹傚彇鐩綍鏂囦欢涓暟
		long size = 0;
		File flist[] = f.listFiles();
		size = flist.length;
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isDirectory()) {
				size = size + getlist(flist[i]);
				size--;
			}
		}
		return size;
	}
}
