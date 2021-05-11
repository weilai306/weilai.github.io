package javaee.jpa.one2many.bidirection;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String major;
	private String gender;
	private String name;

	
	
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="teacher_id")
	private Teacher teacher;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}


	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher t) {
		this.teacher=t;
	}
}