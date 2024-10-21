package org.wisdom.ecommerce.order.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import org.wisdom.ecommerce.config.BaseTimeEntity;

@Builder
@Getter
@Table(name = "order_item")
@Entity
public class OrderItemEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private long orderId;
  private long productId;
  private int quantity;
  private int unitPrice;

  public OrderItemEntity() {
  }

  public OrderItemEntity(long id, long orderId, long productId, int quantity, int price) {
    this.id = id;
    this.orderId = orderId;
    this.productId = productId;
    this.quantity = quantity;
    this.unitPrice = price;
  }

  public static OrderItemEntity of(long orderId, long productId, int quantity, int price) {
    return OrderItemEntity.builder()
        .orderId(orderId)
        .productId(productId)
        .quantity(quantity)
        .unitPrice(price)
        .build();
  }
}
