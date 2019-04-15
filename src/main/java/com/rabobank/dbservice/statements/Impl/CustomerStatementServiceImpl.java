package com.rabobank.dbservice.statements.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabobank.dbservice.statements.CustomerStatementService;
import com.rabobank.dbservice.statements.Repository.CustomerStatementsRepository;
import com.rabobank.entity.CustomerStatements;

@Service
public class CustomerStatementServiceImpl implements CustomerStatementService{
	
	@Autowired
	CustomerStatementsRepository customerStatementsRepository;

	@Override
	public List<CustomerStatements> retrieveAllStatements() {
		// TODO Auto-generated method stub
		
			  List<CustomerStatements> statements = customerStatementsRepository.findAll();
			  return statements;
			 
	}

}
