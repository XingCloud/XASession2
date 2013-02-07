package com.xingcloud.xa.session2.ra;

import com.xingcloud.xa.session2.ra.expr.Expression;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/7/13
 * Grouping 操作。
 */
public interface Group extends Operation {
	/**
	 *
	 * @param relation  输入的relation
	 * @param groupingExpressions 根据这个参数，确定如何对relation进行分组
	 * @param projectionExpressions 对每个分组之后的子relation，应用这个参数，输出一行
	 * @returns
	 */
	Group setInput(RelationProvider relation, List<Expression> groupingExpressions, List<Expression> projectionExpressions);
}
