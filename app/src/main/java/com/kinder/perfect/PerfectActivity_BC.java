package com.kinder.perfect;

import android.widget.Toast;

import com.google.gson.Gson;
import com.kinder.app.tools.KinderNetWork;
import com.kinder.menu.MenuActivity_VC;
import com.kinder.perfect.customviews.PerfectMainViewXmlView;
import com.kinder.perfect.model.PerfectDataSource;
import com.kinder.perfect.model.UploadDataSource;
import com.myt360.kindergarten.Kind_BaseActivity;
import com.tour.app.camera.CameraDialogListener;
import com.tour.app.camera.CameraDialog_VC;
import com.tour.app.wheelviewdialog.BasicInfoModel;
import com.tour.app.wheelviewdialog.WheelViewDialogListener;
import com.tour.app.wheelviewdialog.WheelViewDialog_VC;

import java.util.ArrayList;
import java.util.List;

import cn.kinder.bean.BabyModel;
import cn.kinder.bean.RelationModel;
import cn.kinder.bean.UserModel;
import cn.kinder.bean.UserPicModel;
import cn.kinder.user.DbOperationModel;

public abstract class PerfectActivity_BC extends Kind_BaseActivity {

	public PerfectMainViewXmlView mainView;
	
	public static final int UPLOADPIC_DEFAULT=0;
	public static final int UPLOADPIC_START=1;
	public static final int UPLOADPIC_SUCCESS=2;
	public static final int UPLOADPIC_FAIL=3;
	public int upload_status=UPLOADPIC_DEFAULT;
	public boolean issubmit;//true:已按提交按钮，但是图片仍在上传
	//图片上传集合
	public List<UserPicModel> picModels=new ArrayList<UserPicModel>();
	protected UserPicModel model;//成功取得图片后将该对象添加到图片上传集合中。
	protected PerfectDataSource dataSource;
	/**链接网路接口，请求数据*/
	protected void get_UserInfo_Datas_ByNetWork()
	{
		KinderNetWork.get_UserInfo_ByNetWork(this, getEventMessage());
	}
	/**家长完善用户信息
	 * 
	 * @param  (username usertel usersex seniority)
	 * */
	protected void perfect_UserInfo_ByNetWork(String username,String usertel,String usersex,String seniority,String babys,String userpic)
	{
		KinderNetWork.perfect_UserInfo_ByNetWork(this, getEventMessage(), username, usertel, usersex, seniority, babys, userpic);
	}
	/**图片上传接口*/
	protected void submit_updatepic_byNetWork(String filename,UserPicModel model)
	{
		KinderNetWork.submit_updatepic_byNetWork(this, getEventMessage(), filename, model);
	}

	/**开始获取数据*/
	protected void start_getData(Object obj)
	{
		startLoading();
	}
	/**成功获取数据*/
	protected void succ_getData(Object obj)
	{
		stopLoading();
		if(obj!=null&&obj instanceof PerfectDataSource)
		{
			PerfectDataSource source=(PerfectDataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				this.dataSource=source;
				initMainViewData(dataSource);
			}else 
			{
				Toast.makeText(this, source.getErrorMsg(), Toast.LENGTH_SHORT).show();
			}
		}
	}
	/**失败获取数据*/
	protected void fail_getData(Object obj)
	{
		stopLoading();
	}
	/**数据初始化*/
	protected  void initMainViewData(PerfectDataSource source)
	{
		//数据初始化
		mainView.initData(source);
	}
	
	/**图片开始上传*/
	protected void start_uploadPic()
	{
		upload_status=UPLOADPIC_START;
	}
	
	/**图片上传成功*/
	protected void succ_uploadPic(Object obj)
	{
		
		if(obj!=null && obj instanceof UploadDataSource)
		{
			UploadDataSource source=(UploadDataSource)obj;
			String errorCode=source.getErrorCode();
			if(errorCode==null||errorCode.equals(""))
			{
				logic_succupload(source);
			}else
			{
			  Toast.makeText(this, source.getErrorMsg(), Toast.LENGTH_SHORT).show();
			  upload_status=UPLOADPIC_FAIL;
			  this.picModels.remove(source.getUserPicModel());
			}
			

			if(this.picModels.size()==0)//集合中的图片上传完毕
			{
				if(issubmit)
				{
					logic_clickSaveBtn_();
				}
				
			}
		}
	}
	
	/**图片上传成功后的逻辑处理*/
	private void logic_succupload(UploadDataSource source) {
		// TODO Auto-generated method stub
		UserPicModel model=source.getUserPicModel();
		if(model!=null)
		{
			int ps=model.getPosition();
			if(ps==-1)//用户头像上传
			{
				this.dataSource.getUserModel().setUserpic(source.getFileurl());
			}else
			{
				this.dataSource.getBabyModel().get(ps).setBabypic(source.getFileurl());
			}
			this.picModels.remove(model);
		}
	}
	/**图片开始上传*/
	protected void fail_uploadPic()
	{
		upload_status=UPLOADPIC_FAIL;
	}
	/**完善信息成功*/
	public void succ_updateInfo(Object obj)
	{
		if(obj!=null && obj instanceof PerfectDataSource)
		{
			PerfectDataSource source=(PerfectDataSource)obj;
			String errorcode=source.getErrorCode();
			if(errorcode==null||errorcode.equals(""))
			{
				Toast.makeText(this, "完善信息成功", Toast.LENGTH_SHORT).show();
				
				DbOperationModel.updateUserInfo(this, this.dataSource.getUserModel());
				
				skipActivity(MenuActivity_VC.class);
			}
		}
	}
	/**点击保存按钮*/
	public  void logic_clickSaveBtn() {
		// TODO Auto-generated method stub
		if(this.picModels.size()==0)//upload_status==UPLOADPIC_DEFAULT||upload_status==UPLOADPIC_SUCCESS||upload_status==UPLOADPIC_FAIL
		{
			logic_clickSaveBtn_();
		}else
		{
			issubmit=true;
		}
		
	}
	
	
	/**完善信息逻辑处理*/
	private void logic_clickSaveBtn_()
	{
		String username =mainView.userInfoView.nameinfoView.name_EditText.getText().toString();
		if(username==null||username.equals(""))
		{
			Toast.makeText(this, "用户名必填", Toast.LENGTH_SHORT).show();
			return ;
		}
	//	String usertel=mainView.userInfoView.phoneInfoView.value_TextView.getText().toString();
		String usersex=mainView.userInfoView.sexInfoView.getPosition()+"";
		
		if(dataSource==null)
		{
			return;
		}
		UserModel userModel=dataSource.getUserModel();
		String usertype=userModel.getUsertype();
		
		
		if(!mainView.clauseView.isAgre())
		{
			Toast.makeText(this, "请阅读并同意服务条款", Toast.LENGTH_SHORT).show();
			return;
		}
		
		
		if(usertype.equals("10005"))//家长
		{
			RelationModel relationModel=mainView.userInfoView.whoInfoView.getModel();
			String seniority="0";
			if(relationModel!=null)
			{
				seniority=String.valueOf(relationModel.getRelationid());
			}
			
			mainView.getBabaysInfo(dataSource);
		    this.dataSource.getUserModel().setUsername(username);
		    this.dataSource.getUserModel().setUsersex(usersex);
		    this.dataSource.getUserModel().setRelation(Integer.parseInt(seniority));
			List<BabyModel> babymodels=dataSource.getBabyModel();
			Gson gson=new Gson();
			String json=gson.toJson(babymodels);
			perfect_UserInfo_ByNetWork(username, null, usersex, seniority, json, this.dataSource.getUserModel().getUserpic());
		}else
		{
			 this.dataSource.getUserModel().setUsername(username);
			 this.dataSource.getUserModel().setUsersex(usersex);
			perfect_UserInfo_ByNetWork(username, null, usersex, null, null,this.dataSource.getUserModel().getUserpic());
		}
	}
	/**点击用户头像逻辑处理*/
	protected void clickUserPic(CameraDialogListener cameraDialogListener)
	{
		CameraDialog_VC dialog=new CameraDialog_VC(this,app.pro,app.screenW,app.screenH);
		dialog.setCameraDialogListener(cameraDialogListener);
		dialog.show();
	}
	
	/**选择性别控件*/
	protected void logic_clickSexItem(WheelViewDialogListener listener) {
		// TODO Auto-generated method stub
		List<BasicInfoModel> hotels=new ArrayList<BasicInfoModel>();
		hotels.add(new BasicInfoModel("0", "女"));
		hotels.add(new BasicInfoModel("1", "男"));
		
		if(hotels!=null&&hotels.size()>0)//酒店有数据
		{
			WheelViewDialog_VC hotel_Dialog=new WheelViewDialog_VC(this,app.pro,app.screenW,app.screenH,WheelViewDialogListener.OPERATIONTYPE_SEX);
			hotel_Dialog.setWheelViewDialogListener(listener);
			hotel_Dialog.setDatas(hotels);
			
		}
	}

	
	/**选我是谁控件*/
	protected void logic_clickWhoItem(WheelViewDialogListener listener) {
		// TODO Auto-generated method stub
		if(this.dataSource==null||this.dataSource.getRelationModel()==null||this.dataSource.getRelationModel().size()==0)
		{
			return;
		}
		List<BasicInfoModel> hotels=new ArrayList<BasicInfoModel>();
		List<RelationModel> relationModels=this.dataSource.getRelationModel();
		for(RelationModel model:relationModels)
		{
			hotels.add(new BasicInfoModel(String.valueOf(model.getRelationid()),model.getRelationname()));
		}
		
		
		if(hotels!=null&&hotels.size()>0)//酒店有数据
		{
			WheelViewDialog_VC hotel_Dialog=new WheelViewDialog_VC(this,app.pro,app.screenW,app.screenH,WheelViewDialogListener.OPERATIONTYPE_WHO);
			hotel_Dialog.setWheelViewDialogListener(listener);
			hotel_Dialog.setDatas(hotels);
			
		}
	}
	
	

	/**点击dialog确定按钮后，回调信息*/
	public void logic_clickDialog(int position,int operationtype)
	{
		if(operationtype==WheelViewDialogListener.OPERATIONTYPE_SEX)//性别
		{
			mainView.refreshSexData(position);
		}else if(operationtype==WheelViewDialogListener.OPERATIONTYPE_WHO)//我是
		{
			mainView.refreshWhoData(this.dataSource.getRelationModel().get(position));
		}
	}



}
