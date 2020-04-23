import Exceptions.LackDepartments;
import Exceptions.LackGroups;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private static List<Department> departmentList = new ArrayList<>();
    private List<Group> department = new ArrayList<>();
    private List<String> subjects = new ArrayList<>();
    private String tagDepartment;

    public Department() {

    }

    public List<Group> getDepartment() {
        return department;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public String getTagDepartment() {
        return tagDepartment;
    }

    public void setTagDepartment(String tagDepartment) {
        this.tagDepartment = tagDepartment;
    }

    public void addSubject(String subject){
        subjects.add(subject);
    }

    public void addGroup(Group group){
        department.add(group);
    }

    public static List<Department> getDepartmentList() {
        return departmentList;
    }

    public static void setDepartmentList(Department department) {
        departmentList.add(department);
    }

    public static float averagePerformance (String subject){
        float summaryRate = 0.0f;
        int summaryNumberOfRatings = 0;
        try {
            if (departmentList.size() == 0){
                throw new LackDepartments("Отсутствие факультетов в университете.");
            }
            for (Department currentDepartment: departmentList
            ) {
                try {
                    if(currentDepartment.getDepartment().size() == 0){
                        throw new LackGroups("Отсутствие групп на факультете: " + currentDepartment.getTagDepartment());
                    }
                    for (Group currentGroup: currentDepartment.getDepartment()
                    ) {
                        float rate = Student.averagePerformance(subject, currentGroup, currentDepartment);
                        if (rate > 0){
                            summaryRate += rate;
                            summaryNumberOfRatings++;
                        }
                    }
                }
                catch (LackGroups e){
                    System.out.println(e.getMessage());
                }
            }
        }
        catch (LackDepartments e){
            System.out.println(e.getMessage());
        }
        finally {
            summaryRate = summaryRate / summaryNumberOfRatings;
        }
        return summaryRate;
    }
}