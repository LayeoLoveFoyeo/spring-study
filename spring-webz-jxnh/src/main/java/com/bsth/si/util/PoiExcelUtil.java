/**
 * @Title: PoiExcelUtil.java
 * @Package com.sine.excel
 * @Description: TODO
 * Copyright: Copyright (c) 2012
 * Company: 
 *
 * @author sine
 * @date 2012-12-21 上午10:06:22
 * 
 * @version V1.0
 *//*

package com.bsth.si.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

*/
/**
 * 关于poi处理excel的一些util工具， 总体方向：找出标志符号，替换新值
 * 
 * @ClassName: PoiExcelUtil
 * @Description: TODO
 * @author sine
 * @date 2012-12-21 上午10:06:22
 * 
 *//*

public class PoiExcelUtil {
	private static Logger logger = Logger.getLogger(PoiExcelUtil.class);

	public static void main(String[] args) throws Exception {
		File file = new File("src/com/sine/excel/file/product.xls");
		HashMap<String, Object> map = PoiExcelUtil.getExcelObjectData(file);
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "    \t   " + entry.getValue());
		}
	}

	*/
/**
	 * 功能：获取EXCEL数据 String 类型
	 * 
	 * @param file
	 *            文件
	 * @return HashMap<String, String>
	 *//*

	public static HashMap<String, String> getExcelStringData(File file) {
		return getExcelStringData(file, 0);
	}

	*/
/**
	 * 功能：获取EXCEL数据 String 类型
	 * 
	 * @param file
	 *            文件
	 * @param index
	 *            sheet的位置
	 * @return HashMap<String, String>
	 *//*

	public static HashMap<String, String> getExcelStringData(File file, int index) {
		HashMap<String, String> map = new HashMap<String, String>();
		map = getSheetStringData(getWorkbook(file), index);
		return map;
	}

	*/
/**
	 * 功能：获取EXCEL数据 Object 类型
	 * 
	 * @param file
	 *            文件
	 * @return HashMap<String, Object>
	 *//*

	public static HashMap<String, Object> getExcelObjectData(File file) {
		return getExcelObjectData(file, 0);
	}

	*/
/**
	 * 功能：获取EXCEL数据 Object 类型
	 * 
	 * @param file
	 *            文件
	 * @param index
	 *            sheet的位置
	 * @return HashMap<String, Object>
	 *//*

	public static HashMap<String, Object> getExcelObjectData(File file, int index) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map = getSheetObjectData(getWorkbook(file), index);
		return map;
	}

	*/
/**
	 * 获取sheet内的值 getSheetStringData
	 * 
	 * 
	 * @Title: getSheetStringData
	 * @Description: TODO
	 * @param @param wb
	 * @param @param index
	 * @param @return 设定文件
	 * @return HashMap<String,String> 返回类型
	 *//*

	private static HashMap<String, String> getSheetStringData(Workbook wb, int index) {
		HashMap<String, String> map = new HashMap<String, String>();
		Sheet sheet = wb.getSheetAt(index);
		map.put("rowSize", String.valueOf(sheet.getLastRowNum() + 1));
		for (int r = 0; r < sheet.getLastRowNum() + 1; r++) {
			Row row = sheet.getRow(r);
			// 行为空
			if (row != null)
				for (int c = 0; c < row.getLastCellNum(); c++) {
					Cell cell = row.getCell(c);
					if (cell != null)
						map.put(r + "/" + c, PoiExcelUtil.getCellStringValue(cell));
				}
		}
		return map;
	}

	*/
/**
	 * 获取sheet内的值 getSheetObjectData
	 * 
	 * 
	 * @Title: getSheetObjectData
	 * @Description: TODO
	 * @param @param wb
	 * @param @param index
	 * @param @return 设定文件
	 * @return HashMap<String,Object> 返回类型
	 *//*

	private static HashMap<String, Object> getSheetObjectData(Workbook wb, int index) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Sheet sheet = wb.getSheetAt(index);
		map.put("rowSize", String.valueOf(sheet.getLastRowNum() + 1));
		for (int r = 0; r < sheet.getLastRowNum() + 1; r++) {
			Row row = sheet.getRow(r);
			// 行为空
			if (row != null)
				for (int c = 0; c < row.getLastCellNum(); c++) {
					Cell cell = row.getCell(c);
					if (cell != null)
						map.put(r + "/" + c, PoiExcelUtil.getCellObjectValue(cell));
				}
		}
		return map;
	}

	public static Workbook getWorkbook(File file) {
		if (file.getName().contains(".xlsx")) {
			try {
				XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
				return xwb;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (file.getName().contains(".xls")) {
			try {
				HSSFWorkbook hwb = new HSSFWorkbook(new FileInputStream(file));
				return hwb;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	*/
/**
	 * 获取sheet内的值 getStringCellValue 取CELL值
	 * 
	 * @Title: getStringCellValue
	 * @Description: TODO
	 * @param @param cell
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 *//*

	public static String getCellStringValue(Cell cell) {
		String v_excelData = null;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: // 数字日期类型
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				// 日期格式
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				v_excelData = dateFormat.format(cell.getDateCellValue());
			} else {
				v_excelData = cell.getNumericCellValue() + "";
				BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
				v_excelData = bd.toPlainString();
			}
			break;
		case Cell.CELL_TYPE_STRING:
			// 字符串
			v_excelData = cell.getStringCellValue();
			v_excelData = v_excelData.trim();
			if (v_excelData.equals("") || v_excelData.length() <= 0)
				v_excelData = "";
			break;
		case Cell.CELL_TYPE_FORMULA:
			// 公式
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			v_excelData = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_BLANK:
			// 空白
			v_excelData = "";
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			// 布尔型
			v_excelData = cell.getBooleanCellValue() + "";
			break;
		case Cell.CELL_TYPE_ERROR:
			// Error
			v_excelData = "";
			break;
		}
		return v_excelData;
	}

	*/
/**
	 * 
	 * getCellObjectValue 取CELL值
	 * 
	 * @Title: getCellObjectValue
	 * @Description: TODO
	 * @param @param cell
	 * @param @return 设定文件
	 * @return Object 返回类型
	 * @throws
	 *//*

	public static Object getCellObjectValue(Cell cell) {
		Object v_excelData = null;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: // 数字日期型
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				v_excelData = cell.getDateCellValue();
			} else {
				v_excelData = cell.getNumericCellValue();
			}
			break;
		case Cell.CELL_TYPE_STRING:
			// 字串型
			v_excelData = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_FORMULA:
			// 公式型
			v_excelData = cell.getCellFormula();
			break;
		case Cell.CELL_TYPE_BLANK:
			// 空白型
			v_excelData = "";
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			// 布朗型
			v_excelData = cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_ERROR:
			// Error
			v_excelData = cell.getErrorCellValue();
			break;
		}
		return v_excelData;
	}

	*/
/**
	 * 插入CELL insertCell
	 * 
	 * @Title: insertCell
	 * @Description: TODO
	 * @param @param cell
	 * @param @param cellStyle
	 * @param @param obj 设定文件
	 * @return void 返回类型
	 * @throws
	 *//*

	public static void insertCell(Cell cell, int cellStyle, Object obj) {
		if (!obj.equals("") && obj != null) {
			Class<? extends Object> clz = obj.getClass();
			switch (cellStyle) {
			case Cell.CELL_TYPE_NUMERIC: // 数字日期类型
				if (clz.equals(Long.class)) {
					logger.debug("Long");
					cell.setCellValue(Long.valueOf(obj.toString().trim()));
				} else if (clz.equals(Integer.class)) {
					logger.debug("Integer");
					cell.setCellValue(Integer.valueOf(obj.toString().trim()));
				} else if (clz.equals(Double.class)) {
					logger.debug("Double");
					cell.setCellValue(Double.valueOf(obj.toString().trim()));
				} else if (clz.equals(Float.class)) {
					logger.debug("Float");
					cell.setCellValue(Float.valueOf(obj.toString().trim()));
				}
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				break;
			case Cell.CELL_TYPE_STRING:
				// 字符串
				cell.setCellValue(obj.toString());
				cell.setCellType(Cell.CELL_TYPE_STRING);
				break;
			case Cell.CELL_TYPE_FORMULA:
				// 公式
				cell.setCellValue(obj.toString());
				cell.setCellType(Cell.CELL_TYPE_FORMULA);
				break;
			case Cell.CELL_TYPE_BLANK:
				// 空白
				cell.setCellValue("");
				cell.setCellType(Cell.CELL_TYPE_BLANK);
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				// 布尔型
				cell.setCellValue(Boolean.valueOf(obj.toString()));
				cell.setCellType(Cell.CELL_TYPE_BOOLEAN);
				break;
			case Cell.CELL_TYPE_ERROR:
				// Error
				break;
			}
		}
	}

	*/
/**
	 * 插入值 insertCell 支持 Long Integer Double Float String 的对应转换
	 * 
	 * @Title: insertCell
	 * @Description: TODO
	 * @param @param cell
	 * @param @param obj 设定文件
	 * @return void 返回类型
	 * @throws
	 *//*

	public static void insertCell(Cell cell, Object obj) {
		if (!obj.equals("") && obj != null) {
			if (obj instanceof Long) {
				logger.debug("Long");
				cell.setCellValue(Long.valueOf(obj.toString().trim()));
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			} else if (obj instanceof Integer) {
				logger.debug("Integer");
				cell.setCellValue(Integer.valueOf(obj.toString().trim()));
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			} else if (obj instanceof Double) {
				logger.debug("Double");
				cell.setCellValue(Double.valueOf(obj.toString().trim()));
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			} else if (obj instanceof Float) {
				logger.debug("Float");
				cell.setCellValue(Float.valueOf(obj.toString().trim()));
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			} else if (obj instanceof BigDecimal) {
				logger.debug("BigDecimal");
				cell.setCellValue(obj.toString());
				cell.setCellType(Cell.CELL_TYPE_STRING);
			} else if (obj instanceof String) {
				// 字符串
				logger.debug("String");
				cell.setCellValue(obj.toString());
				cell.setCellType(Cell.CELL_TYPE_STRING);
			} else if (obj instanceof Date) {
				logger.debug("Date");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd mm:ss");
				cell.setCellValue(dateFormat.format(obj));
				cell.setCellType(Cell.CELL_TYPE_STRING);
			} else {
				logger.debug("=============" + obj.getClass());
				logger.debug("String");
				cell.setCellValue(obj.toString());
				cell.setCellType(Cell.CELL_TYPE_STRING);
			}
		}
	}

	public static HashMap<String, Object> getReplacedValue(File oldFile, File newFile,
			HashMap<String, Object> newValue, int index) {
		// 用于替换的map
		HashMap<String, Object> replaceValue = new HashMap<String, Object>();
		// 获取所有的cell值
		HashMap<String, Object> map = PoiExcelUtil.getExcelObjectData(oldFile, index);
		// 找到特殊标记,替换值
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			Object entryValue = entry.getValue();
			if (!entryValue.equals("") && entryValue instanceof String) {
				String uniqueValue = (String) entryValue;
				if (uniqueValue.startsWith("#") && uniqueValue.endsWith("#")) {
					uniqueValue = uniqueValue.substring(1, uniqueValue.length() - 1);
					if (newValue.get(uniqueValue) != null) {
						replaceValue.put(entry.getKey(), newValue.get(uniqueValue));
					} else {
						replaceValue.put(entry.getKey(), " ");
					}
				}
			}
		}
		return replaceValue;
	}

	*/
/**
	 * 根据模版 插入值 workbookWrite
	 * 
	 * 
	 * @Title: workbookWrite
	 * @Description: TODO
	 * @param @param oldFile
	 * @param @param newFile
	 * @param @param rList 是个map的集合，顺序就是sheet的顺序
	 * @return void 返回类型
	 * @throws
	 *//*

	public static void workbookWrite(File oldFile, File newFile, List<HashMap<String, Object>> rList) {
		FileOutputStream fileOut = null;
		HSSFWorkbook hwb = null;
		try {
			fileOut = new FileOutputStream(newFile);
			hwb = new HSSFWorkbook(new FileInputStream(oldFile));
			for (int i = 0; i < rList.size(); i++) {
				HSSFSheet sheet = hwb.getSheetAt(i);
				HashMap<String, Object> map = rList.get(i);
				for (Entry<String, Object> entry : map.entrySet()) {
					String[] rc = entry.getKey().split("/");
					int row = Integer.valueOf(rc[0]);
					int col = Integer.valueOf(rc[1]);
					HSSFCell cell = sheet.getRow(row).getCell(col);
					PoiExcelUtil.insertCell(cell, entry.getValue());
				}
			}
			hwb.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void workbookWrite1(File oldFile, File newFile, List<List<Object>> rList, int roffset, int coffset) {
		FileOutputStream fileOut = null;
		HSSFWorkbook hwb = null;
		try {
			fileOut = new FileOutputStream(newFile);
			hwb = new HSSFWorkbook(new FileInputStream(oldFile));
			HSSFSheet sheet = hwb.getSheetAt(0);
			for (int i = 0,len = rList.size(); i < len; i++) {
				List<Object> list = rList.get(i);
				HSSFRow hrow = sheet.createRow(i + roffset);
				for (int j = 0,len1 = list.size();j <len1;j++) {
					HSSFCell cell = hrow.createCell(j + coffset);
					PoiExcelUtil.insertCell(cell, list.get(j));
				}
			}
			hwb.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.flush();
				fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
*/
