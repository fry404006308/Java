package com.fry.bean;

public class Question {
	String itemID;
	String contentDescription;
	Option options;
	String correctAnswer;
	Image_ images;
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
	public Option getOptions() {
		return options;
	}
	public void setOptions(Option options) {
		this.options = options;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public Image_ getImages() {
		return images;
	}
	public void setImages(Image_ images) {
		this.images = images;
	}
	
}
