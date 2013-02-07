package com.xingcloud.xa.session2.test;

import com.xingcloud.xa.session2.parser.Parser;
import net.sf.jsqlparser.JSQLParserException;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class Tests {

	public static String sql1 = "select * from user;";
    public static String sql2 = "select event, uid from event where date='2013-02-01';";
    public static String sql3 = "SELECT COUNT(DISTINCT(uid))\n" +
			                    "FROM (event NATURAL JOIN user)\n" +
			                    "WHERE user.register_time='2013-02-01'\n" +
			                    "AND event.date='2013-02-02' and event.event='visit';";

    public static String sql4 = "SELECT user.ref0, COUNT(DISTINCT(uid)), sum(event.value)\n" +
			                    "FROM (event NATURAL JOIN user)\n" +
			                    "WHERE user.register_time='2013-02-01'\n" +
			                    "AND event.date='2013-02-02' and event.event='visit' group by user.ref0;";


	public static void main(String[] args) throws JSQLParserException {
        Parser.getInstance().parse(Tests.sql4);
    }
}
