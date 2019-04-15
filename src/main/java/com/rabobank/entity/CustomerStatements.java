package com.rabobank.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_STATEMENTS")
public class CustomerStatements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger reference;

	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;

	@Column(name = "DESCRIPTION")
	private Integer description;

	@Column(name = "START_BALANCE")
	private BigDecimal startBalance;

	@Column(name = "MUTATION")
	private BigDecimal mutation;

	@Column(name = "END_BALANCE")
	private BigDecimal endBalance;

	@Column(name = "IS_VALID_END_BALANCE")
	private Boolean isValidEndBalance;

	@Column(name = "IS_UNIQUE_STATEMENT")
	private Boolean isUniqueStatement;

	public BigInteger getReference() {
		return reference;
	}

	public void setReference(BigInteger reference) {
		this.reference = reference;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getDescription() {
		return description;
	}

	public void setDescription(Integer description) {
		this.description = description;
	}

	public BigDecimal getStartBalance() {
		return startBalance;
	}

	public void setStartBalance(BigDecimal startBalance) {
		this.startBalance = startBalance;
	}

	public BigDecimal getMutation() {
		return mutation;
	}

	public void setMutation(BigDecimal mutation) {
		this.mutation = mutation;
	}

	public BigDecimal getEndBalance() {
		return endBalance;
	}

	public void setEndBalance(BigDecimal endBalance) {
		this.endBalance = endBalance;
	}

	public Boolean getIsValidEndBalance() {
		return isValidEndBalance;
	}

	public void setIsValidEndBalance(Boolean isValidEndBalance) {
		this.isValidEndBalance = isValidEndBalance;
	}

	public Boolean getIsUniqueStatement() {
		return isUniqueStatement;
	}

	public void setIsUniqueStatement(Boolean isUniqueStatement) {
		this.isUniqueStatement = isUniqueStatement;
	}

}
