package com.mk.testframework.dt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;

public class ExcelUtils {

	public static String ExcelPath;
	static File file;
	static FileInputStream ExcelFile;
	private final Environment env;
	private Context context;

	@Inject
	public ExcelUtils(Environment env, Context context) {
		this.env = env;
		this.context = context;
	}

	public static String excelfileName = null;
	public static String testDataExcelPath = null;
	public static Workbook excelWBook;
	public static Sheet excelWSheet;
	public static Cell cell;
	private Row row;
	public int rowNumber;
	public static int columnNumber;


	/**
	 * This method has 1 parameter: "Excel sheet name". It creates FileInputStream
	 * and set excel file and excel sheet to excelWBook and excelWSheet variables.
	 */
	public void setExcelFileSheet() {
		String sheetName = "orders";
		testDataExcelPath = "orders" + File.separator;
		try {
			File file = new File(testDataExcelPath + excelfileName);
			FileInputStream inputStream = new FileInputStream(file);
			String fileExtensionName = excelfileName.substring(excelfileName.indexOf("."));
			if (fileExtensionName.equals(".xlsx")) {
				excelWBook = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equals(".xls")) {
				excelWBook = new HSSFWorkbook(inputStream);
			}
			excelWSheet = excelWBook.getSheet(sheetName);
		} catch (Exception e) {
			try {
				throw (e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void setEnvExcelFile() {
		testDataExcelPath = "orders" + File.separator;
		try {
			excelfileName = "Orders_Automation_" + env.getCurrentLocale().toString() + ".xlsx";
			File file = new File(testDataExcelPath + excelfileName);
			System.out.println("Excel File set : " + excelfileName);
			FileInputStream inputStream = new FileInputStream(file);
			String fileExtensionName = excelfileName.substring(excelfileName.indexOf("."));
			if (fileExtensionName.equals(".xlsx")) {
				excelWBook = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equals(".xls")) {
				excelWBook = new HSSFWorkbook(inputStream);
			}
		} catch (Exception e) {
			try {
				throw (e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * This method reads the test data from the Excel cell. We are passing row
	 * number and column number as parameters.
	 */
	public String getCellData(int rowNum, int colNum) {
		try {
			cell = excelWSheet.getRow(rowNum).getCell(colNum);
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			throw (e);
		}
	}
	
	public String device() {
		String device;
		boolean mobile = env.isSysPropsSpecified(Environment.SysProps.MOBILE);
		if(mobile) {
			device = "mobile";
		}else {
			device = "desktop";
		}
		return device;
	}

	public List<String> getCellData() throws IOException {
		String sheetName = env.getCurrentLocale().toString(); 
		List<String> arrName = new ArrayList<String>();
		int colNum = 0;

		testDataExcelPath = "conf" + File.separator + env.getProperty("deployment")+File.separator +device()+"_menulist.xlsx";
		FileInputStream fis = new FileInputStream(testDataExcelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		try {
			for(int i=0;i<sheet.getLastRowNum();i++) {
			
			XSSFCell cell = sheet.getRow(i).getCell(colNum);
			arrName.add(cell.getStringCellValue());
			}
			System.out.println("Array size: "+arrName.size());
			return arrName;
		} catch (Exception e) {
			throw (e);
		}
		
	}

	public void setCellData(String value, String scriptNumber) throws IOException {
		setOrderID(value, scriptNumber);
		setDate(value, scriptNumber);
	}

	public void setOrderID(String value, String scriptNumber) throws IOException {
		int rowNum = 0;
		int colNum = 2;
		testDataExcelPath = "orders" + File.separator + "Orders_Automation_" + env.getCurrentLocale().toString()
				+ ".xlsx";
		String sheetName = "orders";
		FileInputStream fis = new FileInputStream(testDataExcelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		System.out.println("Input sheet: " + sheet.getSheetName() + " is read from location: " + testDataExcelPath);
		XSSFRow row = sheet.getRow(0);
		int col_num = -1;
		int count = 1;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals("ScriptNumber")) {
				col_num = i;
				break;
			}
		}
		XSSFCell cell = row.getCell(col_num);
		row = sheet.getRow(count);
		cell = row.getCell(col_num);

		while (cell.getStringCellValue() != "") {
			String valuescriptNumber = cell.getStringCellValue();

			row = sheet.getRow(count);
			cell = row.getCell(col_num);
			if (valuescriptNumber.equalsIgnoreCase(scriptNumber)) {
				rowNum = count;
				break;
			}
			count++;
		}

		try {
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(value);
			} else {
				cell.setCellValue(value);
			}
			// Create an object of File class to write excel file
			File excelFileName = new File(testDataExcelPath);

			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(excelFileName);

			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			try {
				throw (e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void setDate(String value, String scriptNumber) throws IOException {
		int rowNum = 0;
		int colNum = 1;
		testDataExcelPath = "orders" + File.separator + "Orders_Automation_" + env.getCurrentLocale().toString()
				+ ".xlsx";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy");
		String dateOfOrderPlacement = formater.format(calendar.getTime());
		String sheetName = "orders";
		FileInputStream fis = new FileInputStream(testDataExcelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		System.out.println("Input sheet: " + sheet.getSheetName() + " is read from location: " + testDataExcelPath);
		XSSFRow row = sheet.getRow(0);
		int col_num = -1;
		int count = 1;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals("ScriptNumber")) {
				col_num = i;
				break;
			}
		}
		XSSFCell cell = row.getCell(col_num);
		row = sheet.getRow(count);
		cell = row.getCell(col_num);
		while (cell.getStringCellValue() != "") {
			String valuescriptNumber = cell.getStringCellValue();
			row = sheet.getRow(count);
			cell = row.getCell(col_num);
			if (valuescriptNumber.equalsIgnoreCase(scriptNumber)) {
				rowNum = count;
				break;
			}
			count++;
		}
		try {
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(dateOfOrderPlacement);
			} else {
				cell.setCellValue(dateOfOrderPlacement);
			}
			File excelFileName = new File(testDataExcelPath);
			FileOutputStream fileOut = new FileOutputStream(excelFileName);
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			//fis.close();
		} catch (Exception e) {
			try {
				throw (e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void zipOrderFile() {
		try {
			String filePath = "orders" + File.separator;
			File file = new File(filePath + "Orders_Automation_" + env.getCurrentLocale().toString() + ".xlsx");
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			formater.format(calendar.getTime());
			String zipFileName = filePath + "archives" + File.separator + "Orders_Automation_"
					+ env.getCurrentLocale().toString() + "_" + formater.format(calendar.getTime()) + ".zip";
			addToZipFile(file, zipFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addToZipFile(File file, String zipFileName) throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream(zipFileName);
		ZipOutputStream zos = new ZipOutputStream(fos);
		ZipEntry zipEntry = new ZipEntry(file.getName());
		zos.putNextEntry(zipEntry);
		FileInputStream fis = new FileInputStream(file);
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) > 0) {
			zos.write(bytes, 0, length);
		}
		zos.closeEntry();
		zos.close();
		fis.close();
		fos.close();
		System.out.println(file.getCanonicalPath() + " is zipped to " + zipFileName);
		context.setOrderZipStatus(true);
	}

}
