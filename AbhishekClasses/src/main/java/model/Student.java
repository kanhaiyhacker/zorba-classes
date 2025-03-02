package model;

public class Student {
   private int id;
   private String name;
   private double sub1Score;
   private double sub2Score;
   private double sub3Score;
   private double finalScore;
   private String grade;
   private String location;
   private String mobile;
   private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSub1Score() {
        return sub1Score;
    }

    public void setSub1Score(double sub1Score) {
        this.sub1Score = sub1Score;
    }

    public double getSub2Score() {
        return sub2Score;
    }

    public void setSub2Score(double sub2Score) {
        this.sub2Score = sub2Score;
    }

    public double getSub3Score() {
        return sub3Score;
    }

    public void setSub3Score(double sub3Score) {
        this.sub3Score = sub3Score;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sub1Score=" + sub1Score +
                ", sub2Score=" + sub2Score +
                ", sub3Score=" + sub3Score +
                ", finalScore=" + finalScore +
                ", grade='" + grade + '\'' +
                ", location='" + location + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
