package com.fry.poiDemo.service;

import com.fry.poiDemo.bean.Exam;
import com.fry.poiDemo.dao.Excel;

public class ExcelService {
	public void writeExcel(Exam exam,String excelName){
		Excel excel=new Excel();
		excel.writeExcel(exam,excelName);
	}
}
