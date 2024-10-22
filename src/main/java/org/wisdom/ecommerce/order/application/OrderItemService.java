package org.wisdom.ecommerce.order.application;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

  private final OrderItemRepository repository;

  public OrderItemService(OrderItemRepository repository) {
    this.repository = repository;
  }

  public void save(Long orderId, Long productId, int quantity, int price) {
    repository.save(orderId, productId, quantity, price);
  }

  public List<Long> bestProductsForThreeDays() {
    return repository.bestProductsForThreeDays();
  }
}
