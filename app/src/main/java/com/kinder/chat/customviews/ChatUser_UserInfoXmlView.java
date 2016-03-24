package com.kinder.chat.customviews;

import java.util.List;

import android.content.Context;
import android.view.View;

import cn.kinder.bean.RelationModel;
import cn.kinder.bean.UserModel;

import com.kinder.app.tools.Kinder_Bitmap;
import com.kinder.chat.viewsxml.ChatUser_UserInfoXml;
import com.kinder.perfect.model.PerfectDataSource;
import com.myt360.app.consts.RuleConst;

public class ChatUser_UserInfoXmlView extends ChatUser_UserInfoXml {

	private Context context;
	public ChatUser_UserInfoXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	/**数据初始化*/
	public void initData(PerfectDataSource dataSource) {
		// TODO Auto-generated method stub
		
		UserModel userModel=dataSource.getUserModel();
		if(userModel==null)
		{
			return;
		}
		String usertype=userModel.getUsertype();
		if(usertype!=null&&!usertype.equals(""))
		{
			if(usertype.equals(RuleConst.USER))//家长
			{
				this.rule_TextView.setVisibility(View.VISIBLE);
			}
		}
		//用户头像
				String userpic=userModel.getUserpic();
				if(userpic!=null&&!userpic.equals(""))
				{
					Kinder_Bitmap.getInstance(context).display(userhead_CircularImage, userpic, getBitmapFromCache(context, "user_defaule"));
				}else
				{
					userhead_CircularImage.setImageBitmap(getBitmapFromCache(context, "user_default"));
				}
				//姓名
				this.name_TextView.setText(userModel.getUsername());
				//性别
				String usersex=userModel.getUsersex();
				if(usersex!=null&&!usersex.equals(""))
				{
					if(usersex.equals("0"))
					{
						this.sex_ImageView.setImageResource(R.getRCode("drawable", "girl"));
					}else
					{
						this.sex_ImageView.setImageResource(R.getRCode("drawable", "man"));
					}
				}
				
				//我是
				int relation=userModel.getRelation();
				List<RelationModel> relationmodels=dataSource.getRelationModel();
				if(relationmodels!=null&&relationmodels.size()>0)
				{
					for(RelationModel model:relationmodels)
					{
						if(relation==model.getRelationid())
						{
							this.rule_TextView.setText("我是"+model.getRelationname());
						}
					}
				}
				
	}

}
