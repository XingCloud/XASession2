package com.xingcloud.xa.session2.test;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class Tests {

	String sql1 = "select * from user;";
	String sql2 = "select event, uid from event where date='2013-02-01';";
	String sql3 = "SELECT COUNT(DISTINCT(uid))\n" +
			"\t\t// FROM event NATURAL JOIN user\n" +
			"\t\t// WHERE user.register_time='2013-02-01'\n" +
			"\t\t// AND event.date='2013-02-02' and event.event='visit';";

	String sql4 = "SELECT user.ref0, COUNT(DISTINCT(uid)), sum(event.value)\n" +
			"\t\t// FROM event NATURAL JOIN user\n" +
			"\t\t// WHERE user.register_time='2013-02-01'\n" +
			"\t\t// AND event.date='2013-02-02' and event.event='visit' group by user.ref0;";


	public static void main(String[] args) {

	}
}
