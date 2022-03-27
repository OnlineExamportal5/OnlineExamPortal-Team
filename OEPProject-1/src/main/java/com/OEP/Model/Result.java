package com.OEP.Model;

	import java.io.Serializable;

	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.OneToOne;

	import com.fasterxml.jackson.annotation.JsonBackReference;

	@Entity
	public class Result implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int serialNo;
		private int marks;
		private String resultStatus;

		@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
		@JoinColumn(name = "Test_id")
		@JsonBackReference
		private Tests test;

		public Result(int serialNo, int marks, String resultStatus, Tests test) {
			super();
			this.serialNo = serialNo;
			this.marks = marks;
			this.resultStatus = resultStatus;
			this.test = test;
		}

		public Result() {
			super();
		}

		public int getMarks() {
			return marks;
		}

		public void setMarks(int marks) {
			this.marks = marks;
		}

		public String getResultStatus() {
			return resultStatus;
		}

		public void setResultStatus(String resultStatus) {
			this.resultStatus = resultStatus;
		}

		public Tests getTest() {
			return test;
		}

		public void setTest(Tests test) {
			this.test = test;
		}

		public int getSerialno() {
			return serialNo;
		}

		public void setSerialno(int serialno) {
			this.serialNo = serialno;
		}

		@Override
		public String toString() {
			return "Result [serialNo=" + serialNo + ", marks=" + marks + ", resultStatus=" + resultStatus + ", test=" + test
					+ "]";
		}

		

	}


