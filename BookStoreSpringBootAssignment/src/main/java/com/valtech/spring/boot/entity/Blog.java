package com.valtech.spring.boot.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("blog")
public class Blog extends Book {

	private String url;
	private int VisitedCount;
	
	public Blog() {}
	
	public Blog(String name,Date whenPublished,String url, int visitedCount) {
		super(name, whenPublished);
		this.url = url;
		VisitedCount = visitedCount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getVisitedCount() {
		return VisitedCount;
	}

	public void setVisitedCount(int visitedCount) {
		VisitedCount = visitedCount;
	}

	@Override
	public String toString() {
		return "Blog [url=" + url + ", VisitedCount=" + VisitedCount + "]";
	}
	
}
