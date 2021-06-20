package com.mypack.beans;

public class Employee {
    private long id;
    private String name;
    private String contact;
    
    private EmpDetails empDetails; 
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public EmpDetails getEmpDetails() {
		return empDetails;
	}
	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
	}
	public String toString() {
        return "Employee: ID:" + id + ", NAME: "+ name + ", CONTACT: " + contact + ", EMP_DETAILS: " + empDetails;
    }   
}
