package com.freecoder.wx.service.impl;

import com.freecoder.response.result.ResultException;
import com.freecoder.response.result.ResultStatus;
import com.freecoder.wx.mapper.EmployeeJpaRepository;
import com.freecoder.wx.mapper.RestaurantRepository;
import com.freecoder.wx.model.Employee;
import com.freecoder.wx.model.EmployeeType;
import com.freecoder.wx.model.Restaurant;
import com.freecoder.wx.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeJpaRepository jpaRepository;

    @Value("${appid}")
    private String appid;
    @Value("${secret}")
    private String secret;
    @Value("${grantType}")
    private String grantType;
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Employee getEmployeeInfo(Long id) {
        return jpaRepository.findById(id).get();
    }

    @Override
    public List<Employee> getRestEmployees(String restId) {
        return jpaRepository.findALlByRestaurant_RestID(restId);
    }

    @Override
    public Boolean deleteRestEmployees(Long employeeId, String restId) throws ResultException {
        Employee employee = jpaRepository.findById(employeeId).get();
        if (!employee.getRestaurant().getRestID().equals(restId)) {
            throw new ResultException("无操作权限",ResultStatus.FORBIDDEN);
        }
        Long result = Integer.toUnsignedLong(jpaRepository.updateTypeAndRestaurantById(null, null, employeeId));
        System.out.println("更新返回值："+result);
        return (employeeId == result);
    }

    @Override
    public Employee updateByEmployee(String nickName, String avatarUrl, String phoneNum, Long id) throws ResultException {
        if(jpaRepository.updateNickNameAndAvatarUrlAndPhoneNumById(nickName, avatarUrl, phoneNum, id)!=id){
            throw new ResultException("更新失败", ResultStatus.BAD_REQUEST);
        }
        Employee employee = getEmployeeInfo(id);
        System.out.println("更新结果："+employee);
        return employee;
    }

    @Override
    public Employee updateByAdmin(EmployeeType type, Restaurant restId, String phoneNum) throws ResultException {
        Long id = Integer.toUnsignedLong(jpaRepository.updateTypeAndRestaurantByPhoneNum(type, restId, phoneNum));
        Employee employee = getEmployeeInfo(id);
        System.out.println("更新结果："+employee);
        return employee;
    }
}
