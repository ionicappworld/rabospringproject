package com.rabobank.statment.validator.impl;

import java.math.BigInteger;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.rabobank.statment.model.Record;
import com.rabobank.statment.model.Records;
import com.rabobank.statment.validator.CustomerStatementValidator;

@Component
public class CustomerStatementValidatorImpl implements CustomerStatementValidator {

	@Override
	public Boolean validateDuplicate(Records records) {
		if (records != null) {
			// Grouping by reference no to get the duplicate statement
			Map<BigInteger, Long> groupByReference = records.getChildrecords().parallelStream()
					.collect(Collectors.groupingBy(Record::getReference, Collectors.counting()));

			// update the duplicate in Records Object
			groupByReference.entrySet().stream().filter(entrySet -> entrySet.getValue() > 1)
					.forEach(duplicate -> records.getChildrecords().stream()
							.filter(duplicateStatement -> duplicateStatement.getReference().equals(duplicate.getKey()))
							.forEach(deplicateRecord -> deplicateRecord.setIsUniqueStatement(false)));
			return !groupByReference.entrySet().stream().filter(entrySet -> entrySet.getValue() > 1).findAny()
					.isPresent();
		} else {
			return false;
		}
	}

	@Override
	public Boolean validateEndBalance(Records records) {
		if (records != null) {

			records.getChildrecords().stream().forEach(record -> {
				if ((record.getStartBalance().add(record.getMutation())).compareTo(record.getEndBalance()) == 0) {
					record.setIsValidEndBalance(true);
				} else {
					record.setIsValidEndBalance(false);
				}
			});
			return !records.getChildrecords().stream().filter(record -> !record.getIsValidEndBalance()).findAny()
					.isPresent();
		} else {
			return false;
		}
	}

}
