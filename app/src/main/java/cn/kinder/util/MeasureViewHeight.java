package cn.kinder.util;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * 
 * 测量控件高度
 * 
 * */
public class MeasureViewHeight {

	
	 /**计算Listview的高度*/
	public static void measureListViewHeight(ListView listview){
		
		
			ListAdapter listAdapter=listview.getAdapter();
			if (listAdapter == null) {
	            return;
	        }
			int totalHeight = 0;  
	        for (int i = 0, len = (listAdapter.getCount()); i < len; i++) {   
	        View listItem = listAdapter.getView(i, null, listview);
	        listItem.measure(0, 0);
	        totalHeight += listItem.getMeasuredHeight();
	       }
	        ViewGroup.LayoutParams params = listview.getLayoutParams();
	        params.height = totalHeight
					+ (listview.getDividerHeight() * (listAdapter.getCount() - 1));
			listview.setLayoutParams(params);
	}
	
	 /**计算Gridview的高度*/
	public static void measureGridViewHeight(GridView listview){
			ListAdapter listAdapter=listview.getAdapter();
			if (listAdapter == null) {
	            return;
	        }
			int totalHeight = 0;  
			int rem=listAdapter.getCount()%2;
			int totalcount=listAdapter.getCount()/2;
			if(rem!=0){
				totalcount++;
			}
	        for (int i = 0, len = totalcount; i < len; i++) {   
	        View listItem = listAdapter.getView(i, null, listview);
	        listItem.measure(0, 0);
	        totalHeight += listItem.getMeasuredHeight();
	       }
	        ViewGroup.LayoutParams params = listview.getLayoutParams();
	        params.height = totalHeight;
			Log.e("params.height", listAdapter.getCount()+"--"+params.height+"");
			listview.setLayoutParams(params);
	}

}
