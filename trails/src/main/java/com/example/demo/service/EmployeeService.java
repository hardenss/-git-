package com.example.demo.service;

import com.example.demo.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Mapper
@Service
public interface EmployeeService {
    void add(Employee e);

    List<Map<String,Object>> getProvinces();

    List<Map<String,Object>> getCitys();

    String getProcvicne(String id);

    List<Map<String,Object>> getUser();
}
