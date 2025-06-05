package com.example.mapper;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzPageQueryParam;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface ClazzMapper {
    //查询所有班级
    List<Clazz> findAllClazzInfolist();

    //根据id查询班级信息
    Clazz getClazzInfoById(Integer clazzId);
    //添加班级信息
    void addClazzInfo(Clazz clazzName);
    //删除班级信息
    void deleteClazzInfo(Integer clazzId);
    //修改班级信息
    void updateClazzInfo(Clazz clazz);


    List<Clazz> findClazzInfoList(ClazzPageQueryParam param);

    long getClazzCount(ClazzPageQueryParam param);

    @MapKey("name")
    List<Map<String, Object>> studentCountData();


}
