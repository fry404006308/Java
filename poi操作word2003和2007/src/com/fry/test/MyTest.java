package com.fry.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

public class MyTest {
	public static void main(String[] args) {
		readWord("myRes\\test3.docx");
	}
	
	public static void readWord(String fileName){
		try {
			//word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
			OPCPackage opcPackage = POIXMLDocument.openPackage(fileName);
			POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
			String text = extractor.getText();
			System.out.println(text);
			//将2007的测试输出结果打印到files\\2003.txt
			PrintStream ps2=new PrintStream(fileName);
			ps2.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
