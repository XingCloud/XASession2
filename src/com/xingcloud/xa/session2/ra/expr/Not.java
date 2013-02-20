package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class Not implements Expression {

	public Expression input;

	public Not(Expression input) {
		this.input = input;
	}

	public Object evaluate(Row input) {
		try{
            return !Boolean.parseBoolean(this.input.evaluate(input).toString());
        } catch (IllegalArgumentException e){
            return true;
        }
	}
}
