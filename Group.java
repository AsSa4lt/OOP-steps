package com.gmail.st1tchqwerty;
import java.util.*;

public class Group {
	private Student[] students=new Student[10];
	private String name;
	
	public Group(){
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student[] getStudents() {
	    return students;
	}
	
	
	public void sort() {
		for(int i=0; i<students.length;i++) {
			for(int j=0; j<students.length; i++) {
				if(students[i].getName().compareTo(students[j].getName())==-1) {
					String c=students[i].getName();
					students[i].setName(students[j].getName());
					students[j].setName(c);
				}
			}
		}
	}
	
	@Override
    public String toString() {
        String output = "";
        sort();
        for(int i=0;  i<students.length; i++) {
        	output=output+students[i]+" ";
        }
        return output;
    }
	
	
	@SuppressWarnings("resource")
	public void delete(int index){
        try {
            students[index] = null;
            sort();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect index.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Incorrect index");
        }
    }
	 
	
	public void add (Student addStud){
        boolean abil = false;
        for (int i = 0; i < getStudents().length; i++) {
            if (getStudents()[i] == null) {
                getStudents()[i] = addStud;
                abil = true;
                break;
            }
        }
        if (abil==false) {
            try {
                throw new NoSpaceException();
            } catch (NoSpaceException e) {
                System.out.println("no space");
            }
        }
    }
	
	
	@SuppressWarnings("resource")
	public Student search (String surname){
        boolean searching = false;
        int j=0;
        while(getStudents()[j].getSurname()!=null) {
        	j++;
        }
        
        for (int i = 0; i <= j; i++) {
            try {
                if (getStudents()[i].getSurname().equals(surname)) {
                	 searching = true;
                    return getStudents()[i];
                }
            } catch (NullPointerException npe) {
                continue;
            }
        }
        if (searching==false) {
            try {
                throw new SearchException();
            } catch (SearchException e) {
                System.out.println("No student");
            }
        }
		return null;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(students);
		result = prime * result + Objects.hash(name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(name, other.name) && Arrays.equals(students, other.students);
	}

	public boolean equalStudents() {
		boolean istrue=false;
		for(int i=0; i<students.length;i++){
			for(int j=0; j<students.length;j++) {
				if(students[i].equals(students[j])) {
					istrue=true;
				}
			}
		}
		return istrue;
	}

	
}


