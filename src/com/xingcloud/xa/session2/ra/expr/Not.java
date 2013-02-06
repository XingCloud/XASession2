package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class Not implements Expression {

	Expression input;

	public Not(Expression input) {
		this.input = input;
	}

	public Object evaluate(Row input) {
		return null;  //TODO method implementation
	}
}
