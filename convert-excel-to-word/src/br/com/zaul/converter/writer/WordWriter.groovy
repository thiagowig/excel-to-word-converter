package br.com.zaul.converter.writer

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import br.com.zaul.converter.converter.ColumnEnum;
import br.com.zaul.converter.model.Service;
/**
 * 
 * @author tfonseca
 *
 */
class WordWriter {
	
	def zipFileManager = new ZipFileManager(System.getProperty("java.io.tmpdir") + File.separator + "servicos.zip")
	
	/**
	 * 
	 * @param services
	 */
	void write(List<Service> services) {
		
		for (service in services) {
			def wordDocument = new XWPFDocument()
			
			appendSections(wordDocument, service)
			
			saveFile(wordDocument, service)
		}
		
		zipFileManager.close()
	}
	
	/**
	 * 
	 * @param wordDocument
	 * @param service
	 */
	void appendSections(XWPFDocument wordDocument, Service service) {
		
		generateDocumentTitle(wordDocument)
		
		for (column in ColumnEnum.values()) {
			generateDocumentSection(wordDocument, column)
			generateDocumentSectionContent(wordDocument, column, service)
		}
	}

	/**
	 * 
	 * @param wordDocument
	 * @param column
	 * @param service
	 * @return
	 */
	private generateDocumentSectionContent(XWPFDocument wordDocument, ColumnEnum column, Service service) {
		def methodName = column.getMethodName()
		def paragraphs = service."${methodName}"().split("\n")
		
		for (paragraph in paragraphs) {
			def paragraphContent = wordDocument.createParagraph()
			def runContent = paragraphContent.createRun()
			
			runContent.setText(paragraph)
			runContent.setFontSize(11)
			runContent.setFontFamily("Cambria")			
		}
		
		wordDocument.createParagraph()
	}

	/**
	 * 
	 * @param wordDocument
	 * @param column
	 * @return
	 */
	private generateDocumentSection(XWPFDocument wordDocument, ColumnEnum column) {
		def paragraphSection = wordDocument.createParagraph()
		def runSection = paragraphSection.createRun()
		runSection.setText(column.getTitle())
		runSection.setBold(true)
		runSection.setColor("365F91")
		runSection.setFontSize(14)
		runSection.setFontFamily("Calibri")
	}

	/**
	 * 
	 * @param wordDocument
	 * @return
	 */
	private generateDocumentTitle(XWPFDocument wordDocument) {
		def paragraphTitle = wordDocument.createParagraph()
		def runTitle = paragraphTitle.createRun()
		runTitle.setText("Modelo de Serviços – Template")
		runTitle.setBold(true)
		runTitle.setColor("365F91")
		runTitle.setFontSize(14)
		runTitle.setFontFamily("Calibri")
	}
	
	/**
	 * 
	 * @param document
	 * @param service
	 */
	void saveFile(XWPFDocument document, Service service) {
		def fileName = System.getProperty("java.io.tmpdir") + File.separator + "${service.name}.docx"
		def outputStream = new FileOutputStream(new File(fileName))
		document.write(outputStream)
		outputStream.close()
		
		zipFileManager.addFile(fileName)
		
		println "Arquivo '${fileName}' criado"
	}
	
	File getFile() {
		zipFileManager.getZipFile()
	}
}
