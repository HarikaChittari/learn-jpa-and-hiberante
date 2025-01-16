package com.demo.springboot.learn_jpa_and_hiberante.course.jdbc;

import com.demo.springboot.learn_jpa_and_hiberante.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {


    @Autowired
    private CourseJdbcRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1,"ReactJS","in28minutes"));
        repository.insert(new Course(2,"AWS","in28minutes"));
        repository.insert(new Course(3,"Azure","in28minutes"));
        repository.insert(new Course(4,"Angular","in28minutes"));
        repository.deleteById(1);

        //System.out.println(repository.selectById(1));
        System.out.println(repository.selectById(2));
        System.out.println(repository.selectById(3));

    }
}
