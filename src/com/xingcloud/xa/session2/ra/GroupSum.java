package com.xingcloud.xa.session2.ra;

import com.xingcloud.xa.session2.ra.expr.Expression;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/6/13
 * 根据对输入的relation的每一行，执行expression；
 * 按照每一个不同的expression结果分组，每个组内对colName对应的列进行加和计算。
 *
 * 输出：一个relation：其中一列是每一个取值对应的sum结果；其他列按照 projection 的定义。
 */
public interface GroupSum extends Operation {
	GroupSum setInput(RelationProvider relation, String colName, Expression groupbyExpression, List<Expression> projection);
}
