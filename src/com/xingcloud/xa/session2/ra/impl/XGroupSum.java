package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.*;
import com.xingcloud.xa.session2.ra.expr.Expression;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class XGroupSum extends AbstractOperation implements GroupSum{

	public Relation evaluate() {
		//TODO immars
		return null;  //TODO method implementation
	}

	public GroupSum setInput(RelationProvider relation, String colName, Expression groupbyExpression, List<Expression> projection) {
		return null;  //TODO method implementation
	}
}
