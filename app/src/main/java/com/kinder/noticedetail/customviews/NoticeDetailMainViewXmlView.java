package com.kinder.noticedetail.customviews;

import java.util.List;

import android.content.Context;
import android.view.View;

import cn.kinder.bean.BabyModel;

import com.kinder.notice.model.NoticeListModel;
import com.kinder.noticedetail.adapter.NoticeDetail_Adapter;
import com.kinder.noticedetail.model.NoticeDetail_DataSource;
import com.kinder.noticedetail.viewsxml.NoticeDetailMainViewXml;
import com.kinder.parent.model.ArticleListModel;

public class NoticeDetailMainViewXmlView extends NoticeDetailMainViewXml 
{
	

	public NoticeDetailMainViewXmlView(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	/**设置监听*/
	public void setListener(OnClickListener onClickListener)
	{
		this.titleBarView.setListener(onClickListener);
		this.bottomView.setListener(onClickListener);
	}
	
	public void initViewBeforeData(NoticeListModel listmodel)
	{
		this.infoView.initViewData(listmodel);
	}


	/**成功获取网络数据*/

	public void initMainViewData(NoticeDetail_DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		if(dataSource==null)
		{
			return;
		}
		String type=dataSource.getType();
		if(type!=null&&!type.equals(""))
		{
			if(type.equals("0"))//非活动
			{
				this.bottomView.setVisibility(View.GONE);
				this.partView.setVisibility(View.GONE);
			}else if(type.equals("1"))//活动
			{
				logic_bottom(dataSource);
				this.partView.setVisibility(View.VISIBLE);
				this.partView.initViewData(dataSource);
			}
			String content=dataSource.getNoticeModel().getNoticecontent();
			if(content!=null&&!content.equals(""))
			{
				if(content.startsWith("http"))
				{
					this.webviewwrap.setwebviewData(content, "url");
				}else
				{
					this.webviewwrap.setwebviewData(content, "code");
				}
			}
			
		}
	}
	
	/**若是活动类型，且无宝宝，则不显示参加按钮*/
	public void logic_bottom(NoticeDetail_DataSource dataSource)
	{
		List<BabyModel> models=dataSource.getHomeBabyModel();
		if(models!=null&&models.size()>0)
		{
			this.bottomView.setVisibility(View.VISIBLE);
		}else
		{
			this.bottomView.setVisibility(View.GONE);
		}
	}
}
