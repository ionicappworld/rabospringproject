package com.rabobank.statment.reader;

import org.springframework.web.multipart.MultipartFile;

import com.rabobank.statment.enums.StatementFileType;
import com.rabobank.statment.model.Records;
import com.rabobank.statment.reader.impl.CSVStatementReaderImpl;
import com.rabobank.statment.reader.impl.XMLStatementReaderImpl;



public interface StatementReader {
	
	public Records readStatement(MultipartFile file) throws Exception;
	
	 static StatementReader getFileReader(MultipartFile inputFile) throws Exception {
		switch (StatementFileType.getFileType(inputFile.getOriginalFilename())) {
		case CSV:
			return new CSVStatementReaderImpl();
		case XML:
			return new XMLStatementReaderImpl();
		default:
			throw new Exception("Invalid file type, Please check your input arguments");
		}
	}

}
