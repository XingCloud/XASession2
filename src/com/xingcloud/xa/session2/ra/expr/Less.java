package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * User: Jian Fang
 * Date: 13-2-20
 * Time: 下午2:43
 */
public class Less extends BinaryExpression {
    public Less(Expression left, Expression right) {
        super(left, right);
    }

    public Object evaluate(Row input) {
        try{
            Object l = left.evaluate(input);
            Object r = right.evaluate(input);
            return Double.parseDouble(l.toString()) < Double.parseDouble(r.toString());
        } catch (IllegalArgumentException e){
            return true;
        }
    }
}
