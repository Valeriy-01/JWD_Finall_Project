package by.tc.finalproject.bean;

import java.io.Serializable;

public class Faculty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private PlanRequirements planRequirements;
	private SubjectRequirements subjectRequirements;

	public Faculty() {
	}

	public Faculty(String title, PlanRequirements planRequirements, SubjectRequirements subjectRequirements) {
		this.title = title;
		this.planRequirements = planRequirements;
		this.subjectRequirements = subjectRequirements;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PlanRequirements getPlanRequirements() {
		return planRequirements;
	}

	public void setPlanRequirements(PlanRequirements planRequirements) {
		this.planRequirements = planRequirements;
	}

	public SubjectRequirements getSubjectRequirements() {
		return subjectRequirements;
	}

	public void setSubjectRequirements(SubjectRequirements subjectRequirements) {
		this.subjectRequirements = subjectRequirements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Faculty other = (Faculty) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
