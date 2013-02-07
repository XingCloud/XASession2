package com.xingcloud.xa.session2.parser;

import com.xingcloud.xa.session2.ra.RelationProvider;
import net.sf.jsqlparser.statement.select.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: Jian Fang
 * Date: 13-2-6
 * Time: 下午2:50
 */
public class SelectVisitorImpl implements SelectVisitor {
    private RelationProvider relationProvider;

    public RelationProvider getRelationProvider(){
        return relationProvider;
    }

    @Override
    public void visit(PlainSelect plainSelect) {
    }

    @Override
    public void visit(Union union) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
