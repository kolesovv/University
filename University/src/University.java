public class University {
    public static void main(String[] args) {
        Group group_0001;
        Group group_0002;
        Group group_0003;
        Group group_0004;
        Group group_0005;
        Group group_0006;
        Department technical;
        Department humanitarian;
        Department historical;

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
        group_0004.addStudent("Дарья");

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

        Student olga = group_0001.findStudent("Ольга");
        olga.rateStudent(olga, "Механика", 6);
        olga.rateStudent(olga, "Механика", 10);
        olga.rateStudent(olga, "Механика", 3);
        olga.rateStudent(olga, "Гидравлика", 7);
        olga.rateStudent(olga, "Английский", 9);

        Student kirill = group_0001.findStudent("Кирилл");
        kirill.rateStudent(kirill, "Механика", 2);
        kirill.rateStudent(kirill, "Гидравлика", 8);
        kirill.rateStudent(kirill, "Английский", 4);

        Student daniil = group_0001.findStudent("Даниил");

        Student karina = group_0005.findStudent("Карина");
        karina.rateStudent(karina, "История", 5);
        karina.rateStudent(karina, "История", 7);
        karina.rateStudent(karina, "Английский", 9);


        System.out.println("Средний балл по всем предметам студента: " +
                olga.getName() + " " + String.format("%.1f", olga.averagePerformance(olga)));

        System.out.println("Средний балл по конкретному предмету в конкретной группе и на конкретном факультете: "
                + String.format("%.1f",Student.averagePerformance("Механика", group_0001, technical)));

        System.out.println("Средний балл по предмету для всего университета: "
                + String.format("%.1f", Department.averagePerformance("Английский")));
    }
}