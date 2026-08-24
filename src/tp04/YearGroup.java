package tp04;

import java.util.ArrayList;

public class YearGroup {
    
    private ArrayList<StudentAbs> yg;

    public YearGroup() {
        this.yg = new ArrayList<>();
    }

    public ArrayList<StudentAbs> getStudents() {
        return yg;
    }

    public void setStudents(ArrayList<StudentAbs> yg) {
        this.yg = yg;
    }

    public void addStudent(StudentAbs other) {
        this.yg.add(other);
    }

    public void addStudent(ArrayList<StudentAbs> others) {
        this.yg.addAll(others);
    }

    public void addGrades(double[] aTest) {
        for(int i = 0; i < yg.size(); i++) {
            yg.get(i).addGrade(aTest[i]);
        }
    }

    public void validation(int thresholdAbs, int thresholdAvg) {
        for(StudentAbs s : yg) {
            if(s.validation(thresholdAbs, thresholdAvg)) {
                System.out.println(s);
            }
        }
    }



}
