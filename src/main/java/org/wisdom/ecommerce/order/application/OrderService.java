package org.wisdom.ecommerce.order.application;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import org.wisdom.ecommerce.order.presentation.OrderApiDto;
import org.wisdom.ecommerce.order.presentation.OrderApiDto.Response;

@Service
public class OrderService {

    public Response order(OrderServiceDto.Request orderRequest) {
        return OrderApiDto.Response.builder()
            .userId(orderRequest.userId())
            .productId(orderRequest.productId())
            .orderId(1)
            .totalAmount(BigDecimal.TEN)
            .build();
    }
}
