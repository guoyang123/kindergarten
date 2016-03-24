package com.kinder.noticedetail;

import android.os.Bundle;
import android.view.View;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;

import com.kinder.app.tools.KinderEventMessage;
import com.kinder.app.tools.KinderNetWork;
import com.kinder.notice.model.JoinModel;
import com.kinder.noticedetail.customviews.NoticeDetailMainViewXmlView;
import com.tour.app.sign.SignDialogListener;

public class NoticeDetailActivity_VC extends NoticeDetailActivity_BC 
implements SignDialogListener
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initParam();
		mainView=new NoticeDetailMainViewXmlView(this,app.pro,app.screenW,app.screenH);
	    mainView.setListener(this);
		mainView.initViewBeforeData(noticelistmodel);
		setContentView(mainView);
	    if(noticelistmodel!=null)
	    {
	      String cate=noticelistmodel.getNoticecate();
	      if(cate!=null&&!cate.equals(""))
	      {
		    	   if(cate.equals("3"))//活动
		    	   {
		    		   KinderNetWork.interface_getNoticeDetail_byNetWork(this,getEventMessage(),String.valueOf(noticelistmodel.getNoticeid()),"1");
		    	   }else
		    	   {
		    		   KinderNetWork.interface_getNoticeDetail_byNetWork(this,getEventMessage(),String.valueOf(noticelistmodel.getNoticeid()),"0");
		    	   }
	      }
	    }
	    
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
			case KinderEventMessage.MSG_GETNOTICEDETAIL_START:
				start_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GETNOTICEDETAIL_SUCCESS:
				succ_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_GETNOTICEDETAIL_FAIL:
				fail_getData(msg.getObj());
				break;
				//
			case KinderEventMessage.MSG_SIGN_START://报名参加
				start_getData(msg.getObj());
				break;
			case KinderEventMessage.MSG_SIGN_SUCCESS:
				succ_signData(msg.getObj());
				break;
			case KinderEventMessage.MSG_SIGN_FAIL:
				fail_getData(msg.getObj());
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		int id=v.getId();
		if(id==mainView.titleBarView.back_Button.getId())
		{
			this.finish();
		}else if(id==mainView.bottomView.nopart_Button.getId())//不参加
		{
			logic_nopart(this);
			
		}else if(id==mainView.bottomView.part_Button.getId())//参加
		{
			logic_part(this);
			
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
	public void onClickBtn(JoinModel model) {
		// TODO Auto-generated method stub
	//	Toast.makeText(this, babys, 0).show();
		if(model==null)
		{
			return;
		}
		if(model.getIsjoin().equals("1"))//参加
		{
			addBabyToDatasource(model.getBabyModels());
		}
		KinderNetWork.interface_Sign_byNetWork(this, getEventMessage(), model.getBabyids(), model.getIsjoin(),noticelistmodel.getNoticeid()+"");
	}

}
