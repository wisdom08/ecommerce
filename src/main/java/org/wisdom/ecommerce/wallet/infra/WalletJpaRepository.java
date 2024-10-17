package org.wisdom.ecommerce.wallet.infra;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletJpaRepository extends JpaRepository<WalletEntity, Long> {

    Optional<WalletEntity> findByUserId(long userId);
}
