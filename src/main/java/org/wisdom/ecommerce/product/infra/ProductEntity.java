package org.wisdom.ecommerce.product.infra;

import jakarta.persistence.*;
import lombok.Getter;
import org.wisdom.ecommerce.config.BaseTimeEntity;
import org.wisdom.ecommerce.product.domain.Product;

@Getter
@Table(name = "product")
@Entity
public class ProductEntity extends BaseTimeEntity {

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private int price;
  private int quantity;

  public Product toDomain() {
    return Product.builder()
            .productId(id)
            .name(name)
            .price(price)
            .quantity(quantity)
            .build();
  }

  public static ProductEntity from(Product product) {
    ProductEntity productEntity = new ProductEntity();
    productEntity.id = product.productId();
    productEntity.name = product.name();
    productEntity.price = product.price();
    return productEntity;
  }
}
