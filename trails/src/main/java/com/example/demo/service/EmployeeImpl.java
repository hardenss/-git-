package com.example.demo.service;

import com.example.demo.mapper.BuinessMapper;
import com.example.demo.model.Employee;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EmployeeImpl implements EmployeeService {
    @Autowired
   private BuinessMapper buinessMapper;
    @Autowired
    @Qualifier(value="ds1SqlsessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;


    @Override
    public void add(Employee e) {

            buinessMapper.addEmploee(e);



    }

    @Override
    public List<Map<String, Object>> getProvinces() {
        return buinessMapper.getProvinces();
    }

    @Override
    public List<Map<String, Object>> getCitys() {
        return buinessMapper.getCitys();
    }

    @Override
    public String getProcvicne(String id) {
        return buinessMapper.getProvinceName(id);
    }

    @Override
    public List<Map<String, Object>> getUser() {
        return sqlSessionTemplate.selectList("BuinessMapper.getUser");
    }
}
