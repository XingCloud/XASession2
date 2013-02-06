package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class Add implements Expression {
	Expression left;
	Expression right;

	public Add(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public Object evaluate(Row input) {
		Object l = left.evaluate(input);
		Object r = right.evaluate(input);
		int li = 0;
		int ri = 0;

		if (l instanceof String){

		}
		return li + ri;
	}
}
