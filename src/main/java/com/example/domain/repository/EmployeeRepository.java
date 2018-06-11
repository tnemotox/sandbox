package com.example.domain.repository;

import com.example.domain.model.EmployeeEntity;
import com.example.domain.model.MappingHelper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeRepository  {

    List<MappingHelper<Integer, EmployeeEntity>> findAllByIds(@Param("ids") List<Integer> ids);
}
