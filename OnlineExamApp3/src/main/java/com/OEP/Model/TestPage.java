package com.OEP.Model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Test")

public class TestPage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Test_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testId;

	 @Column(name = "CourseType", nullable = false)
	 @NotEmpty
	 @Size(min = 2, message = "user CourseType must have atleast two character")

	private String courseType;


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

	@Override
	public String toString() {
		return "TestPage [testId=" + testId + ", courseType=" + courseType + "]";
	}

	
}
