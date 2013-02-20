package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class Equals extends BinaryExpression  {

	public Equals(Expression left, Expression right) {
		super(left, right);

	}

	public Object evaluate(Row input) {
        try{
            Object l = left.evaluate(input);
            Object r = right.evaluate(input);
            return l.equals(r);
        } catch (IllegalArgumentException e){
            return true;
        }
	}
}
