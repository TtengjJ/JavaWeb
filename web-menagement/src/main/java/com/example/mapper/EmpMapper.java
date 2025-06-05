package com.example.mapper;

import com.example.pojo.Emp;
import com.example.pojo.EmpPageQueryParam;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

//员工信息
@Mapper
public interface EmpMapper {
    //本次查询总计数
    //@Select("select count(*) from emp")
    long getEmpCount(EmpPageQueryParam param);

    //分页查询
    //@Select( "select e.*,d.name deptName  from emp e left join  dept d on e.dept_id=d.id order by e.update_time desc limit #{page},#{pageSize}")
    List<Emp> getEmpList(Integer offset, EmpPageQueryParam param);

    //新增员工信息
    void insert(Emp emp);

    //根据id删除员工信息
    void deleteByIds(List<Integer> ids);


    //根据id查询员工信息
    Emp selectById(Integer id);

    void updateById(Emp emp);

    //统计员工职位人数
    //用Map封装为职业和人数
    @MapKey("job")
    List<Map<String, Object>> empJobData();

    //统计员工性别人数
    @MapKey("gender")
    List<Map<String, Object>> empGenderData();

    //根据用户名和密码查询用户信息
    @Select("select id,username,name from emp where username=#{username} and password=#{password}")
    Emp selectByNamePassword(Emp emp);
}
