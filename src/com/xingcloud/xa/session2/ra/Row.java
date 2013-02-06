package com.xingcloud.xa.session2.ra;

import java.util.Map;

/**
 * Author: mulisen
 * Date:   2/5/13
 */
public interface Row {
	Object get(int index);
	Object get(String columnName);
}
