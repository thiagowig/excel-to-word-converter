package br.com.zaul.converter.executor

import br.com.zaul.converter.reader.ExcelReader
import br.com.zaul.converter.writer.WordWriter

/**
 * 
 * @author tfonseca
 *
 */
class ScriptExecutor {

	/**
	 * 
	 * @param args
	 */
	static main(args) {
		println '##### Iniciando a conversão'
	
		def excelReader = new ExcelReader()
		def wordWriter = new WordWriter()
		
		def workbook = excelReader.read()
		def list = excelReader.createList(workbook)
		wordWriter.write(list)
		
		println '##### Fim da conversão'
	}

}
