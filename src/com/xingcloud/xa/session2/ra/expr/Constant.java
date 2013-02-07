package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class Constant implements Expression{

	public Object value;

	public Constant(Object value) {
		this.value = value;
	}

	public Object evaluate(Row input) {
		return value;
	}
}
