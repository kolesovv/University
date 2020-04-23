import Exceptions.BelowZeroAboveTen;
import Exceptions.LackStudents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private Map<String, List<Integer>> academicPerformance = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Map<String, List<Integer>> getAcademicPerformance() {
        return academicPerformance;
    }

    public void setAcademicPerformance(Map<String, List<Integer>> academicPerformance) {
        this.academicPerformance = academicPerformance;
    }

    public Map<String, List<Integer>> getPerformance() {
        try {
            if (academicPerformance.keySet().isEmpty()){
                throw new LackStudents("Отсутсвие предметов у студента.");
            }
        }
        catch (LackStudents e){
            System.out.println(e.getMessage());
        }
        return academicPerformance;
    }

    public static void rateStudent(Student student, String subject, int value){
        try{
            if (value < 0 || value > 10){
                throw new BelowZeroAboveTen("Оценка ниже 0 или выше 10.", value);
            }
            if (!student.academicPerformance.containsKey(subject)){
                student.academicPerformance.put(subject, new ArrayList<>());
            }
            student.academicPerformance.get(subject).add(value);
        }
        catch (BelowZeroAboveTen e){
            System.out.println(e.getMessage());
        }
    }

    // Посчитать средний балл по всем предметам студента
    public static float averagePerformance(Student student){
        int summaryRate = 0;
        int summaryNumberOfRatings = 0;
        for (Map.Entry<String, List<Integer>> entry : student.academicPerformance.entrySet()
             ) {
            for (int currentRate:entry.getValue()
                 ) {
                summaryNumberOfRatings++;
                summaryRate += currentRate;
            }
        }
        return (float)summaryRate / summaryNumberOfRatings;
    }

    public static float averagePerformance(Student student, String subject){
        int summaryRate = 0;
        int summaryNumberOfRatings = 0;
        for (Map.Entry<String, List<Integer>> entry : student.academicPerformance.entrySet()
        ) {
            if (entry.getKey().equals(subject)){
                for (int currentRate:entry.getValue()
                ) {
                    summaryNumberOfRatings++;
                    summaryRate += currentRate;
                }
            }
        }
        return (float)summaryRate / summaryNumberOfRatings;
    }

    // Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
    public static float averagePerformance(String subject, Group group, Department department){
        float summaryRate = 0.0f;
        int summaryNumberOfRatings = 0;
        for (Group currentGroup: department.getDepartment()
             ) {
            if (currentGroup.equals(group)){
                for (Student currentStudent: currentGroup.getCurrentGroup()
                     ) {
                    float rate = averagePerformance(currentStudent, subject);
                    if (rate > 0){
                        summaryRate += + rate;
                        summaryNumberOfRatings++;
                    }
                }
                return summaryRate / summaryNumberOfRatings;
            }
        }
        return summaryRate;
    }

    @Override
    public String toString() {
        return "Student: '" + name + '\'';
    }
}