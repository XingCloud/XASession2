package com.xingcloud.xa.session2.ra;

import com.xingcloud.xa.session2.ra.expr.And;
import com.xingcloud.xa.session2.ra.expr.ColumnValue;
import com.xingcloud.xa.session2.ra.expr.Constant;
import com.xingcloud.xa.session2.ra.expr.Equals;
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
		implementations.put("Group", XGroup.class);
	}

	public static PlanFactory getInstance(){
		return instance;
	}

	public Operation createOperation(Class<? extends Operation> clz){
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

	public Distinct newDistinct(){
		return (Distinct) createOperation(Distinct.class);
	}

	public Group newGroup(){
		return (Group) createOperation(Group.class);
	}
	public Count newCount(){
		return new XCount();
	}

	public Sum newSum(){
		return new XSum();
	}

	public Join newJoin(){
		return (Join) createOperation(Join.class);
	}

	public Projection newProjection(){
		return (Projection) createOperation(Projection.class);
	}

	public Selection newSelection(){
		return (Selection) createOperation(Selection.class);
	}

	public TableScan newTableScan(String tableName){
		return new XTableScan(tableName);
	}

	public static void main(String[] args) {
		PlanFactory f = getInstance();

		//DAU
		//SELECT COUNT(DISTINCT(uid))
		// FROM event NATURAL JOIN user
		// WHERE user.register_time='2013-02-01'
		// AND event.date='2013-02-02' and event.event='visit'
		f.newGroup().setInput(
				f.newDistinct().setInput(
						f.newJoin().setInput(
								f.newSelection().setInput(
										f.newTableScan("user"),
										new Equals(new ColumnValue("register_time"), new Constant("2013-02-01"))
								),
								f.newSelection().setInput(
										f.newTableScan("event"),
										new And(new Equals(new ColumnValue("date"), new Constant("2013-02-02")),
												new Equals(new ColumnValue("event"), new Constant("visit"))
										)
								)
						),
						new ColumnValue("uid")
				)
				,null,null
		);
	}
}
