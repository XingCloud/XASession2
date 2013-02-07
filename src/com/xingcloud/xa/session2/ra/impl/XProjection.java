package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.*;
import com.xingcloud.xa.session2.ra.expr.Expression;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class XProjection extends AbstractOperation implements Projection{

	public Projection setInput(RelationProvider relation, Expression ... projections) {
		//TODO method implementation
		return this;
	}

	public Relation evaluate() {
		return null;  //TODO method implementation
	}

}
