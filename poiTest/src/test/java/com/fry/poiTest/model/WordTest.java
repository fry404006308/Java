package com.fry.poiTest.model;

import java.net.URL;

import org.junit.*;
import org.junit.Assert.*;

public class WordTest {
//	@Test
	public void testDocx(){
		ClassLoader classLoader = getClass().getClassLoader(); 
		//test3.docx���洿����
//		URL resource = classLoader.getResource("test3.docx"); 
		//test4.docx������ͼƬ
		URL resource = classLoader.getResource("test4.docx"); 
		String srcFile = resource.getPath();  
        System.out.println(srcFile);  
		Word word=new Word();
		//��Word�е�readDocx������ȡpath��Ӧ��srcFile�ļ�docx�е�����
		word.readDocx(srcFile);
		
		//��srcFile��docx��word�ļ��е����ֶ�ȡ��destFile��txt���ı��ļ���ȥ
		String destFile="myRes//test3.txt";
		word.readDocx2(srcFile,destFile);
	}
	
	//��ȡdocx�ļ��е����ֺ�ͼƬ
//	@Test
	public void testDocxImage(){
		System.out.println("------------------------------����testDocxImage------------------------------");
		ClassLoader classLoader = getClass().getClassLoader(); 
		URL resource = classLoader.getResource("test4.docx"); 
		String srcFile = resource.getPath();  
        System.out.println(srcFile);  
        Word word=new Word();
        String imageFile="myRes//image//";
        //��ȡsrcFileԴword�ļ�docx�е�imageͼƬ���Ҵ�����ļ���imageFile��
        word.readDocxImage(srcFile, imageFile);
	}
	
	//��ȡword(.docx)�еı���
	@Test
	public void testDocxTable(){
		System.out.println("------------------------------����testDocxTable------------------------------");
		ClassLoader classLoader = getClass().getClassLoader(); 
		URL resource = classLoader.getResource("test5.docx"); 
		String srcFile = resource.getPath();  
        System.out.println(srcFile);  
        Word word=new Word();
        word.readDocxTable(srcFile);
	}
}