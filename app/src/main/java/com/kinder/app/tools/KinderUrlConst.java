package com.kinder.app.tools;

public class KinderUrlConst {

	public static final String BASE_URL="http://112.74.87.155:8080/app"; 
	
	/**登陆接口*/
	public static final String LOGIN=BASE_URL+"/user/login.do";
	/**获取个人信息接口*/
	public static final String GET_USERINFO=BASE_URL+"/user/getUserInfo.do";
	/**环信获取个人信息接口*/
	public static final String GET_USERINFOBYEASEMOBID=BASE_URL+"/user/getUserByEasemobid.do";
	
	/**完善信息接口*/
	public static final String PERFECT_USERINFO=BASE_URL+"/user/updateUserInfoFirst.do";
	/**发送验证码*/
	public static final String GET_VERTIFY=BASE_URL+"/user/getSmsCode.do";
	/**图片上传接口*/
	public static final String UPLOADPIC=BASE_URL+"/user/uploadPicture.do";
	
	/**修改密码*/
	public static final String UPDATE_PSW=BASE_URL+"/user/changePassword.do";
	/**获取老师考勤*/
	public static final String CHECK_TEACHERURL=BASE_URL+"/check/teacherCheck.do";
	/**获取家长下所有宝宝接口*/
	public static final String GET_USERBABYSURL=BASE_URL+"/check/homeAllCheck.do";
	/**获取宝宝某月考勤接口*/
	public static final String GET_CHECKBABYSURL=BASE_URL+"/check/homeBabyCheck.do";
	/**发送安全码接口*/
	public static final String SEND_SAFTYCODEURL=BASE_URL+"/check/sendSaftyCode.do";
	/**获取疾病接口*/
	public static final String GET_DIEASESURL=BASE_URL+"/check/getDiseaseModel.do";
	/**请假接口*/
	public static final String SUBMIT_LEAVEURL=BASE_URL+"/check/saveKinderCheck.do";
    /**通讯录接口*/
    public static final String GET_CONTACTLIST_URL=BASE_URL+"/user/getContactsList.do";
   
    	 public static final String GET_CHATLIST_URL=BASE_URL+"/user/getChatList.do";
    
    /**意见反馈接口*/
    public static final String FEEDBACK_URL=BASE_URL+"/check/saveKinderFeedback.do";
    /**获取通知接口*/
    public static final String GET_NOTICE_URL=BASE_URL+"/notice/getNoticeList.do";
    /**获取通知详细接口*/
    public static final String GET_NOTICEDETAIL_URL=BASE_URL+"/notice/getNoticeContent.do";
    /**文章列表接口*/
    public static final String GET_ARTICLES_URL=BASE_URL+"/article/getArticleList.do";
    /**文章详细接口*/
    public static final String GET_ARTICLEDETAIL_URL=BASE_URL+"/article/getArticleInfo.do";
    /**根据班级环信ID获取班级家长*/
    public static final String GET_USERS_URL=BASE_URL+"/user/getClassUser.do";
    /**顶踩分享接口*/
    public static final String GET_PRAISESHARE_URL=BASE_URL+"/article/articleUDS.do";
    /**收藏、取消收藏接口*/
    public static final String GET_COLLECT_URL=BASE_URL+"/article/articleCollect.do";
    	 /**我的收藏接口*/
     public static final String GET_MYCOLLECTS_URL=BASE_URL+"/article/userArticleCollectList.do";
     /**宝宝报名接口*/
     public static final String GET_SIGN_URL=BASE_URL+"/notice/babyRegistration.do";
       
}
