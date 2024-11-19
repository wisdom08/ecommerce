package org.wisdom.ecommerce.order.application;

import java.util.List;
import org.wisdom.ecommerce.order.domain.Order;

public interface OrderItemRepository {

  Order save(Long orderId, Long productId, int quantity, int price, Long userId);

  List<Long> bestProductsForThreeDays();
}
