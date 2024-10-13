package org.wisdom.ecommerce.order.application;

import org.springframework.stereotype.Service;
import org.wisdom.ecommerce.order.presentation.OrderApiDto;

import java.math.BigDecimal;

@Service
public class OrderService {
    public OrderApiDto.Response order(OrderServiceDto.Request orderRequest) {
        return OrderApiDto.Response.builder()
                .userId(orderRequest.userId())
                .productId(orderRequest.productId())
                .orderId(1)
                .totalAmount(BigDecimal.TEN)
                .build();
    }
}
