package com.OEP.Model;

	import java.io.Serializable;
	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.OneToOne;
	import javax.validation.constraints.Email;
	import javax.validation.constraints.NotEmpty;
	import javax.validation.constraints.NotNull;
	import javax.validation.constraints.Size;
	import org.hibernate.validator.constraints.Range;
	@Entity
	public class Admin implements Serializable {
	    private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    @Column(name = "name", nullable = false)
	    @NotEmpty
	    @Size(min = 2, message = "user name must have atleast two character")
	    private String name;
	    @NotNull(message = "email field must not be empty")
	    @Email(message = "email should be in valid format")
	    private String emailid;
	    @Column(name = "password", nullable = false)
	    @NotEmpty
	    @Size(min = 2, message = "password should contain one uppercase and lowercase")
	    private String password;
	    @NotNull(message = "mobileno should not be empty")
	    @Range(min = 3)
	    private int mobileno;
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id")
	    private Address address;
	    public Admin(int id,String name, String emailid, String password, int mobileno, Address address) {
	        super();
	        this.id=id;
	        this.name = name;
	        this.emailid = emailid;
	        this.password = password;
	        this.mobileno = mobileno;
	        this.address = address;
	    }
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getEmailid() {
	        return emailid;
	    }
	    public void setEmailid(String emailid) {
	        this.emailid = emailid;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public int getMobileno() {
	        return mobileno;
	    }
	    public void setMobileno(int mobileno) {
	        this.mobileno = mobileno;
	    }
	    public Address getAddress() {
	        return address;
	    }
	    public void setAddress(Address address) {
	        this.address = address;
	    }
	    @Override
	    public String toString() {
	        return "Admin [id=" + id + ", name=" + name + ", emailid=" + emailid + ", password=" + password + ", mobileno="
	                + mobileno + ", address=" + address + "]";
	    }
	}


