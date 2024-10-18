package org.wisdom.ecommerce.order.application;

public interface OrderItemRepository {

    void save(long orderId, long productId, int quantity, int price);
}
