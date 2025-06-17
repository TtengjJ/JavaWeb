package com.example.mapper;


import com.example.pojo.OperateLog;
import com.example.pojo.OperateLogPageQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OperateLogMapper {

    //插入日志数据
    @Insert("insert into operate_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    void insert(OperateLog log);

    //分页查询日志数据
    @Select("SELECT  l.id, l.operate_emp_id, l.operate_time, l.class_name, l.method_name, l.method_params, l.return_value, l.cost_time, e.name AS operate_emp_name " +
            "FROM operate_log l LEFT JOIN emp e ON l.operate_emp_id = e.id")
    List<OperateLog> pageQuery(@Param("param") OperateLogPageQueryParam param);

    //查询日志数据总数
    @Select("SELECT COUNT(*) FROM operate_log")
    Long pageQueryCount(@Param("param") OperateLogPageQueryParam param);

}
