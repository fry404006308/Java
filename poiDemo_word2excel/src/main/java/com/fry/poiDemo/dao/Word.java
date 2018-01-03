package com.fry.poiDemo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

public class Word {
	// maven̫������
	// ��ȡsrcFileԴword�ļ�docx����
	// ��ȡsrcFileԴword�ļ�docx�е�imageͼƬ���Ҵ�����ļ���imageFile��
	public String readDocxImage(String srcFile, String imageFile) {
		String path = srcFile;
		File file = new File(path);
		try {
			// ��XWPFWordExtractor����ȡ����
			FileInputStream fis = new FileInputStream(file);
			XWPFDocument document = new XWPFDocument(fis);
			XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(document);
			String text = xwpfWordExtractor.getText();
//			System.out.println(text);
			//����ȡ�������ִ�ŵ���Ӧ�ļ����е�txt�ļ���
			String temp[]=srcFile.split("\\/");
			String temp1=temp[temp.length-1];
			String temp3[]=temp1.split("\\.");
			String txtFileName="myRes//txt//"+temp3[0]+".txt";
			PrintStream ps = new PrintStream(txtFileName);
			ps.println(text);
			

			// ��XWPFDocument��getAllPictures����ȡ���е�ͼƬ
			List<XWPFPictureData> picList = document.getAllPictures();
			for (XWPFPictureData pic : picList) {
//				System.out.println(pic.getPictureType() + file.separator + pic.suggestFileExtension() + file.separator
//						+ pic.getFileName());
				byte[] bytev = pic.getData();
//				System.out.println(bytev.length);
				// ����1000bites��ͼƬ���ǲ�Ū����������word��Ī����СͼƬ��Ӱ��
				if (bytev.length > 300) {
					FileOutputStream fos = new FileOutputStream(imageFile + pic.getFileName());
					fos.write(bytev);
				}
			}
			fis.close();
			return text;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}