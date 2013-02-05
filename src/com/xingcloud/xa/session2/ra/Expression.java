package com.xingcloud.xa.session2.ra;

/**
 * Author: mulisen
 * Date:   2/5/13
 * 对一行进行一个表达式计算，输出一个标量结果。
 */
public interface Expression {
	String calculate(Row input);
}
