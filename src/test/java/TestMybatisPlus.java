import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhj.mapper.EmployeeMapper;
import com.yhj.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: pc
 * @Date: 2021/10/12
 * @Description:
 **/
public class TestMybatisPlus {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    //    EmployeeMapper employeeMapper = ctx.getBean();
    EmployeeMapper employeeMapper = ctx.getBean("employeeMapper",EmployeeMapper.class);

    @Test
    public void test1() throws SQLException {
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testinsert(){
        Employee employee = new Employee();
        employee.setLastName("MP");
        employee.setEmail("dadad");
        employee.setGender(1);
        employee.setAge(12);

        int insert = employeeMapper.insert(employee);
        System.out.println(insert);
    }

    @Test
    public void testSelectPage(){
        Page<Employee> employeePage = employeeMapper.selectPage(new Page<>(1, 1), null);
        List<Employee> records = employeePage.getRecords();
        for (Employee record : records) {
            System.out.println(record);

        }
    }
}

