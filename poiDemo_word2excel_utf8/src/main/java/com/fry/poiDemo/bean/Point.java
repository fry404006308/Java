package com.fry.poiDemo.bean;

import java.util.List;

public class Point {
	String text;//这个知识点对应的全文
	String pointID;//point的id号
	String pointName;//point的名字
	List<Question> questions;//point里面的那些问题
	
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
