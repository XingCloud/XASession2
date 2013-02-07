package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Group;
import com.xingcloud.xa.session2.ra.Relation;
import com.xingcloud.xa.session2.ra.RelationProvider;
import com.xingcloud.xa.session2.ra.expr.Expression;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/7/13
 */
public class XGroup extends AbstractOperation implements Group {


	RelationProvider relation;

	Expression[] groupingExpressions;

	Expression[] projectionExpressions;

	public Relation evaluate() {
		return null;  //TODO method implementation
	}

    public Group setInput(RelationProvider relation, Expression[] groupingExpressions, Expression[] projectionExpressions) {
		resetInput();
        this.relation = relation;
		this.groupingExpressions = groupingExpressions;
		this.projectionExpressions = projectionExpressions;
		addInput(relation);
        return this;
    }

	@Override
	public String toString() {
		return IndentPrint.print(this);
	}

}
