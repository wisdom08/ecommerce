package org.wisdom.ecommerce.wallet.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import org.wisdom.ecommerce.config.BaseTimeEntity;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Builder
@Getter
@Table(name = "wallet")
@Entity
public class WalletEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private int balance;

    public WalletEntity() {

    }

    public WalletEntity(long id, long userId, int balance) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
    }

    public static WalletEntity of(long userId, int amount) {
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
