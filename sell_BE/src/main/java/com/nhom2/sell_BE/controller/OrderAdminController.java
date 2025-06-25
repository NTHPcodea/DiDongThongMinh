package com.nhom2.sell_BE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import com.nhom2.sell_BE.services.OrderAdminService;

@RestController
@CrossOrigin(origins = "http://localhost:8888") 
@RequestMapping(value = "/api/v1/order_admin")
public class OrderAdminController {
@Autowired
private OrderAdminService orderAdminService;

  @GetMapping("get_all")
  // @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<Object> getAllOrder() {
    return orderAdminService.getAllOrderAdmin();
  }

  @DeleteMapping("/{id}")
  // @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<Object> deleteOrder(@PathVariable("id") String id){
    return orderAdminService.deleteOrderAdmin(id);
  }
}
