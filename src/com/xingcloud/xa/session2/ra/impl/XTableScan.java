package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Relation;
import com.xingcloud.xa.session2.ra.Row;
import com.xingcloud.xa.session2.ra.RowIterator;
import com.xingcloud.xa.session2.ra.TableScan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class XTableScan extends AbstractOperation implements TableScan {

	String tableName;

	Relation result;

	static final String dataDir="./data/1/";

	public XTableScan(String tableName) {
		this.tableName = tableName;
	}

	public Relation evaluate() {
		if(result == null){
			//读取 \t 分割的文本文件，生成一个XRelation
			//文本文件头一行是列名；其余各行是relation中的行。
			try {
				BufferedReader reader = new BufferedReader(new FileReader(dataDir+tableName+".txt"));
				String line = reader.readLine();
				if(line == null){
					return null;
				}
				StringTokenizer st = new StringTokenizer(line,"\t");
				List<String> columnNames = new ArrayList<String>();
				for(;st.hasMoreTokens();){
					columnNames.add(st.nextToken());
				}
				List<Object[]> rows = new ArrayList<Object[]>();
				for(line=reader.readLine();line!=null;line=reader.readLine()){
					Object[] row = new Object[columnNames.size()];
					st = new StringTokenizer(line, "\t'");
					int i = 0;
					for(;st.hasMoreTokens();){
						row[i]=st.nextToken();
						i++;
					}
					if(i==columnNames.size()){
						rows.add(row);
					}
				}
				Map<String, Integer> columnIndex = new TreeMap<String, Integer>();
				for (int i = 0; i < columnNames.size(); i++) {
					String columnName = columnNames.get(i);
					columnIndex.put(columnName, i);
				}
				result = new XRelation(columnIndex, rows);

			} catch (FileNotFoundException e) {
				e.printStackTrace();  //e:
			} catch (IOException e) {
				e.printStackTrace();  //e:
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return IndentPrint.print(this);
	}

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		Relation r = new XTableScan("user").evaluate();
		RowIterator it = r.iterator();
		for(Row row = it.nextRow(); row != null; row = it.nextRow()){
			System.out.println(row.get("register_time"));
		}
		System.out.println(r);
	}
}
