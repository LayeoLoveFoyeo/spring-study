/*
package com.bsth.si.util;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;

import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class JxlUtil {

	public static void main(String[] args) throws Exception {
		JxlUtil jxl = new JxlUtil();
		HashMap<String, Object> map = jxl.importXLS("3.xls", "Sheet1");

		System.out.println(map.get("colSize"));
		System.out.println(map.get("rowSize"));

		int colSize = Integer.valueOf(map.get("colSize").toString());
		int rowSize = Integer.valueOf(map.get("rowSize").toString());

		for (int c = 1; c < colSize; c++) {
			for (int r = 1; r < rowSize; r++) {
				Object temp = map.get(c + "/" + r);
				System.out.print(temp + "\t");
			}
			System.out.println("");
		}
	}

	public HashMap<String, Object> importXLS(String e, Object obj)
			throws Exception {
		Sheet sheet;
		if (obj instanceof String) {
			sheet = getSheetFromXls(e, obj.toString());
		} else {
			sheet = getSheetFromXls(e, Integer.parseInt(obj.toString()));
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		*/
/*
		 * 全部将数据放到map中，key 为坐标 将行列的数量也存放到map中 r = 1,排除标题
		 *//*

		map.put("colSize", String.valueOf(sheet.getColumns()));
		map.put("rowSize", String.valueOf(sheet.getRows()));
		for (int c = 0; c < sheet.getColumns(); c++) {
			for (int r = 1; r < sheet.getRows(); r++) {
				map.put(r + "/" + (c + 1), sheet.getCell(c, r).getContents());
			}
		}
		return map;
	}

	public HashMap<String, String> importXLS(File file, Object obj)
			throws Exception {
		Sheet sheet;
		if (obj instanceof String) {
			sheet = getSheetFromXls(file, obj.toString());
		} else {
			sheet = getSheetFromXls(file, Integer.parseInt(obj.toString()));
		}
		HashMap<String, String> map = new HashMap<String, String>();
		*/
/*
		 * 全部将数据放到map中，key 为坐标 将行列的数量也存放到map中 r = 1,排除标题
		 *//*

		map.put("colSize", String.valueOf(sheet.getColumns()));
		map.put("rowSize", String.valueOf(sheet.getRows()));
		for (int c = 0; c < sheet.getColumns(); c++) {
			for (int r = 1; r < sheet.getRows(); r++) {
				CellType type = sheet.getCell(c, r).getType();
				CellType date = type.DATE;
				map.put(r + "/" + (c + 1), sheet.getCell(c, r).getContents());
			}
		}
		return map;
	}

	public HashMap<String, Object> importXLO(File file, Object obj)
			throws Exception {
		Sheet sheet;
		if (obj instanceof String) {
			sheet = getSheetFromXls(file, obj.toString());
		} else {
			sheet = getSheetFromXls(file, Integer.parseInt(obj.toString()));
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		*/
/*
		 * 全部将数据放到map中，key 为坐标 将行列的数量也存放到map中 r = 1,排除标题
		 *//*

		map.put("colSize", String.valueOf(sheet.getColumns()));
		map.put("rowSize", String.valueOf(sheet.getRows()));
		for (int c = 0; c < sheet.getColumns(); c++) {
			for (int r = 1; r < sheet.getRows(); r++) {
				CellType type = sheet.getCell(c, r).getType();
				CellType date = type.DATE;
				if (type == date) {
					map.put(r + "/" + (c + 1),
							((DateCell) sheet.getCell(c, r)).getDate());
				} else {
					map.put(r + "/" + (c + 1), sheet.getCell(c, r)
							.getContents());
				}
			}
		}
		return map;
	}

	*/
/**
	 * 检查字段
	 * 
	 * @param str
	 * @param c
	 * @param r
	 *//*

	public boolean checkNull(String str, int c, int r) {
		if (str == null || "".equals(str)) {
			System.out.println("行：" + (r + 1) + " 列：" + (c + 1) + ": 字段为空！");
			return true;
		} else {
			return false;
		}
	}

	*/
/**
	 * 获取对象
	 * 
	 * @param xlspath
	 *            excel的路径
	 * @param sheetName
	 *            sheet的名字
	 * @return
	 * @throws Exception
	 *//*

	private Sheet getSheetFromXls(String xlspath, String sheetName)
			throws Exception {
		InputStream is = JxlUtil.class.getResourceAsStream(xlspath);
		Workbook workbook = Workbook.getWorkbook(is);
		return workbook.getSheet(sheetName);
	}

	private Sheet getSheetFromXls(File file, String sheetName) throws Exception {
		Workbook workbook = Workbook.getWorkbook(file);
		return workbook.getSheet(sheetName);
	}

	*/
/**
	 * 获取对象
	 * 
	 * @param xlspath
	 *            excel的路径
	 * @param sheetName
	 *            sheet的位置
	 * @return
	 * @throws Exception
	 *//*

	private Sheet getSheetFromXls(String xlspath, int sheetIndex)
			throws Exception {
		InputStream is = JxlUtil.class.getResourceAsStream(xlspath);
		Workbook workbook = Workbook.getWorkbook(is);
		return workbook.getSheet(sheetIndex);
	}

	private Sheet getSheetFromXls(File file, int sheetIndex) throws Exception {
		Workbook workbook = Workbook.getWorkbook(file);
		return workbook.getSheet(sheetIndex);
	}
	
	

	public static void insertNumber(WritableSheet wws, int col, int row, int value) {
		try {
			Number cell = new Number(col, row, value);
			CellFormat cf = (CellFormat) wws.getCell(col, row).getCellFormat();
			if(cf!=null){
				cell.setCellFormat(cf);
			}
			wws.addCell(cell);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertString(WritableSheet wws, int col, int row, String value) {
		try {
			Label cell = new Label(col, row, value);
			CellFormat cf = (CellFormat) wws.getCell(col, row).getCellFormat();
			if(cf!=null){
				cell.setCellFormat(cf);
			}
			wws.addCell(cell);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
*/
