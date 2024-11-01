package org.wisdom.ecommerce.cart.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.wisdom.ecommerce.config.BaseTimeEntity;


@Getter
@Table(name = "cart")
@Entity
public class CartEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long userId;


}
