package com.ty.one_to_one_uni_dto;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class PanCard {
	@Id
	private String panNo;
	private String holder_name;
	private String address;
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getHolder_name() {
		return holder_name;
	}
	public void setHolder_name(String holder_name) {
		this.holder_name = holder_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "PanCard [panNo=" + panNo + ", holder_name=" + holder_name + ", address=" + address + "]";
	}
	
}
