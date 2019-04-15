package com.rabobank.statment.reader.impl;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.rabobank.statment.model.Record;
import com.rabobank.statment.model.Records;
import com.rabobank.statment.reader.StatementReader;

@Component
public class CSVStatementReaderImpl implements StatementReader {

	@Override
	public Records readStatement(MultipartFile file) {
		List<Record> customerStatements = new ArrayList<>();
		Records records;

		try {
			CSVParser parser = CSVFormat.EXCEL.withHeader().withDelimiter(',')
					.parse(new InputStreamReader(file.getInputStream()));

			parser.forEach(record -> {
				Record customerRecords = new Record(new BigInteger(record.get("Reference")),
						record.get("AccountNumber"), record.get("Description"),
						new BigDecimal(record.get("Start Balance")), new BigDecimal(record.get("Mutation")),
						new BigDecimal(record.get("End Balance")));

				customerStatements.add(customerRecords);
			});
		} catch (Exception e) {
		}
		records = new Records();
		records.setChildrecords(customerStatements);
		return records;

	}

}
