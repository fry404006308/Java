package com.fry.poiDemo.dao;

import org.junit.Test;

import com.fry.poiDemo.bean.Exam;
import com.fry.poiDemo.service.WordService;

public class ExcelTest {
	@Test
	public void testWriteExcel1(){
		Excel excel = new Excel();
		String excelName="myRes//excel//test1.xlsx";
		String wordFile ="myRes//word//model1.docx";
		String imageFile="myRes//image1//";
		Exam exam=new Exam();
		WordService wordService = new WordService();
		wordService.readWord(wordFile, imageFile, exam);
		
		excel.writeExcel(exam,excelName);
	}
	@Test
	public void testWriteExcel2(){
		Excel excel = new Excel();
		String excelName="myRes//excel//test2.xlsx";
		String wordFile ="myRes//word//model2.docx";
		String imageFile="myRes//image2//";
		Exam exam=new Exam();
		WordService wordService = new WordService();
		wordService.readWord(wordFile, imageFile, exam);
		
		excel.writeExcel(exam,excelName);
	}
	@Test
	public void testWriteExcel3(){
		Excel excel = new Excel();
		String excelName="myRes//excel//test3.xlsx";
		String wordFile ="myRes//word//model3.docx";
		String imageFile="myRes//image3//";
		Exam exam=new Exam();
		WordService wordService = new WordService();
		wordService.readWord(wordFile, imageFile, exam);
		
		excel.writeExcel(exam,excelName);
	}
}
