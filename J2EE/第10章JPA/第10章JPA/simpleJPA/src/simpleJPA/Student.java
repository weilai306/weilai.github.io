package simpleJPA;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
	
	@Id	
	private int id;

	private String name;
	private String gender;
	private String address_id;

	public Student() {
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String StuName) {
		this.name = StuName;
	}
	
	public String getGender() {
		return this.gender;
	}
	public void setGender(String Gender) {
		this.gender = Gender;
	}
	public String getaddress_id() {
		return this.address_id;
	}
	public void setaddress_id(String addressid) {
		this.address_id = addressid;
	}
}