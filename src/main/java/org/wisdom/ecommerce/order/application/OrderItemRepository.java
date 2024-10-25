package org.wisdom.ecommerce.order.application;

import java.util.List;

public interface OrderItemRepository {

  void save(Long orderId, Long productId, int quantity, int price);

  List<Long> bestProductsForThreeDays();
}
