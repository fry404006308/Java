package com.fry.poiDemo.bean;

import java.util.List;

public class Question {
	String text;//ÿ�������Ӧ��ȫ��
	String itemID;//����ı��
	String contentDescription;//���������
	List<Option> options;//�����е�ѡ��
	String correctAnswer;//�������ȷ��
	List<Image_> images;//�����е�ͼƬ
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