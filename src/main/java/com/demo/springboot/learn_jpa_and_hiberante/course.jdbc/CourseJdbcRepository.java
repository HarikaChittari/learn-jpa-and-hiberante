package com.demo.springboot.learn_jpa_and_hiberante.course.jdbc;


import com.demo.springboot.learn_jpa_and_hiberante.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {


    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY =
          """
             INSERT INTO COURSE (id,name,author)
             VALUES(?, ?, ?);
          """;

    private static String DELETE_QUERY =
            """
                delete from course where id =?;
            """;
    private static String SELECT_QUERY =
            """
                SELECT * FROM COURSE;
            """;

    private static String SELECT_QUERY_BY_ID =
            """
                select * FROM course 
                where id = ?;
            """;


    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(),course.getName(),course.getAuthor());
    }

    public void deleteById(long id){
        springJdbcTemplate.update(DELETE_QUERY,
               id);
    }

    public Course selectById(long id){
        //result set to map to course bean
        //ResultSet -> Bean =>  Row Mapper
        return springJdbcTemplate.queryForObject(SELECT_QUERY_BY_ID, new BeanPropertyRowMapper<>(Course.class), id);
    }



}
