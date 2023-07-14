package com.freecoder.wx.service.impl;

import com.freecoder.response.result.ResultException;
import com.freecoder.response.result.ResultStatus;
import com.freecoder.wx.mapper.CustomerJpaRepository;
import com.freecoder.wx.model.Customer;
import com.freecoder.wx.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 微信登录服务实现
 *
 * @author : LY
 * @version : [v1.0]
 * @createTime : [2023/7/9 10:14]
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerJpaRepository jpaRepository;

    @Value("${appid}")
    private String appid;
    @Value("${secret}")
    private String secret;
    @Value("${grantType}")
    private String grantType;

    @Override
    public Customer getCustomerInfo(Long id) {
        return jpaRepository.findById(id).get();
    }

    @Override
    public Customer updateCustomerNameAndAvatar(String nickName, String avatarUrl, Long id) throws ResultException {
        if(jpaRepository.updateNickNameAndAvatarUrlById(nickName, avatarUrl, id)==0){
            throw new ResultException("更新失败",ResultStatus.BAD_REQUEST);
        }
        Customer customer = getCustomerInfo(id);
        System.out.println("更新结果："+customer);
        return customer;
    }

    @Override
    public Customer updateCustomerVipInfo(Boolean isVip, Long id) throws ResultException {
        if(jpaRepository.updateIsVipById(isVip, id)!=id){
            throw new ResultException("更新失败",ResultStatus.BAD_REQUEST);
        }
        Customer customer = getCustomerInfo(id);
        System.out.println("更新结果："+customer);
        return customer;
    }
}
