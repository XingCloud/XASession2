package com.xingcloud.xa.session2.ra;

/**
 * Author: mulisen
 * Date:   2/7/13
 * 聚合操作，其输入是一个relation；输出(evaluate方法)是一个只有一列、只有一行的relation，其中的内容是聚合后的值。
 */
public interface Aggregation extends Operation {
	/**
	 * 计算输出聚合的结果
	 * @return
	 */
	Object aggregate();

	/**
	 * 初始化聚合函数的状态。使得这个对象可以反复使用
	 */
	void init();
}
