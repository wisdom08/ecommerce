package org.wisdom.ecommerce.wallet.presentation;

import lombok.Builder;
import lombok.Getter;

@Builder
public record WalletApiRequest(@Getter Long userId, Integer amount) {

}
