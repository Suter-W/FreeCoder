package com.freecoder.wx.mapper;

import com.freecoder.wx.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Integer>, JpaSpecificationExecutor<OrderInfo> {
}