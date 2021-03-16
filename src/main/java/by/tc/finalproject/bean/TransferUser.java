package by.tc.finalproject.bean;

import java.io.Serializable;

public class TransferUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int facultyId;
	private String name;
	private String surname;
	private int totalScope;
	private String email;

	public TransferUser(int id, int facultyId, String name, String surname, int totalScope, String email) {
		this.id = id;
		this.facultyId = facultyId;
		this.name = name;
		this.surname = surname;
		this.totalScope = totalScope;
		this.email = email;
	}

	public TransferUser() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getTotalScope() {
		return totalScope;
	}

	public void setTotalScope(int totalScope) {
		this.totalScope = totalScope;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
