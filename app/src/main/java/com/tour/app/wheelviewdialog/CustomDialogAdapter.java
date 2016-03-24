package com.tour.app.wheelviewdialog;

import java.util.List;

import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class CustomDialogAdapter extends ArrayWheelAdapter<String> {

	private float pro;
//	private List<View> views=new ArrayList<View>();
	private int currentItem,currentValue;
	public <T> CustomDialogAdapter(Context context, float pro,String[] strs,int current)
	{
		super(context, strs);
		// TODO Auto-generated constructor stub
		this.pro=pro;
	}

	public void setCurrentItem(int currentItem) {
		this.currentItem = currentItem;
	}


	


	@Override
	public View getItem(int index, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
	//	Log.e("buzz1", "==getItem: currentValue:"+currentValue+"currentItem:"+currentItem);
//		
//		this.currentValue=index;
//		convertView= super.getItem(index, convertView, parent);
//	    TextView text=(TextView)convertView.findViewById(R.id.text);
//		text.setTextSize((int)(15*pro));
//		text.setText(models.get(index).getTypename());
//		return convertView;
		return super.getItem(index, convertView, parent);
	}
}
