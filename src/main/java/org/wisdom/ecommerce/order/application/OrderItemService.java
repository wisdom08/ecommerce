package org.wisdom.ecommerce.order.application;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wisdom.ecommerce.order.domain.Order;

@Service
public class OrderItemService {

  private final OrderItemRepository repository;

  public OrderItemService(OrderItemRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public Order save(Long orderId, Long productId, int quantity, int price, Long userId) {
    return repository.save(orderId, productId, quantity, price, userId);
  }

  @Transactional(readOnly = true)
  public List<Long> bestProductsForThreeDays() {
    return repository.bestProductsForThreeDays();
  }
}
