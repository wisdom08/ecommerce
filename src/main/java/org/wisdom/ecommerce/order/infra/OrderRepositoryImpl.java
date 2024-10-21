package org.wisdom.ecommerce.order.infra;

import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.order.application.OrderRepository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

  private final OrderJpaRepository repository;

  public OrderRepositoryImpl(OrderJpaRepository repository) {
    this.repository = repository;
  }


  @Override
  public long place(long userId) {
    return repository.save(OrderEntity.of(userId)).getId();
  }
}
