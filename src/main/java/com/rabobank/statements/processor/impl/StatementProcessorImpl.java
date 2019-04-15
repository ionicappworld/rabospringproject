package com.rabobank.statements.processor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rabobank.statements.processor.StatementProcessor;
import com.rabobank.statment.model.Records;
import com.rabobank.statment.reader.StatementReader;
import com.rabobank.statment.validator.CustomerStatementValidator;

@Service
public class StatementProcessorImpl implements StatementProcessor {

	@Autowired
	CustomerStatementValidator customerStatementValidator;

	@Override
	public Object processStatement(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			Records statements = StatementReader.getFileReader(file).readStatement(file);
			customerStatementValidator.validateDuplicate(statements);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
