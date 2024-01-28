import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class CRUDTest {
    private SqlSession sqlSession;

    @BeforeEach
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sessionFactory.openSession(true);
    }
    @Test
    public void testInsert(){
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpSalary(546.2);
        employee.setEmpName("crown");
        int insert = mapper.insertEmp(employee);
        System.out.println("insert = " + insert);
    }

    @Test
    public void testUpdate(){
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee=new Employee();
        employee.setEmpId(1);
        employee.setEmpName("Marlin");
        employee.setEmpSalary(39.4);
        int update = mapper.update(employee);
        System.out.println("update = " + update);
    }

    @Test
    public void testDelete(){
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int i = mapper.deleteById(1);
        System.out.println("i = " + i);

    }
    @AfterEach
    public void close(){
        sqlSession.close();
    }
}
