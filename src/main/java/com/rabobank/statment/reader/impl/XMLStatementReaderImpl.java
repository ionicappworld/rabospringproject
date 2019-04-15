package com.rabobank.statment.reader.impl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.rabobank.statement.controller.StatementProcessorController;
import com.rabobank.statment.model.Records;
import com.rabobank.statment.reader.StatementReader;

@Component
public class XMLStatementReaderImpl implements StatementReader {
	private static final Logger logger = LoggerFactory.getLogger(StatementProcessorController.class);

	@Override
	public Records readStatement(MultipartFile file) throws Exception {
		Records statments = null;
		try {
			// creating the JAXB context
			JAXBContext jaxbContext = JAXBContext.newInstance(Records.class);
			// creating the unmarshall object
			Unmarshaller unmarshallerObj = jaxbContext.createUnmarshaller();
			// calling the unmarshall method
			statments = (Records) unmarshallerObj.unmarshal(file.getInputStream());
		} catch (JAXBException e) {
			logger.error("JAXBException While reading the statement from XML", e);
			throw new Exception("JAXBException While reading the statement from XML");
		} catch (Exception e) {
			logger.error("Exception While reading the statement from XML", e);
			throw new Exception("Exception While reading the statement from XML");
		}

		return statments;

	}

}
