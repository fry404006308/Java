package com.fry.poiDemo.service;

import java.util.ArrayList;
import java.util.List;

import com.fry.poiDemo.bean.Exam;
import com.fry.poiDemo.bean.Option;
import com.fry.poiDemo.bean.Point;
import com.fry.poiDemo.bean.Question;
import com.fry.poiDemo.dao.Word;

public class WordService {
	//��srcFile��Ӧ��word�ļ��е����ݶ����ڴ���
	// ��ȡsrcFileԴword�ļ�docx�е�imageͼƬ���Ҵ�����ļ���imageFile��
	public void readData(String srcFile, String imageFile){
		Word word=new Word();
		String text=word.readDocxImage(srcFile, imageFile);//��dao��word�ļ��л�ȡ�����ı�
//		System.out.println(text);
		//�����г����ֺ͵�֮��Ķ����滻���滻��""
		String regex1="[1-9][0-9]*\\.\\[[\\w]*\\]";
		String temp[]=text.split(regex1);
		for(String item:temp){
			System.out.println("--------��ʼ��--------");
			System.out.println(item);
			System.out.println("--------������--------");
		}
	}
	
	//д����һ��Ҫı����
	
	//1�������Ĳ���Ӧ���ǰ�һ�����Զ����� readExam��Ҳ��readWord
	//2��Ȼ���������Խ��в���
	//��������ԵĶ��point������  getPoints
	//3��Ȼ���ÿһ��֪ʶ����в���
	//��ÿһ��֪ʶ�㻮�ֳ�ÿһ����Ŀ  getQuestions
	//4��Ȼ���ÿһ����Ŀ���в���
	//��ÿһ����Ŀ�ֳ���ɺ͸���ѡ���Լ��õ���ȷѡ��  getItems
	
	
	public void readWord(String srcFile, String imageFile){
		Exam exam=new Exam();
	}
	
	//1�������Ĳ���Ӧ���ǰ�һ�����Զ����� readExam��Ҳ��readWord
	public void readExam(String srcFile, String imageFile,Exam exam){
		Word word=new Word();
		String text=word.readDocxImage(srcFile, imageFile);//��dao��word�ļ��л�ȡ�����ı�
		
		//����dao��word�ļ��л�ȡ�����ı��浽exam������
		exam.setText(text);
		//��ȡ���Ե�����
		String examName=getFileName(srcFile);
		exam.setName(examName);
	}
	
	
	//2��Ȼ���������Խ��в���
	//��������ԵĶ��point������  getPoints
	public void readPoint(Exam exam){
		//��Exam��������ݶ����������point��
		List<Point> points=new ArrayList<Point>();
		String examText=exam.getText();
		String regex="[0-9]+\\.[0-9]+\\.[0-9]+\\s*";
		String[] pointTexts=examText.split(regex);

		for(int i=0;i<=pointTexts.length-1;i++){
			//�����Եı������Exam������
			if(i==0){
				String title=pointTexts[i].trim();
				exam.setTitle(title);
			}else{//��֪ʶ����뵽exam�����points��
				Point point = new Point();
				String pointText=pointTexts[i].trim();
				point.setText(pointText);
				points.add(point);
			}
		}
		//��д�����ݵ�point���õ�exam��setPoint��
		exam.setPoints(points);
	}
	
	//3��Ȼ���ÿһ��֪ʶ����в���
	//��ÿһ��֪ʶ�㻮�ֳ�ÿһ����Ŀ  getQuestions
	public void readQuestion(Point point){
		String pointText=point.getText();
		String regex ="[0-9]+\\.\\s*\\[\\w+\\]\\s*";
		String[] questionTexts=pointText.split(regex);
		List<Question> questions=new ArrayList<Question>();
		
		for(int i=0;i<questionTexts.length;i++){
			if(i==0){
				String pointName=questionTexts[i].trim();
				point.setPointName(pointName);
			}
			else{
				Question question=new Question();
				String questionText=questionTexts[i].trim();
				question.setText(questionText);
				questions.add(question);
			}
		}
		point.setQuestions(questions);
//		for(int i=0;i<questionTexts.length;i++){
//			System.out.println("-----------------------------����"+i+"��ʼ-----------------------------");
//			System.out.println(questionTexts[i]);
//			System.out.println("-----------------------------����"+i+"����-----------------------------");
//		}
	}
	
	//4��Ȼ���ÿһ����Ŀ���в���
	//��ÿһ����Ŀ�ֳ���ɺ͸���ѡ���Լ��õ���ȷѡ��  getItems
	public void readItem(Question question){
		String questionText=question.getText();
		//���ѡ����A.����ʽ��������������ѡ���ǣ�A������ʽ����������
		String regex ="[ABCD]\\s*[\\.��]\\s*";
		String regex1="[��(]\\s*[ABCD]\\s*[��)]\\s*";
		String[] optionTexts;
		Boolean havaDot=questionText.contains("A.")||questionText.contains("A .")||questionText.contains("A  .")||questionText.contains("A��")||questionText.contains("A ��");
		if(havaDot){
//			System.out.println("aaaaaaaaaaa");
			optionTexts=questionText.split(regex);
		}
		else{
			optionTexts=questionText.split(regex1);
		}
		
		List<Option> options=new ArrayList<Option>();
		for(int i=0;i<optionTexts.length;i++){
			if(i==0){
				String contentDescription=optionTexts[i].trim().replaceAll("[?��  ]", "");
				question.setContentDescription(contentDescription);
			}
			else{
				Option option_=new Option();
				String optionText=optionTexts[i].trim().replaceAll("[?��  ]", "");
				option_.setText(optionText);
				options.add(option_);
			}
		}
		question.setOptions(options);
	}
	
	//������ȷ�𰸵�ʱ���ҿ��԰����ԷǴ�д��ĸȫ���滻��""��Ȼ���������ַ������ڣ�ȡ���һ��
	public void readCorrectAnswer(Question question){
		String contentDescription=question.getContentDescription();
		String regex="[^A-Za-z]";
		String standard=contentDescription.replaceAll(regex, "");
		String ans="";
		if(standard.length()>=1){
			ans=standard.charAt(standard.length()-1)+"";
		}
		question.setCorrectAnswer(ans);
	}
	
	
	//��·���ܻ�ȡ�ļ�����
	/*
	 * �����·��������õ�model2
	 * //myRes//word//model1.docx
	 * */
	public String getFileName(String srcFile){
		String temp[]=srcFile.split("\\/");
		String temp1=temp[temp.length-1];
		String temp3[]=temp1.split("\\.");
		String txtFileName=temp3[0];
		return txtFileName;
	}
	
}