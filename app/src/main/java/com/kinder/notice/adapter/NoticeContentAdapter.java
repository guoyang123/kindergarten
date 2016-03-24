package com.kinder.notice.adapter;

import java.util.List;

import com.kinder.notice.customviews.NoticeAdapterLinearLayout;
import com.kinder.notice.model.NoticeListModel;
import com.kinder.notice.model.Notice_DataSource;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class NoticeContentAdapter extends BaseAdapter {

   private Context context;
   private float pro,screenW,screenH;
   private List<NoticeListModel>	 models;
	
   public NoticeContentAdapter(Context context, float pro, float screenW,
			float screenH) 
		{
			super();
			this.context = context;
			this.pro = pro;
			this.screenW = screenW;
			this.screenH = screenH;
	    }
	
   public void setModels(List<NoticeListModel> models) {
	this.models = models;
}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(models!=null)
		{
			return models.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null)
		{
			convertView=new NoticeAdapterLinearLayout(context,pro,screenW,screenH);
		}
		NoticeAdapterLinearLayout adapter=(NoticeAdapterLinearLayout)convertView;
		adapter.noticeAdapterView.initViewData(this.models.get(position));
		
		return convertView;
	}

}
