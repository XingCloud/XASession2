package com.xingcloud.xa.session2.parser;

import com.xingcloud.xa.session2.ra.Operation;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;

import java.io.StringReader;

/**
 * User: Jian Fang
 * Date: 13-2-7
 * Time: 下午12:44
 */
public class Parser {
    private static Parser instance = new Parser();
    private CCJSqlParserManager pm;

    private Parser(){
        pm = new CCJSqlParserManager();
    }

    public static Parser getInstance(){
        return instance;
    }

    public Operation parse(String sql) throws JSQLParserException {
        Statement statement = pm.parse(new StringReader(sql));
        if(statement instanceof Select){
            Select selectStatement = (Select) statement;
            SelectVisitorImpl visitor = new SelectVisitorImpl();
            selectStatement.getSelectBody().accept(visitor);
            return visitor.getOperation();
        }
        return null;
    }
}
