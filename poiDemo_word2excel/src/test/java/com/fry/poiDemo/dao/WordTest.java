package com.fry.poiDemo.dao;

import java.net.URL;

import org.junit.Test;

import com.fry.poiDemo.dao.Word;



public class WordTest {
	//��ȡdocx�ļ��е����ֺ�ͼƬ
	@Test
	public void testDocxImage(){
		System.out.println("------------------------------����testDocxImage------------------------------");
		ClassLoader classLoader = getClass().getClassLoader(); 
		URL resource = classLoader.getResource("model2.docx"); 
		String srcFile = resource.getPath();  
        System.out.println(srcFile);  
        Word word=new Word();
        String imageFile="myRes//image2//";
        //��ȡsrcFileԴword�ļ�docx�е�imageͼƬ���Ҵ�����ļ���imageFile��
        word.readDocxImage(srcFile, imageFile);
	}
}