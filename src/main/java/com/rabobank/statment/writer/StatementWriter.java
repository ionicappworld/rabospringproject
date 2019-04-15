package com.rabobank.statment.writer;

import javax.servlet.http.HttpServletResponse;


public interface StatementWriter {
	
	public void writeOutputReport(HttpServletResponse response);

}
