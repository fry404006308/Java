package com.fry.poiTest.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;

public class Word {
	//用Word中的readDocx函数读取path对应的srcFile文件中的文字
	public void readDocx(String srcFile){
		File file = new File(srcFile);
        String str = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            XWPFDocument xdoc = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            String doc1 = extractor.getText();
            System.out.println(doc1);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	//将srcFile（docx）word文件中的文字读取到destFile（txt）文本文件中去
	public void readDocx2(String srcFile,String destFile){
		//word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
		OPCPackage opcPackage;
		try {
			opcPackage = POIXMLDocument.openPackage(srcFile);
			POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
			String text2007 = extractor.getText();
			System.out.println(text2007);
			//将2007的测试输出结果打印到files\\2003.txt
			PrintStream ps2=new PrintStream(destFile);
			ps2.println(text2007);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OpenXML4JException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//maven太好用了
	//读取srcFile源word文件docx中的image图片并且存放在文件夹imageFile中
	public void readDocxImage(String srcFile,String imageFile){
		String path =srcFile;
	    File file = new File(path);
	    try {
	      //用XWPFWordExtractor来获取文字
	      FileInputStream fis = new FileInputStream(file);
	      XWPFDocument document = new XWPFDocument(fis);
	      XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(document);
	      String text = xwpfWordExtractor.getText();
	      System.out.println(text);
	      
	      //用XWPFDocument的getAllPictures来获取所有的图片
	      List<XWPFPictureData> picList = document.getAllPictures();
	      for (XWPFPictureData pic : picList) {
	        System.out.println(pic.getPictureType() + file.separator + pic.suggestFileExtension()
	            +file.separator+pic.getFileName());
	        byte[] bytev = pic.getData();
	        System.out.println(bytev.length);
	        //大于1000bites的图片我们才弄下来，消除word中莫名的小图片的影响
	        if(bytev.length>300){
	        	FileOutputStream fos = new FileOutputStream(imageFile+pic.getFileName()); 
		        fos.write(bytev);
	        }
	      }
	      fis.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	//读取word(.docx)中的表格
	public void readDocxTable(String srcFile){
		System.out.println("------------------------------这是读取表格readDocxTable分割线------------------------------");
		XWPFDocument document;
		try {
			document = new XWPFDocument(new FileInputStream(srcFile));
			// 获取所有表格
			List<XWPFTable> tables = document.getTables();
			for (XWPFTable table : tables) {
			    // 获取表格的行
			    List<XWPFTableRow> rows = table.getRows();
			    for (XWPFTableRow row : rows) {
			        // 获取表格的每个单元格
			        List<XWPFTableCell> tableCells = row.getTableCells();
			        for (XWPFTableCell cell : tableCells) {
			             // 获取单元格的内容
			             String text = cell.getText();
			             System.out.println(text);
			        }
			    }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//读取word(.docx)中的图片的位置
	public void readDocxImagePosition(String srcFile){
		XWPFDocument document;
		try {
			document = new XWPFDocument(new FileInputStream(srcFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
