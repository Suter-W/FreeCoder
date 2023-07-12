package com.freecoder.wx.mapper;

import com.freecoder.wx.model.Employee;
import com.freecoder.wx.model.EmployeeType;
import com.freecoder.wx.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
    @Transactional
    @Modifying
    @Query("update Employee e set e.type = ?1, e.restaurant = ?2 where e.id = ?3")
    int updateTypeAndRestaurantById(EmployeeType type, Restaurant restaurant, Long id);
    List<Employee> findALlByRestaurant_RestID(String restID);
    @Transactional
    @Modifying
    @Query("update Employee e set e.nickName = ?1, e.avatarUrl = ?2, e.phoneNum = ?3 where e.id = ?4")
    int updateNickNameAndAvatarUrlAndPhoneNumById(String nickName, String avatarUrl, String phoneNum, Long id);

    @Transactional
    @Modifying
    @Query("update Employee e set e.type = ?1, e.restaurant = ?2 where e.phoneNum = ?3")
    int updateTypeAndRestaurantByPhoneNum(EmployeeType type, Restaurant restaurant, String phoneNum);



}