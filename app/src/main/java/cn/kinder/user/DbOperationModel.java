package cn.kinder.user;

import java.util.List;

import net.tsz.afinal.FinalDb;
import net.tsz.afinal.FinalDb.DbUpdateListener;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import cn.kinder.bean.UserModel;

/**
 * 
 * 用户模型，该类操作底层文件，包括增删改查
 * 
 * */
public class DbOperationModel 
{

	public static volatile FinalDb fb=null;
	
	public static FinalDb getFinalDb(Context context){
		if(fb==null)
		{
			synchronized (FinalDb.class) {
				if(fb==null)
				{
					fb=FinalDb.create(context, DBConst.DBNAME, DBConst.isDebug,3,new DbUpdateListener() {
						//数据库升级
						@Override
						public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
							/** */
						}
					});
				}
			}
		}
		return fb;
	}
	
	/**
	 * 
	 * 检查数据表是否存在
	 * 
	 * */
	public static boolean tableIsExist(SQLiteDatabase db,String tableName) {
		

		Cursor cursor = null;
		try {
			String sql = "SELECT COUNT(*) AS c FROM sqlite_master WHERE type ='table' AND name ='"
					+ tableName + "' ";
			
			cursor = db.rawQuery(sql, null);
			if (cursor != null && cursor.moveToNext()) {
				int count = cursor.getInt(0);
				if (count > 0) {
					
					return true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null)
				cursor.close();
			cursor = null;
		}

		return false;
	}

	/**
	 * 
	 * 保存用户信息
	 * 
	 * */
	public static void saveUserInfo(Context context,UserModel model)
	{
		FinalDb fb=getFinalDb(context);
		fb.save(model);
	}
	/**获取用户信息*/
	public static UserModel getUserInfo(Context context)
	{
		FinalDb fb=getFinalDb(context);
		List<UserModel> models=fb.findAll(UserModel.class);
		if(models!=null&&models.size()>0)
		{
			return models.get(0);
		}
		return null;
	}

	/**更新用户信息*/
	public static void updateUserInfo(Context context,UserModel model)
	{
		FinalDb fb=getFinalDb(context);
		
		UserModel userModel=getUserInfo(context);
		if(userModel!=null)
		{
			int count=userModel.getLogcount();
			model.setLogcount(count);
		}
		fb.update(model, "`userid`='"+model.getUserid()+"'");
	}
	
	/**
	 * 
	 * 删除用户信息
	 * 
	 * */
	public static void deleteUserInfo(Context context,UserModel model)
	{
		FinalDb fb=getFinalDb(context);
		fb.delete(model);
	}
	
	
	
}
