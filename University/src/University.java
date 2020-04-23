/*
В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы.
У каждого студента есть несколько учебных предметов по которым он получает оценки. Необходимо
реализовать иерархию студентов, групп и факультетов.

* Посчитать средний балл по всем предметам студента
* Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
* Посчитать средний балл по предмету для всего университета

    Релизовать следующие исключения:
* Оценка ниже 0 или выше 10
* Отсутсвие предметов у студента (должен быть хотя бы один)
* Отсутствие студентов в группе
* Отсутствие групп на факультете
* Отсутствие факультетов в университете
*/


public class University {
    private static Group group_0001;
    private static Group group_0002;
    private static Group group_0003;
    private static Group group_0004;
    private static Group group_0005;
    private static Group group_0006;
    private static Department technical;
    private static Department humanitarian;
    private static Department historical;

    static {
        group_0001 = new Group();
        group_0001.addStudent("Кирилл");
        group_0001.addStudent("Ольга");
        group_0001.addStudent("Даниил");

        group_0002 = new Group();
        group_0002.addStudent("Кирилл");
        group_0002.addStudent("Михаил");
        group_0002.addStudent("Карина");

        group_0003 = new Group();
        group_0003.addStudent("Мария");
        group_0003.addStudent("Светлана");
        group_0003.addStudent("Сергей");

        group_0004 = new Group();

        group_0005 = new Group();
        group_0005.addStudent("Кирилл");
        group_0005.addStudent("Алексей");
        group_0005.addStudent("Карина");

        group_0006 = new Group();
        group_0006.addStudent("Александр");
        group_0006.addStudent("Михаил");
        group_0006.addStudent("Виктор");

        technical = new Department();
        Department.setDepartmentList(technical);
        technical.setTagDepartment("Технический факультет");
            technical.addSubject("Механика");
            technical.addSubject("Гидравлика");
            technical.addSubject("Физика");
            technical.addSubject("Философия");
            technical.addSubject("Английский");
            technical.addGroup(group_0001);
            technical.addGroup(group_0003);
            technical.addGroup(group_0006);

        humanitarian = new Department();
        Department.setDepartmentList(humanitarian);
        humanitarian.setTagDepartment("Гуманитарный факультет");
            humanitarian.addSubject("История");
            humanitarian.addSubject("Русский язык");
            humanitarian.addSubject("Философия");
            humanitarian.addSubject("Математика");
            humanitarian.addSubject("Английский");
            humanitarian.addGroup(group_0002);
            humanitarian.addGroup(group_0004);
            humanitarian.addGroup(group_0005);

        historical = new Department();
        Department.setDepartmentList(historical);
        historical.setTagDepartment("Исторический факультет");
    }

    public static void main(String[] args) {

        Student olga = group_0001.findStudent("Ольга");
        Student.rateStudent(olga, "Механика", 6);
        Student.rateStudent(olga, "Механика", 10);
        Student.rateStudent(olga, "Механика", 3);
        Student.rateStudent(olga, "Гидравлика", 7);
        Student.rateStudent(olga, "Английский", 5);

        Student kirill = group_0001.findStudent("Кирилл");
        Student.rateStudent(kirill, "Механика", 2);
        Student.rateStudent(kirill, "Гидравлика", 8);
        Student.rateStudent(kirill, "Английский", 4);

        Student daniil = group_0001.findStudent("Даниил");

        Student karina = group_0005.findStudent("Карина");
        Student.rateStudent(karina, "История", 5);
        Student.rateStudent(karina, "История", 7);
        Student.rateStudent(karina, "Английский", 9);


        System.out.println("Средний балл по всем предметам студента: " +
                olga.getName() + " " + String.format("%.1f", Student.averagePerformance(olga)));

        System.out.println("Средний балл по конкретному предмету в конкретной группе и на конкретном факультете: "
                + String.format("%.1f",Student.averagePerformance("Механика", group_0001, technical)));

        System.out.println("Средний балл по предмету для всего университета: "
                + String.format("%.1f", Department.averagePerformance("Английский")));
    }
}