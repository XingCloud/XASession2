package com.xingcloud.xa.session2.ra;

/**
 * Author: mulisen
 * Date:   2/5/13
 * 输入一个relation；对其中的每一行进行expression计算；
 * 输出：TODO ??? 或者还是需要 GroupbyDistinct，GroupbySum instead of Groupby
 */
public interface Groupby extends Operation {
	void setInput(RelationProvider relation, Expression expression);
}
