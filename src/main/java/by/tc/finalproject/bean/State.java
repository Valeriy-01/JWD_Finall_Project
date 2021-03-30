package by.tc.finalproject.bean;

import java.io.Serializable;

public class State implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int studentId;
	private int firstSubjectResult;
	private int secondSubjectResult;
	private int thirdSubjectResult;
	private int certificateResult;
	private int totalScope;

	public State(int firstSubjectResult, int secondSubjectResult, int thirdSubjectResult, int certificateResult) {
		this.firstSubjectResult = firstSubjectResult;
		this.secondSubjectResult = secondSubjectResult;
		this.thirdSubjectResult = thirdSubjectResult;
		this.certificateResult = certificateResult;
	}

	public State() {
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getFirstSubjectResult() {
		return firstSubjectResult;
	}

	public void setFirstSubjectResult(int firstSubjectResult) {
		this.firstSubjectResult = firstSubjectResult;
	}

	public int getSecondSubjectResult() {
		return secondSubjectResult;
	}

	public void setSecondSubjectResult(int secondSubjectResult) {
		this.secondSubjectResult = secondSubjectResult;
	}

	public int getThirdSubjectResult() {
		return thirdSubjectResult;
	}

	public void setThirdSubjectResult(int thirdSubjectResult) {
		this.thirdSubjectResult = thirdSubjectResult;
	}

	public int getCertificateResult() {
		return certificateResult;
	}

	public void setCertificateResult(int certificateResult) {
		this.certificateResult = certificateResult;
	}

	public int getTotalScope() {
		return totalScope;
	}

	public void setTotalScope(int totalScope) {
		this.totalScope = totalScope;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + certificateResult;
		result = prime * result + firstSubjectResult;
		result = prime * result + secondSubjectResult;
		result = prime * result + studentId;
		result = prime * result + thirdSubjectResult;
		result = prime * result + totalScope;
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
		State other = (State) obj;
		if (certificateResult != other.certificateResult)
			return false;
		if (firstSubjectResult != other.firstSubjectResult)
			return false;
		if (secondSubjectResult != other.secondSubjectResult)
			return false;
		if (studentId != other.studentId)
			return false;
		if (thirdSubjectResult != other.thirdSubjectResult)
			return false;
		if (totalScope != other.totalScope)
			return false;
		return true;
	}

}
