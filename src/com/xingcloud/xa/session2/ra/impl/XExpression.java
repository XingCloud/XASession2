package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Expression;
import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class XExpression implements Expression {

	private String expr;

	public XExpression(String expr) {
		this.expr = expr;
	}

	public String calculate(Row input) {
		return null;  //TODO method implementation
	}
}
