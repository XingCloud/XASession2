package com.xingcloud.xa.session2.ra.expr;

import com.xingcloud.xa.session2.ra.Aggregation;
import com.xingcloud.xa.session2.ra.Row;

/**
 * Author: mulisen
 * Date:   2/7/13
 */

public class AggregationExpr implements Expression {

	public Aggregation aggregation;

	public AggregationExpr(Aggregation aggregation) {
		this.aggregation = aggregation;
	}

	public Object evaluate(Row input) {
		return aggregation.aggregate();
	}

	public void init(){
		aggregation.init();
	}


}
