package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        StudentJDBCTemplate studentjdbcTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

        System.out.println("------------ Record Cretions ---------------");
        studentjdbcTemplate.create("Yuri",21);
        studentjdbcTemplate.create("Hana",27);
        studentjdbcTemplate.create("John",15);

        System.out.println("----------List Records ------------");
        List<Student> students = studentjdbcTemplate.listStudents();

        for (Student student: students) {
            System.out.println("Id: "+ student.getId()+" , Name: "+student.getName()+
                    " , Age: "+student.getAge());
        }
    }
}
