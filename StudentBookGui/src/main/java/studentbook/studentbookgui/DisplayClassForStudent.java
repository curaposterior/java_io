package studentbook.studentbookgui;

public class DisplayClassForStudent {
    private String groupName;
    private String grades;
    private Integer average;
    private StudentCondition condition;

    public DisplayClassForStudent(String groupName, String grades, Integer average) {
        this.groupName = groupName;
        this.grades = grades;
        this.average = average;
    }
    public StudentCondition getCondition() {
        return condition;
    }

    public void setCondition(StudentCondition condition) {
        this.condition = condition;
    }
    public String getGroupName() {
        return groupName;
    }

    public String getGrades() {
        return grades;
    }

    public Integer getAverage() {
        return average;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }
}
