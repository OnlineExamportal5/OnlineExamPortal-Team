package com.OEP.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

	@Entity
	public class Address implements Serializable {

		private static final long serialVersionUID = 1L;
		
		    @Id
		    @GeneratedValue(strategy = GenerationType.AUTO)
		    private int addressId;
		    @NotNull(message = "street name should not be empty")
		    private String street;
		    @Column(name = "city", nullable = false)
		    @NotEmpty
		    private String city;
		    @Column(name = "state", nullable = false)
		    @NotEmpty
		    private String state;
		    @Column(name = "zipCode", nullable = false)
		    @NotEmpty
		    private int zipCode;
			private String country;
	
		@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
		@JoinColumn(name = "userId")
		@JsonBackReference
		private Users users;


		public Address(int addressId, String city, int zipCode, String country) {
			super();
			this.addressId = addressId;
			this.city = city;
			this.zipCode = zipCode;
			this.country = country;
		}
		
		 public Address(int addressId,String street, String city, String state, int zipCode) {
		        super();
		        this.addressId=addressId;
		        this.street = street;
		        this.city = city;
		        this.state = state;
		        this.zipCode = zipCode;
		 }

		public Address() {
			super();
		}

		public int getAddress_Id() {
			return addressId;
		}

		public void setAddress_Id(int address_Id) {
			this.addressId = address_Id;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public int getZipCode() {
			return zipCode;
		}

		public void setZipCode(int zipCode) {
			this.zipCode = zipCode;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public Users getUsers() {
			return users;
		}

		public void setUsers(Users users) {
			this.users = users;
		}

		@Override
		public String toString() {
			return "Address [address_id=" + addressId + ", city=" + city + ", zipCode=" + zipCode + ", country=" + country
					+ ", users=" + users + "]";
		}

	}
	
	   
	

