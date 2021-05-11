package javaee.jpa.many2many.moreparameter;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.IdValidation;

import java.util.Collection;
import java.util.ArrayList;

/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int age;
	private String gender;    
	private String teacherName;
	@OneToMany(cascade = { CascadeType.ALL },mappedBy="teacher")
	private Collection<Course> courses= new  ArrayList<Course>();
	
	public Teacher() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Collection<Course> getCourses() {
        return this.courses;
    }
    public void setCoursess(Collection courses) {
        this.courses = courses;
    }
	


}