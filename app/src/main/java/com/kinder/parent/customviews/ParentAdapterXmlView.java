package com.kinder.parent.customviews;

import android.content.Context;
import android.view.View;

import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.parent.model.ArticleListModel;
import com.kinder.parent.viewsxml.ParentAdapterXml;
import com.myt360.app.consts.RuleConst;

import cn.kinder.bean.UserModel;
import cn.kinder.util.TimeUtils;

public class ParentAdapterXmlView extends ParentAdapterXml {

	private Context context;
	private UserModel user;
	public ParentAdapterXmlView(Context context, float pro, float screenW,
			float screenH,UserModel user) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.user=user;
		if(user!=null)
		{
			String type=user.getUsertype();
			if(type!=null&&!type.equals(""))
			{
				if(type.equals(RuleConst.USER))
				{
					this.collectwrapview.setVisibility(View.VISIBLE);
				}else
				{
					this.collectwrapview.setVisibility(View.GONE);
				}
			}
		}
		
	}
	/**数据初始化*/
	public void initAdapterData(ArticleListModel model) {
		// TODO Auto-generated method stub
		if(model==null)
		{
			return;
		}
		//图片
		String thumb=model.getThumb();
		if(thumb!=null&&!thumb.equals(""))
		{
			//thumb=KinderUrlConst.PIC_URL+thumb;
			Kinder_Bitmap.getInstance(context).display(thumb_ImageView,thumb, getBitmapFromCache(context, "buzz_ppt_default"), getBitmapFromCache(context, "buzz_ppt_default"));
		}else
		{
			thumb_ImageView.setVisibility(View.GONE);
		}
		//标题
		String title=model.getArtiletitle();
		this.title_TextView.setText(title);
		//发布人
		String from=model.getArticletype();//model.getArticlefrom();
		if(from!=null&&!from.equals(""))
		{
			if(from.equals("0"))
			{
				this.author_TextView.setText("普通");//来源:
			}else
			{
				this.author_TextView.setText("转发");//来源:
			}
		}
		
		//时间
		String time=TimeUtils.getArticleTime(model.getAddtime());
	    this.time_TextView.setText(time);
	    
	   int collect= model.getIscollected();
	   if(collect==0)
	   {
		   this.collectwrapview.collect_ImageView.setImageResource(R.getRCode("drawable", "parent_collected"));
	   }else if(collect==1)
	   {
		   this.collectwrapview.collect_ImageView.setImageResource(R.getRCode("drawable", "parent_collect"));
	   }
		
	   this.collectwrapview.count_TextView.setText(String.valueOf(model.getColcount()));
	}
	
	/**获取来源*/
	public String getArticleFrom(String type)
	{
		String from=null;
		if(type!=null&&!type.equals(""))
		{
			if(type.equals("0"))
			{
				from="普通";
			}else if(type.equals("1"))
			{
				from="抓取";
			}else if(type.equals("2"))
			{
				from="转发";
			}
		}
		return from;
	}
}
