package com.xingcloud.xa.session2.parser;

import com.xingcloud.xa.session2.ra.*;
import com.xingcloud.xa.session2.ra.expr.*;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.arithmetic.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.expression.operators.relational.Between;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.SubSelect;

import java.util.List;

/**
 * User: Jian Fang
 * Date: 13-2-6
 * Time: 下午5:09
 */
public class ExpressionVisitorImpl implements ExpressionVisitor {
    private RelationProvider relationProvider;
    private com.xingcloud.xa.session2.ra.expr.Expression expression;

    public ExpressionVisitorImpl(RelationProvider relationProvider){
        super();
        this.relationProvider = relationProvider;
    }

    public com.xingcloud.xa.session2.ra.expr.Expression getExpression(){
        return expression;
    }

    @Override
    public void visit(NullValue nullValue) {
        expression = ExpressionBuilder.constant(null);
    }

    @Override
    public void visit(Function function) {
        String functionName = function.getName();
        List<Expression> expressions = function.getParameters().getExpressions();
        com.xingcloud.xa.session2.ra.expr.Expression[] xExpressions = new com.xingcloud.xa.session2.ra.expr.Expression[expressions.size()];
        for(Expression e: expressions){
            ExpressionVisitorImpl visitor = new ExpressionVisitorImpl(relationProvider);
            e.accept(visitor);
            xExpressions[expressions.indexOf(e)] = visitor.getExpression();
        }
        Distinct distinct = null;
        if(function.isDistinct()){
            distinct = PlanFactory.getInstance().newDistinct();
            distinct.setInput(relationProvider, xExpressions);
        }
        if(functionName.toUpperCase().equals("COUNT")){
            Count count = PlanFactory.getInstance().newCount();
            if(function.isDistinct()){
                count.setInput(distinct);
            } else {
                count.setInput(relationProvider);
            }
            expression = ExpressionBuilder.aggregation(count);

        }
        else if(functionName.toUpperCase().equals("SUM")){
            Sum sum = PlanFactory.getInstance().newSum();
            String columnName = null;
            if(expressions.size() > 0){
                columnName = expressions.get(0).toString();
            }
            if(function.isDistinct()){
                sum.setInput(distinct, columnName);
            } else {
                sum.setInput(relationProvider, columnName);
            }
            expression = ExpressionBuilder.aggregation(sum);
        }
    }

    @Override
    public void visit(InverseExpression inverseExpression) {
        Expression e = inverseExpression.getExpression();
        e.accept(this);
    }

    @Override
    public void visit(JdbcParameter jdbcParameter) {
        expression = ExpressionBuilder.constant(jdbcParameter.toString());
    }

    @Override
    public void visit(DoubleValue doubleValue) {
        expression = ExpressionBuilder.constant(doubleValue.getValue());
    }

    @Override
    public void visit(LongValue longValue) {
        expression = ExpressionBuilder.constant(longValue.getValue());
    }

    @Override
    public void visit(DateValue dateValue) {
        expression = ExpressionBuilder.constant(dateValue.getValue());
    }

    @Override
    public void visit(TimeValue timeValue) {
        expression = ExpressionBuilder.constant(timeValue.getValue());
    }

    @Override
    public void visit(TimestampValue timestampValue) {
        expression = ExpressionBuilder.constant(timestampValue.getValue());
    }

    @Override
    public void visit(Parenthesis parenthesis) {
        parenthesis.getExpression().accept(this);
    }

    @Override
    public void visit(StringValue stringValue) {
        expression = ExpressionBuilder.constant(stringValue.getValue());
    }

    @Override
    public void visit(Addition addition) {
        Expression left = addition.getLeftExpression();
        ExpressionVisitorImpl leftVisitor = new ExpressionVisitorImpl(relationProvider);
        left.accept(leftVisitor);

        Expression right = addition.getRightExpression();
        ExpressionVisitorImpl rightVisitor = new ExpressionVisitorImpl(relationProvider);
        right.accept(rightVisitor);

        expression = ExpressionBuilder.add(leftVisitor.getExpression(), rightVisitor.getExpression());
    }

    @Override
    public void visit(Division division) {
        Expression left = division.getLeftExpression();
        ExpressionVisitorImpl leftVisitor = new ExpressionVisitorImpl(relationProvider);
        left.accept(leftVisitor);

        Expression right = division.getRightExpression();
        ExpressionVisitorImpl rightVisitor = new ExpressionVisitorImpl(relationProvider);
        right.accept(rightVisitor);

        expression = ExpressionBuilder.div(leftVisitor.getExpression(), rightVisitor.getExpression());
    }

    @Override
    public void visit(Multiplication multiplication) {
        Expression left = multiplication.getLeftExpression();
        ExpressionVisitorImpl leftVisitor = new ExpressionVisitorImpl(relationProvider);
        left.accept(leftVisitor);

        Expression right = multiplication.getRightExpression();
        ExpressionVisitorImpl rightVisitor = new ExpressionVisitorImpl(relationProvider);
        right.accept(rightVisitor);

        expression = ExpressionBuilder.mul(leftVisitor.getExpression(), rightVisitor.getExpression());
    }

    @Override
    public void visit(Subtraction subtraction) {
        Expression left = subtraction.getLeftExpression();
        ExpressionVisitorImpl leftVisitor = new ExpressionVisitorImpl(relationProvider);
        left.accept(leftVisitor);

        Expression right = subtraction.getRightExpression();
        ExpressionVisitorImpl rightVisitor = new ExpressionVisitorImpl(relationProvider);
        right.accept(rightVisitor);

        expression = ExpressionBuilder.sub(leftVisitor.getExpression(), rightVisitor.getExpression());
    }

    @Override
    public void visit(AndExpression andExpression) {
        Expression left = andExpression.getLeftExpression();
        ExpressionVisitorImpl leftVisitor = new ExpressionVisitorImpl(relationProvider);
        left.accept(leftVisitor);

        Expression right = andExpression.getRightExpression();
        ExpressionVisitorImpl rightVisitor = new ExpressionVisitorImpl(relationProvider);
        right.accept(rightVisitor);

        expression = ExpressionBuilder.and(leftVisitor.getExpression(), rightVisitor.getExpression());
    }

    @Override
    public void visit(OrExpression orExpression) {
        Expression left = orExpression.getLeftExpression();
        ExpressionVisitorImpl leftVisitor = new ExpressionVisitorImpl(relationProvider);
        left.accept(leftVisitor);

        Expression right = orExpression.getRightExpression();
        ExpressionVisitorImpl rightVisitor = new ExpressionVisitorImpl(relationProvider);
        right.accept(rightVisitor);

        expression = ExpressionBuilder.or(leftVisitor.getExpression(), rightVisitor.getExpression());
    }

    @Override
    public void visit(Between between) {
        Expression left = between.getLeftExpression();
        ExpressionVisitorImpl leftVisitor = new ExpressionVisitorImpl(relationProvider);
        left.accept(leftVisitor);

        Expression start = between.getBetweenExpressionStart();
        ExpressionVisitorImpl startVisitor = new ExpressionVisitorImpl(relationProvider);
        start.accept(startVisitor);

        Expression end = between.getBetweenExpressionEnd();
        ExpressionVisitorImpl endVisitor = new ExpressionVisitorImpl(relationProvider);
        end.accept(endVisitor);

        expression = ExpressionBuilder.between(leftVisitor.getExpression(), startVisitor.getExpression(), endVisitor.getExpression());
    }

    @Override
    public void visit(EqualsTo equalsTo) {
        Expression left = equalsTo.getLeftExpression();
        ExpressionVisitorImpl leftVisitor = new ExpressionVisitorImpl(relationProvider);
        left.accept(leftVisitor);

        Expression right = equalsTo.getRightExpression();
        ExpressionVisitorImpl rightVisitor = new ExpressionVisitorImpl(relationProvider);
        right.accept(rightVisitor);

        expression = ExpressionBuilder.eq(leftVisitor.getExpression(), rightVisitor.getExpression());
    }

    @Override
    public void visit(GreaterThan greaterThan) {
        Expression left = greaterThan.getLeftExpression();
        ExpressionVisitorImpl leftVisitor = new ExpressionVisitorImpl(relationProvider);
        left.accept(leftVisitor);

        Expression right = greaterThan.getRightExpression();
        ExpressionVisitorImpl rightVisitor = new ExpressionVisitorImpl(relationProvider);
        right.accept(rightVisitor);

        expression = ExpressionBuilder.gt(leftVisitor.getExpression(), rightVisitor.getExpression());
    }

    @Override
    public void visit(GreaterThanEquals greaterThanEquals) {
        Expression left = greaterThanEquals.getLeftExpression();
        ExpressionVisitorImpl leftVisitor = new ExpressionVisitorImpl(relationProvider);
        left.accept(leftVisitor);

        Expression right = greaterThanEquals.getRightExpression();
        ExpressionVisitorImpl rightVisitor = new ExpressionVisitorImpl(relationProvider);
        right.accept(rightVisitor);

        expression = ExpressionBuilder.gte(leftVisitor.getExpression(), rightVisitor.getExpression());
    }

    @Override
    public void visit(InExpression inExpression) {
        //TODO need implements
    }

    @Override
    public void visit(IsNullExpression isNullExpression) {
        //TODO need implements
    }

    @Override
    public void visit(LikeExpression likeExpression) {
        //TODO need implements
    }

    @Override
    public void visit(MinorThan minorThan) {
        //TODO need implements
    }

    @Override
    public void visit(MinorThanEquals minorThanEquals) {
        //TODO need implements
    }

    @Override
    public void visit(NotEqualsTo notEqualsTo) {
        Expression left = notEqualsTo.getLeftExpression();
        ExpressionVisitorImpl leftVisitor = new ExpressionVisitorImpl(relationProvider);
        left.accept(leftVisitor);

        Expression right = notEqualsTo.getRightExpression();
        ExpressionVisitorImpl rightVisitor = new ExpressionVisitorImpl(relationProvider);
        right.accept(rightVisitor);

        com.xingcloud.xa.session2.ra.expr.Expression eq = ExpressionBuilder.eq(leftVisitor.getExpression(), rightVisitor.getExpression());
        expression = ExpressionBuilder.not(eq);
    }

    @Override
    public void visit(Column column) {
        expression = ExpressionBuilder.column(column.getColumnName());
    }

    @Override
    public void visit(SubSelect subSelect) {
        //TODO need implements
    }

    @Override
    public void visit(CaseExpression caseExpression) {
        //TODO need implements
    }

    @Override
    public void visit(WhenClause whenClause) {
        //TODO need implements
    }

    @Override
    public void visit(ExistsExpression existsExpression) {
        //TODO need implements
    }

    @Override
    public void visit(AllComparisonExpression allComparisonExpression) {
        //TODO need implements
    }

    @Override
    public void visit(AnyComparisonExpression anyComparisonExpression) {
        //TODO need implements
    }

    @Override
    public void visit(Concat concat) {
        //TODO need implements
    }

    @Override
    public void visit(Matches matches) {
        //TODO need implements
    }

    @Override
    public void visit(BitwiseAnd bitwiseAnd) {
        //TODO need implements
    }

    @Override
    public void visit(BitwiseOr bitwiseOr) {
        //TODO need implements
    }

    @Override
    public void visit(BitwiseXor bitwiseXor) {
        //TODO need implements
    }
}
