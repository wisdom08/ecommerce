package org.wisdom.ecommerce.wallet.infra;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import org.wisdom.ecommerce.config.BaseTimeEntity;

@Builder
@Getter
@Table(name = "transaction")
@Entity
public class TransactionEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private long walletId;

  private int amount;

  @Enumerated(EnumType.STRING)
  private TransactionType type;

  public TransactionEntity(long id, long walletId, int amount, TransactionType type) {
    this.id = id;
    this.walletId = walletId;
    this.amount = amount;
    this.type = type;
  }

  public TransactionEntity() {

  }

  public static TransactionEntity chargeOf(long walletId, int amount) {
    return TransactionEntity.builder()
        .walletId(walletId)
        .amount(amount)
        .type(TransactionType.CHARGE)
        .build();
  }
}
