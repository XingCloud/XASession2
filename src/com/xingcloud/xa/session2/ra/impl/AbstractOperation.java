package com.xingcloud.xa.session2.ra.impl;

import com.xingcloud.xa.session2.ra.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public abstract class AbstractOperation implements Operation{

	protected List<RelationProvider> inputs = new ArrayList<RelationProvider>();

	protected Relation result = null;

	protected void addInput(RelationProvider input){
		inputs.add(input);
	}

	protected void resetInput(){
		inputs.clear();
	}

	public List<RelationProvider> getInputs() {
		return inputs;
	}

	public RowIterator iterator() {
		if(result == null){
			result = this.evaluate();
		}
		return result.iterator();
	}

	public Map<String, Integer> getColumnIndex() {
		if(result == null){
			result = this.evaluate();
		}
		return result.getColumnIndex();
	}
}
