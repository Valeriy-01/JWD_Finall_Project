package by.tc.finalproject.bean;

import java.io.Serializable;

public class AdmissionResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int studentId;
	private boolean admissionResult;

	public AdmissionResult(boolean admissonResult) {
		this.admissionResult = admissonResult;
	}

	public AdmissionResult() {
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public boolean isAdmissionResult() {
		return admissionResult;
	}

	public void setAdmissionResult(boolean admissionResult) {
		this.admissionResult = admissionResult;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (admissionResult ? 1231 : 1237);
		result = prime * result + studentId;
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
		AdmissionResult other = (AdmissionResult) obj;
		if (admissionResult != other.admissionResult)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

}
