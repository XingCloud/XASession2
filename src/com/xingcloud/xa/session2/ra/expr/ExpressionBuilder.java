package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Aggregation;

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
    public static Multiple mul(Expression left, Expression right){
        return new Multiple(left, right);
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
    public static And and(Expression left, Expression right){
        return new And(left, right);
    }
    public static Or or(Expression left, Expression right){
        return new Or(left, right);
    }
    public static Between between(Expression left, Expression start, Expression end){
        return new Between(left, start, end);
    }
    public static Greater gt(Expression left, Expression right){
        return new Greater(left, right);
    }
    public static GreaterEqual gte(Expression left, Expression right){
        return new GreaterEqual(left, right);
	}
    public static Less lt(Expression left, Expression right){
        return new Less(left, right);
    }
    public static LessEqual lte(Expression left, Expression right){
        return new LessEqual(left, right);
    }
	public static AggregationExpr aggregation(Aggregation aggregation){
		return new AggregationExpr(aggregation);
	}
	public static Multiple multiple(Expression left, Expression right){
		return new Multiple(left, right);
	}
}
