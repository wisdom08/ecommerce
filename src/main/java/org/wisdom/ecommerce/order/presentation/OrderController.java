package org.wisdom.ecommerce.order.presentation;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wisdom.ecommerce.common.model.CommonApiResponse;
import org.wisdom.ecommerce.order.application.OrderFacade;

@Tag(name = "[주문]")
@RequestMapping("/api/v1/order")
@RestController
public class OrderController {

  private final OrderFacade orderFacade;

  public OrderController(OrderFacade orderFacade) {
    this.orderFacade = orderFacade;
  }

  @PatchMapping
  public CommonApiResponse<OrderApiResponse> order(@RequestBody OrderApiRequest request) {
    orderFacade.place(request.userId(), request.productId(), request.quantity());
    return CommonApiResponse.success(null);
  }
}
