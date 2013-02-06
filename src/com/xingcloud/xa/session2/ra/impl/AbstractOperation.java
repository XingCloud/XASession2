package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.Operation;
import com.xingcloud.xa.session2.ra.Relation;
import com.xingcloud.xa.session2.ra.Row;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public abstract class AbstractOperation implements Operation {
	protected List<Operation> inputs = new ArrayList<Operation>();

	protected Relation result = null;

	protected void addInput(Operation input){
		inputs.add(input);
	}

	public Row nextRow() {
		if(result == null){
			result = this.evaluate();
		}
		return result.nextRow();
	}
}
