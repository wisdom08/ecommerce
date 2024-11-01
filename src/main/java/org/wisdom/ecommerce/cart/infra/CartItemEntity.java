package org.wisdom.ecommerce.cart.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import org.wisdom.ecommerce.cart.domain.CartItem;

@Builder
@Getter
@Table(name = "cart_item")
@Entity
public class CartItemEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long cartId;
  private Long productId;
  private int quantity;

  public CartItemEntity() {

  }

  public CartItemEntity(Long id, Long cartId, Long productId, int quantity) {
    this.id = id;
    this.cartId = cartId;
    this.productId = productId;
    this.quantity = quantity;
  }

  public static CartItemEntity of(Long userId, Long productId, int quantity) {
    return CartItemEntity.builder()
        .cartId(userId)
        .productId(productId)
        .quantity(quantity)
        .build();
  }

  public CartItem toDomain() {
    return CartItem.builder()
        .id(id)
        .cartId(cartId)
        .productId(productId)
        .quantity(quantity)
        .build();
  }
}
