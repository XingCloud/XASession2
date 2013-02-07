package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Distinct;
import com.xingcloud.xa.session2.ra.Relation;
import com.xingcloud.xa.session2.ra.RelationProvider;
import com.xingcloud.xa.session2.ra.Row;
import com.xingcloud.xa.session2.ra.expr.Expression;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class XDistinct extends AbstractOperation implements Distinct {

	RelationProvider relation;
	Expression[] expressions;

	public Relation evaluate() {
		return null;  //TODO method implementation
	}

	public Distinct setInput(RelationProvider relation, Expression ... expressions ) {
		resetInput();
        this.relation = relation;
		this.expressions = expressions;
		addInput(relation);
		return this;
	}

	@Override
	public String toString() {
		return IndentPrint.print(this);
	}

}
