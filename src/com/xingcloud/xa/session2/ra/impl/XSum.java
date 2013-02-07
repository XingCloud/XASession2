package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Aggregation;
import com.xingcloud.xa.session2.ra.RelationProvider;
import com.xingcloud.xa.session2.ra.Sum;

/**
 * Author: mulisen
 * Date:   2/7/13
 */
public class XSum implements Sum {

	RelationProvider relation;
	String columnName;
	public Aggregation setInput(RelationProvider relation, String columnName) {
		this.relation = relation;
		this.columnName = columnName;
		return this;
	}

	public Object evaluate() {
		return null;  //TODO method implementation
	}

	public void init() {
		//TODO method implementation
	}

}
