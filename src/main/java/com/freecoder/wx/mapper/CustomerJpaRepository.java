package com.freecoder.wx.mapper;

import com.freecoder.wx.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    @Transactional
    @Modifying
    @Query("update Customer c set c.nickName = ?1, c.avatarUrl = ?2 where c.id = ?3")
    int update(String nickName, String avatarUrl, long id);

//    GeoResult<Customer> findByOpenID(@NonNull String openID);

    @Transactional
    @Modifying
    @Query("update Customer c set c.nickName = ?1, c.avatarUrl = ?2 where c.id = ?3")
    int updateNickNameAndAvatarUrlById(String nickName, String avatarUrl, long id);

    @Transactional
    @Modifying
    @Query("update Customer c set c.isVip = ?1 where c.id = ?2")
    int updateIsVipById(boolean isVip, long id);

    boolean existsByOpenId(String openId);

    Optional<Customer> findByOpenId(String openId);


}
