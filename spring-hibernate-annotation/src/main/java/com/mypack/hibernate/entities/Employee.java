package com.mypack.hibernate.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMP_ID")
    private long id;
	
	@Column(name="NAME", nullable=false)
    private String name;
	
	@Column(name="CONTACT", nullable=false)
    private String contact;
    
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DETAIL_ID",foreignKey=@ForeignKey(name="DETAIL_ID_FK"), nullable=true)
    private EmpDetails empDetails;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "EMP_PRIVILEGES", joinColumns = { @JoinColumn(name = "EMP_ID") }, inverseJoinColumns = { @JoinColumn(name = "PRIVILEGE_ID") })
	private Set<Privilege> previleges;
    
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
	
	public Set<Privilege> getPrevileges() {
		return previleges;
	}
	public void setPrevileges(Set<Privilege> previleges) {
		this.previleges = previleges;
	}
	public String toString() {
        return "Employee: ID:" + id + ", NAME: "+ name + ", CONTACT: " + contact + ", EMP_DETAILS: " + empDetails;
    }   
}
