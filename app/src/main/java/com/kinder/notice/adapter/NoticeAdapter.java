package com.kinder.notice.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class NoticeAdapter extends FragmentPagerAdapter {

	private List<Fragment> fragments=null;
	private String[]title;
	public NoticeAdapter(FragmentManager fm,List<Fragment> fragments,String[]title ) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.fragments=fragments;
		this.title=title;
	}

	
	
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragments.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return title[position];
	}

}
