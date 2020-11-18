package beans;

import java.util.ArrayList;
import java.util.List;

public class Grades {

    private List<Grade> grades = new ArrayList<Grade>();

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
