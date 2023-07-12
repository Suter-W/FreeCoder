package com.freecoder.web.service.impl;

import com.freecoder.web.mapper.EmployeeManageMapper;
import com.freecoder.web.service.EmployeeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmployeeManageServiceImpl
 * @Description TODO
 * @DATE 2023/7/10 15:11
 */
@Service
public class EmployeeManageServiceImpl implements EmployeeManageService {

    @Autowired
    private EmployeeManageMapper employeeManageMapper;

    public boolean addEmploy(){
        boolean addEmployStatus = employeeManageMapper.addEmploy();
        return addEmployStatus;
    }

    public List<String> getEmployInfo(){
        List<String> EmployInfoList = employeeManageMapper.getEmployInfo();
        return EmployInfoList;
    }

    public boolean refineEmployInfo(){
        boolean refineEmployInfoStatus = employeeManageMapper.refineEmployInfo();
        return refineEmployInfoStatus;
    }

}
