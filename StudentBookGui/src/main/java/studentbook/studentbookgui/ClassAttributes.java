package studentbook.studentbookgui;

import java.util.ArrayList;

public class ClassAttributes {
    private int average;
    private ArrayList<Integer> points = new ArrayList<>();
    private StudentCondition condition = StudentCondition.PRESENT;

    public void setAverage(int average) {
        this.average = average;
    }

    public void addGrade(int grade) {
        getPoints().add(grade);
        calculateAverage();
    }

    public void setPoints(ArrayList<Integer> points) {
        this.points = points;
    }

    public void setCondition(StudentCondition condition) {
        this.condition = condition;
    }

    public int getAverage() {
        return average;
    }

    public ArrayList<Integer> getPoints() {
        return points;
    }

    public StudentCondition getCondition() {
        return condition;
    }

    public void calculateAverage() {
        if (points.isEmpty()) {
            setAverage(0);
        }
        try {
            Integer avg = 0;
            for (Integer elem : getPoints()) {
                avg += elem;
            }
            setAverage(avg / getPoints().size());
        } catch (ArithmeticException e) {
            this.average = 0;
        }
    }
    public String getGrades() {
        StringBuilder p = new StringBuilder();
        for (Integer grad: points) {
            p.append("/").append(grad);
        }
        return String.valueOf(p);
    }
}
