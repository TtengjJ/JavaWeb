package com.example.mapper;

import com.example.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//员工经历
@Mapper
public interface EmpExprMapper {


    void insert(EmpExpr empExpr);

    void deleteByExprs(List<Integer> ids);

    List<EmpExpr> selectByEmpId(Integer id);
}
