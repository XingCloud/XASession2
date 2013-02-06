package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class FunctionCall implements Expression {

	Expression[] args;

	String funcName;

	public FunctionCall(String funcName, Expression ... args) {
		this.funcName = funcName;
		this.args = args;
	}

	public Object evaluate(Row input) {
		return null;  //TODO method implementation
	}
}
