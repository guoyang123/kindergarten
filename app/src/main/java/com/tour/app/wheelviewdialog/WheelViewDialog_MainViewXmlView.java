package com.tour.app.wheelviewdialog;

import java.util.List;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.WheelView;
import android.content.Context;
import android.graphics.Color;

public class WheelViewDialog_MainViewXmlView extends WheelViewDialog_MainViewXml {

	private Context context;
	private float pro,screenW,screenH;
	private CustomDialogAdapter adapter;
	public WheelViewDialog_MainViewXmlView(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.pro=pro;
		this.screenW=screenW;
		this.screenH=screenH;
		
	}

	/**设置监听*/
	public void setListener(OnClickListener listener)
	{
		this.sure_Button.setOnClickListener(listener);
		this.cancel_Button.setOnClickListener(listener);
	}
	
//	/**设置标题*/
//	public void setTitle(String text)
//	{
//		this.desc_TextView.setText(text);
//	}
	
	/**设置数据源
	 * @param <T>*/
	public  void setDatas(List<BasicInfoModel> models)
	{
		String[] strs=new String[models.size()];
		for(int i=0;i<models.size();i++)
		{
			strs[i]=models.get(i).getTypename();
		}
		adapter=new CustomDialogAdapter(context,pro,strs,1);
		adapter.setItemResource(R.getRCode("layout", "wheelviewitem"));
		//adapter.setItemTextResource(itemTextResourceId)
		wheel_WheelView.setAdapter(adapter);
		wheel_WheelView.setText_size(((int)(sure_Button.getTextSize()*0.8)),(int)(sure_Button.getTextSize()));//(int)(15*pro)
		wheel_WheelView.setCurrentItem(models.size()/2);
		wheel_WheelView.addChangingListener(new OnWheelChangedListener() {
			
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				adapter.setCurrentItem(wheel_WheelView.getCurrentItem());
			}
		});
	}
	/**获取数据源*/
	public CustomDialogAdapter getAdapter() {
		return adapter;
	}
}


