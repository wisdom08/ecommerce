package org.wisdom.ecommerce.product.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Table
@Entity
public class ProductDetail {

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Getter
  private int quantity;
}
