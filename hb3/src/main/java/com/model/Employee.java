package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAllEmployee",query = "from Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String ename;
	private String edesignation;
	private String ecompany;
	@Column(columnDefinition = "double(10,2)")
	private double esalary;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEdesignation() {
		return edesignation;
	}

	public void setEdesignation(String edesignation) {
		this.edesignation = edesignation;
	}

	public String getEcompany() {
		return ecompany;
	}

	public void setEcompany(String ecompany) {
		this.ecompany = ecompany;
	}

	public double getEsalary() {
		return esalary;
	}

	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", edesignation=" + edesignation + ", ecompany=" + ecompany
				+ ", esalary=" + esalary + "]";
	}

	public Employee(int eid, String ename, String edesignation, String ecompany, double esalary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.edesignation = edesignation;
		this.ecompany = ecompany;
		this.esalary = esalary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
}
