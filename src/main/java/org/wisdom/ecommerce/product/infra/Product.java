package org.wisdom.ecommerce.product.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import org.wisdom.ecommerce.config.BaseTimeEntity;

@Getter
@Table
@Entity
public class Product extends BaseTimeEntity {

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private int price;

  @OneToOne
  @JoinColumn(name = "product_detail_id")
  private ProductDetail productDetail;

}
