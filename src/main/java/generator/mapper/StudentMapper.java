package generator.mapper;

import generator.com.atguigu.pojo.Student;

/**
* @author lenovo
* @description 针对表【student】的数据库操作Mapper
* @createDate 2024-01-31 14:32:22
* @Entity generator.com.atguigu.pojo.Student
*/
public interface StudentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

}
