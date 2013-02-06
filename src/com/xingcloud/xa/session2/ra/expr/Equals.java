package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class Equals implements Expression {

	Expression left;
	Expression right;

	public Equals(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public Object evaluate(Row input) {
		return (Boolean)left.evaluate(input).equals(right.evaluate(input));
	}
}
