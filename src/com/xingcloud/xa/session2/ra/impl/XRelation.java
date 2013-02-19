package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Relation;
import com.xingcloud.xa.session2.ra.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class XRelation implements Relation {

	Map<String, Integer> columnIndex;

	List<Object[]> rows = new ArrayList<Object[]>();

	int cursor = -1;

	public XRelation() {

	}

	public XRelation(Map<String, Integer> columnIndex, List<Object[]> rows) {
		this.columnIndex = columnIndex;
		this.rows = rows;
	}

	public Row nextRow() {
		cursor++;
		if(cursor < rows.size()){
			Object[] rowData = rows.get(cursor);
			return new XRow(columnIndex, rowData);
		}else{
			return null;
		}
	}

	public Map<String, Integer> getColumnIndex() {
		return columnIndex;
	}

	public String toString() {
		return IndentPrint.print(this);
	}

	public static class XRow implements Row{

		public Map<String, Integer> columnNames;

		public Object[] rowData;

		public XRow(Map<String, Integer> columnNames, Object[] rowData) {
			this.columnNames = columnNames;
			this.rowData = rowData;
		}

		public Object get(int index) {
			return rowData[index];
		}

		public Object get(String columnName) {
			return get(columnNames.get(columnName));
		}
	}
}
