package com.kinder.check.customviews;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import cn.kinder.bean.BabyCheckModel;
import cn.kinder.util.TimeUtils;

import com.kinder.check.CheckUserFragment_VC;
import com.kinder.check.adapter.CheckUserAdapter;
import com.kinder.check.viewsxml.CheckUserXml;

public class CheckUserXmlView extends CheckUserXml {

	private CheckUserAdapter adapter;
	public CheckUserXmlView(Context context, float pro, float screenW,
			float screenH,FragmentManager fm) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		adapter=new CheckUserAdapter(fm);
		this.viewpager.setAdapter(adapter);
	}

	
	/**数据初始化*/
	public void setDatas(List<BabyCheckModel> datas)
	{
		List<CheckUserFragment_VC> fragments=new ArrayList<CheckUserFragment_VC>();
		if(datas!=null&&datas.size()>0)
		{
			for(int i=0;i<datas.size();i++)
			{
				CheckUserFragment_VC fragment=new CheckUserFragment_VC(datas.get(i));
				fragments.add(fragment);
				String time=TimeUtils.getTeacherCheckTime(new Date());
				Log.e("buzz1", "本月"+time+"已加入缓存");
				fragment.months.put(time, datas.get(i).getBabyCheckTimeModel());
			}
			this.adapter.setFragments(fragments);
			this.adapter.notifyDataSetChanged();
		}
	}
}
