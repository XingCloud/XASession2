package com.xingcloud.xa.session2.parser;

import com.xingcloud.xa.session2.ra.RelationProvider;
import com.xingcloud.xa.session2.ra.expr.ExpressionBuilder;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.select.*;

import java.util.List;

/**
 * User: Jian Fang
 * Date: 13-2-6
 * Time: 下午4:23
 */
public class SelectItemVisitorImpl implements SelectItemVisitor {
    private RelationProvider relationProvider;
    private com.xingcloud.xa.session2.ra.expr.Expression expression;

    public SelectItemVisitorImpl(RelationProvider relationProvider){
        super();
        this.relationProvider = relationProvider;
    }

    public com.xingcloud.xa.session2.ra.expr.Expression getExpression(){
        return expression;
    }

    @Override
    public void visit(AllColumns allColumns) {
        expression = ExpressionBuilder.column(allColumns.toString());
    }

    @Override
    public void visit(AllTableColumns allTableColumns) {
        expression = ExpressionBuilder.column(allTableColumns.toString());
    }

    @Override
    public void visit(SelectExpressionItem selectExpressionItem) {
        Expression expression = selectExpressionItem.getExpression();
        ExpressionVisitorImpl visitor = new ExpressionVisitorImpl(relationProvider);
        expression.accept(visitor);
        this.expression = visitor.getExpression();
    }
}
