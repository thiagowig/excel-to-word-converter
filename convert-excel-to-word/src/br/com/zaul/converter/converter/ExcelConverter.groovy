package br.com.zaul.converter.converter

import java.lang.invoke.LambdaForm.Name;

import org.apache.poi.ss.usermodel.Row

import br.com.zaul.converter.model.Service

/**
 * 
 * @author tfonseca
 *
 */
class ExcelConverter {
	
	/**
	 * 
	 * @param row
	 * @return
	 */
	Service convert(Row row) {
		def service = new Service()
		
		for (column in ColumnEnum.values()) {
			def methodName = column.setMethodName()
			
			service."${methodName}"(row.getCell(column.getColumnPosition()).toString()) 
		}
		
		service
	}
}
