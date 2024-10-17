package org.wisdom.ecommerce.wallet.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.wisdom.ecommerce.config.BaseTimeEntity;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Getter
@Table(name = "wallet")
@Entity
public class WalletEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private int balance;

    public static WalletEntity from(Wallet wallet) {
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.id = wallet.id();
        walletEntity.balance = wallet.balance();
        return walletEntity;
    }

    public Wallet toDomain() {
        return Wallet.builder()
            .id(id)
            .balance(balance)
            .build();
    }
}
