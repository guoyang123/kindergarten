package com.kinder.parent.model;

import java.io.Serializable;
import java.util.List;

import cn.kinder.bean.Kinder_DataSource;

public class ArticleDetail_DataSource extends Kinder_DataSource implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1758142763070857062L;

	private ArticleModel ArticleModel;

	public ArticleModel getArticleModel() {
		return ArticleModel;
	}

	public void setArticleModel(ArticleModel articleModel) {
		ArticleModel = articleModel;
	}


	
	
}
