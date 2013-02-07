package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/7/13
 */
public class And extends BinaryExpression  {

	public And(Expression left, Expression right) {
		super(left, right);
	}

	public Object evaluate(Row input) {
		return (Boolean)left.evaluate(input) && (Boolean)right.evaluate(input);
	}
}
