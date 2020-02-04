package me.practice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phone")
public class Phone {

	public enum PhoneType {
		  Home,
		  Cell,
		  Work
		}
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
    private PhoneType type;
	private String number;
	
	public Phone() {
	}
	
	public Phone(PhoneType type, String number) {
		this.type = type;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
}
