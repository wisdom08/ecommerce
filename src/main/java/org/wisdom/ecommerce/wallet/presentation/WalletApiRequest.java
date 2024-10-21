package org.wisdom.ecommerce.wallet.presentation;

import lombok.Builder;

@Builder
public record WalletApiRequest(Long userId, Integer amount) {

}
