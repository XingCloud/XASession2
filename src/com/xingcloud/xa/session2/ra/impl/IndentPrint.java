package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Aggregation;
import com.xingcloud.xa.session2.ra.RelationProvider;
import com.xingcloud.xa.session2.ra.expr.*;

import java.util.Map;

/**
 * Author: mulisen
 * Date:   2/7/13
 */
public class IndentPrint {
	public static String print(RelationProvider relation){
		StringBuilder sb = new StringBuilder();
		printRP(relation, 0, sb);
		return sb.toString();
	}
	public static void printRP(RelationProvider relation, int depth, StringBuilder sb){
		if(relation == null){
			sb.append(prefix(depth)).append("NULL\n");
		}else{
		if(relation instanceof XDistinct){
			printDistinct((XDistinct)relation, depth, sb);
		}else if(relation instanceof XGroup){
			printGroup((XGroup)relation, depth, sb);
		}else if(relation instanceof XJoin){
			printJoin((XJoin)relation, depth, sb);
		}else if(relation instanceof XProjection){
			printProjection((XProjection)relation, depth, sb);
		}else if(relation instanceof XSelection){
			printSelection((XSelection)relation, depth, sb);
		}else if(relation instanceof XTableScan){
			printTableScan((XTableScan)relation, depth, sb);
		}else if(relation instanceof XRelation){
			printRelation((XRelation)relation, depth, sb);
		}
		}
	}

	private static String prefix(int depth){
		StringBuilder indentSB = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			indentSB.append("  ");
		}
		return indentSB.toString();
	}

	private static void printRelation(XRelation relation, int depth, StringBuilder sb) {
		sb.append(prefix(depth)).append("R( ");
		for (Map.Entry<String, Integer> entry : relation.columnIndex.entrySet()) {
			String key = entry.getKey();
			sb.append(key).append(" ");
		}
		sb.append(")\n");
	}

	private static void printTableScan(XTableScan tableScan, int depth, StringBuilder sb) {
		sb.append(prefix(depth)).append("TABLE '").append(tableScan.tableName).append("'\n");
	}

	private static void printSelection(XSelection selection, int depth, StringBuilder sb) {
		String indent = prefix(depth);
		sb.append(indent).append("SELECT FROM:\n");
		printRP(selection.relation,depth + 1, sb);
		sb.append(indent).append("SELECT WHERE:\n");
		printExpression(selection.expression,depth+1,sb);
		sb.append(indent).append("END SELECT\n");
	}

	private static void printProjection(XProjection projection, int depth, StringBuilder sb) {
		String indent = prefix(depth);
		sb.append(indent).append("PROJECTION FROM:\n");
		printRP(projection.relation,depth + 1, sb);
		sb.append(indent).append("PROJECTION TO:\n");
		if(projection.projections == null){
			sb.append(indent).append("  ").append("*");
		}else{
			for (int i = 0; i < projection.projections.length; i++) {
				Expression proj = projection.projections[i];
				printExpression(proj,depth+1,sb);
			}
		}
		sb.append(indent).append("END PROJECTION\n");
	}

	private static void printJoin(XJoin join, int depth, StringBuilder sb) {
		String indent = prefix(depth);
		sb.append(indent).append("NATURAL JOIN LEFT:\n");
		printRP(join.left,depth + 1, sb);
		sb.append(indent).append("JOIN RIGHT:\n");
		printRP(join.right,depth + 1,sb);
		sb.append(indent).append("END JOIN\n");
	}

	private static void printGroup(XGroup group, int depth, StringBuilder sb) {
	    String indent = prefix(depth);
		sb.append(indent).append("GROUP FROM:\n");
		printRP(group.relation, depth+1, sb);
		sb.append(indent).append("GROUP BY:\n");
		if(group.groupingExpressions == null){
			sb.append(indent).append("  ").append("*");
		}else{
			for (int i = 0; i < group.groupingExpressions.length; i++) {
				Expression grouping = group.groupingExpressions[i];
				printExpression(grouping, depth+1,sb);
			}
		}
		sb.append(indent).append("GROUP OUTPUT:\n");
		if(group.projectionExpressions == null){
			sb.append(indent).append("  ").append("*");
		}else{
			for (int i = 0; i < group.projectionExpressions.length; i++) {
				Expression projection = group.projectionExpressions[i];
				printExpression(projection,depth+1,sb);
			}
		}
		sb.append(indent).append("END GROUP\n");
	}

	private static void printDistinct(XDistinct distinct, int depth, StringBuilder sb) {
		String indent = prefix(depth);
		sb.append(indent).append("DISTINCT FROM:\n");
		printRP(distinct.relation, depth + 1, sb);
		sb.append(indent).append("DISTINCT TO:\n");
		if(distinct.expressions == null){
			sb.append(indent).append("  ").append("*");
		}else{
			for (int i = 0; i < distinct.expressions.length; i++) {
				Expression projection = distinct.expressions[i];
				printExpression(projection, depth + 1, sb);
			}
		}
		sb.append(indent).append("END DISTINCT\n");
	}

	private static void printExpression(Expression expression, int depth, StringBuilder sb) {
		String indent = prefix(depth);
		if(expression instanceof BinaryExpression){
			BinaryExpression be = (BinaryExpression) expression;
			sb.append(indent).append(be.getClass().getSimpleName()).append(" (\n");
			printExpression(be.left, depth + 1, sb);
			sb.append(indent).append(",\n");
			printExpression(be.right, depth + 1, sb);
			sb.append(indent).append(")\n");
		}else if(expression instanceof AggregationExpr){
			printAggregation(((AggregationExpr)expression).aggregation, depth, sb);
		}else if(expression instanceof Between){

		}else if(expression instanceof ColumnValue){
			sb.append(indent).append("COLUMN(").append(((ColumnValue)expression).columnName).append(")\n");
		}else if(expression instanceof Constant){
			sb.append(indent).append("CONST(").append(((Constant)expression).value).append(")\n");
		}else if(expression instanceof FunctionCall){

		}else if(expression instanceof Not){
			sb.append(indent).append("NOT(\n");
			printExpression(((Not)expression).input, depth+1, sb);
			sb.append(indent).append(")\n");
		}
	}

	private static void printAggregation(Aggregation aggregation, int depth, StringBuilder sb) {
		String indent = prefix(depth);
		if(aggregation instanceof XCount){
			sb.append(indent).append("COUNT(\n");
			printRP(((XCount)aggregation).relation, depth+1, sb);
			sb.append(indent).append(")\n");
		}else if(aggregation instanceof XSum){
			sb.append(indent).append("SUM('").append(((XSum)aggregation).columnName).append("',\n");
			printRP(((XSum)aggregation).relation, depth+1, sb);
			sb.append(indent).append(")\n");
		}
	}


}
