package com.ty.one_to_one_uni_dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Person {
	@Id
	private int id;
	private String name;
	private String address;
	private long phone;
	private int age;
	@OneToOne
	private PanCard panCard;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public PanCard getPanCard() {
		return panCard;
	}
	public void setPanCard(PanCard panCard) {
		this.panCard = panCard;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", age=" + age
				+ ", panCard=" + panCard + "]";
	}
	
}
