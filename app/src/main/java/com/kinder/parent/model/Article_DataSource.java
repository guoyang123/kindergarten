package com.kinder.parent.model;

import java.io.Serializable;
import java.util.List;

import cn.kinder.bean.Kinder_DataSource;

public class Article_DataSource extends Kinder_DataSource implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1758142763070857062L;

	private List<ArticleListModel> ArticleListModel;

	public List<ArticleListModel> getArticleListModel() {
		return ArticleListModel;
	}

	public void setArticleListModel(List<ArticleListModel> articleListModel) {
		ArticleListModel = articleListModel;
	}
	
	
	
}
