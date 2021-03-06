package com.kinder.perfect;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.kinder.app.tools.CameraTool;
import com.kinder.app.tools.CameraTool.CameraToolProtocol;
import com.kinder.app.tools.KinderEventMessage;
import com.kinder.perfect.customviews.PerfectMainViewXmlView;
import com.myt360.app.interfaces.OnUserPicClickListener;
import com.tour.app.camera.CameraDialogListener;
import com.tour.app.wheelviewdialog.WheelViewDialogListener;

import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.UserPicModel;

public class PerfectActivity_VC extends PerfectActivity_BC 
implements CameraDialogListener,CameraToolProtocol,WheelViewDialogListener,
OnUserPicClickListener
{

	private CameraTool camera;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		camera= new CameraTool(this, this);
		mainView=new PerfectMainViewXmlView(this,app.pro,app.screenW,app.screenH);
		mainView.setListener(this,this);
		setContentView(mainView);
		get_UserInfo_Datas_ByNetWork();
	}
	@Override
	public void onMessage(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageBackgroundThread(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageMainThread(Object object) {
		// TODO Auto-generated method stub
		if(object!=null&&object instanceof KinderEventMessage)
		{
			KinderEventMessage msg=(KinderEventMessage)object;
			switch(msg.getCode())
			{
			case KinderEventMessage.MSG_GET_USERIFNO_START:
				start_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GET_USERIFNO_SUCCESS:
				succ_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GET_USERIFNO_FAIL:
				fail_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_UPLOADPIC_START://图片上传
				start_uploadPic();
				break;
			case KinderEventMessage.MSG_UPLOADPIC_SUCCESS:
				succ_uploadPic(msg.getObj());
				break;
			case KinderEventMessage.MSG_UPLOADPIC_FAIL:
				fail_uploadPic();
				break;
			case KinderEventMessage.MSG_PERFECT_USERIFNO_START://完善信息
				startLoading();
				break;
			case KinderEventMessage.MSG_PERFECT_USERIFNO_SUCCESS://完善信息
				stopLoading();
				succ_updateInfo(msg.getObj());
				break;
			case KinderEventMessage.MSG_PERFECT_USERIFNO_FAIL://完善信息
				stopLoading();
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		if(id==mainView.save_Button.getId())
		{
		  logic_clickSaveBtn();
		}else if(id==mainView.userInfoView.userhead_ImageView.getId())
		{
			//点击用户头像
			model=new UserPicModel(-1,null);
			clickUserPic(this);
		}else if(id==mainView.userInfoView.back_Button.getId())
		{
			this.finish();
		}else if(id==mainView.userInfoView.nameinfoView.del_Button.getId())
		{
			mainView.userInfoView.nameinfoView.initData("");
		}else if(id==mainView.userInfoView.sexInfoView.getId())
		{
			//选择性别
			logic_clickSexItem(this);
		}else if(id==mainView.userInfoView.whoInfoView.getId())
		{
			//我是
			logic_clickWhoItem(this);
		}
	}

	
	@Override
	public EventMessage initLocalEventMessage() {
		// TODO Auto-generated method stub
		return getEventMessage();
	}

	@Override
	public EventMessage initPlugEventMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (resultCode == 0)
			return;
		
		// 拍照
		if (requestCode == CameraTool.PHOTO_REQUEST_TAKEPHOTO) {// 拍照

			// 设置文件保存路径
			// Utils.startPhotoZoom(this, Uri.fromFile(file), file, 100, 100);
			camera.ActivityResult(requestCode, resultCode, data,true);
			
		}
		if (data == null)
			return;
		

		// 读取相册缩放图片
		if (requestCode == CameraTool.PHOTO_REQUEST_GALLERY) {
			camera.ActivityResult(requestCode, resultCode, data,true);
		}
		// 处理结果
		if (requestCode == CameraTool.PHOTO_REQUEST_CUT) {

			camera.photoCutFinish();
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	@Override
	public void OnCameraResponse(Bitmap thumb, String picUrl, int status) {
		// TODO Auto-generated method stub
//		mainView.userInfoView.userhead_ImageView.setImageBitmap(thumb);
//		submit_updatepic_byNetWork(picUrl);
		
		if(model!=null)
		{
			picModels.add(model);
			
			int ps=model.getPosition();
			if(ps==-1)
			{
				mainView.userInfoView.userhead_ImageView.setImageBitmap(thumb);
			}else 
			{
				model.getPic_CircularImage().setImageBitmap(thumb);
			}
			submit_updatepic_byNetWork(picUrl,model);
		}
		
	}
	@Override
	public void onClickBtn(int position) {
		// TODO Auto-generated method stub
		if(position==CameraDialogListener.CAMERA_BUTTON)
		{
			camera.getPhotoFromCamera();
			
		}else if(position==CameraDialogListener.PHOTO_BUTTON)
		{
			camera.getPhotoFromGallery();
		}
	}
	@Override
	public void onClickBtn(int type, int position, int operationtype) {
		// TODO Auto-generated method stub
		logic_clickDialog(position,operationtype);
	}
	@Override
	public void onUserPicClick(UserPicModel userPicModel) {
		// TODO Auto-generated method stub
		this.model=userPicModel;
		clickUserPic(this);
	}
}
