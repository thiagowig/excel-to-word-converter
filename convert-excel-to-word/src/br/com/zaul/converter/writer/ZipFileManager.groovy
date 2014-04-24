package br.com.zaul.converter.writer

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class ZipFileManager {

	FileOutputStream fileOutputStream
	ZipOutputStream zipOutputStream
	File zipFile
	
	public ZipFileManager(String zipFilePath) {
		zipFile = new File(zipFilePath)
		fileOutputStream = new FileOutputStream(zipFile)
		zipOutputStream = new ZipOutputStream(fileOutputStream)
	}
	
	def addFile(String filePath) {
		zipOutputStream.putNextEntry(new ZipEntry(filePath))
		
		def fileInputStream = new FileInputStream(filePath)
		byte[] buffer = new byte[1024];
		
		int len;
		while ((len = fileInputStream.read(buffer)) > 0) {
			zipOutputStream.write(buffer, 0, len);
		}
		
		zipOutputStream.closeEntry()
	}
	
	def close() {		
		zipOutputStream.close()
	}
	
	public File getZipFile() {
		zipFile
	}
	
}
