package com.kinder.app.tools;

/**消息类型定义*/
public class KinderEventMessage 
{

	//登陆接口
	public static final int MSG_LOGIN_START=1;
	public static final int MSG_LOGIN_SUCCESS=2;
	public static final int MSG_LOGIN_FAIL=3;
	//获取个人信息接口
	public static final int MSG_GET_USERIFNO_START=4;
	public static final int MSG_GET_USERIFNO_SUCCESS=5;
	public static final int MSG_GET_USERIFNO_FAIL=6;
	//完善家长个人信息接口
	public static final int MSG_PERFECT_USERIFNO_START=7;
	public static final int MSG_PERFECT_USERIFNO_SUCCESS=8;
	public static final int MSG_PERFECT_USERIFNO_FAIL=9;
	//获取验证码接口
	public static final int MSG_GET_VERFITY_START=10;
	public static final int MSG_GET_VERFITY_SUCCESS=11;
	public static final int MSG_GET_VERFITY_FAIL=12;
	//图片上传接口
	public static final int MSG_UPLOADPIC_START=13;
	public static final int MSG_UPLOADPIC_SUCCESS=14;
	public static final int MSG_UPLOADPIC_FAIL=15;			
		
	//设置密码接口
	public static final int MSG_SETPSW_START=16;
	public static final int MSG_SETPSW_SUCCESS=17;
	public static final int MSG_SETPSW_FAIL=18;		
	
	//老师考勤
	public static final int MSG_CHECKTEACHER_START=19;
	public static final int MSG_CHECKTEACHER_SUCCESS=20;
	public static final int MSG_CHECKTEACHER_FAIL=21;	
	//老师下所有宝宝
	public static final int MSG_USERBABAYS_START=22;
	public static final int MSG_USERBABYS_SUCCESS=23;
	public static final int MSG_USERBABYS_FAIL=24;	
	//宝宝某月考勤接口
	public static final int MSG_CHECKBABY_START=25;
	public static final int MSG_CHECKBABY_SUCCESS=26;
	public static final int MSG_CHECKBABY_FAIL=27;	
	//发送安全码接口
	public static final int MSG_SENDCODE_START=29;
	public static final int MSG_SENDCODE_SUCCESS=30;
	public static final int MSG_SENDCODE_FAIL=31;	
	
	//获取疾病接口
	public static final int MSG_DIEASE_START=32;
	public static final int MSG_DIEASE_SUCCESS=33;
	public static final int MSG_DIEASE_FAIL=34;	
	
	//提交请假接口
	public static final int MSG_SUBMITLEAVE_START=35;
	public static final int MSG_SUBMITLEAVE_SUCCESS=36;
	public static final int MSG_SUBMITLEAVE_FAIL=37;	
	
	//通讯录接口
	public static final int MSG_CONTACTLIST_START=38;
	public static final int MSG_CONTACTLIST_SUCCESS=39;
	public static final int MSG_CONTACTLIST_FAIL=40;	
	//意见反馈接口
	public static final int MSG_FEEDBACK_START=41;
	public static final int MSG_FEEDBACK_SUCCESS=42;
	public static final int MSG_FEEDBACK_FAIL=43;	
	
	//获取通知接口
	public static final int MSG_GETNOTICE_START=44;
	public static final int MSG_GETNOTICE_SUCCESS=45;
	public static final int MSG_GETNOTICE_FAIL=46;
	
	//获取通知详细接口
	public static final int MSG_GETNOTICEDETAIL_START=47;
	public static final int MSG_GETNOTICEDETAIL_SUCCESS=48;
	public static final int MSG_GETNOTICEDETAIL_FAIL=49;
	
	//获取文章列表接口
	public static final int MSG_GETARTICLES_START=50;
	public static final int MSG_GETARTICLES_SUCCESS=51;
	public static final int MSG_GETARTICLES_FAIL=52;
	
	//获取文章详细接口
	public static final int MSG_GETARTICLEDETAIL_START=53;
	public static final int MSG_GETARTICLEDETAIL_SUCCESS=54;
	public static final int MSG_GETARTICLEDETAIL_FAIL=55;
	
	//根据班级环信ID获取班级家长
	public static final int MSG_GETUSERS_START=56;
	public static final int MSG_GETUSERS_SUCCESS=57;
	public static final int MSG_GETUSERS_FAIL=58;
	
	//顶踩分享接口
	public static final int MSG_PRAISESHARE_START=59;
	public static final int MSG_PRAISESHARE_SUCCESS=60;
	public static final int MSG_PRAISESHARE_FAIL=61;
	
	//收藏、取消收藏接口
	public static final int MSG_COLLECT_START=62;
	public static final int MSG_COLLECT_SUCCESS=63;
	public static final int MSG_COLLECT_FAIL=64;
	
	//报名接口
	public static final int MSG_SIGN_START=65;
	public static final int MSG_SIGN_SUCCESS=66;
	public static final int MSG_SIGN_FAIL=67;
	//重新登录提示
	public static final int MSG_RELOGIN=68;
	
	
	
	private int code;
	private Object obj;
	public KinderEventMessage(int code, Object obj) {
		super();
		this.code = code;
		this.obj = obj;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
