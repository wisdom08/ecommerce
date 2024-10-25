package org.wisdom.ecommerce.cart.infra;

import jakarta.persistence.*;
import lombok.Getter;
import org.wisdom.ecommerce.config.BaseTimeEntity;


@Getter
@Table(name = "cart")
@Entity
public class CartEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Long userId;


}
