package org.wisdom.ecommerce.order.application;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderItemService {

  private final OrderItemRepository repository;

  public OrderItemService(OrderItemRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public void save(Long orderId, Long productId, int quantity, int price) {
    repository.save(orderId, productId, quantity, price);
  }

  @Transactional(readOnly = true)
  public List<Long> bestProductsForThreeDays() {
    return repository.bestProductsForThreeDays();
  }
}
