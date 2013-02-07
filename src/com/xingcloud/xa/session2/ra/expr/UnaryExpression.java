package com.xingcloud.xa.session2.ra.expr;

/**
 * Author: mulisen
 * Date:   2/7/13
 */
public abstract class UnaryExpression implements Expression {
	Expression sub;

	protected UnaryExpression(Expression sub) {
		this.sub = sub;
	}
}
