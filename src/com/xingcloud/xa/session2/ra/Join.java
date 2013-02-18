package com.xingcloud.xa.session2.ra;

/**
 * Author: mulisen
 * Date:   2/6/13
 * 输入：两个关系
 * 输出：根据相同列名的自然连接的关系。
 * 自然连接（Natural Join）：根据left和right的相同名字的列作为连接条件。
 */
public interface Join extends Operation {
	Join setInput(RelationProvider left, RelationProvider right);
}
