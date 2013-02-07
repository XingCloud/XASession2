package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Operation;
import com.xingcloud.xa.session2.ra.Relation;
import com.xingcloud.xa.session2.ra.TableScan;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class XTableScan extends AbstractOperation implements TableScan {

	String tableName;

	public XTableScan(String tableName) {
		this.tableName = tableName;
	}

	public Relation evaluate() {
		return null;  //TODO method implementation immars
	}

	@Override
	public String toString() {
		return IndentPrint.print(this);
	}
}
