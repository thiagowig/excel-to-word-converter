package br.com.zaul.converter.reader

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.zaul.converter.converter.ExcelConverter;
import br.com.zaul.converter.model.Service;

/**
 * 
 * @author tfonseca
 *
 */
class ExcelReader {
	
	final Integer firstSheet = 2
	final Integer firstRow = 2
	
	/**
	 * 
	 * @return
	 */
	Workbook read(File file) {
		def inputStream = new FileInputStream(file)
		new XSSFWorkbook(inputStream)
	}
	
	/**
	 * 
	 * @param workbook
	 * @return
	 */
	List<Service> createList(Workbook workbook) {
		def list = new ArrayList<Service>()
		def excelConverter = new ExcelConverter()
		
		for (Integer i = firstSheet; i < workbook.numberOfSheets; i++) {
			def sheet = workbook.getSheetAt(i)
			
			for (Integer j = firstRow; j < sheet.getLastRowNum(); j++) {
				def row = sheet.getRow(j)
				list.add(excelConverter.convert(row))
			}
		}
		
		list
	}

}
