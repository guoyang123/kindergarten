package com.kinder.parent.model;

import java.io.Serializable;

public class ArticleListModel implements Serializable {

	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 6020091167968058064L;
	private int articleid;
	private String artiletitle;
	private String articletype;
	private String articleurl;
	private String thumb	;
	private String articlefrom;
	private String addtime;
	private int colcount	;
	private int iscollected;//当前用户是不是已经收藏这个文章0-是 1-否

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
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public int getColcount() {
		return colcount;
	}
	public void setColcount(int colcount) {
		this.colcount = colcount;
	}
	public int getIscollected() {
		return iscollected;
	}
	public void setIscollected(int iscollected) {
		this.iscollected = iscollected;
	}
	
	

}
