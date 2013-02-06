package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/5/13
 * 对一行进行一个表达式计算，输出一个标量结果。
 */
public interface Expression {
	Object evaluate(Row input);
}
