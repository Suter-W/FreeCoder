package com.freecoder.web.service.impl;


import com.freecoder.web.mapper.AdminDishMapper;
import com.freecoder.web.mapper.AdminEmployeeMapper;
import com.freecoder.web.model.Employee;
import com.freecoder.web.service.AdminEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminEmployeeServiceImpl implements AdminEmployeeService {

    @Autowired
    private AdminEmployeeMapper adminEmployeeMapper;

    public List<Employee> getEmployeeList(String restID){return adminEmployeeMapper.getEmployeeList(restID);};

    public void addEmployee(String restID, String phone_num, String type){adminEmployeeMapper.addEmployee(restID,phone_num,type);};

    public void deleteEmployee(String phone_num){adminEmployeeMapper.deleteEmployee(phone_num);};
}
