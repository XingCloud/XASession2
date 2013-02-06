package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Projection;
import com.xingcloud.xa.session2.ra.Relation;
import com.xingcloud.xa.session2.ra.RelationProvider;
import com.xingcloud.xa.session2.ra.Row;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class XProjection extends AbstractOperation implements Projection{
	public Projection setInput(RelationProvider relation, List<String> columnNames) {
		//TODO method implementation
		return this;
	}

	public Relation evaluate() {
		return null;  //TODO method implementation
	}

}
