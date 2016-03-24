package com.kinder.notice.customviews;

import android.content.Context;
import android.view.View;

import cn.kinder.bean.UserModel;
import cn.kinder.util.TimeUtils;

import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.notice.model.NoticeListModel;
import com.kinder.notice.viewsxml.Notice_All_AdapterXml;

public class Notice_All_AdapterXmlView extends Notice_All_AdapterXml {

	private Context context;
	public Notice_All_AdapterXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	/**数据初始化*/
	public void initViewData(NoticeListModel model) 
	{
		// TODO Auto-generated method stub
		if(model==null)
		{
			return;
		}
		//图片
		String thumb=model.getThumb();
		if(thumb!=null&&!thumb.equals(""))
		{
			Kinder_Bitmap.getInstance(context).display(thumb_ImageView, thumb, getBitmapFromCache(context, "user_defaule"));
		}else
		{
			thumb_ImageView.setVisibility(View.GONE);
		}
		//标题
		String title=model.getNoticetitle();
		this.title_TextView.setText(title);
		//发布人
		UserModel userModel=model.getUserModel();
		if(userModel!=null)
		{
			this.author_TextView.setText("发布人:"+userModel.getUsername());
		}
		//时间
		String time=TimeUtils.getActivityDetailTime(model.getAddtime());
	    this.time_TextView.setText(time);
	
	}

}
