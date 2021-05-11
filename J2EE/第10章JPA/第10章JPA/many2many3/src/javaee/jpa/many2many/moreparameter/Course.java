package javaee.jpa.many2many.moreparameter;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.*;

@Entity
@IdClass(CoursePK.class)
@Table(name="course")
public class Course {

	private static final long serialVersionUID = 1L;

		
	@ManyToOne(cascade = { CascadeType.ALL },optional=false)
    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID",nullable=false, updatable=false,insertable=false)
	private Teacher teacher;
    @ManyToOne(cascade={CascadeType.ALL},optional=false)
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID",nullable=false, updatable=false,insertable=false)
	private Student student;
	private String course;
	@Id
	private int teacher_id;
	@Id
	private int student_id;
	
	
	public Course() {
	}


	public int getStudent_id()
	{
	      return student_id;
	}

	public void setStudent_id(int student_id)
	{
	      this.student_id = student_id;
	}

	public int getTeacher_id()
	{
	      return teacher_id;
	}

	public void setTeacher_id(int teacher_id)
	{
	      this.teacher_id = teacher_id;
	}

	public String getCourse() {
		return this.course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public Teacher getTeacher() {
		return this.teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Student getStudent() {
		return this.student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
