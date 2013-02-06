package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.*;
import com.xingcloud.xa.session2.ra.expr.Expression;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class XGroupCount extends AbstractOperation implements GroupCount{
	public GroupCount setInput(RelationProvider relation, Expression groupbyExpression, List<Expression> projections) {
		//TODO method implementation
		//TODO immars
		return this;
	}

	public Relation evaluate() {
		return null;  //TODO method implementation
	}

}
