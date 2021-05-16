package com.ieet.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;
import org.junit.Test;

import com.alibaba.excel.EasyExcel;
import com.ieet.pojo.Personnel;


public class Excel {

	
	String PATH = "D:\\MyWorkspace-Win32-Jdk10\\SSMIEET\\";
	@Test
	public void Write() throws Exception {
		
		Workbook workbook = new HSSFWorkbook();
		
		Sheet sheet = workbook.createSheet("adminwzw");
		
		for(int rowNum = 0 ; rowNum < 5 ; rowNum++)
		{
			Row row = sheet.createRow(rowNum);
			for (int cellNum = 0; cellNum < 10; cellNum++) {
				Cell cell = row.createCell(cellNum);
				cell.setCellValue(cellNum);
			}
		}
		
		
		FileOutputStream fileOutputStream = new FileOutputStream(PATH + "吴泽文统计表.xls");
		
		workbook.write(fileOutputStream);
		
		fileOutputStream.close();
		/*((SXSSFWorkbook)workbook).dispose();*/
		System.out.println("生成ok");
		
	}

	
	/*public void Read(FileInputStream inputStream ) throws Exception {
		
		
			
		Workbook workbook = new HSSFWorkbook(inputStream);
		
		Sheet sheet = workbook.getSheet("adminwzw");
		Row rowTitle = sheet.getRow(0);
		if (rowTitle!=null) {
			int CellCount = rowTitle.getPhysicalNumberOfCells();
			for(int CellNum = 0 ;CellNum < CellCount; CellNum++) {
				Cell cell = rowTitle.getCell(CellNum);
				if (cell!=null) {
					CellType cellType = cell.getCellType();
					String cellValue = cell.getStringCellValue();
					System.out.print(cellValue + " | ");
				}
			
			}
			System.out.println("..");
			
			//内容
			int rowCount = sheet.getPhysicalNumberOfRows();
			for (int rowNum = 1; rowNum < rowCount; rowNum++) {
				Row rowData = sheet.getRow(rowNum);
				if (rowData!=null) {
					//读取列
					int cellCount = rowTitle.getPhysicalNumberOfCells();
					for (int cellNum = 0; cellNum < cellCount; cellNum++) {
						System.out.print("("+(rowNum+1)+"-"+(cellNum+1)+")");
						
						Cell cell = rowData.getCell(cellNum);
						//匹配列的类型
						if(cell!=null) {
							CellType cellType = cell.getCellType();
							String cellValue = "";
							
							switch (cellType) {
							case STRING:
								System.out.print("[String]");
								cellValue = cell.getStringCellValue();
								break;
							case NUMERIC:	//日期 普通数字
								System.out.print("[NUMERIC]");
								if (HSSFDateUtil.isCellDateFormatted(cell)) {
									System.out.print("[日期]");
									Date date = cell.getDateCellValue();
									 cellValue = new DateTime(date).toString("yyyy-MM-dd");								
								}else {
									System.out.println("[转字符串]");
									cell.setCellType(cellType.STRING);
									cellValue = cell.toString();								
								}
								
								
								break;	
							case _NONE:
								System.out.print("[_NONE]");
								cellValue = cell.getStringCellValue();
								break;	
								
							case ERROR:
								System.out.print("[error");
								break;
							default:
								break;
							}
							System.out.print(cellValue);
						}						
					}
					System.out.println(".");
				}			
			}			
		}
		inputStream.close();	
	}*/
	
	@Test
	public void simpleWrite() {
		String fileName = PATH + "EasyTest.xlsx";
		
		EasyExcel.write(fileName,Personnel.class).sheet("model").doWrite(data2());
		System.out.println("ok");
	}

	private List<Personnel> data2() {
		
		ArrayList<Personnel> list = new ArrayList<Personnel>();
		for (int i = 0; i < 10; i++) {
			Personnel personnel = new Personnel(i,"wzw","教师","team","xxx","xxxx");			

			list.add(personnel);
		}
		return list;
	}
	
	@Test
	public void AAAa() {
	System.out.println("wzw");
		
	}
	
	 @Test
	    public void simpleWritewzw() {
	        // 写法1
			String fileName = PATH + "EasyTest.xlsx";
	        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
	        // 如果这里想使用03 则 传入excelType参数即可
	        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());

	      
	        }
	    
	 private List<DemoData> data() {
	        List<DemoData> list = new ArrayList<DemoData>();
	        for (int i = 0; i < 10; i++) {
	            DemoData data = new DemoData();
	            data.setString("字符串" + i);
	            data.setDate(new Date());
	            data.setDoubleData(0.56);
	            list.add(data);
	        }
	        return list;
	    }
}
