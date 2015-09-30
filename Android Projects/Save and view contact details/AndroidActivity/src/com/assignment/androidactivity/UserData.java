package com.assignment.androidactivity;

public class UserData {
	
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String creditCardNUmber;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreditCardNUmber() {
		return creditCardNUmber;
	}
	public void setCreditCardNUmber(String creditCardNUmber) {
		this.creditCardNUmber = creditCardNUmber;
	}	
	public int  getId() {
		return id;
	}
	public void  setId(int id) {
		this.id = id;
	}
	 @Override
	    public String toString() {
	        return "UserData [id=" + id + ", FirstName=" + firstName + ", LastName=" + lastName +", Address=" + address + ", CreditCard=" + creditCardNUmber
	                + "]";
	    }
}
