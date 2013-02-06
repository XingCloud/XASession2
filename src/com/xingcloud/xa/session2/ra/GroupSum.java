package com.xingcloud.xa.session2.ra;

/**
 * Author: mulisen
 * Date:   2/6/13
 * 根据对输入的relation的每一行，执行expression；
 * 按照每一个不同的expression结果分组，每个组内对colName对应的列进行加和计算。
 *
 * 输出：一个两列的relation：一列是不同的expression的取值；另一列是每一个取值对应的sum结果。
 */
public interface GroupSum extends Operation {
	void setInput(RelationProvider relation, String colName, Expression groupbyExpression);
}
