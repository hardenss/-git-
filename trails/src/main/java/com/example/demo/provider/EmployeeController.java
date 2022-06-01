package com.example.demo.provider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Employee;
import com.example.demo.model.ServerResponse;
import com.example.demo.service.EmployeeService;
import com.example.demo.zhujie.GouLinJun;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

@CrossOrigin
    @RequestMapping("add")
   public ServerResponse addEmployee(@RequestBody BindingResult bindingResult, @RequestParam("1")String info, @RequestParam("2")MultipartFile file){


    JSONObject jsonObject=JSONObject.parseObject(info);
        Employee employee=new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setAge(Integer.parseInt(jsonObject.getString("age")));
        employee.setEmployees(jsonObject.getString("name"));
        employee.setSex(jsonObject.getString("sex"));
        employee.setProvince(employeeService.getProcvicne(jsonObject.getString("province")));
        employee.setCity(jsonObject.getString("city"));
        System.out.println(bindingResult.getModel());
        try {
            employee.setImage(file.getBytes());
            employeeService.add(employee);
            return new ServerResponse(100);
        }catch (Exception e){
            return new ServerResponse(200);
        }
    }
@CrossOrigin
    @RequestMapping("getLocation")
    public ServerResponse getLocation(HttpServletResponse response){
//        response.addHeader("Access-Control-Allow-Origin","*");
        List<Map<String,Object>> location=new ArrayList<>();

        List<Map<String,Object>> province=employeeService.getProvinces();
        List<Map<String,Object>> citys=employeeService.getCitys();
        Map<String,Object> map=new HashMap<>();
        map.put("province",province);
        map.put("city",citys);
        location.add(map);
        ServerResponse serverResponse=new ServerResponse(100,JSONObject.toJSONString(location));
        return serverResponse;
    }
    @GouLinJun
    @RequestMapping("getUser")
    public ServerResponse getUserInfo(@RequestParam("1")String agr,@RequestParam("2")int arg){

        String id="02888ade-6edd-4f2f-b316-bf7f20bf9371";

        List<Map<String,Object>> list=employeeService.getUser();
        ServerResponse serverResponse=new ServerResponse(100,JSONObject.toJSONString(list));
        return serverResponse;
    }

    @RequestMapping("test")
    public ServerResponse gettest(){

        String id="02888ade-6edd-4f2f-b316-bf7f20bf9371";

        List<Map<String,Object>> list=employeeService.getUser();
        ServerResponse serverResponse=new ServerResponse(100,JSONObject.toJSONString(list));
        return serverResponse;
    }
}
