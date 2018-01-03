package com.fry.poiDemo.bean;

import java.util.List;

public class Question {
	String text;//每个问题对应的全文
	String itemID;//问题的编号
	String contentDescription;//问题的主干
	List<Option> options;//问题中的选项
	String correctAnswer;//问题的正确答案
	List<Image_> images;//问题中的图片
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getContentDescription() {
		return contentDescription;
	}
	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public List<Image_> getImages() {
		return images;
	}
	public void setImages(List<Image_> images) {
		this.images = images;
	}
	
	
	
}
