package com.xingcloud.xa.session2.ra;

import java.util.List;

/**
 * Author: mulisen
 * Date:   2/5/13
 */
public interface Projection {
	void setInput(RelationProvider relation, List<String> columnNames);
}
