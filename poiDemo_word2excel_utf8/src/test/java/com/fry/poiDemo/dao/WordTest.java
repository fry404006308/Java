package com.fry.poiDemo.dao;

import java.net.URL;

import org.junit.Test;

import com.fry.poiDemo.dao.Word;



public class WordTest {
	//读取docx文件中的文字和图片
	@Test
	public void testDocxImage(){
		System.out.println("------------------------------这是testDocxImage------------------------------");
		ClassLoader classLoader = getClass().getClassLoader(); 
		URL resource = classLoader.getResource("model2.docx"); 
		String srcFile = resource.getPath();  
        System.out.println(srcFile);  
        Word word=new Word();
        String imageFile="myRes//image2//";
        //读取srcFile源word文件docx中的image图片并且存放在文件夹imageFile中
        word.readDocxImage(srcFile, imageFile);
	}
}
