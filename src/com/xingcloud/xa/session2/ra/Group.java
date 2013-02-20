package com.xingcloud.xa.session2.ra;

import com.xingcloud.xa.session2.ra.expr.Expression;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/7/13
 * Grouping 操作。
 * 对于输入的Relation，
 * 首先，根据groupingExpression 把所有行分成不同的组；
 * 然后，每一组的最终输出一行，其所具有的列由projectionExpression决定。
 * 按照标准的定义，projectionExpression可以包含两种表达式：
 * 	groupingExpression中的表达式，以及对每一组中所有行的聚合表达式。
 */
public interface Group extends Operation {
	/**
	 *
	 * @param relation  输入的relation
	 * @param groupingExpressions 根据这个参数，确定如何对relation进行分组
	 * @param projectionExpressions 对每个分组之后的子relation，应用这个参数，输出一行
	 * @returns
	 */
	Group setInput(RelationProvider relation, Expression[] groupingExpressions, Expression[] projectionExpressions);
}
