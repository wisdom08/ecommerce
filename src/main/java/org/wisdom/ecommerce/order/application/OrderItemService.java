package org.wisdom.ecommerce.order.application;

import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    private final OrderItemRepository repository;

    public OrderItemService(OrderItemRepository repository) {
        this.repository = repository;
    }


    public void save(long orderId, long productId, int quantity, int price) {
        repository.save(orderId, productId, quantity, price);
    }
}
