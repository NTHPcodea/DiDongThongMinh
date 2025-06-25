package com.nhom2.sell_BE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom2.sell_BE.services.AdminOrderService;

@RestController
@CrossOrigin(origins = "http://localhost:8888") 
@RequestMapping(value = "/api/v1/admin_order")

public class AdminOrderController {
    @Autowired

  private AdminOrderService adminOrderService;
  @GetMapping("get_all")
  // @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<Object> getAllADOrder() {
    return adminOrderService.getAllOrderAdmin();
  }
}
