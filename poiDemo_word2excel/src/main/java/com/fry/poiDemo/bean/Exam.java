package com.fry.poiDemo.bean;

import java.util.List;

public class Exam {
	String text;//���Ե�ȫ������
	String name;//��������
	List<Point> points;//���Զ�Ӧ��֪ʶ��
	String title;//���Եı���
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
