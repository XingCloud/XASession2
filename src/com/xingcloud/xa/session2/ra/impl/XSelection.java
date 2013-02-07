package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.*;
import com.xingcloud.xa.session2.ra.expr.Expression;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class XSelection extends AbstractOperation implements Selection{

	RelationProvider relation;
	Expression expression;

	public Selection setInput(RelationProvider relation, Expression e) {
		resetInput();
		this.relation = relation;
		this.expression = e;
		addInput(relation);
		return this;
	}

	public Relation evaluate() {
		return null;  //TODO method implementation
	}

	@Override
	public String toString() {
		return IndentPrint.print(this);
	}
}
