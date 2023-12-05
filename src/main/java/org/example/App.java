package org.example;

import org.example.configuration.MyConfig;
import org.example.dao.MyRepository;
import org.example.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(MyConfig.class);

        MyRepository repository = context.getBean(MyRepository.class);
        repository.getListOfUsers();
        repository.saveUser(new User(Long.valueOf("3"), "James", "Brown", Byte.valueOf("24")));
        repository.updateUser(new User(Long.valueOf("3"), "Thomas", "Shelby", Byte.valueOf("24")));
        repository.deleteUser(Long.valueOf("3"));
    }
}
