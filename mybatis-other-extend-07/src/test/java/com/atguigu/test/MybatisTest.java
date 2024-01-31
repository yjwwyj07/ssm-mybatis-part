package com.atguigu.test;


import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MybatisTest {
    private SqlSession session;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }
    @Test
    public void testToOne(){
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        PageHelper.startPage(2,2);
        List<Employee> employeeList=mapper.queryList();
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList);
        List<Employee> list = pageInfo.getList();
        System.out.println("list = " + list);
        int pages = pageInfo.getPages();
        System.out.println("pages = " + pages);
        long total = pageInfo.getTotal();
        System.out.println("total = " + total);

    }



    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }
}
