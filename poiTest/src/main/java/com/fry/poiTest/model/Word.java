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
	//��Word�е�readDocx������ȡpath��Ӧ��srcFile�ļ��е�����
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
	
	//��srcFile��docx��word�ļ��е����ֶ�ȡ��destFile��txt���ı��ļ���ȥ
	public void readDocx2(String srcFile,String destFile){
		//word 2007 ͼƬ���ᱻ��ȡ�� �����е����ݻᱻ�����ַ��������
		OPCPackage opcPackage;
		try {
			opcPackage = POIXMLDocument.openPackage(srcFile);
			POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
			String text2007 = extractor.getText();
			System.out.println(text2007);
			//��2007�Ĳ�����������ӡ��files\\2003.txt
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
	
	//maven̫������
	//��ȡsrcFileԴword�ļ�docx�е�imageͼƬ���Ҵ�����ļ���imageFile��
	public void readDocxImage(String srcFile,String imageFile){
		String path =srcFile;
	    File file = new File(path);
	    try {
	      //��XWPFWordExtractor����ȡ����
	      FileInputStream fis = new FileInputStream(file);
	      XWPFDocument document = new XWPFDocument(fis);
	      XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(document);
	      String text = xwpfWordExtractor.getText();
	      System.out.println(text);
	      
	      //��XWPFDocument��getAllPictures����ȡ���е�ͼƬ
	      List<XWPFPictureData> picList = document.getAllPictures();
	      for (XWPFPictureData pic : picList) {
	        System.out.println(pic.getPictureType() + file.separator + pic.suggestFileExtension()
	            +file.separator+pic.getFileName());
	        byte[] bytev = pic.getData();
	        System.out.println(bytev.length);
	        //����1000bites��ͼƬ���ǲ�Ū����������word��Ī����СͼƬ��Ӱ��
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
	
	//��ȡword(.docx)�еı���
	public void readDocxTable(String srcFile){
		System.out.println("------------------------------���Ƕ�ȡ����readDocxTable�ָ���------------------------------");
		XWPFDocument document;
		try {
			document = new XWPFDocument(new FileInputStream(srcFile));
			// ��ȡ���б���
			List<XWPFTable> tables = document.getTables();
			for (XWPFTable table : tables) {
			    // ��ȡ�������
			    List<XWPFTableRow> rows = table.getRows();
			    for (XWPFTableRow row : rows) {
			        // ��ȡ�����ÿ����Ԫ��
			        List<XWPFTableCell> tableCells = row.getTableCells();
			        for (XWPFTableCell cell : tableCells) {
			             // ��ȡ��Ԫ�������
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
	
	
	//��ȡword(.docx)�е�ͼƬ��λ��
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