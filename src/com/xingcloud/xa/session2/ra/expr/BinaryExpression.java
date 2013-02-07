package com.xingcloud.xa.session2.ra.expr;

/**
 * Author: mulisen
 * Date:   2/7/13
 */
public abstract class BinaryExpression implements Expression {
	public Expression left;
	public Expression right;

	protected BinaryExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
}
