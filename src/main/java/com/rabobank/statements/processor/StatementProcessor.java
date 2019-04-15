package com.rabobank.statements.processor;

import org.springframework.web.multipart.MultipartFile;


public interface StatementProcessor {

	Object processStatement(MultipartFile file);

}
