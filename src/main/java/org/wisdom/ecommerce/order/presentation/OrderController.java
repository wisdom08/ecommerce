package org.wisdom.ecommerce.order.presentation;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wisdom.ecommerce.common.model.CommonApiResponse;
import org.wisdom.ecommerce.order.application.OrderService;

@Tag(name = "주문/결제")
@RequestMapping("/api/v1/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PatchMapping
    public CommonApiResponse<OrderApiDto.Response> order(@RequestBody OrderApiDto.Request orderRequest) {
        return CommonApiResponse.success(orderService.order(orderRequest.toOrderServiceDto()));
    }
}
