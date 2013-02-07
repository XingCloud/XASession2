package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * User: Jian Fang
 * Date: 13-2-7
 * Time: 上午10:02
 */
public class GreaterEqual implements Expression {
    Expression left;
    Expression right;

    public GreaterEqual(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Object evaluate(Row input) {
        Object l = left.evaluate(input);
        Object r = right.evaluate(input);
        int li = 0;
        int ri = 0;

        if (l instanceof String){

        }
        return li >= ri;
    }
}
