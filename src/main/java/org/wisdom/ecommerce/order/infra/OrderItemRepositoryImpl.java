package org.wisdom.ecommerce.order.infra;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.order.application.OrderItemRepository;
import org.wisdom.ecommerce.order.domain.Order;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {

  private final OrderItemJpaRepository repository;

  public OrderItemRepositoryImpl(OrderItemJpaRepository repository) {
    this.repository = repository;
  }

  @Override
  public Order save(Long orderId, Long productId, int quantity, int price, Long userId) {
    return repository.save(OrderItemEntity.of(orderId, productId, quantity, price)).toDomain(userId);
  }

  @Override
  public List<Long> bestProductsForThreeDays() {
    return repository.bestItemsForThreeDays();
  }
}
