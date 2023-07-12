package com.freecoder.web.service;


import com.freecoder.web.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminEmployeeService {
    List<Employee> getEmployeeList(String restID);

    void addEmployee(String restID, String phone_num, String type);

    void deleteEmployee(String phone_num);
}
