package demo;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO{
    private DataSource dataSource;
    private JdbcTemplate j;
    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.j = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String name, Integer age) {
        String sql = "insert into Student (name,age) values (?, ?)";
        j.update(sql,name,age);
        System.out.println("Create record name = "+name+" Age = "+ age);
        return;
    }

    @Override
    public Student getStudent(Integer id) {
       String sql = "select * from Student where id = ?";
       Student student = j.queryForObject(sql,new Object[]{id}, new StudentMapper());
       return student;
    }

    @Override
    public List<Student> listStudents() {
        List<Student> students = j.query("select * from Student",new StudentMapper());

        return students;
    }
}
