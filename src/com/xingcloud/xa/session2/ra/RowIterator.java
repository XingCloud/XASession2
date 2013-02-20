package com.xingcloud.xa.session2.ra;

/**
 * Author: mulisen
 * Date:   2/20/13
 */
public interface RowIterator {
	Row nextRow();
	boolean hasNext();
}
