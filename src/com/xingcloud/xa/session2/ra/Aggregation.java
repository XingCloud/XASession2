package com.xingcloud.xa.session2.ra;

/**
 * Author: mulisen
 * Date:   2/7/13
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
