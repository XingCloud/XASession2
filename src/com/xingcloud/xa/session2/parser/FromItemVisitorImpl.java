package com.xingcloud.xa.session2.parser;

import com.xingcloud.xa.session2.ra.*;
import net.sf.jsqlparser.expression.Expression;
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
    private Expression where;

    public FromItemVisitorImpl(Expression where){
        this.where = where;
    }

    public RelationProvider getRelationProvider(){
        return relationProvider;
    }

    @Override
    public void visit(Table table) {
        TableScan tableScan = PlanFactory.getInstance().newTableScan(table.getName());
        relationProvider = PlanFactory.getInstance().newSelection();
        ((Selection)relationProvider).setInput(tableScan, getWhere(tableScan));

    }

    @Override
    public void visit(SubSelect subSelect) {
        SelectVisitorImpl visitor = new SelectVisitorImpl();
        subSelect.getSelectBody().accept(visitor);
        relationProvider = visitor.getOperation();
    }

    @Override
    public void visit(SubJoin subJoin) {
        FromItem left = subJoin.getLeft();
        FromItem right = subJoin.getJoin().getRightItem();
        FromItemVisitorImpl leftVisitor = new FromItemVisitorImpl(where);
        FromItemVisitorImpl rightVisitor = new FromItemVisitorImpl(where);
        left.accept(leftVisitor);
        right.accept(rightVisitor);
        relationProvider = PlanFactory.getInstance().newJoin();
        ((Join)relationProvider).setInput(leftVisitor.getRelationProvider(), rightVisitor.getRelationProvider());
    }

    private com.xingcloud.xa.session2.ra.expr.Expression getWhere(RelationProvider relationProvider){
        if(where != null){
            ExpressionVisitorImpl visitor = new ExpressionVisitorImpl(relationProvider);
            this.where.accept(visitor);
            return visitor.getExpression();
        } else {
            return null;
        }
    }
}
