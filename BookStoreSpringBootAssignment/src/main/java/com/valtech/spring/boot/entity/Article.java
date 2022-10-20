package com.valtech.spring.boot.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("article")
public class Article extends Book{

	private String url;
	
	public Article() {}
	
	public Article(String name,Date whenPublished, String url) {
		super(name, whenPublished);
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Article [url=" + url + "]";
	}
	
}
