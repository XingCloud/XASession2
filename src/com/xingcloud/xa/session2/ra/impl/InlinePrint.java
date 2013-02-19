package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Aggregation;
import com.xingcloud.xa.session2.ra.expr.*;

/**
 * Author: mulisen
 * Date:   2/19/13
 */
public class InlinePrint {

	public static void printExpression(Expression expression, StringBuilder sb) {
		if(expression instanceof BinaryExpression){
			BinaryExpression be = (BinaryExpression) expression;
			sb.append("(");
			printExpression(be.left, sb);
			sb.append(")").append(be.getClass().getSimpleName()).append("(");
			printExpression(be.right, sb);
			sb.append(")");
		}else if(expression instanceof AggregationExpr){
			printAggregation(((AggregationExpr)expression).aggregation, sb);
		}else if(expression instanceof Between){

		}else if(expression instanceof ColumnValue){
			sb.append("`").append(((ColumnValue)expression).columnName).append("`");
		}else if(expression instanceof Constant){
			sb.append("'").append(((Constant)expression).value).append("'");
		}else if(expression instanceof FunctionCall){

		}else if(expression instanceof Not){
			sb.append("!(");
			printExpression(((Not) expression).input, sb);
			sb.append(")");
		}

	}

	public static void printAggregation(Aggregation aggregation, StringBuilder sb) {
		if(aggregation instanceof XCount){
			sb.append("COUNT(..)");
		}else if(aggregation instanceof XSum){
			sb.append("SUM(..)");
		}
	}

	public static void main(String[] args) {
	}
}
