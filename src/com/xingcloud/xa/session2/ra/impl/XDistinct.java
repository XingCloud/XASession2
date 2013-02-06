package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Distinct;
import com.xingcloud.xa.session2.ra.Relation;
import com.xingcloud.xa.session2.ra.RelationProvider;
import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class XDistinct extends AbstractOperation implements Distinct {
	public Distinct setInput(RelationProvider relation, String colName) {
		//TODO method implementation
		return this;
	}

	public Relation evaluate() {
		return null;  //TODO method implementation
	}

}
