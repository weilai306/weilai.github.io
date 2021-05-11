package javaee.jpa.one2many.oneway;

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
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int age;

	private String gender;
    
	private String teacherName;
	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinTable(name="ref_teacher_student",joinColumns={@JoinColumn(name="teacher_id",referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="student_id",referencedColumnName="id")} )
    private Collection<Student> students= new  ArrayList<Student>();

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
	
	public Collection<Student> getStudents() {
        return students;
    }
    public void setStudents(Collection students) {
        this.students = students;
    }

}