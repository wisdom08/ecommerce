package org.wisdom.ecommerce.order.application;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public Long order(Long userId) {
    return orderRepository.place(userId);
  }
}
