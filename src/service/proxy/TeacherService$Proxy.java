package service.proxy;

import entity.Human;
import entity.Student;
import entity.Teacher;
import service.Database;
import service.StudentService;
import service.TeacherService;

public class TeacherService$Proxy extends TeacherService {

    private final TeacherService service;

    public TeacherService$Proxy(TeacherService service){
        this.service=service;

    }
    @Override
    public Teacher register(){
        Teacher teacher = this.service.register();
        Database.save();
        return teacher;
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

    @Override
    public void addStudentsToTeacher() {


        super.addStudentsToTeacher();
        Database.save();
    }

}
