package com.xingcloud.xa.session2.parser;

import com.xingcloud.xa.session2.ra.Join;
import com.xingcloud.xa.session2.ra.PlanFactory;
import com.xingcloud.xa.session2.ra.RelationProvider;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.FromItem;
import net.sf.jsqlparser.statement.select.FromItemVisitor;
import net.sf.jsqlparser.statement.select.SubJoin;
import net.sf.jsqlparser.statement.select.SubSelect;

/**
 * User: Jian Fang
 * Date: 13-2-6
 * Time: 下午5:47
 */
public class FromItemVisitorImpl implements FromItemVisitor {
    private RelationProvider relationProvider;

    public RelationProvider getRelationProvider(){
        return relationProvider;
    }

    @Override
    public void visit(Table table) {
        table.accept(this);
        relationProvider = PlanFactory.getInstance().newTableScan(table.getName());
    }

    @Override
    public void visit(SubSelect subSelect) {
        SelectVisitorImpl visitor = new SelectVisitorImpl();
        subSelect.getSelectBody().accept(visitor);
        relationProvider = visitor.getRelationProvider();
    }

    @Override
    public void visit(SubJoin subJoin) {
        FromItem left = subJoin.getLeft();
        FromItem right = subJoin.getJoin().getRightItem();
        FromItemVisitorImpl leftVisitor = new FromItemVisitorImpl();
        FromItemVisitorImpl rightVisitor = new FromItemVisitorImpl();
        left.accept(leftVisitor);
        right.accept(rightVisitor);
        relationProvider = PlanFactory.getInstance().newJoin();
        ((Join)relationProvider).setInput(leftVisitor.getRelationProvider(), rightVisitor.getRelationProvider());
    }
}
