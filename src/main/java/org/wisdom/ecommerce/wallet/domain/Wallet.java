package org.wisdom.ecommerce.wallet.domain;

import lombok.Builder;

@Builder
public record Wallet(long id, long userId, int balance) {

}
