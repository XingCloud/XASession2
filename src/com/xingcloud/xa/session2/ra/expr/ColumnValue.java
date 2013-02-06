package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class ColumnValue implements Expression {

	String columnName;

	public ColumnValue(String columnName) {
		this.columnName = columnName;
	}

	public Object evaluate(Row input) {
		return input.get(columnName);
	}
}
