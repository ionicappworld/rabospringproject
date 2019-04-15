package com.rabobank.statment.writer.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.rabobank.dbservice.statements.CustomerStatementService;
import com.rabobank.entity.CustomerStatements;
import com.rabobank.statment.writer.StatementWriter;

@Service
public class CSVStatementWriterImpl implements StatementWriter {
	
	@Autowired
	CustomerStatementService customerStatementService;
	@Override
	public void writeOutputReport(HttpServletResponse response) {
		String filename = "OutputReport.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        try {
			StatefulBeanToCsv<CustomerStatements> writer = new StatefulBeanToCsvBuilder<CustomerStatements>(response.getWriter())
			        .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
			        .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
			        .withOrderedResults(false)
			        .build();
			writer.write(customerStatementService.retrieveAllStatements());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
