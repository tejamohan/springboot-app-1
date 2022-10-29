package com.zuul.service.domain;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BankDomain {
	
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
@Column(name = "reg_num")
private long registrationNumber;
@Column(name = "bank_name")
private String bankName;
@Column(name = "branch")
private String branch;
@Column(name = "ifsc")
private String ifsc;
@Column(name = "account_type")
private String acType;
@Column(name = "amount")
private double deposite;

@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JoinColumn(name = "bankid",referencedColumnName = "rbi_reg_number")
private RBIDomain rbiDomain;

public long getRegistrationNumber() {
	return registrationNumber;
}

public void setRegistrationNumber(long registrationNumber) {
	this.registrationNumber = registrationNumber;
}

public String getBankName() {
	return bankName;
}

public void setBankName(String bankName) {
	this.bankName = bankName;
}

public String getBranch() {
	return branch;
}

public void setBranch(String branch) {
	this.branch = branch;
}

public String getIfsc() {
	return ifsc;
}

public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}

public String getAcType() {
	return acType;
}

public void setAcType(String acType) {
	this.acType = acType;
}

public double getDeposite() {
	return deposite;
}

public void setDeposite(double deposite) {
	this.deposite = deposite;
}

public RBIDomain getRbiDomain() {
	return rbiDomain;
}

public void setRbiDomain(RBIDomain rbiDomain) {
	this.rbiDomain = rbiDomain;
}

@Override
public String toString() {
	return "BankDomain [registrationNumber=" + registrationNumber + ", bankName=" + bankName + ", branch=" + branch
			+ ", ifsc=" + ifsc + ", acType=" + acType + ", deposite=" + deposite + ", rbiDomain=" + rbiDomain + "]";
}





}
