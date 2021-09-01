package com.gmail.st1tchqwerty;

import java.util.Objects;

public class Human {
	private String name;
	private String surname;
	private int age;
	private int gender;
	
	public Human(int age, String surname, String name) {
		this.age=age;
		this.surname=surname;
		this.name=name;
	}
	
	public Human() {
		
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSurname(String surname) {
		this.surname=surname;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return "Human[name="+ name+", surname="+ surname+", age="+age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, surname,age, gender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		return age == other.age && gender == other.gender && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname);
	}

	
	
	
	
	
}
