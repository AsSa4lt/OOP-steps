package com.gmail.st1tchqwerty;

import java.util.Objects;

public class Student extends Human implements CSVConverter{
	private int grade;
	private String specialization;
	
	public Student() {
		super();
	}
	
	public Student(int age, String surname, String name, int grade, String specialization) {
		super(age, surname, name);
		this.grade=grade;
		this.specialization=specialization;
	}
	
	public void setGrade(int grade) {
		this.grade=grade;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setSpec(String specialization) {
		this.specialization=specialization;
	}
	
	public String getSpec() {
		return specialization;
	}
	
	public String toString() {
		return "Student[name="+ getName()+", surname="+ getSurname()+", age="+getAge()+", grade"+grade+", specialization"+specialization;
	}

	@Override
	public String toCSVString() {
		return this.getName()+";"+this.getSurname()+";"+this.getAge()+";"+this.getGrade()+";"+this.specialization+";";
	}

	@Override
	public Student fromCSVString(String str) {;
		String[] splittedString = str.split(";");
		String name = splittedString[0];
		String surname = splittedString[1];
		String age = splittedString[2];
		String grade=splittedString[3];
		String specialization=splittedString[4];
		Student stud=new Student(Integer.parseInt(age), surname, name, Integer.parseInt(grade), specialization);
		return stud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(grade, specialization);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return grade == other.grade && Objects.equals(specialization, other.specialization);
	}
	
	

}
