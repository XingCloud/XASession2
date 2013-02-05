package com.xingcloud.xa.session2.ra;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/5/13
 * 根据输入的relation 和 列 columnName，
 * 输出一个和输入relation同样行的relation
 */
public interface Projection extends Operation {
	void setInput(RelationProvider relation, List<String> columnNames);
}
