package com.example.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    private int id;

    private String name;

    private String mailAddress;

    private int departmentId;

    private String departmentName;

    private List<DepartmentEntity> subDepartments;
}
