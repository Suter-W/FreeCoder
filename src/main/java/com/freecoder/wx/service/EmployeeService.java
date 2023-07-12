package com.freecoder.wx.service;

import com.freecoder.response.result.ResultException;
import com.freecoder.wx.model.Employee;
import com.freecoder.wx.model.EmployeeType;
import com.freecoder.wx.model.Restaurant;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeInfo(Long id);

    List<Employee> getRestEmployees(String restId);

    Boolean deleteRestEmployees(Long employeeId, String restId) throws ResultException;

    public Employee updateByEmployee(String nickName, String avatarUrl, String phoneNum, Long id) throws ResultException;

    public Employee updateByAdmin(EmployeeType type, Restaurant restId, String phoneNum) throws ResultException;
}
