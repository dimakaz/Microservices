package me.practice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="issue")
public class Issue {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private String description;

    public Issue() {	
    }
    
	public Issue(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
