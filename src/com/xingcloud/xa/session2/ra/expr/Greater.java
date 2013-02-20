package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * User: Jian Fang
 * Date: 13-2-7
 * Time: 上午9:59
 */
public class Greater extends BinaryExpression  {

    public Greater(Expression left, Expression right) {
		super(left, right);
    }

    public Object evaluate(Row input) {
        try{
            Object l = left.evaluate(input);
            Object r = right.evaluate(input);
            return Double.parseDouble(l.toString()) > Double.parseDouble(r.toString());
        } catch (IllegalArgumentException e){
            return true;
        }
    }
}
