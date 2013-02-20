package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * User: Jian Fang
 * Date: 13-2-7
 * Time: 上午9:49
 */
public class Between implements Expression {
    Expression left;
    Expression start;
    Expression end;

    public Between(Expression left, Expression start, Expression end){
        this.left = left;
        this.start = start;
        this.end = end;
    }

    public Object evaluate(Row input) {
        try{
            Double s = Double.parseDouble(start.evaluate(input).toString());
            Double l = Double.parseDouble(left.evaluate(input).toString());
            Double e = Double.parseDouble(end.evaluate(input).toString());
            return s <= l && e >= l;
        } catch (IllegalArgumentException e){
            return true;
        }
    }
}
