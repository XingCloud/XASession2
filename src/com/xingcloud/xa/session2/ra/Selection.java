package com.xingcloud.xa.session2.ra;

import com.xingcloud.xa.session2.ra.expr.Expression;

/**
 * Author: mulisen
 * Date:   2/5/13
 * 输入一个relation，和一个表达式expression。对relation的每行进行表达式计算；
 * 输出表达式计算结果为true的行。
 */
public interface Selection extends Operation {
	Selection setInput(RelationProvider relation, Expression e);
}
