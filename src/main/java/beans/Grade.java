package beans;

public class Grade {

    Date date = new Date();
    private String grade;
    private float score;

    // Getter Methods
    public float getScore() {
        return score;
    }
    public String getGrade() {
        return grade;
    }
    public Date getDate() {
        return date;
    }

    // Setter Methods
    public void setScore(float score) {
        this.score = score;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}