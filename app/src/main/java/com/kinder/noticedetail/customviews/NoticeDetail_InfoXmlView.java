package com.kinder.noticedetail.customviews;

import android.content.Context;
import cn.kinder.bean.UserModel;
import cn.kinder.util.TimeUtils;

import com.kinder.notice.model.NoticeListModel;
import com.kinder.noticedetail.viewsxml.NoticeDetail_InfoXml;
import com.kinder.parent.model.ArticleListModel;

public class NoticeDetail_InfoXmlView extends NoticeDetail_InfoXml {

	public NoticeDetail_InfoXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	/**数据初始化*/
	public void initViewData(NoticeListModel model)
	{
		this.title_TextView.setText(model.getNoticetitle());
		UserModel user=model.getUserModel();
		if(user!=null)
		{
			this.desc_TextView.setText("来源:"+user.getUsername()+"  类型:"+getNoticeType(model.getNoticecate())+"     时间:"+TimeUtils.getActivityDetailTime(model.getAddtime()));
		}else
		{
			this.desc_TextView.setText("来源:"+""+"  类型:"+model.getNoticecate()+"     时间:"+TimeUtils.getActivityDetailTime(model.getAddtime()));
		}
		
	}
	
	/**根据通知类型获取通知说明*/
	private String getNoticeType(String notice)
	{
		if(notice==null||notice.equals(""))
		{
			return null;
		}
		if(notice.equals("1"))
		{
			return "食谱";
		}else if(notice.equals("2"))
		{
			return "教学";
		}else if(notice.equals("3"))
		{
			return "活动";
		}else if(notice.equals("4"))
		{
			return "通知";
		}
		return null;
	}
}
