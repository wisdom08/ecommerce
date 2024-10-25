package org.wisdom.ecommerce.product.domain;

import lombok.Builder;

@Builder
public record Product(Long id, String name, int price, int quantity) {

  public void validateQuantity(Integer quantity) {
    if (this.quantity < quantity) {
      throw new IllegalArgumentException("재고가 부족합니다.");
    }
  }
}
