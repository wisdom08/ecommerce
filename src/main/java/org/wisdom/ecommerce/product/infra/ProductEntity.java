package org.wisdom.ecommerce.product.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.wisdom.ecommerce.config.BaseTimeEntity;
import org.wisdom.ecommerce.product.domain.Product;

@Getter
@Table(name = "product")
@Entity
public class ProductEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private int price;
  private int quantity;

  public static ProductEntity from(Product product) {
    ProductEntity productEntity = new ProductEntity();
    productEntity.id = product.id();
    productEntity.name = product.name();
    productEntity.price = product.price();
    return productEntity;
  }

  public Product toDomain() {
    return Product.builder()
        .id(id)
        .name(name)
        .price(price)
        .quantity(quantity)
        .build();
  }
}
