package com.xingcloud.xa.session2.ra;

import com.xingcloud.xa.session2.ra.impl.*;

import java.util.Hashtable;

/**
 * Author: mulisen
 * Date:   2/6/13
 */
public class PlanFactory {

	private static PlanFactory instance = new PlanFactory();
	private final Hashtable<String, Class<? extends Operation>> implementations;

	private PlanFactory(){
		implementations = new Hashtable<String, Class<? extends Operation>>();
		implementations.put("Distinct", XDistinct.class);
		implementations.put("Projection", XProjection.class);
		implementations.put("Selection", XSelection.class);
		implementations.put("Join", XJoin.class);
		implementations.put("GroupCount", XGroupCount.class);
		implementations.put("GroupSum", XGroupSum.class);
	}

	public static PlanFactory getInstance(){
		return instance;
	}

	public Operation createOpeation(Class<? extends Operation> clz){
		Class<? extends Operation> implementClz = implementations.get(clz.getSimpleName());
		try {
			return implementClz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();  //e:
		} catch (IllegalAccessException e) {
			e.printStackTrace();  //e:
		}
		return null;
	}

	public static void main(String[] args) {
		getInstance().createOpeation(Distinct.class);
	}
}
