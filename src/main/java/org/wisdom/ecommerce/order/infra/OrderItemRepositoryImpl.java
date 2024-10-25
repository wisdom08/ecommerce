package org.wisdom.ecommerce.order.infra;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.order.application.OrderItemRepository;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {

  private final OrderItemJpaRepository repository;

  public OrderItemRepositoryImpl(OrderItemJpaRepository repository) {
    this.repository = repository;
  }

  @Override
  public void save(Long orderId, Long productId, int quantity, int price) {
    repository.save(OrderItemEntity.of(orderId, productId, quantity, price));
  }

  @Override
  public List<Long> bestProductsForThreeDays() {
    return repository.bestItemsForThreeDays();
  }
}
