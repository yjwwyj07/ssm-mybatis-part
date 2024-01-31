package generator.mapper;

import generator.com.atguigu.pojo.Teacher;

/**
* @author lenovo
* @description 针对表【teacher】的数据库操作Mapper
* @createDate 2024-01-31 14:32:22
* @Entity generator.com.atguigu.pojo.Teacher
*/
public interface TeacherMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

}
