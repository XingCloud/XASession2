package com.xingcloud.xa.session2.ra.expr;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class ExpressionBuilder {
	public static Add add(Expression left, Expression right){
		return new Add(left, right);
	}
	public static Sub sub(Expression left, Expression right){
		return new Sub(left, right);
	}
	public static Div div(Expression left, Expression right){
		return new Div(left, right);
	}
	public static Equals eq(Expression left, Expression right){
		return new Equals(left, right);
	}
	public static Not not(Expression input){
		return new Not(input);
	}
	public static FunctionCall call(String functionName, Expression ... args){
		return new FunctionCall(functionName, args);
	}
	public static Constant constant(Object value){
		return new Constant(value);
	}
	public static ColumnValue column(String columnName){
		return new ColumnValue(columnName);
	}
}
