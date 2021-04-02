package by.tc.finalproject.bean;

import java.io.Serializable;

public class SubjectRequirements implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String firstSubject;
	private String secondSubject;
	private String thirdSubject;

	public SubjectRequirements() {
	}

	public SubjectRequirements(String firstSubject, String secondSubject, String thirdSubject) {
		this.firstSubject = firstSubject;
		this.secondSubject = secondSubject;
		this.thirdSubject = thirdSubject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstSubject() {
		return firstSubject;
	}

	public void setFirstSubject(String firstSubject) {
		this.firstSubject = firstSubject;
	}

	public String getSecondSubject() {
		return secondSubject;
	}

	public void setSecondSubject(String secondSubject) {
		this.secondSubject = secondSubject;
	}

	public String getThirdSubject() {
		return thirdSubject;
	}

	public void setThirdSubject(String thirdSubject) {
		this.thirdSubject = thirdSubject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstSubject == null) ? 0 : firstSubject.hashCode());
		result = prime * result + id;
		result = prime * result + ((secondSubject == null) ? 0 : secondSubject.hashCode());
		result = prime * result + ((thirdSubject == null) ? 0 : thirdSubject.hashCode());
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
		SubjectRequirements other = (SubjectRequirements) obj;
		if (firstSubject == null) {
			if (other.firstSubject != null)
				return false;
		} else if (!firstSubject.equals(other.firstSubject))
			return false;
		if (id != other.id)
			return false;
		if (secondSubject == null) {
			if (other.secondSubject != null)
				return false;
		} else if (!secondSubject.equals(other.secondSubject))
			return false;
		if (thirdSubject == null) {
			if (other.thirdSubject != null)
				return false;
		} else if (!thirdSubject.equals(other.thirdSubject))
			return false;
		return true;
	}

}
