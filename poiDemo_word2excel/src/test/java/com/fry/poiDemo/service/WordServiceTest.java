package com.fry.poiDemo.service;

import java.net.URL;
import java.util.List;

import org.junit.Test;

import com.fry.poiDemo.bean.Exam;
import com.fry.poiDemo.bean.Option;
import com.fry.poiDemo.bean.Point;
import com.fry.poiDemo.bean.Question;

public class WordServiceTest {
	@Test
	public void testReadData(){
		//��ȡresource�е��ļ�
		ClassLoader classLoader = getClass().getClassLoader(); 
		URL resource = classLoader.getResource("model1.docx"); 
		String srcFile = resource.getPath();  
		String imageFile="myRes//image1//";
		//����WordService
		WordService wordService=new WordService();
		wordService.readData(srcFile, imageFile);
	}
	
	@Test
	public void testGetFileName(){
		String srcFile="//myRes//word//model1.docx";
		WordService wordService=new WordService();
		String name=wordService.getFileName(srcFile);
		System.out.println(name);
	}
	
	@Test
	public void testReadExam(){
		String srcFile ="myRes//word//model1.docx";
		String imageFile="myRes//image1//";
		Exam exam=new Exam();
		WordService wordService=new WordService();
		wordService.readExam(srcFile, imageFile, exam);
		System.out.println(exam.getText());
		System.out.println(exam.getName());
	}
	
	@Test
	public void testReadPoint(){
		String srcFile ="myRes//word//model1.docx";
		String imageFile="myRes//image1//";
		Exam exam=new Exam();
		WordService wordService=new WordService();
		wordService.readExam(srcFile, imageFile, exam);
		wordService.readPoint(exam);
		List<Point> points=exam.getPoints();
		System.out.println(points.size());
		for(int i=0;i<points.size();i++){
			System.out.println("--------------------------------֪ʶ��"+(i+1)+"��ʼ��--------------------------------");
			System.out.println(points.get(i).getText());
			System.out.println("--------------------------------֪ʶ��"+(i+1)+"������--------------------------------");
		}
	}
	
	@Test
	public void testReadQuestion(){
		String srcFile ="myRes//word//model1.docx";
		String imageFile="myRes//image1//";
		Exam exam=new Exam();
		WordService wordService=new WordService();
		wordService.readExam(srcFile, imageFile, exam);
		wordService.readPoint(exam);
		List<Point> points=exam.getPoints();
		for(int i=0;i<points.size();i++){
			wordService.readQuestion(points.get(i));
		}
		List<Question> questions=points.get(0).getQuestions();
		for(int i=0;i<questions.size();i++){
			System.out.println("-----------------------------����"+(i+1)+"��ʼ-----------------------------");
			System.out.println(questions.get(i).getText());
			System.out.println("-----------------------------����"+(i+1)+"����-----------------------------");	
		}
	}
	@Test
	public void testReadItem(){
		String srcFile ="myRes//word//testmodel2.docx";
		String imageFile="myRes//image//";
		Exam exam=new Exam();
		WordService wordService=new WordService();
		wordService.readExam(srcFile, imageFile, exam);
		wordService.readPoint(exam);
		List<Point> points=exam.getPoints();
		for(int i=0;i<points.size();i++){
			wordService.readQuestion(points.get(i));
		}
		List<Question> questions=points.get(0).getQuestions();
		for(int i=0;i<questions.size();i++){
			System.out.println("-----------------------------����"+(i+1)+"��ʼ-----------------------------");
			wordService.readItem(questions.get(i));
			System.out.println("------�������------");
			System.out.println(questions.get(i).getContentDescription());
			System.out.println("------��ɽ���------");
			List<Option> options=questions.get(i).getOptions();
			for(int j=0;j<options.size();j++){
				System.out.println("------����ѡ��"+j+"------");
				System.out.println(options.get(j).getText());
				System.out.println("------����ѡ��"+j+"------");
			}
			
			System.out.println(questions.get(i).getText());
			System.out.println("-----------------------------����"+(i+1)+"����-----------------------------");
		}
	}
	
	@Test
	public void testReadCorrectAnswer(){
		String srcFile ="myRes//word//testmodel2.docx";
		String imageFile="myRes//image//";
		Exam exam=new Exam();
		WordService wordService=new WordService();
		wordService.readExam(srcFile, imageFile, exam);
		wordService.readPoint(exam);
		List<Point> points=exam.getPoints();
		for(int i=0;i<points.size();i++){
			wordService.readQuestion(points.get(i));
		}
		List<Question> questions=points.get(0).getQuestions();
		for(int i=0;i<questions.size();i++){
			Question question=questions.get(i);
			wordService.readItem(question);
			wordService.readCorrectAnswer(question);
			System.out.println(question.getContentDescription());
			System.out.println("��ȷ���ǣ�"+question.getCorrectAnswer());
		}
	}
}
