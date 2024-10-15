package org.wisdom.ecommerce.product.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.wisdom.ecommerce.product.infra.Product;

public class ProductInfo {

  @Schema(description = "상품 응답")
  @Builder
  public record Response(long productId, String name, int price, int quantity) {

    public static Response from(Product product) {
      return Response.builder()
          .productId(product.getId())
          .name(product.getName())
          .price(product.getPrice())
          .quantity(product.getProductDetail().getQuantity())
          .build();
    }
  }
}
