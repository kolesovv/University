import Exceptions.LackStudents;
import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Student> currentGroup = new ArrayList<>();

    public Group() {
    }

    public List<Student> getCurrentGroup() {
        return currentGroup;
    }

    public Student findStudent (String name){
        try {
            if ((currentGroup.size() == 0)){
                throw new LackStudents("Отсутствие студентов в группе " + currentGroup.toString());
            }
            for (Student student: currentGroup
            ) {
                if(name.equals(student.getName())){
                    return  student;
                }
            }
        }
        catch (LackStudents e){
            e.getMessage();
        }
        return null;
    }

    public void addStudent(String name){
        currentGroup.add(new Student(name));
    }
}