package javaee.jpa.many2many.moreparameter;

import javax.persistence.*;

public class CoursePK implements java.io.Serializable{
	private int student_id;
	private int teacher_id;
	
	public CoursePK() { 
	}
	public CoursePK(int student_id, int teacher_id) {
		this.student_id = student_id;
		this.teacher_id = teacher_id;
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
		
	//实现hashCode方法
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((student_id == 0) ? 0 : student_id);
		result = PRIME * result + ((teacher_id == 0) ? 0 : teacher_id);
		return result;
	} 

	//实现equals方法
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj == null) {
			result = false;
		}
		if (this == obj) {
			result = true;
		}

		if (obj instanceof CoursePK) {
			CoursePK pk = (CoursePK) obj;
			if ((this.student_id==pk.getStudent_id()) && (this.teacher_id==pk.getTeacher_id())) {
				result = true;
			}

		} else {
			result = false;
		}
		return result;
	} 


}
