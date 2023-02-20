package one_to_one_uni_dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdharCard {
	@Id
	private int adhar_id;
	private String name;
	private String address;
	public int getAdhar_id() {
		return adhar_id;
	}
	public void setAdhar_id(int adhar_id) {
		this.adhar_id = adhar_id;
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
	@Override
	public String toString() {
		return "AdharCard [adhar_id=" + adhar_id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
