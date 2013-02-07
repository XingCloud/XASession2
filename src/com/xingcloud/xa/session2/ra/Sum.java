package com.xingcloud.xa.session2.ra;

/**
 * Author: mulisen
 * Date:   2/7/13
 */
public interface Sum extends Aggregation{
	Aggregation setInput(RelationProvider relation, String columnName);
}
