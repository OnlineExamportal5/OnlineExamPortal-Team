package com.OEP.Model;

	import java.util.HashSet;
	import java.util.Set;

	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;
	import javax.validation.constraints.Email;
	import javax.validation.constraints.NotNull;
	import javax.validation.constraints.Size;

	import com.fasterxml.jackson.annotation.JsonManagedReference;

	@Entity
	@Table(name = "User_Details")
	public class Users {

		@Id
		private int userId;
		@NotNull(message = "user_name cannot be empty")
		@Size(min = 2, message = "user_name must be atleast two characters")
		private String userName;
		@NotNull(message = "email-id cannot be empty")
		@Email(message = "email_id should be in a valid format")
		private String userEmail;
		private long mobileNo;
		private String password;

		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")
		// @JoinColumn(name = "address_id")
		@JsonManagedReference
		private Address userAddress;

		public Users(int userId, String userName, String userEmail, String password, long mobileNo, Address userAddress) {
			this.userId = userId;
			this.userName = userName;
			this.userEmail = userEmail;
			this.mobileNo = mobileNo;
			this.password = password;
			this.userAddress = userAddress;
		}

		public Users(int userId, String password) {
			super();
			this.userId = userId;
			this.password = password;
		}

		public Users() {
			super();
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}

		public double getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(long mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Address getUserAddress() {
			return userAddress;
		}

		public void setUserAddress(Address userAddress) {
			this.userAddress = userAddress;
		}

		@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
		@JsonManagedReference
		private Set<Tests> test = new HashSet<>();

		public Set<Tests> getTest() {
			return test;
		}

		public void setTest(Set<Tests> test) {
			this.test = test;
		}

		public Users(int userId, String password, Set<Tests> test) {
			super();
			this.userId = userId;
			this.password = password;
			this.test = test;
		}

		@Override
		public String toString() {
			return "Users [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", mobileNo="
					+ mobileNo + ", password=" + password + ", userAddress=" + userAddress + ", test=" + test + "]";
		}

	}

