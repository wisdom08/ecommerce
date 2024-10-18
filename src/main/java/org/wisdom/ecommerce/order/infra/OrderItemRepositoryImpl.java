package org.wisdom.ecommerce.order.infra;

import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.order.application.OrderItemRepository;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {

    private final OrderItemJpaRepository repository;

    public OrderItemRepositoryImpl(OrderItemJpaRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public void save(long orderId, long productId, int quantity, int price) {
        repository.save(OrderItemEntity.of(orderId, productId, quantity, price));
    }
}
