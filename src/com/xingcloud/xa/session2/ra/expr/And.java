package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/7/13
 */
public class And extends BinaryExpression  {

	public And(Expression left, Expression right) {
		super(left, right);
	}

	public Object evaluate(Row input) {
        try{
            Object l = left.evaluate(input);
            Object r = right.evaluate(input);
            return Boolean.parseBoolean(l.toString()) && Boolean.parseBoolean(r.toString());
        } catch (IllegalArgumentException e){
            return true;
        }
	}
}
