package tp04;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    
    private Person pers;
    private double[] grades;

    private Student(Person pers, double[] grades) {
        this.pers = pers;
        this.grades = grades;
    }
    
    Student(String forename, String name, double[] grades) {
        this(new Person(forename, name), grades);

    }

    Student(String forename, String name, double grade) {
        this(new Person(forename, name), new double[]{grade});
    }

    public String getFornename() {
        return this.pers.getForename();
    }

    public String getname() {
        return this.pers.getName();
    }

    public double[] getGrades() {
        return this.grades;
    }

    public int getId() {
        return this.pers.getID();
    }

    public String toString() {
        return "["+this.pers.getID()+": "+this.getFornename()+" "+this.getname()+" = "+Arrays.toString(this.getGrades())+"]"; 
    }

    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        if(!Objects.equals(this.pers, other.pers)) return false; // On regarde l'ID uniquement
        if(this.grades.length != other.grades.length) return false;
        for(int i = 0; i < this.grades.length; i++){
            if(this.grades[i] != other.grades[i]) return false; 
        }
        return true;
    }

    public double getAverage() {
        if(this.grades.length == 0) return 0;
        double counter = 0;
        for(double d : this.grades) {
            counter += d;
        }
        return counter/this.grades.length;
    }

    public void addGrade(double aGrade) {
        double [] nouveau = Arrays.copyOf(this.grades, this.grades.length+1);
        nouveau[this.grades.length] = aGrade;
        this.grades = nouveau;
    }



}
