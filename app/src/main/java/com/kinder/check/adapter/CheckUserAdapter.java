package com.kinder.check.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.widget.Toast;

import com.kinder.check.CheckUserFragment_VC;

public class CheckUserAdapter extends FragmentPagerAdapter {

	
	private List<CheckUserFragment_VC> fragments=null;
	public CheckUserAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	public void setFragments(List<CheckUserFragment_VC> fragments) {
		this.fragments = fragments;
	}
	@Override
	public Fragment getItem(int arg0) 
	{
		// TODO Auto-generated method stub
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(fragments!=null)
		{
			return fragments.size();
		}
		return 0;
	}

	
}
