package com.spring.webapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custId;
	@NotBlank(message="Customer name required")
	private String custName;
	@NotBlank(message="Address required")
	private String address;
	@NotBlank(message="City required")
	private String city;
	@NotBlank(message="Email required")
	@Email(message="Check Email format")
	@Pattern(regexp="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$", message="Email Format Invalid")
	private String email;
	@NotBlank(message="Phone Number required")
	@Pattern(regexp="\\([0-9]{3}\\)[0-9]{3}-[0-9]{4}", message="Follow format: (000)000-0000")
	private String phoneNumber;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
