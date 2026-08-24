package tp04;

import java.util.Objects;

public class StudentAbs {
    
    private Student etu;
    private int nbAbsence;

    public StudentAbs(Student etu, int nbAbsence) {
        this.etu = etu;
        this.nbAbsence = nbAbsence;
    }

    public String toString() {
        return this.etu.toString() +", nbAbs=" +this.nbAbsence; 
    }

    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != obj.getClass()) return false;
        StudentAbs other = (StudentAbs) obj;
        if(!Objects.equals(this.etu, other.etu)) return false;
        if(this.nbAbsence != other.nbAbsence) return false;
        return true;
    }

    boolean warning(int thresholdAbs, double thresholdAvg) {
        return this.nbAbsence >= thresholdAbs || this.etu.getAverage() <= thresholdAvg;
    }

    boolean validation(int thresholdAbs, double thresholdAvg) {
        return !this.warning(thresholdAbs, thresholdAvg);
    }

    public void addGrade(double aGrade) {
        this.etu.addGrade(aGrade);
    }

    public double getAverage() {
        return this.etu.getAverage();
    }

    public int getNbAbsence() {
        return this.nbAbsence;
    }

}
