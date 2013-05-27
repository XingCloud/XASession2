package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Aggregation;
import com.xingcloud.xa.session2.ra.Relation;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Author: mulisen
 * Date:   2/7/13
 */
public abstract class AbstractAggregation extends AbstractOperation implements Aggregation{

	public Relation evaluate() {
		XRelation relation = new XRelation();
		relation.columnIndex = new Hashtable<String, Integer>();
		relation.columnIndex.put("aggregated_"+getClass().getSimpleName(), 0);
		relation.rows = new ArrayList<Object[]>();
		Object[] row = new Object[1];
		row[0] = this.aggregate();
		relation.rows.add(row);
		return relation;
	}
}
