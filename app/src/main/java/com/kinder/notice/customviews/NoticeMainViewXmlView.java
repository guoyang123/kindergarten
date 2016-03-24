package com.kinder.notice.customviews;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.Toast;

import com.kinder.notice.Notice_Active_Fragment_VC;
import com.kinder.notice.Notice_All_Fragment_VC;
import com.kinder.notice.Notice_Food_Fragment_VC;
import com.kinder.notice.Notice_Learn_Fragment_VC;
import com.kinder.notice.Notice_Notice_Fragment_VC;
import com.kinder.notice.adapter.NoticeAdapter;
import com.kinder.notice.model.NoticeListModel;
import com.kinder.notice.viewsxml.NoticeMainViewXml;
import com.kinder.parent.viewsxml.ParentMainViewXml;

public class NoticeMainViewXmlView extends NoticeMainViewXml 
{

	private NoticeAdapter adapter;
	private List<Fragment> fragments=new ArrayList<Fragment>();
	public NoticeMainViewXmlView(Context context, float pro, float screenW,
			float screenH,FragmentManager fm) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		fragments.clear();
		/** 
	     * Tab标题 
	     */  
	    String[] title = 
	    		new String[] { "全部", "通知", "食谱", "教学",  "活动" };  

	    
	    Notice_All_Fragment_VC all=new Notice_All_Fragment_VC(title[0]+"_0");
	    Notice_Notice_Fragment_VC notice=new Notice_Notice_Fragment_VC(title[1]+"_1");
	    Notice_Food_Fragment_VC food=new Notice_Food_Fragment_VC(title[2]+"_2");
	    Notice_Learn_Fragment_VC learn=new Notice_Learn_Fragment_VC(title[3]+"_3");
	    Notice_Active_Fragment_VC active=new Notice_Active_Fragment_VC(title[4]+"_4");
	    fragments.add(all);
	    fragments.add(notice);
	    fragments.add(food);
	    fragments.add(learn);
	    fragments.add(active);
	    adapter=new NoticeAdapter(fm,fragments,title);
	    this.viewpager.setAdapter(adapter);
	    
	    this.tabpageIndicator.setViewPager(viewpager);
	    
	}
	
	public void setListener(OnPageChangeListener listener)
	{
		this.tabpageIndicator.setOnPageChangeListener(listener);
	}

	/**搜索逻辑处理*/
	public void searchLogic(String searchText) {
		// TODO Auto-generated method stub
		int p=this.viewpager.getCurrentItem();
		if(p==0)
		{
			((Notice_All_Fragment_VC)(fragments.get(p))).searchLogic(searchText);
		}else if(p==1)
		{
			((Notice_Notice_Fragment_VC)(fragments.get(p))).searchLogic(searchText);
		}else if(p==2)
		{
			((Notice_Food_Fragment_VC)(fragments.get(p))).searchLogic(searchText);
		}else if(p==3)
		{
			((Notice_Learn_Fragment_VC)(fragments.get(p))).searchLogic(searchText);
		}else if(p==4)
		{
			((Notice_Active_Fragment_VC)(fragments.get(p))).searchLogic(searchText);
		}
	}

	/**通知而来数据模型
	 * noticecate
	 *  食谱  1
		教学 2
		通知 4
		活动 3
	 * 
	 * */
	public void initViewData(NoticeListModel noticeListModel) {
		// TODO Auto-generated method stub
		if(noticeListModel!=null)
		{
			String cate=noticeListModel.getNoticecate();
			if(cate!=null&&!cate.equals(""))
			{
				 if(cate.equals("1"))//食谱
				{
					viewpager.setCurrentItem(2);
				}else if(cate.equals("2"))//教学
				{
					viewpager.setCurrentItem(3);
				}else if(cate.equals("3"))//活动
				{
					viewpager.setCurrentItem(4);
				}else if(cate.equals("4"))//通知
				{
					viewpager.setCurrentItem(1);
				}
			}
			
			
			int p=this.viewpager.getCurrentItem();
			if(p==0)
			{
				((Notice_All_Fragment_VC)(fragments.get(p))).notifydetail(noticeListModel);
			}else if(p==1)
			{
				((Notice_Notice_Fragment_VC)(fragments.get(p))).notifydetail(noticeListModel);
			}else if(p==2)
			{
				((Notice_Food_Fragment_VC)(fragments.get(p))).notifydetail(noticeListModel);
			}else if(p==3)
			{
				((Notice_Learn_Fragment_VC)(fragments.get(p))).notifydetail(noticeListModel);
			}else if(p==4)
			{
				((Notice_Active_Fragment_VC)(fragments.get(p))).notifydetail(noticeListModel);
			}
			
			
			
		}
	}

}
