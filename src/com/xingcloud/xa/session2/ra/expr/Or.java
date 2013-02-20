package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/7/13
 */
public class Or extends BinaryExpression {

	public Or(Expression left, Expression right) {
		super(left, right);
	}

	public Object evaluate(Row input) {
		try{
            return Boolean.parseBoolean(left.evaluate(input).toString()) || Boolean.parseBoolean(right.evaluate(input).toString());
        } catch (IllegalArgumentException e){
            return true;
        }
	}
}
