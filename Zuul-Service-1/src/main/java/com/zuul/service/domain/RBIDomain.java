package com.zuul.service.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class RBIDomain {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rbi_reg_number")
	private long registrationNumber;
	@Column(name = "bank_name")
	private String  bankName;
	@Column(name="policy_rates")
	private double policyRates;
	@Column(name = "resrve_ratios")
	private double reserveRatios;
	@Column(name="deposite_rates")
	private float depositeRates;
	
	@OneToMany(mappedBy = "rbiDomain",orphanRemoval = true)
	private List<BankDomain> banks;

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

	public double getPolicyRates() {
		return policyRates;
	}

	public void setPolicyRates(double policyRates) {
		this.policyRates = policyRates;
	}

	public double getReserveRatios() {
		return reserveRatios;
	}

	public void setReserveRatios(double reserveRatios) {
		this.reserveRatios = reserveRatios;
	}

	public float getDepositeRates() {
		return depositeRates;
	}

	public void setDepositeRates(float depositeRates) {
		this.depositeRates = depositeRates;
	}

	public List<BankDomain> getBanks() {
		return banks;
	}

	public void setBanks(List<BankDomain> banks) {
		this.banks = banks;
	}

	@Override
	public String toString() {
		return "RBIDomain [registrationNumber=" + registrationNumber + ", bankName=" + bankName + ", policyRates="
				+ policyRates + ", reserveRatios=" + reserveRatios + ", depositeRates=" + depositeRates + ", banks="
				+ banks + "]";
	}

	
	
	

}
