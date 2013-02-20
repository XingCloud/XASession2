package com.xingcloud.xa.session2.ra;

import java.util.Map;

/**
 * Author: mulisen
 * Date:   2/5/13
 *
 * 能产生Relation 的类
 */
public interface RelationProvider {
	Map<String, Integer> getColumnIndex();
	RowIterator iterator();
}
