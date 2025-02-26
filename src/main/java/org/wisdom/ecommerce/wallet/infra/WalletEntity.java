package org.wisdom.ecommerce.wallet.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import org.wisdom.ecommerce.config.BaseTimeEntity;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Builder
@Table(name = "wallet")
@Entity
public class WalletEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long userId;
  private Integer balance;

  public WalletEntity() {
  }

  public WalletEntity(Long id, Long userId, Integer balance) {
    this.id = id;
    this.userId = userId;
    this.balance = balance;
  }

  public static WalletEntity of(Long userId, Integer amount) {
    return WalletEntity.builder()
        .userId(userId)
        .balance(amount)
        .build();
  }

  public Wallet toDomain() {
    return Wallet.builder()
        .userId(userId)
        .walletId(id)
        .balance(balance)
        .build();
  }
}
