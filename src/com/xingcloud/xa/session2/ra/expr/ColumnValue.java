package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class ColumnValue implements Expression {

	public String columnName;

	public String tableName;

	public ColumnValue(String columnName) {
		this(columnName, null);
	}

	public ColumnValue(String columnName, String tableName) {
		this.columnName = columnName;
		this.tableName = tableName;
	}

	public Object evaluate(Row input) {
		return input.get(columnName);
	}
}
