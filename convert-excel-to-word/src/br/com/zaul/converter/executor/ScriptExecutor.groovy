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
	 * @param file
	 * @return
	 */
	File execute(File file) {
		println '##### Iniciando a conversão'
		
		def excelReader = new ExcelReader()
		def wordWriter = new WordWriter()
		
		def workbook = excelReader.read(file)
		def list = excelReader.createList(workbook)
		wordWriter.write(list)
		
		println '##### Fim da conversão'
		
		wordWriter.getFile()
	}
	
	/**
	 *
	 * @param args
	 */
	static main(args) {
		def file = new File("resources/input/073EMP_Serviços Candidatos.xlsx")
		new ScriptExecutor().execute(file)
	}

}
