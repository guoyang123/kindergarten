package com.kinder.parent.model;

import java.io.Serializable;

public class ArticleModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6047317914700104807L;

	
	private int articleid	;//	文章id
	private String artiletitle;//	 	文字标题
	private String articletype;// 	类型，0是普通1是抓取
	private String menuName;//文章类型
	private String articlefrom	;//	 	来源
	private String articleurl;//	 	文章链接
	private String thumb	;// 	图片
	private int kinderid	;//	 	幼儿园id,如果是0，就是全部幼儿园都可以显示
	private String articlecontent;//	 	话题详情
	private String addtime;// 	添加时间
	private String status	;//	 	状态，0是下架，1是上架
	private int rank	;// 	排序
	private int colcount	;//	 	收藏次数
	private int articlmenu;// 	分类id
	private int articlup	;//	 	顶的数量
	private int articldown;// 	踩的数量
	private int iscollected;// 	当前用户是不是已经收藏这个文章 0-是 1-否
	private int isupdwn;//是否顶踩 0:未操作1:顶 2:踩
	private String redirctUrl;//手动录制的文章，分享后的url
	public int getArticleid() {
		return articleid;
	}
	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}
	public String getArtiletitle() {
		return artiletitle;
	}
	public void setArtiletitle(String artiletitle) {
		this.artiletitle = artiletitle;
	}
	public String getArticletype() {
		return articletype;
	}
	public void setArticletype(String articletype) {
		this.articletype = articletype;
	}
	public String getArticleurl() {
		return articleurl;
	}
	public void setArticleurl(String articleurl) {
		this.articleurl = articleurl;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getArticlefrom() {
		return articlefrom;
	}
	public void setArticlefrom(String articlefrom) {
		this.articlefrom = articlefrom;
	}
	public int getKinderid() {
		return kinderid;
	}
	public void setKinderid(int kinderid) {
		this.kinderid = kinderid;
	}
	public String getArticlecontent() {
		return articlecontent;
	}
	public void setArticlecontent(String articlecontent) {
		this.articlecontent = articlecontent;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getColcount() {
		return colcount;
	}
	public void setColcount(int colcount) {
		this.colcount = colcount;
	}
	public int getArticlmenu() {
		return articlmenu;
	}
	public void setArticlmenu(int articlmenu) {
		this.articlmenu = articlmenu;
	}
	public int getArticlup() {
		return articlup;
	}
	public void setArticlup(int articlup) {
		this.articlup = articlup;
	}
	public int getArticldown() {
		return articldown;
	}
	public void setArticldown(int articldown) {
		this.articldown = articldown;
	}
	public int getIscollected() {
		return iscollected;
	}
	public void setIscollected(int iscollected) {
		this.iscollected = iscollected;
	}
	public int getIsupdwn() {
		return isupdwn;
	}
	public void setIsupdwn(int isupdwn) {
		this.isupdwn = isupdwn;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getRedirctUrl() {
		return redirctUrl;
	}
	public void setRedirctUrl(String redirctUrl) {
		this.redirctUrl = redirctUrl;
	}
	

	
	
}
