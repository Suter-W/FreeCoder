package com.freecoder.wx.mapper;

import com.freecoder.wx.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

//    GeoResult<Customer> findByOpenID(@NonNull String openID);

    @Transactional
    @Modifying
    @Query("update Customer c set c.nickName = ?1 where c.nickName = ?2")
    int updateNickNameByNickName(String newNickName, String oldNickName);

    boolean existsByOpenId(String openId);

    Optional<Customer> findByOpenId(String openId);




}
