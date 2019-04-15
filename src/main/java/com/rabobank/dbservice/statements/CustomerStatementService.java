package com.rabobank.dbservice.statements;

import java.util.List;

import com.rabobank.entity.CustomerStatements;

public interface CustomerStatementService {
	
	public List<CustomerStatements> retrieveAllStatements();
	 
	 
}
