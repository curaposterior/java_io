package logbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassContainer {
    private Map<String, Class> groups = new HashMap<String, Class>();

    public Map<String, Class> getGroups() {
        return groups;
    }

    public void setGroups(Map<String, Class> groups) {
        this.groups = groups;
    }

    public void addClass(String groupName, int maxNumberOfPeople) {
        groups.put(groupName, new Class(groupName, maxNumberOfPeople));
    }

    public void removeClass(String groupName) {
        this.groups.remove(groupName);
    }

    public ArrayList<Class> findEmpty() {
        ArrayList<Class> emptyClasses = new ArrayList<Class>();
        for (var entry: this.groups.entrySet()) {
            if (entry.getValue().getStudentList().size() == 0) {
                emptyClasses.add(entry.getValue());
            }
        }
        return emptyClasses;
    }

    public void summary() {
        System.out.println("Information about the groups:");

        for (String name: groups.keySet()) {
            double percent = groups.get(name).getStudentList().size() * 100/groups.get(name).maxNumOfStudents;
            System.out.println(groups.get(name).groupName + ": "  + percent + "%");
        }
    }

    public Class get(String grName) {
        return this.groups.get(grName);
    }

    public void addStudent(String grName, Student student) {
        this.groups.get(grName).addStudent(student);
    }

    @Override
    public String toString() {
        return "ClassContainer{" +
                "groups=" + groups +
                '}';
    }
}
