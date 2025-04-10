package service;
import entity.Student;
import util.FileUtil;

import java.util.Scanner;

public class StudentService extends AbstractEducationService {

    protected StudentService() {

        super(Database.HUMAN_WRAPPER.students);
    }

    @Override
    public Student register() {
        System.out.println("Enter student's name");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter student's surname");
        String surname = new Scanner(System.in).nextLine();

        System.out.println("Enter student's age");
        int age = new Scanner(System.in).nextInt();

        System.out.println("Enter student's email");
        String email = new Scanner(System.in).nextLine();

        System.out.println("Enter scholarship");
        Double scholarship = new Scanner(System.in).nextDouble();

        Student student = new Student(name, surname, age, email, scholarship);

        list.add(student);
        FileUtil.writeObjectToFile(Database.HUMAN_WRAPPER);


        return student;
    }


}
