package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class Equals extends BinaryExpression  {

	public Equals(Expression left, Expression right) {
		super(left, right);

	}

	public Object evaluate(Row input) {
		return (Boolean)left.evaluate(input).equals(right.evaluate(input));
	}
}
