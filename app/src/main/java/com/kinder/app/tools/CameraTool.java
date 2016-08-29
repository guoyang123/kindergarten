package com.kinder.app.tools;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;

import java.io.File;

public class CameraTool {

	/**
	 * 相册回调
	 * @author wangandy
	 *
	 */
	public interface CameraToolProtocol{
		public static final int SUCCESS = 1;
		public static final int UNSDCARD = 2;
		public static final int FAILED = 3;

		/**
		 * 获取相机或相册图片回调方法
		 * @param thumb 缩略图
		 * @param picUrl 原图的图片地址，存在sdcard
		 * @param status 状态值
		 */
		public abstract void OnCameraResponse(Bitmap thumb, String picUrl, int status);
	}


	private String localTempImgFileName = "tmpCameraPhoto.jpg";
	private final String localTempImgDir = "TmpCameraPhoto";
	FragmentActivity activity;
	private CameraToolProtocol protocol;

	private Uri uri;

	public static final int PHOTO_REQUEST_TAKEPHOTO = 1;// 拍照
	public static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
	public static final int PHOTO_REQUEST_CUT = 3;// 裁剪

	private String filePath = Environment.getExternalStorageDirectory() + File.separator+localTempImgDir + File.separator + localTempImgFileName;
	public CameraTool(FragmentActivity activity,CameraToolProtocol protocol) {
		// TODO Auto-generated constructor stub
		this.protocol = protocol;
		this.activity=activity;


	}

	/**
	 * 验证是否有sd卡
	 * @return
	 */
	public Boolean verifySdCard(){
		String status=Environment.getExternalStorageState();
		if(status.equals(Environment.MEDIA_MOUNTED)) {
			File dir=new File(Environment.getExternalStorageDirectory() + File.separator+localTempImgDir);
			if(!dir.exists())dir.mkdirs();
			return true;
		}
		return false;
	}

	/**
	 * 从相册获取图片
	 */
	public void getPhotoFromGallery(){
		clearTmpFile();
		if (verifySdCard()) {
			uri = null;
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_GET_CONTENT);  //ACTION_GET_CONTENT
			//intent.addCategory(Intent.CATEGORY_OPENABLE);
			intent.setType("image/*");
			activity.startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
		}else {
			this.protocol.OnCameraResponse(null, null, CameraToolProtocol.UNSDCARD);
		}
	}

	/**
	 * 从相机获取图片
	 */
	public void getPhotoFromCamera(){
		//判断是否有sd卡
		if (verifySdCard()) {
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			uri = Uri.fromFile(new File(filePath));
			intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
			activity.startActivityForResult(intent,PHOTO_REQUEST_TAKEPHOTO);
		}else
		{
			this.protocol.OnCameraResponse(null, null, CameraToolProtocol.UNSDCARD);
		}
	}
	/**
	 * @param isCrop  图片是否需要裁减
	 *
	 * */
	public void ActivityResult(int requestCode, int resultCode, Intent data,boolean isCrop){

		switch (requestCode) {
			case PHOTO_REQUEST_GALLERY:
				if (uri == null&&data!=null)
				{
					uri = data.getData();
//
//			 String[] proj = {MediaStore.Images.Media.DATA};
//
//				//从系统表中查询指定的uri对应的照片
//			 Cursor cursor = activity.getContentResolver().query(uri, proj, null, null, null);
//			 //将光标移至开头 ，这个很重要，不小心很容易引起越界
//	            cursor.moveToFirst();
//
//			 int column_index = cursor.getColumnIndex(proj[0]);
//              String picpath=cursor.getString(column_index);
//              Log.e("buzz1", "picpath:"+picpath);
//           //   this.filePath=picpath;
//          	try {
//				if (Integer.parseInt(Build.VERSION.SDK) < 14) {
//					cursor.close();
//				}
//			} catch (Exception e) {}
				}

				photoCut(uri, 1100,isCrop);
//		photoCutFinish();
				break;

			case PHOTO_REQUEST_TAKEPHOTO:
				if (uri == null) {
					uri = Uri.fromFile(new File(filePath));
				}
				photoCut(uri, 1100,isCrop);
				break;

			case PHOTO_REQUEST_CUT:
				photoCutFinish();
				break;
			default:
				break;
		}

	}

	private void clearTmpFile(){
		File file = new File(filePath);
		if (file.exists()) file.delete();
	}




	private void photoCut(Uri uri,int size,boolean isCrop){
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		if (Build.VERSION.SDK_INT >= 19)//android.os.Build.VERSION_CODES.KITKAT
		{
			String localfilePath=getPath(activity,uri);
			intent.setDataAndType(Uri.fromFile(new File(localfilePath)), "image/*");
		}else
		{
			intent.setDataAndType(uri, "image/*");
		}

		// crop为true是设置在开启的intent中设置显示的view可以剪裁
		intent.putExtra("crop", "false");

		if(isCrop){
			// aspectX aspectY 是宽高的比例
			intent.putExtra("aspectX", 3);
			intent.putExtra("aspectY", 2);
			// outputX,outputY 是剪裁图片的宽高
			intent.putExtra("outputX", size);
			intent.putExtra("outputY", size);
			intent.putExtra("return-data", false);
			//黑边
			intent.putExtra("scale", true);//黑边
			intent.putExtra("scaleUpIfNeeded", true);//黑边
		}
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(filePath)));//黑边
		intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
		activity.startActivityForResult(intent, PHOTO_REQUEST_CUT);
	}

	public void photoCutFinish(){
		//获取返回图片
		Bitmap map = null;
		int resultStatus = CameraToolProtocol.SUCCESS;
		//判断图片是否存在
		File tmpFile = new File(filePath);
		if (!tmpFile.exists()) {
			resultStatus = CameraToolProtocol.FAILED;
			this.protocol.OnCameraResponse(null, filePath, resultStatus);
		}else{
			//获取缩略图
			//map = BitmapTool.getSmallBitmapWithFile(filePath, 128, 128);
			map=BitmapFactory.decodeFile(filePath);
			//压缩图片到1000kb以内
			if (map == null) {
				resultStatus = CameraToolProtocol.FAILED;
			}
		}

		tmpFile = null;

		this.protocol.OnCameraResponse(map, filePath, resultStatus);
	}






	@SuppressLint("NewApi") public static String getPath(final Context context, final Uri uri) {
		final boolean isKitKat = Build.VERSION.SDK_INT >= 19;//Build.VERSION_CODES.KITKAT
		// DocumentProvider
		if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
			// ExternalStorageProvider
			if (isExternalStorageDocument(uri)) {
				final String docId = DocumentsContract.getDocumentId(uri);
				final String[] split = docId.split(":");
				final String type = split[0];
				if ("primary".equalsIgnoreCase(type)) {
					return Environment.getExternalStorageDirectory() + "/"
							+ split[1];
				}
				// TODO handle non-primary volumes
			}
			// DownloadsProvider
			else if (isDownloadsDocument(uri)) {
				final String id = DocumentsContract.getDocumentId(uri);
				final Uri contentUri = ContentUris.withAppendedId(
						Uri.parse("content://downloads/public_downloads"),
						Long.valueOf(id));
				return getDataColumn(context, contentUri, null, null);
			}
			// MediaProvider
			else if (isMediaDocument(uri)) {
				final String docId = DocumentsContract.getDocumentId(uri);
				final String[] split = docId.split(":");
				final String type = split[0];
				Uri contentUri = null;
				if ("image".equals(type)) {
					contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
				} else if ("video".equals(type)) {
					contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
				} else if ("audio".equals(type)) {
					contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
				}
				final String selection = "_id=?";
				final String[] selectionArgs = new String[] { split[1] };
				return getDataColumn(context, contentUri, selection,
						selectionArgs);
			}
		}
		// MediaStore (and general)
		else if ("content".equalsIgnoreCase(uri.getScheme())) {
			// Return the remote address
			if (isGooglePhotosUri(uri))
				return uri.getLastPathSegment();
			return getDataColumn(context, uri, null, null);
		}
		// File
		else if ("file".equalsIgnoreCase(uri.getScheme())) {
			return uri.getPath();
		}
		return null;
	}

	/**
	 * Get the value of the data column for this Uri. This is useful for
	 * MediaStore Uris, and other file-based ContentProviders.
	 *
	 * @param context The context.
	 * @param uri The Uri to query.
	 * @param selection (Optional) Filter used in the query.
	 * @param selectionArgs (Optional) Selection arguments used in the query.
	 * @return The value of the _data column, which is typically a file path.
	 */
	public static String getDataColumn(Context context, Uri uri, String selection,
									   String[] selectionArgs) {

		Cursor cursor = null;
		final String column = "_data";
		final String[] projection = {
				column
		};

		try {
			cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
					null);
			if (cursor != null && cursor.moveToFirst()) {
				final int index = cursor.getColumnIndexOrThrow(column);
				return cursor.getString(index);
			}
		} finally {
			if (cursor != null)
				cursor.close();
		}
		return null;
	}


	/**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is ExternalStorageProvider.
	 */
	public static boolean isExternalStorageDocument(Uri uri) {
		return "com.android.externalstorage.documents".equals(uri.getAuthority());
	}

	/**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is DownloadsProvider.
	 */
	public static boolean isDownloadsDocument(Uri uri) {
		return "com.android.providers.downloads.documents".equals(uri.getAuthority());
	}

	/**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is MediaProvider.
	 */
	public static boolean isMediaDocument(Uri uri) {
		return "com.android.providers.media.documents".equals(uri.getAuthority());
	}

	/**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is Google Photos.
	 */
	public static boolean isGooglePhotosUri(Uri uri) {
		return "com.google.android.apps.photos.content".equals(uri.getAuthority());
	}

}
