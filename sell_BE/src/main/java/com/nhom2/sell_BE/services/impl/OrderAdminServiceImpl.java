package com.nhom2.sell_BE.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nhom2.sell_BE.entities.Order;
import com.nhom2.sell_BE.entities.Product;
import com.nhom2.sell_BE.repositories.OrderRepository;
import com.nhom2.sell_BE.services.OrderAdminService;
import com.nhom2.sell_BE.payload.response.thiennt.OrderAdminResponse;

@Service
public class OrderAdminServiceImpl implements OrderAdminService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResponseEntity<Object> getAllOrderAdmin() {
         List<Order> orders = orderRepository.findAll();
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        OrderAdminResponse respone = new OrderAdminResponse();
        List<OrderAdminResponse> lstResponse = new ArrayList<>();
    
        for (Order order : orders) {
            respone = OrderAdminResponse.builder()
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

    @Override
    public ResponseEntity<Object> deleteOrderAdmin(String id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        orderRepository.deleteById(id);;
        return ResponseEntity.ok().body("Delete Success");
    }
    
}
