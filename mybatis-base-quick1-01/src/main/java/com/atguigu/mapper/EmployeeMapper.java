package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * t_emp表对应数据库SQL语句映射接口!
 *    接口只规定方法,参数和返回值!
 *    mapper.xml中编写具体SQL语句!
 */
public interface EmployeeMapper {

    /**
     * 根据员工id查询员工数据方法
     * @param empId  员工id
     * @return 员工实体对象
     */
    //数据输入
    Employee selectEmployee(Integer empId);
    Employee queryById(Integer empId);
    int deleteById(Integer id);
    List<Employee> queryBySalary(Double salary);

    int insertEmp(Employee employee);
    List<Employee> queryByNameAndSalary(@Param("name") String name,@Param("salary") String salary);

    int insertEmpMap(Map data);
    //数据输出
    //删除插入修改 返回值int
    int deleteByEmpId(Integer id);
    //查询
    String queryNameById(Integer id);

    Double querySalaryById(Integer id);

    Map<String,Object> selectEmpNameAndMaxSalary();

    List<String> queryNameBySalary(Double salary);

    List<Employee> queryAll();
    int update(Employee employee);
}