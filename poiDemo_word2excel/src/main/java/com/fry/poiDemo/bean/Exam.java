package com.fry.poiDemo.bean;

import java.util.List;

public class Exam {
	String text;//测试的全文内容
	String name;//测试名称
	List<Point> points;//测试对应的知识点
	String title;//测试的标题
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	
}
