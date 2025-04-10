package service.proxy;

import entity.Human;
import entity.Student;
import service.Database;
import service.StudentService;

import java.util.Scanner;

public class StudentService$Proxy extends StudentService {

    private final StudentService service;

    public StudentService$Proxy(StudentService service){
        this.service=service;

    }
    public Student register(){
        Student student = this.service.register();
        Database.save();
        return student;
    }
    @Override
    public void showAll(){
        super.showAll();
    }
    @Override
    public Human search() {
       return super.search();
    }

    @Override
    public void delete(){
        super.delete();

        Database.save();
    }
    @Override
    public int showMenu(){
       return  super.showMenu();
    }

}
