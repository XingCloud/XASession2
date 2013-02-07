package com.xingcloud.xa.session2.parser;

import com.xingcloud.xa.session2.ra.GroupCount;
import com.xingcloud.xa.session2.ra.Operation;
import com.xingcloud.xa.session2.ra.PlanFactory;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
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
        selectExpressionItem.accept(this);
        Expression expression = selectExpressionItem.getExpression();
        ExpressionVisitorImpl visitor = new ExpressionVisitorImpl();
        expression.accept(visitor);
        if(visitor.getFunction() != null){
            Function function = visitor.getFunction();
            ExpressionList expressionList = function.getParameters();
            List expressions = expressionList.getExpressions();
            if(expressions.size() > 0){
                if(function.getName().toUpperCase() == "COUNT"){
                    this.function = PlanFactory.getInstance().newGroupCount();
                }
                else if(function.getName().toUpperCase() == "SUM"){
                    this.function = PlanFactory.getInstance().newGroupSum();
                }
            }
        }
    }
}
