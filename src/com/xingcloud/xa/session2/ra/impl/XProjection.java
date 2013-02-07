package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.*;
import com.xingcloud.xa.session2.ra.expr.Expression;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class XProjection extends AbstractOperation implements Projection{

	RelationProvider relation;
	Expression[] projections;

	public Relation evaluate() {
		return null;  //TODO method implementation
	}

	public Projection setInput(RelationProvider relation, Expression ... projections) {
        resetInput();
		this.relation = relation;
		this.projections = projections;
		addInput(relation);
		return this;
	}

	@Override
	public String toString() {
		return IndentPrint.print(this);
	}
}
