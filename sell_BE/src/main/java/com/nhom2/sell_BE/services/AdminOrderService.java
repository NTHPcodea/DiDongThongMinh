package com.nhom2.sell_BE.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public interface AdminOrderService {

    public ResponseEntity<Object> getAllOrderAdmin();

}
