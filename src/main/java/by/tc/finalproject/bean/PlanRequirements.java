package by.tc.finalproject.bean;

import java.io.Serializable;

public class PlanRequirements implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int dialPlan;
	private int passingScope;

	public PlanRequirements() {
	}

	public PlanRequirements(int dialPlan, int passingScope) {
		this.dialPlan = dialPlan;
		this.passingScope = passingScope;
	}

	public int getDialPlan() {
		return dialPlan;
	}

	public void setDialPlan(int dialPlan) {
		this.dialPlan = dialPlan;
	}

	public int getPassingScope() {
		return passingScope;
	}

	public void setPassingScope(int passingScope) {
		this.passingScope = passingScope;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dialPlan;
		result = prime * result + id;
		result = prime * result + passingScope;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanRequirements other = (PlanRequirements) obj;
		if (dialPlan != other.dialPlan)
			return false;
		if (id != other.id)
			return false;
		if (passingScope != other.passingScope)
			return false;
		return true;
	}

}
