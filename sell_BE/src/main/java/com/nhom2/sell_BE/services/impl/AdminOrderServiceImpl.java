package com.nhom2.sell_BE.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nhom2.sell_BE.entities.Order;
import com.nhom2.sell_BE.payload.response.thiennt.AdminOrderResponse;
import com.nhom2.sell_BE.repositories.OrderRepository;
import com.nhom2.sell_BE.services.AdminOrderService;

@Service
public class AdminOrderServiceImpl implements AdminOrderService{
    @Autowired

    private OrderRepository adminOrderRepository;

    @Override
    public ResponseEntity<Object> getAllOrderAdmin(){
        List<Order> orders = adminOrderRepository.findAll();
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        AdminOrderResponse respone = new AdminOrderResponse();
        List<AdminOrderResponse> lstResponse = new ArrayList<>();
    
         for (Order order : orders) {
            respone = AdminOrderResponse.builder()
            .orderId(order.getOrderId())
            .userName(order.getUserName())
            .phoneNumber(order.getPhoneNumber())
            .address(order.getAddress())
            .createdAt(order.getCreatedAt())
          .build();
      lstResponse.add(respone);
    }
    return ResponseEntity.ok().body(lstResponse);
    }
}
