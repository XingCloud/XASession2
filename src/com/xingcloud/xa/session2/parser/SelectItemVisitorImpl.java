package com.xingcloud.xa.session2.parser;

import com.xingcloud.xa.session2.ra.Operation;
import net.sf.jsqlparser.statement.select.*;

import java.util.List;

/**
 * User: Jian Fang
 * Date: 13-2-6
 * Time: 下午4:23
 */
public class SelectItemVisitorImpl implements SelectItemVisitor {
    private String columnName;
    private Operation function;

    @Override
    public void visit(AllColumns allColumns) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visit(AllTableColumns allTableColumns) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visit(SelectExpressionItem selectExpressionItem) {

    }
}
