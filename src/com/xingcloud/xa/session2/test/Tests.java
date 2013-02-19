package com.xingcloud.xa.session2.test;

import com.xingcloud.xa.session2.exec.PlanExecutor;
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
			                    "WHERE user.register_time>='20130201000000' AND user.register_time<'20130202000000'\n" +
			                    "AND event.date='2013-02-02' AND event.event='visit';";

    public static String sql4 = "SELECT user.ref0, COUNT(DISTINCT(uid)), SUM(value)\n" +
			                    "FROM (event NATURAL JOIN user)\n" +
								"WHERE user.register_time>='20130201000000' AND user.register_time<'20130202000000'\n" +
			                    "AND event.date='2013-02-02' AND event.event='visit' " +
								"GROUP BY user.ref0;";

	public static void main(String[] args) throws JSQLParserException {
		PlanExecutor.executePlan(Parser.getInstance().parse(Tests.sql1));
		PlanExecutor.executePlan(Parser.getInstance().parse(Tests.sql2));
		PlanExecutor.executePlan(Parser.getInstance().parse(Tests.sql3));
		PlanExecutor.executePlan(Parser.getInstance().parse(Tests.sql4));
    }
}
