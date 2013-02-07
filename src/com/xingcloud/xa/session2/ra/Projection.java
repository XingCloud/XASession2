package com.xingcloud.xa.session2.ra;

import com.xingcloud.xa.session2.ra.expr.Expression;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/5/13
 * 根据输入的relation 和 列 columnName，
 * 输出一个和输入relation同样行的relation
 */
public interface Projection extends Operation {
	Projection setInput(RelationProvider relation, Expression ... projections);
}
