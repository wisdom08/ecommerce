package org.wisdom.ecommerce.order.application;

import java.util.List;

public interface OrderItemRepository {

  void save(long orderId, long productId, int quantity, int price);

  List<Long> bestItemsForThreeDays();
}
