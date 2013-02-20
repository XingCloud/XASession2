package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Relation;
import com.xingcloud.xa.session2.ra.Row;
import com.xingcloud.xa.session2.ra.RowIterator;

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


	public XRelation() {

	}

	public XRelation(Map<String, Integer> columnIndex, List<Object[]> rows) {
		this.columnIndex = columnIndex;
		this.rows = rows;
	}

	public Map<String, Integer> getColumnIndex() {
		return columnIndex;
	}

	public String toString() {
		return this.dump();
	}

	public RowIterator iterator() {
		return new XRowIterator(this);
	}

	public String dump(){
		String[] columns = new String[columnIndex.size()];
		for (Map.Entry<String, Integer> entry : columnIndex.entrySet()) {
			String column = entry.getKey();
			Integer index = entry.getValue();
			columns[index]=column;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.length; i++) {
			String column = columns[i];
			sb.append(column);
			if(i < columns.length-1){
				sb.append("\t");
			}else{
				sb.append("\n");
			}
		}
		for (int i = 0; i < rows.size(); i++) {
			Object[] row = rows.get(i);
			for (int j = 0; j < row.length; j++) {
				Object value = row[j];
				sb.append(value);
				if(j < row.length-1){
					sb.append("\t");
				}else{
					sb.append("\n");
				}
			}
		}
		return sb.toString();
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
            if(columnNames.get(columnName) != null){
			    return get(columnNames.get(columnName));
            } else {
                return null;
            }
		}
	}

	public static class XRowIterator implements RowIterator{


		private final XRelation relation;

		int cursor = -1;

		public XRowIterator(XRelation relation) {
			this.relation = relation;
		}

		public Row nextRow() {
			cursor++;
			if(cursor < relation.rows.size()){
				Object[] rowData = relation.rows.get(cursor);
				return new XRow(relation.columnIndex, rowData);
			}else{
				return null;
			}
		}

		public boolean hasNext() {
			return cursor + 1 < relation.rows.size();
		}
	}
}
