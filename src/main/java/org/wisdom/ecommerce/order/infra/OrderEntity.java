package org.wisdom.ecommerce.order.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import org.wisdom.ecommerce.config.BaseTimeEntity;

@Builder
@Getter
@Table(name = "orders")
@Entity
public class OrderEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId;
  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  public OrderEntity() {
  }

  public OrderEntity(Long id, Long userId, OrderStatus orderStatus) {
    this.id = id;
    this.userId = userId;
    this.status = orderStatus;
  }

  public static OrderEntity of(Long userId) {
    return OrderEntity.builder()
        .userId(userId)
        .status(OrderStatus.PAID)
        .build();
  }
}
