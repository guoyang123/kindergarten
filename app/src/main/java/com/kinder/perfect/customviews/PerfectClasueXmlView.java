package com.kinder.perfect.customviews;

import android.content.Context;

import com.kinder.perfect.viewsxml.PerfectClasueXml;

import android.view.View;
import android.view.View.OnClickListener;
public class PerfectClasueXmlView extends PerfectClasueXml implements OnClickListener{

	private boolean isAgre=true;
	public PerfectClasueXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.icon_ImageView.setOnClickListener(this);
		this.agrement_TextView.setOnClickListener(this);
	}

	
	
	public boolean isAgre() {
		return isAgre;
	}

	public void setAgre(boolean isAgre) {
		this.isAgre = isAgre;
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==icon_ImageView||v==agrement_TextView)
		{
			isAgre=!isAgre;
			if(isAgre)
			{
				this.icon_ImageView.setImageResource(R.getRCode("drawable", "agrement_agre"));
			}else
			{
				this.icon_ImageView.setImageResource(R.getRCode("drawable", "agrement"));
			}
		}
		
	}
	
	
	
	
}
