package com.gmail.st1tchqwerty;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateStudent{
	public Student CreateStudent(){
	 Scanner sc = new Scanner(System.in);
     String name;
     String surname;
     int age = 0;
     int grade=0;
     String specialization;
     System.out.println("Name: ");
     name = sc.next();

     System.out.println("Surname: ");
     surname = sc.next();

     System.out.println("Age: ");
     try {
         age = sc.nextInt();
     } catch (InputMismatchException ime) {
         System.out.println("Not integer");
         CreateStudent();
     }

     System.out.println("Grade: ");
     try {
         age = sc.nextInt();
     } catch (InputMismatchException e) {
         System.out.println("Not integer");
         CreateStudent();
     }

     System.out.println("Specialization: ");
     specialization = sc.next();
 
     return new Student(age, surname, name, grade, specialization);
	}
}

