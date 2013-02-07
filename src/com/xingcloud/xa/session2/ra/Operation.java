package com.xingcloud.xa.session2.ra;


/**
 * Author: mulisen
 * Date:   2/5/13
 * 所有算子的父类。
 */
public interface Operation extends RelationProvider {
	/**
	 * 执行本操作。
	 * @return 本算子的执行结果
	 */
	Relation evaluate();
}
