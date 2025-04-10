package service.proxy;

import annotations.Saveable;
import entity.Human;
import entity.Student;
import service.Database;
import service.StudentService;

import java.lang.reflect.Method;

import static service.proxy.ProxyUtil.save;

public class StudentService$Proxy extends StudentService {

    private final StudentService service;

    public StudentService$Proxy(StudentService service) {
        this.service = service;
    }

    @Override
    public Student register() {
        Student student = this.service.register();
        save("register", StudentService.class);

        return student;
    }

    @Override
    public void showAll() {
        this.service.showAll();
        save("showAll", StudentService.class);
    }

    @Override
    public Human search() {
        Human search = this.service.search();
        save("search", StudentService.class);
        return search;
    }

    @Override
    public void delete() {
        this.service.delete();
        save("delete", StudentService.class);
    }

    @Override
    public int showMenu() {
        int i = this.service.showMenu();
        save("showMenu", StudentService.class);
        return i;
    }

    private void save(String name, Class clazz)  {
        try{
        Method declaredMethod = clazz.getDeclaredMethod(name, clazz);
        if(declaredMethod.isAnnotationPresent(Saveable.class)){

            Database.save();
        }

    }catch (NoSuchMethodException e){
        throw new RuntimeException(e);
    }
}
}