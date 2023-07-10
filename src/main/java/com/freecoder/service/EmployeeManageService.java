package com.freecoder.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeManageService {

    boolean addEmploy();

    List<String> getEmployInfo();

    boolean refineEmployInfo();
}
