package com.example.demo.mapper;

import com.example.demo.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BuinessMapper {
      void addEmploee(Employee employee);

      List<Map<String,Object>> getProvinces();

      List<Map<String,Object>> getCitys();

      String getProvinceName(String id);

      List<Map<String,Object>> getUser();
}
