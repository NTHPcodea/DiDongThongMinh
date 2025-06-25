package com.nhom2.sell_BE.payload.response.thiennt;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderAdminResponse {
    private String orderId;
    private String userName;
    private String phoneNumber;
    private String address;
    private LocalDateTime createdAt;
}
