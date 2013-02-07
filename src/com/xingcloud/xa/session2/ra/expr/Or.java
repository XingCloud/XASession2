package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/7/13
 */
public class Or implements Expression {
	Expression left;
	Expression right;


	public Or(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public Object evaluate(Row input) {
		return (Boolean) left.evaluate(input) || (Boolean)right.evaluate(input);
	}
}
