package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Join;
import com.xingcloud.xa.session2.ra.Relation;
import com.xingcloud.xa.session2.ra.RelationProvider;
import com.xingcloud.xa.session2.ra.Row;
import com.xingcloud.xa.session2.ra.expr.Expression;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class XJoin extends AbstractOperation implements Join{

	RelationProvider left;
	RelationProvider right;

	public Relation evaluate() {
		return null;  //TODO method implementation
	}

	public Join setInput(RelationProvider left, RelationProvider right) {
		resetInput();
        this.left = left;
		this.right = right;
		addInput(left);
		addInput(right);
		return this;
	}

	@Override
	public String toString() {
		return IndentPrint.print(this);
	}

}
