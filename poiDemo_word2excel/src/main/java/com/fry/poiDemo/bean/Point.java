package com.fry.poiDemo.bean;

import java.util.List;

public class Point {
	String text;//���֪ʶ���Ӧ��ȫ��
	String pointID;//point��id��
	String pointName;//point������
	List<Question> questions;//point�������Щ����
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPointID() {
		return pointID;
	}
	public void setPointID(String pointID) {
		this.pointID = pointID;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
	
}
