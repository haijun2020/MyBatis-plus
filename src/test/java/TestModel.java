import com.yhj.pojo.Employee;
import org.junit.jupiter.api.Test;

/**
 * @Author: pc
 * @Date: 2021/10/13
 * @Description:
 **/
public class TestModel {
    @Test
    public void testModel(){
        Employee employee = new Employee();
        employee.setLastName("杨老师");
        employee.setAge(12);
        employee.setGender(1);
        employee.setEmail("2294815586@qq.com");

        boolean insert = employee.insert();
        System.out.println(insert);

    }
}
