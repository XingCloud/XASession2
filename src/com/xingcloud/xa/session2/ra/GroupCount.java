package com.xingcloud.xa.session2.ra;

import com.xingcloud.xa.session2.ra.expr.Expression;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/6/13
 * 根据对输入的relation的每一行，执行expression；
 * 按照每一个不同的expression结果分组，每个组内进行count行数的计算。
 *
 * 输出：一个relation：其中一列是每一个取值对应的count行数；其他列按照 projection 的定义。
 */
public interface GroupCount extends Operation{
	/**
	 *
	 * @param relation
	 * @param groupbyExpression
	 * @return self. 为了操作方便
	 */
	GroupCount setInput(RelationProvider relation, Expression groupbyExpression, List<Expression> projection);
}
