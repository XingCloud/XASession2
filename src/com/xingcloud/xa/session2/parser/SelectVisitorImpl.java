package com.xingcloud.xa.session2.parser;

import com.xingcloud.xa.session2.ra.*;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.statement.select.Distinct;

import java.util.List;

/**
 * User: Jian Fang
 * Date: 13-2-6
 * Time: 下午2:50
 */
public class SelectVisitorImpl implements SelectVisitor {
    private Operation operation;

    public Operation getOperation(){
        return operation;
    }

    public void visit(PlainSelect plainSelect) {
        //Get from relation provider
        FromItem fromItem = plainSelect.getFromItem();
        FromItemVisitorImpl fromItemVisitor = new FromItemVisitorImpl(plainSelect.getWhere());
        fromItem.accept(fromItemVisitor);

        //Get select list
        List<SelectItem> selectItems = plainSelect.getSelectItems();
        com.xingcloud.xa.session2.ra.expr.Expression[] selectExpressions = new com.xingcloud.xa.session2.ra.expr.Expression[selectItems.size()];
        for(SelectItem selectItem: selectItems){
            SelectItemVisitorImpl visitor = new SelectItemVisitorImpl(fromItemVisitor.getRelationProvider());
            selectItem.accept(visitor);
            selectExpressions[selectItems.indexOf(selectItem)] = visitor.getExpression();
        }

        //Get group reference list
        List<Expression> groupReferences = plainSelect.getGroupByColumnReferences();
        com.xingcloud.xa.session2.ra.expr.Expression[] groupExpressions = null;
        if(groupReferences != null){
            groupExpressions = new com.xingcloud.xa.session2.ra.expr.Expression[groupReferences.size()];
            for(Expression e: groupReferences){
                ExpressionVisitorImpl visitor = new ExpressionVisitorImpl(fromItemVisitor.getRelationProvider());
                e.accept(visitor);
                groupExpressions[groupReferences.indexOf(e)] = visitor.getExpression();
            }
        }

        //Get distinct
        Distinct distinct = plainSelect.getDistinct();
        com.xingcloud.xa.session2.ra.Distinct xDistinct = null;
        if(distinct != null){
            xDistinct = PlanFactory.getInstance().newDistinct();
            xDistinct.setInput(fromItemVisitor.getRelationProvider(), selectExpressions);
        }

        //Get group
        Group group = null;
        if(groupExpressions != null){
            group = PlanFactory.getInstance().newGroup();
            if(xDistinct != null){
                group.setInput(xDistinct, groupExpressions, selectExpressions);
            } else{
                group.setInput(fromItemVisitor.getRelationProvider(), groupExpressions, selectExpressions);
            }
        }

        //Get projection
        Projection projection = PlanFactory.getInstance().newProjection();
        if(group != null){
            projection.setInput(group, selectExpressions);
        } else if(xDistinct != null){
            projection.setInput(xDistinct, selectExpressions);
        } else{
            projection.setInput(fromItemVisitor.getRelationProvider(), selectExpressions);
        }

        operation = projection;

    }

    public void visit(Union union) {
    }
}
