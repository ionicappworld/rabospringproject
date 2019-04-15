package com.rabobank.statement.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rabobank.statements.processor.StatementProcessor;
import com.rabobank.statment.writer.StatementWriter;

@RestController
@RequestMapping("/rabo")
public class StatementProcessorController {
	private static final Logger logger = LoggerFactory.getLogger(StatementProcessorController.class);
	
	@Autowired
	StatementProcessor statementProcessor;
	
	@Autowired
	StatementWriter statementWriter;
	
	@PostMapping("/getValidatedStatement")
	public void getValidatedStatement(@RequestParam("files") MultipartFile file,HttpServletResponse response) {
		if (file != null ) {
			statementProcessor.processStatement(file);
			statementWriter.writeOutputReport(response);
            
		}

	}

}
