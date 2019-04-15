package com.rabobank.statment.validator;

import com.rabobank.statment.model.Record;
import com.rabobank.statment.model.Records;

public interface CustomerStatementValidator {

	public Boolean validateDuplicate(Records records);

	public Boolean validateEndBalance(Records records);

}
