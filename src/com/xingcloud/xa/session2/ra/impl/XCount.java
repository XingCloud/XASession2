package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Aggregation;
import com.xingcloud.xa.session2.ra.Count;
import com.xingcloud.xa.session2.ra.RelationProvider;

/**
 * Author: mulisen
 * Date:   2/7/13
 */
public class XCount extends AbstractAggregation implements Count {
	RelationProvider relation;
	public Aggregation setInput(RelationProvider relation) {
        resetInput();
		init();
		this.relation = relation;
		addInput(relation);
		return this;
	}

	public Object aggregate() {
		return null;  //TODO method implementation
	}

	public void init() {
		//TODO method implementation
	}
}
