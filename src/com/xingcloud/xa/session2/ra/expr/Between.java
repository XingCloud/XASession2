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

    @Override
    public Object evaluate(Row input) {
        Object l = left.evaluate(input);
        Object s = start.evaluate(input);
        Object e = end.evaluate(input);

        //TODO
        return null;
    }
}
