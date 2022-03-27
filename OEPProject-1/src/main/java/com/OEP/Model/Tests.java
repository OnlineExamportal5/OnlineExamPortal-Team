package com.OEP.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

@Table(name = "Tests")
public class Tests {

	@Id

	@Column(name = "Test_id")
	private int testId;
	@Column(name = "CourseType")
	private String courseType;

	@ManyToOne
	@JoinColumn(name = "user_Id")
	@JsonBackReference
	private Users users;

	public Tests(int testId, String courseType) {
		super();
		this.testId = testId;
		this.courseType = courseType;
	}

	public Tests() {
		super();
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	@JsonManagedReference
	@OneToOne(mappedBy = "test", cascade = CascadeType.ALL)
	private Result result;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Tests [testId=" + testId + ", courseType=" + courseType + ", users=" + users + ", result=" + result
				+ "]";
	}

}
